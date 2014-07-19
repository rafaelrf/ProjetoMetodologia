
package core.linked_list;

// TODO: Auto-generated Javadoc
/**
 * The Interface LinkedList.
 * 
 * @param <T> the generic type
 */
public interface LinkedList<T> {

    /**
     * Returns true if the list is empty or false, otherwise.
     * 
     * @return true, if is empty
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in the list.
     * 
     * @return the int
     */
    public int size();

    /**
     * Searches a given element in the list. The search must be sequential from
     * the beginning to the end of the list. If the element is not in the list,
     * then it returns null.
     * 
     * @param element the element
     * @return the t
     */
    public T search(T element);

    /**
     * Inserts a new element at the end of the list.
     * 
     * @param element the element
     */
    public void insert(T element);

    /**
     * Removes an element from the list. If the element does not exist the list
     * is not changed.
     * 
     * @param element the element
     */
    public void remove(T element);

    /**
     * Returns an array containing all elements in the structure. The array does
     * not contain empty spaces (or null elements). The elements are put into
     * the array from the beginning to the end of the list.
     * 
     * @return the t[]
     */
    public T[] toArray();
}
