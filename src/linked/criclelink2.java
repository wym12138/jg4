package linked;

public class criclelink2<E> {
    private int size;
    private Linklist.Node<E> firstNode;
    private Linklist.Node<E> lastnode;

    private Linklist.Node<E> current;/////ysf

    public void reset(){
        current=firstNode;
    }
    public E next(){
        if (current==null) return null;
        current=current.next;
        return current.element;
    }
    public E remove(){
        if (current==null) return null;
        Linklist.Node<E> next=current.next;
        int index = indexOf(current.element);
        E element = remove(index);
        //可能空指针异常
        if (size==0) current=null;
        else current=next;

        return element;
    }
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



    public void add(int index,E element) {
        if (index!=size) {//bu最后面加
            Linklist.Node<E> next = node(index);
            Linklist.Node<E> prev = next.prev;
            Linklist.Node node = new Linklist.Node<>(prev, element, next);
            prev.next = node;
            if (prev == lastnode) {//index==0
                firstNode = node;
            }
        }else {
            Linklist.Node<E> oldlast=lastnode;
            lastnode=new Linklist.Node<>(lastnode,element,firstNode);
            if (oldlast==null){//空链表
                firstNode=lastnode;
                lastnode.next=lastnode;
                lastnode.prev=lastnode;
            }else {
                oldlast.next=lastnode;
                firstNode.prev=lastnode;
            }
        }
        size++;
    }

    public void add(E element){
        add(size,element);
    }


    public E get(int index) {
        return node(index).element;
    }


    public E set(int index,E element) {
        Linklist.Node<E> node=node(index);
        E old=node.element;
        node.element=element;
        return old;
    }


    public E remove(int index) {

        rangeCheck(index);
        Linklist.Node<E> node=firstNode;
        if (size==1){
            firstNode=null;
            lastnode=null;
            size--;
            return node.element;
        }else {
             node = node(index);
            node.prev.next = node.next;
            node.next.prev = node.prev;

            if (node.prev == lastnode) {//index==0
                firstNode = node.next;
            }

            if (node.next == firstNode) {
                lastnode = node.prev;
            }
            size--;
            return node.element;
        }

    }




    public int indexOf(E element) {
        if (element==null){
            Linklist.Node<E> node=firstNode;
            for (int i = 0; i < size; i++) {
                if (node.element==null)
                    return i;
                node=node.next;
            }

        }else {
            Linklist.Node<E> node=firstNode;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element))
                    return i;
                node=node.next;
            }
        }
        return ELEMENT_NOTFOUND;
    }


    public boolean contains(E element) {
        return indexOf(element)!=ELEMENT_NOTFOUND;
    }


    public String toString(){

        Linklist.Node<E> node=firstNode;
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<size;i++){
            sb.append(node.element);
            sb.append(" ");
            node=node.next;
        }
        return sb.toString();
    }

    //---------------------------------------------------------------
    private Linklist.Node<E> node (int index){//获取index位置节点对象
        rangeCheck(index);
        Linklist.Node<E> node=firstNode;
        for (int i=0;i<index;i++){
            node=node.next;
        }
        return node;

    }

    public void rangeCheck(int index){
        //rangecheck
        if (index<0||index>=size){//允许index=size(在添加中允许）
            throw new IndexOutOfBoundsException("index越界");//索引越界异常
        }
    }

}
