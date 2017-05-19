import java.util.*;
class ArrayStackResizing
{
    private String[] s;
    private int N;
    public ArrayStackResizing()
    {
        s=new String[1];
    }

    public boolean isEmpty()
    {
        return N==0;
    }

    public void push(String item)
    {
        if(N==s.length)
            resize(2*s.length);
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

    private void resize(int capacity)
    {
        String[] copy=new String[capacity];
        for(int i=0;i<N;i++)
            copy[i]=s[i];
        s=copy;
    }

    public void main()
    {
        Scanner ob=new Scanner(System.in);
        ArrayStackResizing st=new ArrayStackResizing();
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
                    st.push(item);
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
