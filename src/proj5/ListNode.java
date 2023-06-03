package proj5;
/**
 * Jack Rubin
 * 4/22/23
 * ListNode
 * The ListNode class is more data-specific than the LinkedList class.  It
 * details what a single node looks like.  This node has one data field,
 * holding a pointer to a String object.
 */

public class ListNode
{
    private String data;
    private ListNode next;

    /**
     * Creates ListNode object, which has a String and a next pointer.
     */
    public ListNode(String new_data)
    {
        data = new_data;
        next = null;
    }

    /**
     * getter method for data
     * @return data
     */
    public String getNodeData(){return data;}

    /**
     * getter method for next
     * @return next
     */
    public ListNode getNext(){return next;}

    /**
     * setter method for next
     * @param newNext new ListNode that next is set to.
     */
    public void setNext(ListNode newNext){next = newNext;}

    public String toString(){
        return data;
    }
}

