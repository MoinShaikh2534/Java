import java.util.Scanner;

public class MatrixOperation {
//setmatrix
    static void setMatrix(int[][] m, int row, int col) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements in matrix:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m[i][j] = sc.nextInt();
            }
        }

        System.out.println("Matrix:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
    //display
    static void display(int result[][],int row, int col)
    {
  for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
//main
    public static void main(String[] args) {
        int row , col ,ch=-1;
                Scanner sc = new Scanner(System.in);
                int [][] m1,m2;
             MatrixTest mt = new MatrixTest(); 
              System.out.println("Enter size of row and column:");
                  row=sc.nextInt();
                 col=sc.nextInt();
                m1 = new int[row][col];
               m2 = new int[row][col];
               System.out.println("Enter elements for Matrix 1:");
               setMatrix(m1, row, col); 
               System.out.println("Enter elements for Matrix 2:");
                setMatrix(m2, row, col); 
                int [][] result=new int[row][col];
        while(ch!=0){
        System.out.println("\n     1.Addition\n     2.Substraction\n     3.Multiplication\n     4.Division\n     5.display");
        System.out.println("Enter choice:");
        ch=sc.nextInt();
        if(ch<9 && ch>0)
        {
        switch(ch)
        {
           
            case 1:
      
              result = mt.addition(m1, m2, row, col);  
              System.out.println("Additon is done To see result choice 5 ....");
              break;
            case 2:
                result = mt.subtraction(m1, m2, row, col);
               System.out.println("substraction is done To see result choice 5 ....");
               
                break;
            case 3:
                result = mt.multiplication(m1, m2, row, col); 
                System.out.println("multiplication is done To see result choice 5 ....");

                break;
            case 4:
                 result = mt.division(m1, m2, row, col);  
                System.out.println("division is done To see result choice 5 ....");

                      break;
            case 5:
                System.out.println("Result is:-");
                display(result,row,col);
                break;
            default:
                System.out.println("Enter valid choice...");

        }
        }
        else
        {
            System.exit(0);
        }
       
        }
    }
}

class MatrixTest {

    int[][] addition(int[][] m1, int[][] m2, int row, int col) {
        int[][] m3 = new int[row][col];  
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m3[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return m3;  
    }
    int[][] subtraction(int[][] m1, int[][] m2, int row, int col) {
        int[][] m3 = new int[row][col];  
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m3[i][j] = m1[i][j] - m2[i][j];
            }
        }
        return m3;  
    }
    int[][] multiplication(int[][] m1, int[][] m2, int row, int col) {
        int[][] m3 = new int[row][col];  
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m3[i][j] = m1[i][j] * m2[i][j];
            }
        }
        return m3;  
    }
     int[][] division(int[][] m1, int[][] m2, int row, int col) {
        int[][] m3 = new int[row][col];  
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m3[i][j] = m1[i][j] / m2[i][j];
            }
        }
        return m3;  
    }
    
}
