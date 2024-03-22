package ercha;

import linked.Linklist;

import java.util.LinkedList;
import java.util.Queue;

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
    //------------------------遍历接口:用户自己设计遍历
    public void levelorder(Visitor<E> visitor){
        if (root==null)return;
        Queue<Node<E>> queue=new LinkedList<>();
        queue.offer(root);//
        while (!queue.isEmpty()){
            Node<E> poll = queue.poll();
            if(visitor.visit(poll.element))return;//boolean增强便利
            if (poll.left!=null){
                queue.offer(poll.left);
            }
            if (poll.right!=null){
                queue.offer(poll.right);
            }
        }
    }
    public static abstract class Visitor<E>{

        boolean stop;//用于迭代//一次visit一个stop//需要两次return
        abstract boolean visit(E element);//如果为true就停止遍历
    }
    //--------------------------
    private class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;


        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf(){
            return left==null&&right==null;
        }
        public boolean two(){
            return left!=null&&right!=null;
        }
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



    public void cengxu(){
        if (root==null)return;
        Queue<Node<E>> queue=new LinkedList<>();
        queue.offer(root);//
        while (!queue.isEmpty()){
            Node<E> poll = queue.poll();
            System.out.println(poll.element);
            if (poll.left!=null){
                queue.offer(poll.left);
            }
            if (poll.right!=null){
                queue.offer(poll.right);
            }
        }


    }
    //--------------------打印树
    public String toString(){
        StringBuilder sb =new StringBuilder();
        toString(root,sb,"");
        return sb.toString();
    }

    private void toString(Node<E> node,StringBuilder sb,String prefix){
        if (node==null) return;
        //前序遍历
        sb.append(prefix).append(node.element).append("\n");
        toString(node.left,sb,prefix+"L");
        toString(node.right,sb,prefix+"R");

    }
    //----------------------------hight
    public int hight(){
        return hight(root);
    }

    private int hight(Node<E> node){
        if (node==null) return 0;
        return 1+Math.max(hight(node.left),hight(node.right));
    }


    public int hight1(){
        return hight(root);
    }

    private int hight1(Node<E> node){//需知道一层有多少个

        int hight=0;
        int levelsize=1;//存储每一层的元素数量

        if (root==null) return 0;
        Queue<Node<E>> queue=new LinkedList<>();
        queue.offer(root);//
        while (!queue.isEmpty()){
            Node<E> poll = queue.poll();
            levelsize--;
            if (poll.left!=null){
                queue.offer(poll.left);
            }
            if (poll.right!=null){
                queue.offer(poll.right);
            }
            if (levelsize==0){
                levelsize=queue.size();
                hight++;
            }
        }
        return hight;
    }
    //--------------------------是否为瓦努请按二叉树
    boolean leaf=false;
    public boolean isComplete(){
        if (root==null) return false;
        Queue<Node<E>> queue=new LinkedList<>();
        queue.offer(root);//
        while (!queue.isEmpty()){
            Node<E> poll = queue.poll();
            if (leaf&&!poll.isLeaf()){
                return false;
            }
            if (poll.right!=null&&poll.left!=null){
                queue.offer(poll.left);
                queue.offer(poll.right);
            }else if(poll.left==null&&poll.right!=null){
                return false;
            }else {//必须叶子节点
                leaf=true;
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
            }

        }
        return true;
    }

    public boolean isComplete1() {
        if (root == null) return false;
        Queue<Node<E>> queue=new LinkedList<>();
        queue.offer(root);
        boolean leaf=false;
        while (!queue.isEmpty()){
            Node<E> poll = queue.poll();
            if (leaf&&!poll.isLeaf()) return false;
            if (poll.left!=null){
                queue.offer(poll.left);
            }else if (poll.right!=null){
                return false;
            }
            if (poll.right!=null){
                queue.offer(poll.right);
            }else{
                leaf=true;

            }
        }
        return true;
    }
}
