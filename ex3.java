import java.util.Scanner;
class ex3
{
String name;
int empid;
double salary;
public  ex3(int eid,String n,double sal)
{
     name=n;
       salary=sal;
       empid=eid;

}
public String getname()
  {
   return name;

  }
public int getempid()
  {
   return empid;
  }
public double getsalary()
  {
   return salary;

  }
public double setSalary()
  {
     salary = salary*1.10;  
     return salary;
  }

 public static void main(String args[])
    {
String n;
int eid;
double salary;

 /*/Scanner sc=new Scanner(System.in);
   System.out.println("Enter the name of a employee:");
     n=sc.nextLine();
     
 System.out.println("Enter the id of a employee:");
     eid=sc.nextInt();

 System.out.println("Enter the salary of a employee and : ");
    salary=sc.nextDouble();*/


   ex3 e=new ex3(1,"Manasi",50000);
    System.out.println("\n Initial Employee Informaton: ");
    System.out.println("Employee Id: "+e.getempid()+"\nemployee name:"+e.getname()+"\nEmployee Salary:"+e.getsalary());
    e.setSalary();
    System.out.println(" \n After increment salary by 10% Employee Informaton: ");
    System.out.println("Employee Id: "+e.getempid()+"\nemployee name:"+e.getname()+"\nEmployee Salary:"+e.getsalary());



    }
}