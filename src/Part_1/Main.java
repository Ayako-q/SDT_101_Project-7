package Part_1;

/*
Welcome to my Project 7!
Oleksii Ishchenko for SDT 101
---------- Part 1 -----------
 */

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("\n\u001B[35mPart 1.1 - binary tree concepts\u001B[0m");
        System.out.println("""
                (a) Descendants of node 8: 5, 6, 2, 9 
                (b) Ancestors of node 1: 3 and 7
                (c) Leaf nodes: 5, 9, 1, 4
                (d) Internal nodes: 8, 3, 6, 2, 7
                (e) Node 3 - level 1, node 1 - 2, node 9 - 4
                (f) The height of a tree is 4
                (g) Height of the subtree rooted at 6 is 2
                (h) This is not a full binary tree because full binary tree means that every node on each level 
                except of the last level has either zero or or two children, but as we can see node 6 has only one children
                (i) To make it complete binary tree we can move node 2 to the left child position of node 6,
                and then move mode 9 to the right child position of the node 6. (left child value should be less than parent)
                """);
        System.out.println("\n\u001B[35mPart 1.2 - binary tree traversals \u001B[0m");
        System.out.println("""
                (a) The nodes visited during a level order traversal of the given binary tree would be:
                                
                7, 8, 3, 5, 6, 1, 4, 2, 9
                                
                (b) The nodes visited during an inorder traversal of the given binary tree would be:
                                
                5, 8, 6, 9, 2, 7, 1, 3, 4
                                
                (c) The nodes visited during a preorder traversal of the given binary tree would be:
                                
                7, 8, 5, 6, 2, 9, 3, 1, 4,
                                
                (d) The nodes visited during a postorder traversal of the given binary tree would be:
                                
                5, 9, 2, 6, 8, 1, 4, 3, 7
                """);
    }
}
