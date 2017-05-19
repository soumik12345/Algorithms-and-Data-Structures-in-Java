import java.util.*;
class ArrayStack
{
    private String[] s;
    private int N;
    public ArrayStack(int capacity)
    {
        s=new String[capacity];
    }

    public boolean isEmpty()
    {
        return N==0;
    }

    public void push(String item)
    {
        s[N++]=item;
    }

    public String pop()
    {
        String item=s[--N];
        s[N]=null;
        return item;
    }

    public void Print()
    {
        for(int i=0;i<N;i++)
            System.out.print(s[i]+"->");
    }

    public void main()
    {
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter capacity of stack: ");
        int c=ob.nextInt();
        ArrayStack st=new ArrayStack(c);
        System.out.print("Enter number of testcase: ");
        int t=ob.nextInt();
        while(t-->0)
        {
            String command=ob.next();
            if(command.equals("print"))
            {
                st.Print();
                System.out.println("null");
            }
            else if(command.equals("top"))
            {
                System.out.println("Top element: "+s[N]);
                System.out.println("Top index: "+N);
            }
            else
            {
                if(command.equals("push"))
                {
                    String item=ob.next();
                    if(N<c)
                        st.push(item);
                    else
                        System.out.println("Stack is full");
                }
                else if(command.equals("pop"))
                {
                    if(N==0)
                        System.out.println("The list is empty.");
                    else
                    {
                        String p=st.pop();
                        System.out.println("Popped item: "+p);
                    }
                }
            }
        }
    }
}
