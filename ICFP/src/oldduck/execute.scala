package oldduck;

import java.io._
import scala.collection.mutable.Buffer
import scala.collection.mutable.ArrayBuffer

object execute {
  abstract class PItem
  
  case object IPat extends PItem
  case object CPat extends PItem
  case object FPat extends PItem
  case object PPat extends PItem
  case class Skip(n: Int) extends PItem
  case class Search(s: String) extends PItem
  case object LParen extends PItem
  case object RParen extends PItem

  type Pattern = List[PItem]

  abstract class TItem
  
  case object ITemp extends TItem
  case object CTemp extends TItem
  case object FTemp extends TItem
  case object PTemp extends TItem
  case class Ref(n: Int, level: Int) extends TItem
  case class Len(n: Int) extends TItem
  
  type Template = List[TItem]

  class DNA(in: Reader) {
    object finish extends Exception
    
    class DNASeq {
      private var contents: List[String] = Nil
      private var length = 0
      
      def pop: Option[Char] = {
        if (contents.isEmpty) return None
        val s: String = contents.head
        contents = contents.tail
        if (s.length == 0) return pop
        if (s.length != 1) contents = s.substring(1) :: contents
        length = length - 1
        return Some(s(0))
      }
      
      def push(c: Char): Unit = {
        push(c.toString)
      }
      
      // tune this to try to accumulate large strings
      val THRESHOLD: Int = 100
      
      def push(s: String): Unit = {
        if (!contents.isEmpty && contents.head.length + s.length < THRESHOLD) {
          contents = (s + contents.head) :: contents.tail
        } else {
          contents = s :: contents
        }
        length = length + s.length
      }
      
      def apply(i: Int): Char = applyAux(i, contents)
      
      private def applyAux(i: Int, cs: List[String]): Char = {
        if (cs.isEmpty) return 'X' // dummy value
        val len: Int = cs.head.length
        if (i < len) return cs.head(i)
        return applyAux(i - len, cs.tail)
      }
      
      def len: Int = length
      
      def substring(begin: Int, end: Int): String = {
        var sb: StringBuffer = new StringBuffer
        var b: Int = begin
        var e: Int = end
        if (b >= e) return ""
          
        for (s <- contents) {
          val len: Int = s.length
          if (e <= len) {
            sb.append(s.substring(b, e))
            return sb.toString
          }
          else if (b < len) {
            sb.append(s.substring(b))
            b = 0
          } else {
            b = b - len
          }
          e = e - len
        }
        
        return sb.toString
      }
      
      def drop(i: Int): Unit = {
        if (i == 0 || contents.isEmpty) return
        val len: Int = contents.head.length
        if (i < len) {
          contents = contents.head.substring(i) :: contents.tail
          length = length - i
        } else {
          contents = contents.tail
          drop(i - len)
          length = length - len
        }
      }
      
      override def toString: String = substring(0, len)
      
      def stats: String = contents.take(20).map(s => s.length).toString
    }
    
    object DNASeq {
      def read(in: Reader): DNASeq = {
        val sb: StringBuilder = new StringBuilder
        var ch: Int = in.read
        while (ch != -1) {
          sb.append(ch.asInstanceOf[Char])
          ch = in.read
        }
        in.close
        
        val result: DNASeq = new DNASeq
        result.push(sb.toString)
        return result
      }
    }
    
    val data: DNASeq = DNASeq.read(in)
    
    def pattern: Pattern = {
      var p: Pattern = Nil
      var level: Int = 0
      while (true) {
        data.pop match {
          case Some('C') => p = IPat :: p
          case Some('F') => p = CPat :: p
          case Some('P') => p = FPat :: p
          case Some('I') => data.pop match {
            case Some('C') => p = PPat :: p
            case Some('P') => p = Skip(nat) :: p
            case Some('F') => {
              data.pop
              p = Search(consts) :: p
            }
            case Some('I') => data.pop match {
              case Some('P') => {
                level = level + 1
                p = LParen :: p
              }
              case Some('C') | Some('F') => {
                if (level == 0) return p.reverse
                else {
                  level = level - 1
                  p = RParen :: p
                }
              }
              case Some('I') => popRNA
              case _ => throw finish
            }
            case _ => throw finish
          }
          case _ => throw finish
        }
      }
      
      // Never gets here
      return p.reverse
    }
    
    def popRNA: Unit = {
      rna = getRNA :: rna
    }
    
    // Pop at most 7 characters from the dna
    private def getRNA: String = {
      var r: String = ""
        
      for (i <- 0 until 7) {
        data.pop match {
          case Some(c) => r = r + c
          case None => return r
        }
      }
      return r
    }
    
    def nat: Int = {
      data.pop match {
        case Some('P') => return 0
        case Some('I') | Some('F') => return 2 * nat
        case Some('C') => return 2 * nat + 1
        case _ => throw finish
      }
    }
    
    def consts: String = {
      data.pop match {
        case Some('C') => return 'I' + consts
        case Some('F') => return 'C' + consts
        case Some('P') => return 'F' + consts
        case Some('I') => data.pop match {
          case Some('C') => return 'P' + consts
          case Some(c) => {
            data.push(c)
            data.push('I')
            return ""
          }
          case None => {
            data.push('I')
            return ""
          }
        }
        case _ => return ""
      }
    }
    
    def template: Template = {
      var t: Template = Nil
      while (true) {
        data.pop match {
          case Some('C') => t = ITemp :: t
          case Some('F') => t = CTemp :: t
          case Some('P') => t = FTemp :: t
          case Some('I') => data.pop match {
            case Some('C') => t = PTemp :: t
            case Some('F') | Some('P') => {
              val level = nat
              val n = nat
              t = Ref(n, level) :: t
            }
            case Some('I') => data.pop match {
              case Some('C') | Some('F') => return t.reverse
              case Some('P') => t = Len(nat) :: t
              case Some('I') => popRNA
              case _ => throw finish
            }
            case _ => throw finish
          }
          case _ => throw finish
        }
      }
      
      // Never gets here
      return t.reverse
    }
    
    class Environment {
      private var data: List[String] = Nil
      
      def apply(i: Int): String = {
        val len = data.length
        if (i < len) return data(len - 1 - i)
        else return ""
      }
      
      def add(s: String): Unit = {
        data = s :: data
      }
    }
    
    def matchreplace(p: Pattern, t: Template): Unit = {
      var i: Int = 0
      var e: Environment = new Environment
      var c: List[Int] = Nil
      
      for (pi <- p) {
        pi match {
          case IPat => if (data(i) == 'I') i = i + 1 else return
          case CPat => if (data(i) == 'C') i = i + 1 else return
          case FPat => if (data(i) == 'F') i = i + 1 else return
          case PPat => if (data(i) == 'P') i = i + 1 else return
          case Skip(n) => i = i + n
          case Search(s) => i = search(i, s)
          case LParen => c = i :: c
          case RParen => {
            e.add(data.substring(c.head, i))
            c = c.tail
          }
        }
        if (i > data.len) return
      }
      
      data.drop(i)
      replace(t, e)
    }
    
    def replace(t: Template, e: Environment): Unit = {
      // Process the template backwards, so we don't need r
      for (ti <- t.reverse) {
        ti match {
          case ITemp => data.push('I')
          case CTemp => data.push('C')
          case FTemp => data.push('F')
          case PTemp => data.push('P')
          case Ref(n, level) => data.push(protect(level, e(n)))
          case Len(n) => data.push(asnat(e(n).length))
        }
      }
    }
    
    def protect(level: Int, dna: String): String = {
      if (level == 0) return dna
      else return protect(level - 1, quote(dna))
    }
    
    def quote(dna: String): String = {
      val sb: StringBuilder = new StringBuilder
      for (i <- 0 until dna.length) {
        dna(i) match {
          case 'I' => sb.append('C')
          case 'C' => sb.append('F')
          case 'F' => sb.append('P')
          case 'P' => sb.append("IC")
        }
      }
      return sb.toString
    }
    
    def asnat(n: Int): String = {
      val sb: StringBuilder = new StringBuilder
      var num = n
      while (num > 0) {
        if (num % 2 == 0) sb.append('I')
        else sb.append('C')
        num = num / 2
      }
      sb.append('P')
      return sb.toString
    }
    
    // Return smallest n such that s is a postfix of [i..n], or len + 1 if not found
    def search(i: Int, s: String): Int = {
      var start: Int = i
      val slen = s.length
      while (start <= data.len - slen) {
        var ok: Boolean = true
        var cur = 0
        while (ok && cur < slen) {
          if (data(start + cur) != s(cur)) ok = false
          cur = cur + 1
        }
        if (ok) return start + cur
        start = start + 1
      }
      return data.len + 1
    }
  }

  type RNA = List[String]
  
  var rna: RNA = Nil
  
  def main(args : Array[String]) : Unit = {
    var in: Reader = null
    var out: Writer = null
    
    if (args.length > 0) {
      in = new BufferedReader(new FileReader(args(0)))
    } else {
      in = new BufferedReader(new InputStreamReader(System.in))
    }
    
    if (args.length > 1) {
      out = new BufferedWriter(new FileWriter(args(1)))
    } else {
      out = new BufferedWriter(new OutputStreamWriter(System.out))
    }
    
    execute(in, out)
  }
  
  def execute(in: Reader, out: Writer): Unit = {
    val dna: DNA = new DNA(in)
    // dna.data.push("IIPIFFCPICICIICPIICIPPPICIIC") // This is just to test the sample prefix
    var step: Int = 0
    
    try {
      while (true) {
        val p: Pattern = dna.pattern
        val t: Template = dna.template
        if (step % 100 == 0)
          println("Step: " + step)
        // println(p)
        // println(t)
        // println(dna.data.len + " " + dna.data.stats)
        step = step + 1
        dna.matchreplace(p, t)
      }
    } catch {
      case finish => {
        for (s <- rna.reverse) {
          out.write(s)
          out.write(' ')
        }
        out.close()
      }
    }
  }
}
