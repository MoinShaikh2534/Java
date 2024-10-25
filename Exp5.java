import java.util.*;
import java.time.LocalDate;  
import java.time.Period;  
class person
{
 String name,address;
 LocalDate dob;
 float height,weight;
 public person(String n,float h,float w,String add,LocalDate  db)
{
name=n;
address=add;
height=h;
weight=w;
dob=db;

}
 public int calculateAge()
  {
  LocalDate curDate = LocalDate.now();  
  if ((dob != null) && (curDate != null))   
     {  
          return Period.between(dob, curDate).getYears();  
     }  
  else  
      {  
       return 0;  
    }  
  
 }
public void Display()
{
  System.out.println("Name:"+name+"\nHeight:"+height+"\nWeight:"+weight+"\nAddress:"+address+"\nDate of Brith:"+dob);

}

};
class Student extends person
{
   int rno;
   float[] marks=new float[5];
   public Student(String n,float h,float w,String add,LocalDate  db,int rn,float[] m){
 super(n, h, w, add, db);
rno=rn;
   for(int i =0;i<5;i++)
     {
      marks[i]=m[i];
     }

 }
public float calculateAvg()
{
    float sum=0;
    for(int i =0;i<5;i++)
     {
      sum+=marks[i];
     }
    float totalMarks=100;
    float avg=(sum/totalMarks)*100;
    return avg;
}
 public void Display()
 {
     System.out.println("\n\nStudent information:");
     super.Display();
     System.out.print("Roll Number:"+rno+"\nMarks:");
     for(int i =0;i<5;i++)
     {
     System.out.print(marks[i]+" ");
     }

  }


};
class Employee extends person
{
int empid;
double salary;
public Employee(String n,float h,float w,String add,LocalDate  db,int eid,double sal)
 {
 super(n, h, w, add, db);
empid=eid;
salary=sal;
}
public double calaculateTax()
{
double tax=0.02;
double totalSalaryWithTax = salary * tax;
return totalSalaryWithTax;
}

 public void Display()
 {
     System.out.println("\n\nEmployee information:");
     super.Display();
     System.out.println("Employee ID Number:"+empid+"\nSalary:"+salary);
  }

};
public class Exp5
{
  public static void main(String args[])
   {
     
         Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create and display Person");
            System.out.println("2. Create and display Student");
            System.out.println("3. Create and display Employee");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    person p = new person("ABC", 155, 56, "A/p Abdul Lat", LocalDate.of(2004, 12, 8));
                    p.Display();
                    int age = p.calculateAge();
                    System.out.println("Age: " + age);
                    break;

                case 2:
                    float[] marks = {14, 17, 18, 20, 19};
                    Student s = new Student("XYZ", 143, 45, "A/p Umalwad", LocalDate.of(2004, 2, 29), 301, marks);
                    s.Display();
                    age = s.calculateAge();
                    System.out.println("\nAge: " + age);
                    float avgMarks = s.calculateAvg();
                    System.out.println("Average Marks: " + avgMarks);
                    break;

                case 3:
                    Employee e = new Employee("PQR", 155, 55, "A/p Nadani", LocalDate.of(2004, 5, 13), 1, 50000);
                    e.Display();
                    age = e.calculateAge();
                    System.out.println("Age: " + age);
                    double tax = e.calaculateTax();
                    System.out.println("Tax: " + tax);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

   }
}
