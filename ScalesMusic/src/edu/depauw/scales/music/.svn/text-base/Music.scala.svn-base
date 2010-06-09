package edu.depauw.scales.music;

// each note is (midi pitch #, duration in beats, start time in beats)
// could add dynamic level and "panning" here
// handle instrument at a higher level, so an entire Music value is played by one instrument
case class Note(pitch: Int, duration: Double, start: Double)

class Music(val notes: List[Note]) {
  def this(note: Note) = this(List(note))
  
  def duration: Double = (0.0 /: notes){(x, n) => Math.max(x, n.start + n.duration)}
  
  def +(m: Music): Music = new Music(notes ::: m.delay(duration).notes)
  
  def *(m: Music): Music = new Music(notes ::: m.notes)
  
  def *(count: Int): Music = if (count <= 0) new Music(Nil) else this * (count - 1) + this
  
  def delay(start: Double): Music = new Music(notes.map({n => Note(n.pitch, n.duration, n.start + start)}))
  
  def transpose(interval: Int) = new Music(notes.map({n => Note(if (n.pitch < 0) n.pitch else n.pitch + interval, n.duration, n.start)}))
  
  def stretch(factor: Double) = new Music(notes.map({n => Note(n.pitch, n.duration * factor, n.start * factor)}))
  
  
}

// C4 = Middle C = MIDI pitch # 60
case class C(octave: Int, dur: Double) extends Music(Note(12 * octave + 12, dur, 0.0))

case class Cf(octave: Int, dur: Double) extends Music(Note(12 * octave + 11, dur, 0.0))

case class Cs(octave: Int, dur: Double) extends Music(Note(12 * octave + 13, dur, 0.0))

case class D(octave: Int, dur: Double) extends Music(Note(12 * octave + 14, dur, 0.0))

case class Df(octave: Int, dur: Double) extends Music(Note(12 * octave + 13, dur, 0.0))

case class Ds(octave: Int, dur: Double) extends Music(Note(12 * octave + 15, dur, 0.0))

case class E(octave: Int, dur: Double) extends Music(Note(12 * octave + 16, dur, 0.0))

case class Ef(octave: Int, dur: Double) extends Music(Note(12 * octave + 15, dur, 0.0))

case class Es(octave: Int, dur: Double) extends Music(Note(12 * octave + 17, dur, 0.0))

case class F(octave: Int, dur: Double) extends Music(Note(12 * octave + 17, dur, 0.0))

case class Ff(octave: Int, dur: Double) extends Music(Note(12 * octave + 16, dur, 0.0))

case class Fs(octave: Int, dur: Double) extends Music(Note(12 * octave + 18, dur, 0.0))

case class G(octave: Int, dur: Double) extends Music(Note(12 * octave + 19, dur, 0.0))

case class Gf(octave: Int, dur: Double) extends Music(Note(12 * octave + 18, dur, 0.0))

case class Gs(octave: Int, dur: Double) extends Music(Note(12 * octave + 20, dur, 0.0))

case class A(octave: Int, dur: Double) extends Music(Note(12 * octave + 21, dur, 0.0))

case class Af(octave: Int, dur: Double) extends Music(Note(12 * octave + 20, dur, 0.0))

case class As(octave: Int, dur: Double) extends Music(Note(12 * octave + 22, dur, 0.0))

case class B(octave: Int, dur: Double) extends Music(Note(12 * octave + 23, dur, 0.0))

case class Bf(octave: Int, dur: Double) extends Music(Note(12 * octave + 22, dur, 0.0))

case class Bs(octave: Int, dur: Double) extends Music(Note(12 * octave + 24, dur, 0.0))

case class R(dur: Double) extends Music(Note(Integer.MIN_VALUE, dur, 0.0))

object Duration {
  val WN = 4.0

  val HN = 2.0

  val QN = 1.0

  val EN = 0.5

  val SN = 0.25
  
  def dot(dur: Double) = dur * 1.5
  
  def triplet(dur: Double) = dur / 1.5
}