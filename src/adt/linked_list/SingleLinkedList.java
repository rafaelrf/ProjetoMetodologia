
package adt.linked_list;

public class SingleLinkedList<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head,tail;
	
	public SingleLinkedList (){
		head = new SingleLinkedListNode<T>();
		tail = new SingleLinkedListNode<T>();
	}
	
	
	
	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = head;
		while(!aux.isNIL()){
			size++;
			aux = aux.next;
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = head;
		while(!aux.data.equals(element)){
			aux = aux.next;
		}
		return aux.data;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> newNode =  new SingleLinkedListNode<T>(element,new SingleLinkedListNode<T>()) ;
		
		if(isEmpty()){
			this.head = newNode;
			this.tail = this.head;
		}else{
			this.tail.next = newNode;
			this.tail = newNode;
		}
	}

	@Override
	public void remove(T element) {
		if (head.data.equals(element)) {
			head = head.next;
		} else {
			SingleLinkedListNode<T> aux = head;
			while ((!aux.next.data.equals(element)) && (!aux.next.isNIL())) {
				aux = aux.next;
			}
			if (!aux.next.isNIL()) {
				aux.next = aux.next.next;
			}

		}
		
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> aux = head;
		int index = 0;
		while(!aux.isNIL()){
			array[index] = aux.data;
			index++;
			aux = aux.next;
		}
		return array;
	}
	

}
