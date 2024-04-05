import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Josie Lee
 * @version: 4/5/2024
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        return searchTree(val, root);
    }

    // Returns true if a given val is in the tree, otherwise returns false
    public boolean searchTree(int val, BSTNode root) {
        // If root doesn't exist, return false
        if (root == null) {
            return false;
        }
        // If val equals the root, return true
        if (val == root.getVal()) {
            return true;
        }
        // If val is less than the root, return searchTree with the left child as the new root
        if (val < root.getVal()) {
            return searchTree(val, root.getLeft());
        }
        // Otherwise, return searchTree with the right child as the new root
        else {
            return searchTree(val, root.getRight());
        }
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        // Initialize an ArrayList of BSTNodes
        ArrayList<BSTNode> inOrderSol = new ArrayList<BSTNode>();
        // Get the inorder traversal of the ArrayList
        return getInorderTraversal(root, inOrderSol);
    }

    // Returns an ArrayList of BSTNodes in inorder
    public ArrayList<BSTNode> getInorderTraversal(BSTNode root, ArrayList<BSTNode> inOrderSol) {
        // If the root doesn't exist, return sol
        if (root == null) {
            return inOrderSol;
        }

        // LEFT, ROOT, RIGHT traversal
        // First, add the left child to sol if it exists
        getInorderTraversal(root.getLeft(), inOrderSol);

        // Second, add the root
        inOrderSol.add(root);

        // Third, add the right child to sol if it exists
        getInorderTraversal(root.getRight(), inOrderSol);

        // Return sol
        return inOrderSol;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        // Initialize an ArrayList of BSTNodes
        ArrayList<BSTNode> preOrderSol = new ArrayList<BSTNode>();
        // Get the preorder traversal of the ArrayList
        return getPreorderTraversal(root, preOrderSol);
    }

    // Returns an ArrayList of BSTNodes in preorder
    public ArrayList<BSTNode> getPreorderTraversal(BSTNode root, ArrayList<BSTNode> preOrderSol) {
        // If the root doesn't exist, return sol
        if (root == null) {
            return preOrderSol;
        }

        // ROOT, LEFT, RIGHT traversal
        // First, add the root
        preOrderSol.add(root);

        // Second, add the left child to sol if it exists
        getPreorderTraversal(root.getLeft(), preOrderSol);

        // Third, add the right child to sol if it exists
        getPreorderTraversal(root.getRight(), preOrderSol);

        // Return sol
        return preOrderSol;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        // Initialize an ArrayList of BSTNodes
        ArrayList<BSTNode> postOrderSol = new ArrayList<BSTNode>();
        // Get the postorder traversal of the ArrayList
        return getPostorderTraversal(root, postOrderSol);
    }

    // Returns an ArrayList of BSTNodes in postorder
    public ArrayList<BSTNode> getPostorderTraversal(BSTNode root, ArrayList<BSTNode> postOrderSol) {
        // If the root doesn't exist, return sol
        if (root == null) {
            return postOrderSol;
        }

        // LEFT, RIGHT, ROOT traversal
        // First, add the left child to sol if it exists
        getPostorderTraversal(root.getLeft(), postOrderSol);

        // Second, add the right child to sol if it exists
        getPostorderTraversal(root.getRight(), postOrderSol);

        // Third, add the root
        postOrderSol.add(root);

        // Return sol
        return postOrderSol;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        // Set current tree to a tree with an inserted node
        root = insertNode(root, val);
    }
    // It recursively returns a tree with a node inserted
    public BSTNode insertNode(BSTNode currentNode, int val) {
        // If the currentNode does not exist, return a new BSTNode with val
        if (currentNode == null) {
            return new BSTNode(val);
        }
        if (val < currentNode.getVal()) {
            // Set currentNode's left child to whatever insert returns back
            currentNode.setLeft(insertNode(currentNode.getLeft(), val));
        }
        if (val > currentNode.getVal()) {
            // Set currentNode's right child to whatever insert returns back
            currentNode.setRight(insertNode(currentNode.getRight(), val));
        }
        // Otherwise, val must equal currentNode's value, so return the currentNode
        return currentNode;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
