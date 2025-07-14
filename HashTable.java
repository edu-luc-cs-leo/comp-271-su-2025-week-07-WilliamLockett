/**
 * A simple hasht table is an array of linked lists. In its simplest form, a
 * linked list is represented by its first node. Typically we label this node as
 * "head". Here, however, we'll know it's the first node of the list because it
 * will be placed in an array element. For example, if we have 4 linked lists,
 * we know that the "head" of the third one can be found in position [2] of the
 * underlying array.
 */
public class HashTable<E extends Comparable<E>> {

    /**
     * Underlying array of nodes. Each non empty element of this array is the first
     * node of a linked list.
     */
    private Node[] underlying;

    /**
     * Default size for the underlying array. Users may specify any size, but the
     * default constructor will use this size.
     */
    private static final int DEFAULT_SIZE = 4;

    /** Basic constructor with user-specified size */
    public HashTable(int size) {
        this.underlying = new Node[size];
    }

    /** Default constructor, passes defauilt size to basic constructor */
    public HashTable() {
        this(DEFAULT_SIZE);
    }

    /**
     * Adds a node, with the specified content, to a linked list in the underlying
     * array.
     * 
     * @param content E The content of a new node, to be placed in the array.
     */
    public void add(E content) {
        Node<E> newNode = new Node<>(content); // creates a new node connected to content

        int hash = content.hashCode(); // creates an int to store the hash code
        int index = Math.abs(hash) % underlying.length; // converts the hash to an index for its posistion using modulo

        if (underlying[index] == null){ // if there is nothing in the index,
            underlying[index] = newNode;// place the node in the index's posistion.
        } else {                        // if there is something,
            newNode.setNext(underlying[index]); // links the node to the linkedlist (I read about it after I messed up the question in class),
            underlying[index] = newNode; // set the index to the node.
        }
    } // method add

} // class HashTable
