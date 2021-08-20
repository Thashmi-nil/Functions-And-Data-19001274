class Rational(x: Int, y: Int) {
    require(y>0,"d must be greater than 0")
    val numer = x/gcd(Math.abs(x),y)
    val denom = y/gcd(Math.abs(x),y)

    private def gcd(a:Int,b:Int):Int = if (b==0) a else gcd(b,a%b)

    def +(r: Rational) = new Rational(this.numer*r.denom + this.denom*r.numer, this.denom*r.denom)
    
    def neg=new Rational(-this.numer,this.denom)
    
    def -(r: Rational)=this+r.neg

    override def toString = numer + "/" + denom
}
