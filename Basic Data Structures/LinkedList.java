import java.util.*;
class LinkedList
{
    private class Node
    {
        String item;
        Node next;
    }
    private Node first=null;
    public boolean isEmpty()
    {
        return first==null;
    }

    public void push(String item)
    {
        Node oldFirst=first;
        first=new Node();
        first.item=item;
        first.next=oldFirst;
    }

    public String pop()
    {
        String item=first.item;
        first=first.next;
        return item;
    }

    public void Print(Node head)
    {
        if(head!=null)
        {
            System.out.print(head.item+"->");
            Print(head.next);
        }
    }

    public void main()
    {
        Scanner ob=new Scanner(System.in);
        System.out.print("Enter number of testcase: ");
        int t=ob.nextInt();
        while(t-->0)
        {
            String command=ob.next();
            if(command.equals("print"))
            {
                Print(first);
                System.out.println("null");
            }
            else
            {
                if(command.equals("push"))
                {
                    String item=ob.next();
                    push(item);
                }
                else if(command.equals("pop"))
                {
                    if(first==null)
                        System.out.println("The list is empty.");
                    else
                    {
                        String p=pop();
                        System.out.println("Popped item: "+p);
                    }
                }
            }
        }
    }
}
