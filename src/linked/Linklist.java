package linked;

public class Linklist <E> {
    private int size;
    private Node<E> firstNode;

    private static final int ELEMENT_NOTFOUND=-1;


    public void clear() {
        size=0;
        firstNode=null;

    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size==0;
    }


    public void add(int size,E element) {

    }

    public void add(E element){
        add(size,element);

    }


    public Object get() {
        return null;
    }


    public Object set() {
        return null;
    }


    public Object remove() {
        return null;
    }


    public int indexOf(E element) {
        return 0;
    }


    public boolean contains(E element) {
        return indexOf(element)!=ELEMENT_NOTFOUND;
    }

    private static class Node<E>{
        E element;
        Node<E> next;
        public Node(E element,Node<E> next){
            this.element=element;
            this.next=next;
        }
    }


}
