
package core.bst;

import core.avltree.Estrutura;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class BSTImpl.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class BSTImpl<K extends Comparable<? super K>, V> implements BST<K, V>, Estrutura {

    /** The root. */
    protected BSTNode<K, V> root;

    /**
     * Instantiates a new BST impl.
     */
    public BSTImpl() {
        root = new BSTNode<K, V>();
    }

    /* (non-Javadoc)
     * @see core.bst.BST#getRoot()
     */
    @Override
    public BSTNode<K, V> getRoot() {
        return this.root;
    }

    /* (non-Javadoc)
     * @see core.bst.BST#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return root.isEmpty();
    }

    /* (non-Javadoc)
     * @see core.bst.BST#height()
     */
    @Override
    public int height() {
        return heightAux(root);
    }

    /**
     * Height aux.
     *
     * @param node the node
     * @return the int
     */
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

    /* (non-Javadoc)
     * @see core.bst.BST#search(java.lang.Comparable)
     */
    @Override
    public boolean search(K key) {
        BSTNode<K, V> temp = searchAux(key);
        if (temp.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * Search aux.
     *
     * @param key the key
     * @return the BST node
     */
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

    /* (non-Javadoc)
     * @see core.bst.BST#insert(java.lang.Comparable, java.lang.Object)
     */
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

    /* (non-Javadoc)
     * @see core.bst.BST#maximum(core.bst.BSTNode)
     */
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

    /* (non-Javadoc)
     * @see core.bst.BST#minimum(core.bst.BSTNode)
     */
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

    /* (non-Javadoc)
     * @see core.bst.BST#sucessor(core.bst.BSTNode)
     */
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

    /* (non-Javadoc)
     * @see core.bst.BST#predecessor(core.bst.BSTNode)
     */
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

    /* (non-Javadoc)
     * @see core.bst.BST#preOrder()
     */
    @SuppressWarnings("unchecked")
    @Override
    public K[] preOrder() {
        @SuppressWarnings("rawtypes")
        Comparable[] comparador = new Comparable[size()];
        ArrayList<K> result = new ArrayList<K>();
        preOrderAux(root, result);
        return (K[]) result.toArray(comparador);
    }

    /**
     * Pre order aux.
     *
     * @param node the node
     * @param preOrdenado the pre ordenado
     */
    private void preOrderAux(BSTNode<K, V> node, ArrayList<K> preOrdenado) {
        if (!node.isEmpty()) {
            preOrdenado.add(node.getKey());
            preOrderAux(node.getLeft(), preOrdenado);
            preOrderAux(node.getRight(), preOrdenado);
        }
    }

    /* (non-Javadoc)
     * @see core.bst.BST#order()
     */
    @SuppressWarnings("unchecked")
    @Override
    public K[] order() {
        @SuppressWarnings("rawtypes")
        Comparable[] comparador = new Comparable[size()];
        ArrayList<K> result = new ArrayList<K>();
        orderAux(root, result);
        return (K[]) result.toArray(comparador);
    }

    /**
     * Order aux.
     *
     * @param newNode the new node
     * @param ordenado the ordenado
     */
    private void orderAux(BSTNode<K, V> newNode, ArrayList<K> ordenado) {
        if (!newNode.isEmpty()) {
            orderAux(newNode.getLeft(), ordenado);
            ordenado.add(newNode.getKey());
            orderAux(newNode.getRight(), ordenado);
        }
    }

    /* (non-Javadoc)
     * @see core.bst.BST#postOrder()
     */
    @Override
    public K[] postOrder() {
        Comparable[] comparador = new Comparable[size()];
        ArrayList<K> result = new ArrayList<K>();
        postOrderAux(root, result);
        return (K[]) result.toArray(comparador);
    }

    /**
     * Post order aux.
     *
     * @param newNode the new node
     * @param posOrdenado the pos ordenado
     */
    private void postOrderAux(BSTNode<K, V> newNode, ArrayList<K> posOrdenado) {
        if (!newNode.isEmpty()) {
            postOrderAux(newNode.getLeft(), posOrdenado);
            postOrderAux(newNode.getRight(), posOrdenado);
            posOrdenado.add(newNode.getKey());
        }
    }

    /* (non-Javadoc)
     * @see core.bst.BST#size()
     */
    @Override
    public int size() {
        return size(root);
    }

    /**
     * Size.
     *
     * @param node the node
     * @return the int
     */
    private int size(BSTNode<K, V> node) {
        int result = 0;
        if (!node.isEmpty()) {
            result = 1 + size(node.left) + size(node.right);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see core.bst.BST#remove(java.lang.Comparable)
     */
    @Override
    public void remove(K key) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see core.avltree.Estrutura#insert(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    public void insert(String word) {
        insert((K) word, (V) word);

    }

    /* (non-Javadoc)
     * @see core.avltree.Estrutura#search(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean search(String word) {

        return search((K) word);
    }
}
