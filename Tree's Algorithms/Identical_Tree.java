//Class 1

public class node
{
    int key;
    node left, right;

    node(int val)
    {
        key = val;
        left =  right = null;
    }
}

//Class 2

import java.util.*;
public class Identical_Tree
{
    node rootA, rootB;
    
    boolean check_trees(node A, node B)
    {
        //if both trees are empty, them they are identical
        if(A == null && B == null)
        {
            return true;
        }

        //if both trees have further sub-trees/ or children
        //check for futher sub-trees by recursive function call
        if((A != null && B != null) && A.key == B.key)
        {
            return ((check_trees(A.left, B.left))
                    && (check_trees(A.right, B.right ))
                    );
        }

        //if one tree has child and the other doesn't then
        //no need to check further
        else
        {
            return false;
        }
    }

    public static void main(String[] args)
    {
        Scanner ob = new Scanner(System.in);
        
        Identical_Tree t = new Identical_Tree();
        
        System.out.println("Enter tree A");

        t.rootA = new node(ob.nextInt());
        t.rootA.left = new node(ob.nextInt());
        t.rootA.right = new node(ob.nextInt());
        t.rootA.left.left = new node(ob.nextInt());
        t.rootA.left.right = new node(ob.nextInt());
        t.rootA.right.left = new node(ob.nextInt());
        t.rootA.right.right = new node(ob.nextInt());

        System.out.println("Enter tree B");

        t.rootB = new node(ob.nextInt());
        t.rootB.left = new node(ob.nextInt());
        t.rootB.right = new node(ob.nextInt());
        t.rootB.left.left = new node(ob.nextInt());
        t.rootB.left.right = new node(ob.nextInt());
        t.rootB.right.left = new node(ob.nextInt());
        t.rootB.right.right = new node(ob.nextInt());

        if(t.check_trees(t.rootA, t.rootB))
        {
            System.out.println("The trees are identical");
        }
        else
        {
            System.out.println("The trees a non-identical");
        }
        
    }
}
