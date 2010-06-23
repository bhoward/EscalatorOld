# Prototype Project

This is just a stupid example of what an Escalator document might look like.  This
documentation is basically a [Markdown][1] document, with some extensions (indicated
by an initial `//` on a line) that are caught by our preprocessor to handle extracted
code fragments and embedded tests/examples.

[1]: http://daringfireball.net/projects/markdown/ "Markdown"

Here is the code for a factorial function, which computes \(n!=\prod_{i
=1}^n i\):
<pre class="brush: scala;">
/**
 * A non-OO object to compute factorial.  It's not good FP either...
 */
object Factorial {
  def apply(n: Int): BigInt = if (n &lt;= 1) 1 else Factorial(n - 1) * n
}
</pre>

Now we can test it:
<pre class="brush: scala">
"Factorial(7) is 5040" in {
  Factorial(7) must_==(5040)
}

"Factorial(n) = Factorial(n-1) * n" in {
  val smallInteger = Gen.choose(1, 100)

  Prop.forAll(smallInteger) { n: Int =&gt;
    Factorial(n) == Factorial(n-1) * n
  } must pass
}

"Factorial(-1) is 0" in {
  Factorial(-1) must_==(0)
}
</pre>
<pre class="brush: specs; light: true">
  + Factorial(7) is 5040
  + Factorial(n) = Factorial(n-1) * n
  x Factorial(-1) is 0
</pre>

And here is an example of its use:
<pre class="brush: scala">
Factorial(100)
</pre>
<pre class="brush: plain; light: true">
res0: BigInt = 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
</pre>

That's about it.
