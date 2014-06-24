package adt.bst;

import java.util.ArrayList;

public class BSTImpl<K extends Comparable<? super K>, V> implements BST<K, V> {

	protected BSTNode<K, V> root;

	public BSTImpl() {
		root = new BSTNode<K, V>();
	}

	public BSTNode<K, V> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return heightAux(root);
	}

	protected int heightAux(BSTNode<K,V> node){
		int auxLeft = 0, auxRight = 0;

		if (node.isEmpty()) {
			return -1;
		}

		auxLeft = heightAux(node.left);
		auxRight = heightAux(node.right);

		if (auxLeft > auxRight) {
			return auxLeft + 1;
		} else {
			return auxRight + 1;
		}
	}
	
	@Override
	public BSTNode<K, V> search(K key) {
		return searchAux(root, key);
	}
	
	private BSTNode<K, V> searchAux(BSTNode<K, V> node,K key){
		  BSTNode<K, V> aux = node;
		  
		  while (!aux.isEmpty() && key != aux.getKey()){
		   if (key.compareTo(aux.getKey()) == -1){
		    aux = aux.getLeft();
		   } else{
		    aux = aux.getRight();
		   }
		  }
		  
		  return aux;
		 }
	
	@Override
	public void insert(K key, V value) {
		
		BSTNode<K, V> aux = this.root;
		if (isEmpty()) {
			aux.setKey(key);
			aux.setValue(value);
			aux.setLeft(new BSTNode<K, V>());
			aux.setRight(new BSTNode<K, V>());
			aux.left.parent = aux;
			aux.right.parent = aux;
		} else {

			while (!aux.isEmpty()) {
				if (key.compareTo(aux.getKey()) > 0) {
					aux = aux.getRight();
				} else {
					aux = aux.getLeft();
				}
			}

			aux.setKey(key);
			aux.setValue(value);
			aux.left = new BSTNode<K, V>();
			aux.right = new BSTNode<K, V>();
			aux.left.parent = aux;
			aux.right.parent = aux;
		}
	}
	
	@Override
	public BSTNode<K, V> maximum(BSTNode<K, V> node) {
		BSTNode<K, V> aux = null;
		if (!node.isEmpty()) {
			aux = node;
			while (!aux.getRight().isEmpty()) {
				aux = aux.getRight();
			}
		}
		return aux;
	}

	@Override
	public BSTNode<K, V> minimum(BSTNode<K, V> node) {
		BSTNode<K, V> aux = null;
		if (!node.isEmpty()) {
			aux = node;
			while (!aux.getLeft().isEmpty()) {
				aux = aux.getLeft();
			}
		}
		return aux;
	}

	@Override
	public BSTNode<K, V> sucessor(BSTNode<K, V> node) {
		BSTNode<K, V> result = null;
		
		BSTNode<K, V> auxNode = search(node.getKey());

		if (!auxNode.getRight().isEmpty()) {
			result = minimum(auxNode.getRight());
		} else {
			result = auxNode.getParent();

			while (result != null && auxNode.equals(result.getRight())) {
				auxNode = result;
				result = result.getParent();
			}
		}
		
		return result;
    }

	@Override
	public BSTNode<K, V> predecessor(BSTNode<K, V> node) {
		BSTNode<K, V> result = null;
		
		BSTNode<K, V> auxNode = search(node.getKey());

		if (!auxNode.getLeft().isEmpty()) {
			result = maximum(auxNode.getLeft());
		} else {
			result = auxNode.getParent();

			while (result != null && auxNode.equals(result.getLeft())) {
				auxNode = result;
				result = result.getParent();
			}
		}
		
		return result;
	}

	@Override
	public void remove(K key) {
		BSTNode<K, V> node = search(key);
		removeAux(node);
	}
	
	protected void removeAux(BSTNode<K,V> node){
		if (!node.isEmpty()){
			if (node.getLeft().isEmpty() && node.getRight().isEmpty()){
				node.setKey(null);
				node.setValue(null);				
			} else{				
				if (!node.getLeft().isEmpty() || !node.getRight().isEmpty()){
					if (!node.equals(root)){
						if (node.getParent().getLeft().equals(node)){
							if (!node.getLeft().isEmpty()){
								node.parent.left = node.getLeft();
							} else{
								node.parent.left = node.getRight();
							}
						} else {
							if (!node.getLeft().isEmpty()){
								node.parent.right = node.getLeft();
							} else{
								node.parent.right = node.getRight();
							}						
						}
					} else{
						if (!root.getLeft().isEmpty() && root.getRight().isEmpty()){
							root = root.getLeft();
							root.setParent(null);
						} else{
							if (root.getLeft().isEmpty() && !root.getRight().isEmpty()) {
								root = root.getRight();
								root.setParent(null);
							} else{
								BSTNode<K, V> sucessor = sucessor(node);
								node.setKey(sucessor.getKey());
								node.setValue(sucessor.getValue());
								removeAux(sucessor);													
							}
						}
					}	
				} else{
					if (node.getParent() == null){
						node.setKey(null);
						node.setValue(null);
					}
					BSTNode<K, V> sucessor = sucessor(node);
					node.setKey(sucessor.getKey());
					node.setValue(sucessor.getValue());
					removeAux(sucessor);					
				}
			}
		}
	}

	@Override
	public K[] preOrder() {
		Comparable[] comparador = new Comparable[size()];
		ArrayList<K> result = new ArrayList<K>();
		preOrderAux(root, result);
		return (K[]) result.toArray(comparador);
	}
	
	private void preOrderAux(BSTNode<K, V> node, ArrayList<K> preOrdenado) {
		if (!node.isEmpty()) {
			preOrdenado.add(node.getKey());
			preOrderAux(node.getLeft(), preOrdenado);
			preOrderAux(node.getRight(), preOrdenado);
		}
    }

	@Override
	public K[] order() {
		Comparable[] comparador = new Comparable[size()];
		ArrayList<K> result = new ArrayList<K>();
		orderAux(root, result);
		return (K[]) result.toArray(comparador);
	}

	private void orderAux(BSTNode<K, V> newNode, ArrayList<K> ordenado){
		if (!newNode.isEmpty()) {
			orderAux(newNode.getLeft(), ordenado);
			ordenado.add(newNode.getKey());
			orderAux(newNode.getRight(), ordenado);
		}
    }
	
	@Override
	public K[] postOrder() {
		Comparable[] comparador = new Comparable[size()];
		ArrayList<K> result = new ArrayList<K>();
		postOrderAux(root, result);
		return (K[]) result.toArray(comparador);
	}
	
	private void postOrderAux(BSTNode<K, V> newNode, ArrayList<K> posOrdenado) {
		if (!newNode.isEmpty()) {
			postOrderAux(newNode.getLeft(), posOrdenado);
			postOrderAux(newNode.getRight(), posOrdenado);
			posOrdenado.add(newNode.getKey());
		}
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<K, V> node) {
		int result = 0;
		if (!node.isEmpty()) {
			result = 1 + size(node.left) + size(node.right);
		}
		return result;
	}
}
