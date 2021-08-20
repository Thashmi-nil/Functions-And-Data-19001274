object BankAccount extends App{
    var bank:List[Account]=List(new Account("Sanjana", 11234, -5000), new Account("Sumali", 15471, 8000))
    
    val find=(n:String,b:List[Account])=>b.filter(x=>x.nic.equals(n))
    
    val overdraft=(b:List[Account])=> b.filter(x => x.balance < 0)
    
    val balance=(b:List[Account])=> b.map( x => (x,x.balance)).reduce((p , q) => ( q._1 , p._2 + q._2))
    
    //If balance is positive deposit interest is 0.05 
    //If balance is negative overdraft interest is 0.1
    val interest=(b:List[Account])=>b.map(x=>{
        x.balance match {
            case p if p >= 0 => x.deposit(x.balance * 0.05)
            case _ => x.withdraw(Math.abs(x.balance) * 0.1)
        }
        x
    })
    println("\nTransfer money*********")
    val a1=new Account("Person1",12458,3000)
    val a2=new Account("Person2",12758,3000)

    println("* Person1's account before transfering : " + a1)
    println("* Person2's account before transfering : " + a2 +"\n")

    a1.transfer(a1.balance,a2)

    println("* Person1's account after transfering : " + a1)
    println("* Person2's account after transfering : " + a2)

    println("\nAdd interest*********")
    println("* All Accounts in the bank : " + bank)
    println("* Accounts with negative values : " + overdraft(bank))
    println("* Sum of all account balances : " + balance(bank)._2)

    bank = interest(bank)

    println("* Account list with Final balances after adding interest functions : " + bank)
    println("* Final sum of all account balances : " + balance(bank)._2 + "\n")

}
class Account (x:String, y:Int, z:Double){
    val nic:String=x
    val acnumber: Int = y
    var balance: Double = z

    def withdraw(t:Double) = this.balance=this.balance-t
    def deposit(t:Double) = this.balance=this.balance+t

    def transfer(t:Double, that:Account):Unit={
        this.balance=this.balance-t
        that.balance=that.balance+t
    }

    override def toString = "["+nic+":"+acnumber +":"+ balance+"]"
} 