import java.util.*;
import java.util.Scanner;
class MaxOutOfInputedNoUsingArray
{
    public static void main(String [] args)
    {
       System.out.println("Enter total number of input number:");
        Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
        System.out.println("Enter the "+ n +" numbers");
       int[] num= new int[n];
       for(int i=0;i<n;i++)
	{
		num[i]=sc.nextInt();
	}
       int max=0;
	for(int i=0;i<n;i++)
	{
	if(max < num[i])
    	    {
       		    max=num[i];
       	    }
	}
      System.out.println("Maximum number among all number is "+ max );
    }
}