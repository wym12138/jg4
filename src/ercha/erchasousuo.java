package ercha;

public class erchasousuo <E>{

    private int size;
    private  Node<E> root;

    private Comparator<E> comparator;

    public erchasousuo(Comparator<E> comparator){//构造函数必须带着比较器，用户根据需求自定义方法
        this.comparator=comparator;
    }
    public erchasousuo(){
        this(null);
    }

    //---------------------------------------
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void clear(){

    }

    public void add(E element){
        notnull(element);
        if (root==null){//添加第一个节点
            root=new Node<>(element,null);
            size++;
            return;
        }
        Node<E> node=root;
        Node<E> parent=null;//存下来父节点
        int compare=0;//存下来最后一次比较结果
        while (node!=null){
            compare = compare(element, node.element);
            parent=node;
            if (compare>0){
                node=node.right;//类似链表指针变化
            } else if (compare < 0) {
                node=node.left;
            }else {
                node.element=element;
                return;
            }
        }
        Node<E> newnode=new Node<>(element,parent);
        if (compare>0){
            parent.right=newnode;
        }else {
            parent.left=newnode;
        }



    }

    public void remove(E element){

    }

    public void contain(E element){

    }
    //------------------------------------------------------------
    // compareable接口
    //comparator比较器
    //实现两种兼容
    private int compare(E e1,E e2){//返回值>0 e1大
        if (comparator!=null){
            return comparator.compare(e1,e2);
        }
        return ((Comparable <E>)e1).Compareto(e2);//强制继承

    }

    private void notnull(E element){
        if (element==null){
            throw new IllegalArgumentException("不能唯恐");
        }
    }
    private class Node<E>{
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;


        public Node(E element,Node<E> parent){
            this.element=element;
            this.parent=parent;
        }

        //------------------------遍历
        private void preorder(erchasousuo<E>.Node<E> node){
            if (node==null) return;
            System.out.println(node.element);
            preorder(node.left);
            preorder(node.right);
        }
        public void preorder(){//执行函数
            preorder((erchasousuo<E>.Node<E>) root);

        }


        private void middle(erchasousuo<E>.Node<E> node){
            if (node==null) return;
            middle(node.left);
            System.out.println(node.element);
            middle(node.right);

        }
        public void middle(){
            middle((erchasousuo<E>.Node<E>) root);
        }




        private void last(erchasousuo<E>.Node<E> node){
            if (node==null) return;
            last(node.left);
            last(node.right);
            System.out.println(node.element);



        }

        public void last(){
            last((erchasousuo<E>.Node<E>) root);
        }
    }
}
