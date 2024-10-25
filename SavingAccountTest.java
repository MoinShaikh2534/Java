import java.util.*;
class SavingsAccount
{
  int accoNo;
  String accName,branch;
  double balance;
  static double annualInterstRate=0.04;
  public int setAccno(int aNo)
   {
     accoNo=aNo;
       return accoNo;
   }
public String setName(String n)
   {
     accName=n;
       return accName;
   }
public String setBranch(String bname)
   {
     branch=bname;
       return branch;
   }
public double setannualInterstRate()
   {
     annualInterstRate= 0.04;
       return annualInterstRate;
   }
public double setBalance(double b)
  {
       balance=b;
        return balance;
  }
public static double modifyAnnualInterstRate(double AIR)
  {
   annualInterstRate=AIR;
   return annualInterstRate;
 }
 public int getAccno()
   {
     
       return accoNo;
   }
public String getName()
   {
       return accName;
   }
public String getBranch()
   {
       return branch;
   }
public double getannualInterstRate()
   {
  
       return annualInterstRate;
   }
public double getBalance()
  {
   
        return balance;
  }
public double claculateMothlyInteest()
{
  double monthlyInterest1 = balance * (annualInterstRate / 12);
  balance +=  monthlyInterest1;
   setBalance(balance);
  return balance;
}


}
class SavingAccountTest
 {

 public static void main(String args[])
   {
     double totalBalance;
      SavingsAccount f=new SavingsAccount();
      SavingsAccount s=new SavingsAccount();
       f.setAccno(123);
       f.setName("XYZ");   
       f.setBranch("SBI Lat");
       f.setBalance(1000);

       s.setAccno(153);
       s.setName("PYZ");   
       s.setBranch("SBI ICH");
       s.setBalance(100);
  
        System.out.println("Account Number:-"+f.getAccno());
        System.out.println("Account Name:-"+f.getName());   
        System.out.println(" Branch:-"+f.getBranch());
        System.out.println("Balance:-"+f.getBalance());
  
       f.claculateMothlyInteest();
        
       System.out.println("Balance:-"+f.getBalance());

       System.out.println("Account Number:-"+s.getAccno());
        System.out.println("Account Name:-"+s.getName());   
        System.out.println(" Branch:-"+s.getBranch());
        System.out.println("Balance:-"+s.getBalance());
  
      s.claculateMothlyInteest();
        
       System.out.println("Balance:-"+s.getBalance());

         SavingsAccount.modifyAnnualInterstRate(0.05);
         s.claculateMothlyInteest();
         System.out.println("Balance:-"+s.getBalance());

       
  }

}