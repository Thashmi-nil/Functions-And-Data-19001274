object SubRationalNums extends App{
    val x = new Rational(2,3)
    val y = new Rational(1,8)
    val z = new Rational(4,5)

    val Ans = x - y - z

    println("Rational number (x) : "+x)
    println("Rational number (y) : "+y)
    println("Rational number (z) : "+z)
    println("Answer for (x-y-z)  : "+Ans)
}
