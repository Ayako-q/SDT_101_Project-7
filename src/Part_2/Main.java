package Part_2;

/*
---------- Part 2 -----------
 */

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("\n\u001B[35mPart 2\u001B[0m");
        // Part 2.3
        // lest subtree part
        BinaryTree<Integer> leftSubtree = new BinaryTree<>(17,
                new BinaryTree<>(12,
                        new BinaryTree<>(9),
                        new BinaryTree<>(14)),
                new BinaryTree<>(23,
                        new BinaryTree<>(19),
                        null)
        );
        // right subtree part
        BinaryTree<Integer> rightSubtree = new BinaryTree<>(72,
                new BinaryTree<>(54,
                        null,
                        new BinaryTree<>(67)),
                new BinaryTree<>(76));

        BinaryTree<Integer> tree = new BinaryTree<>(50, leftSubtree, rightSubtree); // root

        // 2.6
        tree.print();
        System.out.println("\n\u001B[35m2.6 Size of our tree:\u001B[0m");
        System.out.println(tree.getSize());
    }
}
