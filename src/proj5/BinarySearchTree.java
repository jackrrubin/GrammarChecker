package proj5;

/**
 * BST that stores BSTNodes that stores Comparable Generics.
 * It has a root which is at the top of the BST.
 * The root is an ancestor of every node that comes after it.
 * The size of the BST is the total number of BSTNodes.
 * The height is the largest depth/path to a single BSTNode.
 *
 * @author Jack Rubin
 * @version 5/22/23
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private BSTNode<E> root;

    public BinarySearchTree() {
        root = null;
    }

    /**
     * inserts recursively into BST
     *
     * @param startingNode inserts into subtree rooted at staringNode
     * @param newNode node to insert
     * @return startingNode with newNode already inserted
     */
    private BSTNode recursiveInsert(BSTNode<E> startingNode, BSTNode<E> newNode) {
        if (startingNode == null) {
            return newNode;
        } else if (startingNode.getKey().compareTo(newNode.getKey()) < 0) {
            startingNode.setRightNode(recursiveInsert(startingNode.getRightNode(), newNode));
            return startingNode;
        } else {  // startingNode.key bigger than newNode.key, so newNode goes on left
            startingNode.setLeftNode(recursiveInsert(startingNode.getLeftNode(), newNode));
            return startingNode;
        }
    }

    /**
     * inserts recursively.
     *
     * @param newElem String to insert
     */
    public void insert(E newElem) {
        BSTNode<E> newNode = new BSTNode(newElem);
        root = recursiveInsert(root, newNode);
    }

    /**
     * Recursive helper method of print.
     * Uses inorder tree traversal algorithm.
     *
     * @param N subroot of tree to print
     */
    private void print(BSTNode<E> N) {
        if (N != null) {     // stop recursing when N is null
            System.out.print("(");
            print(N.getLeftNode());
            System.out.print("  " + N + "  ");
            print(N.getRightNode());
            System.out.print(")");
        }
    }

    /**
     * prints a parenthesized version of the tree that shows
     * the subtree structure.  Example: (( A ) B ( C )) means
     * B is the parent of A (left child) and C (right child).
     */
    public void print() {
        print(root);
        System.out.println();
    }

    /**
     * Traverses through the BST using inorder traversal
     * @param N BSTNode which we're currently examining
     * @return a String with the BST correctly mapped out
     */
    private String inorderTraversal(BSTNode<E> N) {
        if (N != null) {
            return inorderTraversal(N.getLeftNode())+ N +"\n"+ inorderTraversal(N.getRightNode());
        }
        return "";
    }

    /**
     * Returns the contents of the BST as a string, following an
     * inorder traversal.
     * <p>
     * The string version of the tree uses parentheses to show
     * the subtree structure.  e.g. (( A ) B ( C )) means
     * B is the parent of A (left child) and C (right child).
     *
     * @return the String version
     */
    public String toString() {
        return inorderTraversal(root);
    }

    private boolean contains(E target, BSTNode<E> subtreeRoot) {
        if (subtreeRoot == null) {
            return false;
        }
        return subtreeRoot.getKey().compareTo(target) == 0 || contains(target, subtreeRoot.getRightNode())
                || contains(target, subtreeRoot.getLeftNode());
    }

    /**
     * Searches for a value in the BST.
     *
     * @param target the value to search for.
     * @return true if and only if 'target' is in the tree
     */
    public boolean contains(E target) {
        return contains(target, root);
    }

    /**
     * Removes a value from the BST. If the value is not present, does
     * nothing.
     *
     * @param target the value to remove from the tree
     */
    public void delete(E target) {
        root = delete(target, root);
    }

    /**
     * Private recursive helper method. Delete target from subtree rooted at root and return root for a subtree
     * containing all nodes from the tree rooted at root except watching 'target' (if found)
     * @param target String to be deleted
     * @param subtreeRoot
     */
    private BSTNode<E> delete(E target, BSTNode<E> subtreeRoot) {
        if (subtreeRoot == null) {
            return null;
        }
        if (subtreeRoot.getKey().compareTo(target) < 0) {
            subtreeRoot.setRightNode(delete(target, subtreeRoot.getRightNode()));
            return subtreeRoot;
        } else if (subtreeRoot.getKey().compareTo(target) > 0) {
            subtreeRoot.setLeftNode(delete(target, subtreeRoot.getLeftNode()));
            return subtreeRoot;
        } else { // found the node
            if (subtreeRoot.isLeaf()) {
                return null;
            } else if (subtreeRoot.hasRightChildOnly()) {
                return subtreeRoot.getRightNode();
            } else if (subtreeRoot.hasLeftChildOnly()) {
                return subtreeRoot.getLeftNode();
            } else { // has two children
                E maxInLeft = getMaxInSubtree(subtreeRoot.getLeftNode());
                subtreeRoot.setKey(maxInLeft);
                subtreeRoot.setLeftNode(delete(subtreeRoot.getKey(), subtreeRoot.getLeftNode()));
                return subtreeRoot;
            }
        }
    }

    /**
     * Delete helper method when a BSTNode has two children. Locates the BSTNode with the largest key
     * by recursively checking for a right child.
     * @param subtreeRoot BSTNode we're currently examining
     * @return largest BSTNode's key in right subtree
     */
    private E getMaxInSubtree(BSTNode<E> subtreeRoot) {
        BSTNode<E> runner = subtreeRoot;
        while (runner.getRightNode() != null) {
            runner = runner.getRightNode();
        }
        return runner.getKey();
    }

    /**
     * @return the number of elements in the BST
     */
    public int size() {
        return size(root);
    }

    /**
     * Private recursive method for size. Traverses through BST to find the
     * total number of nodes.
     * @param subtreeRoot BSTNode we're currently examining.
     * @return size of the BST.
     */
    private int size(BSTNode subtreeRoot) {
        if (subtreeRoot == null) {
            return 0;
        } else {
            int leftSize = size(subtreeRoot.getLeftNode());
            int rightSize = size(subtreeRoot.getRightNode());
            return leftSize + rightSize + 1;
        }
    }

    /**
     * @return the height of the tree (i.e. the depth of the deepest node)
     */
    public int height() {
        return height(root);
    }

    /**
     * Private recursive method for height. Traverses through BST to find the
     * BSTNode with the greatest depth.
     * @param subtreeRoot BSTNode we're currently examining.
     * @return Greatest depth of a BSTNode in the BST.
     */
    private int height(BSTNode subtreeRoot) {
        if (subtreeRoot == null) {
            return -1;
        } else {
            int leftHeight = height(subtreeRoot.getLeftNode());
            int rightHeight = height(subtreeRoot.getRightNode());
            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }

    /**
     * Gets the key of a Comparable Generic from the BST
     * @param toFind, Comparable Generic we're searching for
     * @return the key
     */
    public E getKey(E toFind){
        return getKey(root, toFind);
    }

    /**
     * traverses through the BST to find the BSTNode containing the key.
     * @param subtreeRoot BSTNode we're currently examining
     * @param toFind key we're looking for inside the root
     * @returnn the key
     */
    private E getKey(BSTNode<E> subtreeRoot, E toFind){
        if(subtreeRoot == null){return null;}
        int comparison = subtreeRoot.getKey().compareTo(toFind);
        if(comparison==0) {
            return subtreeRoot.getKey();
        }
        else if(comparison>0){
            return getKey(subtreeRoot.getLeftNode(), toFind);
        }
        else{
            return getKey(subtreeRoot.getRightNode(), toFind);
        }
    }

    /**
     * @return BSTNode, root of the BST
     */
    public BSTNode<E> getRoot() {
        return root;
    }
}