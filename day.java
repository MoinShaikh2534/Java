import java.util.*;
import java.util.Scanner;

class day
{
    public static void main(String[] args)
    {
       
       int d=Integer.parseInt(args[0]);
       int m=Integer.parseInt(args[1]);
       int y=Integer.parseInt(args[2]);
       String Days[]={"Sunday","Monday","Tuesday","wendesday","Thursday","friday","Sturday"};
       int month[]={31,28,31,30,31,30,31,31,30,31,30,31};
       int totalDays=0;
      for (int j = 1; j < y; j++) {
            totalDays += isLeapYear(j) ? 366 : 365;
        }
       
       for (int i = 1; i < m; i++) {
            totalDays += month[i - 1];
        }
     if (m > 2 && isLeapYear(y)) {
            totalDays++;
        }
         totalDays += d;
       int day=totalDays % 7;
       System.out.println("The day of date "+ d +"/"+ m +"/"+ y +" = "+ Days[day]);
 
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}