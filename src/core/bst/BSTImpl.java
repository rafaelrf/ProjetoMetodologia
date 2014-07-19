
package core.bst;

import core.avltree.Estrutura;

import java.util.ArrayList;

public class BSTImpl<K extends Comparable<? super K>, V> implements BST<K, V>, Estrutura {

    protected BSTNode<K, V> root;

    public BSTImpl() {
        root = new BSTNode<K, V>();
    }

    @Override
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

    protected int heightAux(BSTNode<K, V> node) {
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
    public boolean search(K key) {
        BSTNode<K, V> temp = searchAux(key);
        if (temp.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }

    private BSTNode<K, V> searchAux(K key) {
        BSTNode<K, V> aux = root;

        while (!aux.isEmpty() && key != aux.getKey()) {
            if (key.compareTo(aux.getKey()) < 0) {
                aux = aux.getLeft();
            } else {
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

        BSTNode<K, V> auxNode = searchAux(node.getKey());

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

        BSTNode<K, V> auxNode = searchAux(node.getKey());

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

    @SuppressWarnings("unchecked")
    @Override
    public K[] preOrder() {
        @SuppressWarnings("rawtypes")
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

    @SuppressWarnings("unchecked")
    @Override
    public K[] order() {
        @SuppressWarnings("rawtypes")
        Comparable[] comparador = new Comparable[size()];
        ArrayList<K> result = new ArrayList<K>();
        orderAux(root, result);
        return (K[]) result.toArray(comparador);
    }

    private void orderAux(BSTNode<K, V> newNode, ArrayList<K> ordenado) {
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

    @Override
    public void remove(K key) {
        // TODO Auto-generated method stub

    }

    @SuppressWarnings("unchecked")
    @Override
    public void insert(String word) {
        insert((K) word, (V) word);

    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean search(String word) {

        return search((K) word);
    }
}
