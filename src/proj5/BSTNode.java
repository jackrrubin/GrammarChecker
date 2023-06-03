package proj5;

/**
 * @author Chris Fernandes
 * @version 2/21/18
 *
 * Edited by Jack Rubin
 * Changed the Strings to Comparable Generics for re-usability
 * purposes.
 * Each BSTNode contains a Comparable Generic key, a left link (left child)
 * and right link (right child).
 */
public class BSTNode<E extends Comparable<E>>{

    private E key;
    private BSTNode<E> llink;
    private BSTNode<E> rlink;

    /**
     * non-default constructor
     * @param newKey string that node will hold
     */
    public BSTNode(E newKey)
    {
        key = newKey;
        llink = null;
        rlink = null;
    }

    /**
     * @return the Comparable Generic key
     */
    public E getKey(){return key;}

    /**
     * getter method for right link.
     * @return rlink.
     */
    public BSTNode<E> getRightNode(){return rlink;}

    /**
     * setter method for right link.
     * @param newRightNode BSTNode to replace rlink.
     */
    public void setRightNode(BSTNode<E> newRightNode){rlink = newRightNode;}

    /**
     * getter method for left link.
     * @return llink.
     */
    public BSTNode<E> getLeftNode(){return llink;}

    /**
     * setter method for left link.
     * @param newLeftNode BSTNode to replace llink.
     */
    public void setLeftNode(BSTNode<E> newLeftNode){llink = newLeftNode;}

    /**
     * Setter method for key of a BSTNode
     * @param newKey Comparable generic. New value for key.
     */
    public void setKey(E newKey){key = newKey;}

    /**
     * returns key as printable string
     */
    public String toString()
    {
        return key.toString();
    }


    /**
     * @return true if this node is a leaf, else false
     */
    public boolean isLeaf() {
        return this.llink == null && this.rlink == null;
    }

    /**
     * @return true if this node has a non-null right subtree
     * and a null left subtree, else false
     */
    public boolean hasRightChildOnly() {
        return this.llink == null && this.rlink != null;
    }

    /**
     * @return true if this node has a non-null left subtree
     * and a null right subtree, else false
     */
    public boolean hasLeftChildOnly() {
        return this.llink != null && this.rlink == null;
    }

}