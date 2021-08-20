object NegativeValue extends App{
    val r1=new Rational(2,3)
    val r2=new Rational(6,8)
    val x=r1+r2
    println("First rational number : "+r1)
    println("Second rational number : "+r2)
    println("Addition : "+x)
    println("Negative value of addition : "+x.neg)
}
