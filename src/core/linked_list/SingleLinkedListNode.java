
package core.linked_list;

// TODO: Auto-generated Javadoc
/**
 * The Class SingleLinkedListNode.
 *
 * @param <T> the generic type
 */
public class SingleLinkedListNode<T> {
    
    /** The data. */
    protected T data;
    
    /** The next. */
    protected SingleLinkedListNode<T> next;

    /**
     * Constructor of an empty (NIL) node.
     */
    public SingleLinkedListNode() {
    }

    /**
     * Instantiates a new single linked list node.
     *
     * @param data the data
     * @param next the next
     */
    public SingleLinkedListNode(T data, SingleLinkedListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Checks if is nil.
     *
     * @return true, if is nil
     */
    public boolean isNIL() {
        return this.data == null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String resp = null;
        if (!isNIL()) {
            resp = this.data.toString();
        } else {
            resp = "NIL";
        }
        return resp;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        boolean resp = false;
        if (obj instanceof SingleLinkedListNode) {
            return this.data.equals(((SingleLinkedListNode) obj).data);
        }
        return resp;
    }
}
