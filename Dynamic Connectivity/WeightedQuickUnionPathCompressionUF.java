import java.util.*;

class WeightedQuickUnionPathCompressionUF
{
    private static int[] id;
    private static int[] sz;
    private static int count;
    private WeightedQuickUnionPathCompressionUF(int N)
    {
        count=N;
        id=new int[N];
        sz=new int[N];
        for(int i=0;i<N;i++)
        {    
            id[i]=i;
            sz[i]=i;
        }
    }

    private static int root(int i)
    {
        while(i!=id[i])
        {    
            id[i]=id[id[i]];
            i=id[i];
        }
        return i;
    }

    private static boolean connected(int p,int q)
    {
        return (root(p)==root(q));
    }

    private static void union(int p,int q)
    {
        int i=root(p);
        int j=root(q);
        if(i==j)
            return;
        if(sz[i]<sz[j])
        {
            id[i]=j;
            sz[j]+=sz[i];
        }
        else
        {
            id[j]=i;
            sz[i]+=sz[j];
        }
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
        WeightedQuickUnionPathCompressionUF u=new WeightedQuickUnionPathCompressionUF(n);
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
        System.out.print("Enter the number of root finding operations: ");
        t=ob.nextInt();
        while(t-->0)
        {
            int i=ob.nextInt();
            System.out.println("The root of "+i+": "+root(i));
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
