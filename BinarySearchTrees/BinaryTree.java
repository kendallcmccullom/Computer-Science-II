package BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

/* Do not modify BinaryTree class */
abstract class BinaryTree {

    protected class Node implements TreePrinter.PrintableNode {
        protected int key;
        protected Node parent;
        protected Node left;
        protected Node right;
        public Node(int k, Node p) {
            key = k;
            parent = p;
            left = null;
            right = null;
        }
        public Node getLeft() {return left;}
        public Node getRight() {return right;}
        public String toString() {return ""+key;}
    }

    protected Node root;
    BinaryTree() {
        root = null;
    }
}

class BinarySearchTree extends BinaryTree {
    /* Part (a) methods */

    //takes in a key "k" & deletes the node with that key from the binary search tree.
    public void delete(int k) {
        //x is the node and key k
        Node x = getDescendant(root, k );

        //If x only has a right child or a left child-- set the child node's parent to x's parent
        // and link the child node to x's parent node

        // If x is the root node-- update the root node
        if (x.left == null && x.right != null) {
            x = x.right;
            x.right= null;
        }
        else if (x.right == null && x.left != null) { // x only has a left child
            x=x.left;
            x.left=null;
        }
        else if(x.left == null && x.right == null){  // n has no children
            x=null;

        }else{
            // delete the predecessor node recursively replace x's key with the key of the predecessor node.
            Node predecessor = predecessorNode(x);
            delete(predecessor.key);
            x.key = predecessor.key;

        }
    }



    private Node getSuccessor(Node x) {
        Node successor = x.right;
        while (successor.left != null) {
            successor = successor.left;
        }
        return successor;
    }

    public int successorKey(int k) {
        // return successor of node containing k
        // (can assume there is a node containing k and k is not the max)

        Node n = getDescendant(root, k);
        return successorNode(n).key;
    }

    //need to do the opposite of predesseor
    private Node successorNode(Node x) {
        if (x.right != null) {return minDescendant(x.right);}
        Node ancestor = x.parent;
        while (x != ancestor.left) {
            x = ancestor;
            ancestor = x.parent;
        }
        return ancestor;
    }

    public int minKey() {
        // return minimum stored key
        // (can assume tree is nonempty)
        return minDescendant(root).key;
    }

    //implementing the minKey similar to the maxKey helper function but flipped
    //need to do the opposite for min now

    private Node minDescendant(Node n) {
        // assumes n is not null
        Node current = n;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    /* Part (b) methods */

    public int medianKey() {

        //total num of keys in tree
        int numKeys = size(root);

        //Finds  the middle node of tree
        Node medianNode = findNode(root, (numKeys + 1)/ 2);

        //key that is the median node
        return medianNode.key;
    }

    // function that returns the size of the subtree at a specific node
    private int size(Node node){
        int size = 0;
        if(node != null){
            size++;
            //the next two lines are recursively counting the left & right subtrees
            size+= size(node.left);
            size+= size(node.right);
        }
        return size;
    }

    private Node findNode(Node node, int position) {
        //size of left subtree
        int leftSize = size(node.left);

        //if rank looking fr is less than or equal to the size of left -- node must be left
        if (position <= leftSize) {
            return findNode(node.left, position);

        } else if (position == leftSize + 1) {
            return node;
        } else {
            return findNode(node.right, position - leftSize - 1);
        }
    }

    /* Part (c) methods */

    public int nodesInLevel(int h) {
        // return the number of nodes in level h
        // (can assume h >= 0, but nothing else. The answer might be 0)
        return nodesInLevel(root, h);
    }

    //takes a node and integer then returns the num of nodes at that level, h
    private int nodesInLevel(Node node, int h){

        //if true then subtree is empty
        if (node == null){
            return 0;
        }

        //if this is true we are at the level we want
        if (h == 0){
            return 1;
        }

        //recursively counts the num of nodes at level h-1
        return nodesInLevel(node.left, h - 1) + nodesInLevel(node.right, h -1);
    }

    /* Do not modify below this comment. The rest of the methods are already implemented */

    public boolean contains(int needle) {
        Node ret = getDescendant(root, needle);
        if (ret == null) {return false;}
        return true;
    }
    private Node getDescendant(Node n, int needle) {
        if (n == null) {return null;}
        if (needle == n.key) {return n;}
        else if (needle < n.key) {return getDescendant(n.left, needle);}
        else {return getDescendant(n.right, needle);}
    }

    public void add(int key) {
        if (root == null) {
            root = new Node(key, null);
        }
        else {
            addDescendant(key, root);
        }
    }
    private void addDescendant(int key, Node n) {
        // assumes n is not null
        if (key < n.key) {
            if (n.left == null) {
                n.left = new Node(key, n);
            }
            else {
                addDescendant(key, n.left);
            }
        }
        else {
            if (n.right == null) {
                n.right = new Node(key, n);
            }
            else {
                addDescendant(key, n.right);
            }
        }
    }

    public int maxKey() {
        // assumes root is not null
        return maxDescendant(root).key;
    }

    private Node maxDescendant(Node n) {
        // assumes n is not null
        Node current = n;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public int predecessorKey(int key) {
        // assumes key is not the minimum
        Node n = getDescendant(root, key);
        return predecessorNode(n).key;
    }

    private Node predecessorNode(Node x) {
        if (x.left != null) {return maxDescendant(x.left);}
        Node ancestor = x.parent;
        while (x != ancestor.right) {
            x = ancestor;
            ancestor = x.parent;
        }
        return ancestor;
    }

    public void output() {
        TreePrinter.print(root);
    }

    public static void main(String[] args) {
    	System.out.println("kendall");
        java.util.Scanner myScanner = new java.util.Scanner(System.in);
        BinarySearchTree myTree = new BinarySearchTree();
        boolean done = false;
        while (!done) {
            String operation = myScanner.next();
            if (operation.equals("add")) {
                myTree.add(myScanner.nextInt());
            }
            else if (operation.equals("contains")) {
                System.out.println(myTree.contains(myScanner.nextInt()));
            }
            else if (operation.equals("maxKey")) {
                System.out.println(myTree.maxKey());
            }
            else if (operation.equals("output")) {
                myTree.output();
            }
            else if (operation.equals("predecessorKey")) {
                System.out.println(myTree.predecessorKey(myScanner.nextInt()));
            }
            else if (operation.equals("successorKey")) {
                System.out.println(myTree.successorKey(myScanner.nextInt()));
            }
            else if (operation.equals("minKey")) {
                System.out.println(myTree.minKey());
            }
            else if (operation.equals("medianKey")) {
                System.out.println(myTree.medianKey());
            }
            else if (operation.equals("delete")) {
                myTree.delete(myScanner.nextInt());
            }
            else if (operation.equals("nodesInLevel")) {
                System.out.println(myTree.nodesInLevel(myScanner.nextInt()));
            }
            else if (operation.equals("quit")) {
                done = true;
            }
        }
    }
}


/**
 * Binary tree printer (do not modify)
 *
 * @author MightyPork
 * @see <a href="https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram-in-java">source</a>
 */
class TreePrinter
{
    /** Node that can be printed */
    public interface PrintableNode {
        /** Get left child */
        PrintableNode getLeft();

        /** Get right child */
        PrintableNode getRight();
    }

    /**
     * Print a tree
     */
    public static void print(PrintableNode root) {
        List<List<String>> lines = new ArrayList<List<String>>();

        List<PrintableNode> level = new ArrayList<PrintableNode>();
        List<PrintableNode> next = new ArrayList<PrintableNode>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (PrintableNode n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.toString();
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.getLeft());
                    next.add(n.getRight());

                    if (n.getLeft() != null) nn++;
                    if (n.getRight() != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<PrintableNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }
}