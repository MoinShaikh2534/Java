import java.util.*;
interface stackQueue
{
 void push(int ele);
 int pop();
 void pick();
 void enqueue(int ele);
 int dequeue();
 void show();
}
class stack implements stackQueue
{
int size,returnval;
int top=-1,arr[];
public stack(int s)
{
  size=s;
  arr=new int[size];
}
 public void push(int ele)
{
 if(top>=size-1)
{
  System.out.println("Stack is full.....");
}
else
{
 top=top+1;
 arr[top]=ele;
 System.out.println("Element "+ele+" is pushed");
}

}
 public int pop()
{
    if(top==-1)
   {
    System.out.println("Stack is Empty.....");
   }
   else
     {
    returnval=arr[top];
    top=top-1;
 System.out.println("Element "+returnval+" is poped");

    return(returnval);
     }
  return(-1);
}
public void pick()
{
   System.out.println("The element on Top of the Stack is "+arr[top]);
}
 public void enqueue(int ele){ }
 public int dequeue(){return -1;}
 public void show(){ }

};

class queue implements stackQueue
{
 int size,returnval,front,rear;
 int arr[];
 public queue(int s)
 {
  size=s;
  front=-1;
  rear=-1;
  arr=new int[size];
 }
 public void push(int ele){ }
 public int pop(){ return -1;}
 public void pick(){}
 public void enqueue(int ele)
{
if(rear>=size-1)
{
 System.out.println("Queue is Full.....");
}
else
{
  if(front==-1)
  {
     front=0;
  }
 else
  {
 rear++;
arr[rear]=ele;
 System.out.println("Element "+ele+" is Enqueued");

  }

}
}
 public int dequeue()
{
   if (front == -1 || front > rear) {
            System.out.println("Queue is Empty");
        } 
else
{
  returnval=arr[front];
  front=front+1;
 System.out.println("Element "+returnval+" is dequeued");

  return(returnval);
 }
return(-1);
}
 public void show()
{
   System.out.println("Queue Elements are:");
   for(int i=0;i<size-1;i++)
    {
       System.out.println(arr[i]+" ");
   }
}
};
class ExStackQueue
{
  
public static void main(String args[])
 {
      Scanner sc = new Scanner(System.in);
        stack s = new stack(5);
        queue q = new queue(5);

        int ch = -1;
        while (ch != 0) {
            System.out.println("\nChoose Data Structure:");
            System.out.println("1. Stack");
            System.out.println("2. Queue");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    int stackChoice = -1;
                    while (stackChoice != 0) {
                        System.out.println("\nStack Operations:");
                        System.out.println("1. Push");
                        System.out.println("2. Pop");
                        System.out.println("3. Display");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter choice: ");
                        stackChoice = sc.nextInt();

                        switch (stackChoice) {
                            case 1:
                                System.out.print("Enter element to push: ");
                                int stackEle = sc.nextInt();
                                s.push(stackEle);
                                break;
                            case 2:
                                s.pop();
                                break;
                            case 3:
                                s.pick();
                                break;
                            case 0:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid choice! Please try again.");
                        }
                    }
                    break;

                case 2:
                    int queueChoice = -1;
                    while (queueChoice != 0) {
                        System.out.println("\nQueue Operations:");
                        System.out.println("1. Enqueue");
                        System.out.println("2. Dequeue");
                        System.out.println("3. Display");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter choice: ");
                        queueChoice = sc.nextInt();

                        switch (queueChoice) {
                            case 1:
                                System.out.print("Enter element to enqueue: ");
                                int queueEle = sc.nextInt();
                                q.enqueue(queueEle);
                                break;
                            case 2:
                                q.dequeue();
                                break;
                            case 3:
                                q.show();
                                break;
                            case 0:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid choice! Please try again.");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        sc.close();
   
   
 }
}