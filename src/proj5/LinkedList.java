package proj5;
/**
 * Jack Rubin
 * 4/22/23
 * LinkedList
 * Invariant: The LinkedList has
 * a length which is the total number of nodes.
 * a firstNode which is the first node in the LL.
 * Behaviors include adding nodes, adding Strings which then becomes nodes, getting
 * the length and size.
 */
public class LinkedList
{
    private int length;
    private ListNode firstNode;

    /**
     * Default constructor
     * Creates an empty LinkedList with no length and no firstNode.
     */
    public LinkedList(){
        length=0;
        firstNode=null;
    }

    /**
     * getter method for length
     * @return length of LinkedList
     */
    public int getLength(){return length;}

    /**
     * Uses data to create a new ListNode.
     * Adds it to the end of the LinkedList if there's no specified index.
     * @param data
     */
    public void add(String data){add(data, getLength());}

    /**
     * Adds ListNode to the end of the LinkedList if there's no specified index.
     * @param node
     */
    public void add(ListNode node){add(node, getLength());}

    /**
     * Adds a new ListNode with data to specified index in the LinkedList
     * @param data String data for new ListNode
     * @param index index at which the node is being added to
     */
    public void add(String data, int index){
        verifyIndex(index);
        ListNode newNode = new ListNode(data);
        ListNode target  = getNode(index);
        newNode.setNext(target);
        if(index == 0){firstNode = newNode;}
        else{getNode(index-1).setNext(newNode);}
        calcSize();
    }

    /**
     * * Adds a ListNode with data to specified index in the LinkedList
     * @param node ListNode
     * @param index index at which the node is being added to
     */
    public void add(ListNode node, int index){
        verifyIndex(index);
        if(index == 0){firstNode = node;}
        else{getNode(index-1).setNext(node);}
        calcSize();
    }

    /**
     * calculates the size of the LinkedList.
     * Function is called after a new node is added, to recalculate size each time.
     */
    private void calcSize(){
        length = 0;
        ListNode runner = firstNode;
        while(runner != null){
            length++;
            runner = runner.getNext();
        }
    }

    /**
     * @param index index of the LinkedList
     * @return ListNode at that index
     */
    public ListNode getNode(int index){
        verifyIndex(index);
        ListNode runner = firstNode;
        for (int i = 0; i < index; i++) {
            runner = runner.getNext();
        }
        return runner;
    }

    /**
     * @param index index of the LinkedList
     * @return String data of the ListNode at the index
     */
    public String getData(int index){
        return getNode(index).getNodeData();
    }

    /**
     * Checks to make sure the index is within the correct range.
     * Otherwise, throws an OutOfBounds (I added this so it functions like a real Data Structure).
     * @param index position in LL
     */
    private void verifyIndex(int index){if (index < 0 || index > getLength()) {throw new IndexOutOfBoundsException();}}

    public String toString(){
        String toReturn = "";
        ListNode runner = firstNode;
        while(runner != null){
            toReturn += runner;
            runner = runner.getNext();
            if(runner != null){
                toReturn += ", ";
            }
        }
        return toReturn;
    }
}


