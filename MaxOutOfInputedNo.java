import java.util.*;
import java.util.Scanner;
class MaxOutOfInputedNo
{
    public static void main(String [] args)
    {
        //System.out.println("Enter total number of input number:");
        Scanner sc=new Scanner(System.in);
      //  int n=sc.nextInt();
        System.out.println("Enter the 10 numbers");
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int n3=sc.nextInt();
        int n4=sc.nextInt();
        int n5=sc.nextInt();
        int n6=sc.nextInt();
        int n7=sc.nextInt();
        int n8=sc.nextInt();
        int n9=sc.nextInt();
        int n10=sc.nextInt();
        int max=0;
        if(max < n1)
        {
           max=n1;
        }
        if (max < n2)
        {
            max=n2;
        }
        if(max < n3)
        {
            max=n3;
        }
        if(max < n4)
        {
            max=n4;
        }
        if(max < n5)
        {
            max=n5;
        }
	if(max < n6)
        {
            max=n6;
        }
	if(max < n7)
        {
            max=n7;
        }
	if(max < n8)
        {
            max=n8;
        }

	if(max < n9)
        {
            max=n9;
        }

	if(max < n10)
        {
            max=n10;
        }
System.out.println("Maximum number among all number is "+ max );
    }
}