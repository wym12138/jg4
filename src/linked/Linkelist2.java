package linked;

public class Linkelist2 <E>{//双向链表



        private int size;
        private Linklist.Node<E> firstNode;
        private Linklist.Node<E> lastnode;

        private static final int ELEMENT_NOTFOUND=-1;


        public void clear() {
            size=0;
            firstNode=null;
            lastnode=null;

        }


        public int size() {
            return size;
        }


        public boolean isEmpty() {
            return size==0;
        }



        public void add(int index,E element) {

            if (index!=size) {//最后面加
                Linklist.Node<E> next = node(index);
                Linklist.Node<E> prev = next.prev;
                Linklist.Node node = new Linklist.Node<>(prev, element, next);
                if (prev == null) {//index==0
                    firstNode = node;
                } else {
                    prev.next = node;
                }
            }else {
                Linklist.Node<E> oldlast=lastnode;
                lastnode=new Linklist.Node<>(lastnode,element,null);
                if (oldlast==null){
                    firstNode=lastnode;
                }else {
                    oldlast.next=lastnode;
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
            linked.Linklist.Node<E> node=node(index);
            E old=node.element;
            node.element=element;
            return old;
        }


        public E remove(int index) {
            rangeCheck(index);
            Linklist.Node<E> node=node(index);

            if (node.prev==null){//index==0
                firstNode=node.next;
                //node.next.prev=null;//会执行下一个if
            }else {
                node.prev.next=node.next;
            }

            if (node.next==null){
                lastnode=node.prev;
            }else {
                node.next.prev=node.prev;
            }

            size--;
            return node.element;

        }




        public int indexOf(E element) {
            if (element==null){
                linked.Linklist.Node<E> node=firstNode;
                for (int i = 0; i < size; i++) {
                    if (node.element==null)
                        return i;
                    node=node.next;
                }

            }else {
                linked.Linklist.Node<E> node=firstNode;
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

            linked.Linklist.Node<E> node=firstNode;
            StringBuilder sb=new StringBuilder();
            for (int i=0;i<size;i++){
                sb.append(node.element);
                sb.append(" ");
                node=node.next;
            }
            return sb.toString();
        }


        //---------------------------------------------------------------
        private linked.Linklist.Node<E> node (int index){//获取index位置节点对象

            rangeCheck(index);

            if (index<(size>>1)){
                linked.Linklist.Node<E> node=firstNode;
                for (int i=0;i<index;i++){
                    node=node.next;
                }
                return node;

            }else {
                Linklist.Node<E> node = lastnode;
                for (int i=size-1;i>index;i--){
                    node=node.prev;
                }
                return node;


            }



        }

        public void rangeCheck(int index){
            //rangecheck
            if (index<0||index>=size){//允许index=size(在添加中允许）
                throw new IndexOutOfBoundsException("index越界");//索引越界异常
            }
        }


    }


