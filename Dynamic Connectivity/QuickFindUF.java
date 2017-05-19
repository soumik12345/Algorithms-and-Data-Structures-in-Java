import java.util.*;
class QuickFindUF
{
    private static int[] id;

    private QuickFindUF(int N)
    {
        id=new int[N];
        for(int i=0;i<N;i++)
            id[i]=i;
    }

    private static boolean connected(int p,int q)
    {
        return (id[p]==id[q]);
    }

    private static void union(int p,int q)
    {
        int pid=id[p];
        int qid=id[q];
        for(int i=0;i<id.length;i++)
            if(id[i]==pid)
                id[i]=qid;
    }

    private static void disPlayArray()
    {
        System.out.println("Node\tID");
        for(int i=0;i<id.length;i++)
            System.out.print(i+"\t"+id[i]);
    }

    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int n=ob.nextInt();
        QuickFindUF u=new QuickFindUF(n);
        System.out.print("Enter the number of union operations: ");
        int t=ob.nextInt();
        while(t-->0)
        {
            int p=ob.nextInt();
            int q=ob.nextInt();
            if(!u.connected(p,q))
            {
                u.union(p,q);
                System.out.println(p+" and "+q+" have been connected.");
            }
            else
                System.out.println(p+" and "+q+" are already connected.");
        }
        System.out.print("Enter the number of connected operations: ");
        t=ob.nextInt();
        while(t-->0)
        {
            int p=ob.nextInt();
            int q=ob.nextInt();
            if(!u.connected(p,q))
                System.out.println(p+" and "+q+" are not connected.");
            else
                System.out.println(p+" and "+q+" are connected.");
        }
        System.out.println("Final state of the nodes:");
        disPlayArray();
    }
}
