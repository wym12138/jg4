package linked;

public class circlelink<E> {
    private int size;
    private Linklist.Node<E> firstNode;

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
        if (index==0){
            firstNode = new Linklist.Node<>(element, firstNode);//先赋值后操作
            //那到最后一个节点
            Linklist.Node<E> last =(size==0)?firstNode :node(size - 1);
            last.next=firstNode;
            size++;
        }else {
            Linklist.Node<E> prev = node(index - 1);
            prev.next=new Linklist.Node<E>(element,prev.next);
            size++;
        }
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
        if (index == 0) {
            if (size==1){
                firstNode=null;
            }else {
                Linklist.Node<E> last = node(size - 1);
                firstNode = firstNode.next;
                last.next = firstNode;
            }

        }else {
            Linklist.Node<E> prev = node(index - 1);
            node=prev.next;
            prev.next = prev.next.next;
        }
        size--;
        return node.element;

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
