package array;

import linked.List;

public class arraylist<E>  {
    private int size;
    private E[] elements;

    private static final int DEFAYLT_CAPACITY=10;
    private static final int ELEMENT_NOTFOUND=-1;


    //------------增删改查-------------------------------


    public arraylist(int capaticy){
        capaticy=(capaticy<0)?DEFAYLT_CAPACITY:capaticy;//三元
        elements= (E[]) new Object [capaticy];

    }
    public arraylist(){
        this(DEFAYLT_CAPACITY);
    }

    public void clear(){
        for(int i=0;i<size;i++){//清空数组中地址，对象因此消失//内存管理细节
            elements[i]=null;
        }
        size=0;
        if (elements!=null&&elements.length>DEFAYLT_CAPACITY){
            elements= (E[]) new Object[DEFAYLT_CAPACITY];
        }

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(E element){
        add(size,element);
    }
    public E get(int index){
        if (index<0||index>=size){
            throw new IndexOutOfBoundsException("index越界");//索引越界异常
        }
        return elements[index];
    }

    public E set(int index,E element){
        if (index<0||index>=size){
            throw new IndexOutOfBoundsException("index越界");//索引越界异常
        }
        E old=elements[index];
        elements[index]=element;
        return old;
    }

    public void add(int index,E element){
        if (index<0||index>size){//允许index=size
            throw new IndexOutOfBoundsException("index越界");//索引越界异常
        }
        //扩容
        ensureConpasity(size+1);

        for (int i=size-1;i>=index;i--){
            elements[i+1]=elements[i];
        }
        elements[index]=element;
        size++;



    }

    public E remove(int index){//挪动
        if (index<0||index>=size){
            throw new IndexOutOfBoundsException("index越界");//索引越界异常
        }
        E old=elements[index];
        for (int i=index+1;i<size;i++){
            elements[i-1]=elements[i];
        }
        size--;
        elements[size]=null;//内存管理细节

        trim();//缩容

        return old;
    }

    public void remove(E element){
        remove(indexOf(element));
    }

    public int indexOf(E element){//写元素返回索引
        if (element==null){
            for (int i = 0; i < size; i++) {
                if (elements[i]==null)
                    return i;
            }

        }else {

            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i]))
                    return i;
            }
        }
        return ELEMENT_NOTFOUND;

    }

    public boolean contains(E element){
        return indexOf(element)!=ELEMENT_NOTFOUND;
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<size;i++){
            sb.append(elements[i]);
            sb.append(" ");
        }
        return sb.toString();
    }


    //----------------------------------------------------

    private void ensureConpasity(int newcapacity){//保证有capacity的容量
        int oldcap =elements.length;
        if (oldcap>=newcapacity){
            return;
        }else {
            int new1=oldcap+(oldcap>>1);//1.5倍
            E[] newElement= (E[]) new Object[new1];
            for (int i=0;i<size;i++){
                newElement[i]=elements[i];
            }
            elements=newElement;
        }
    }

    private void trim(){
        int capacity=elements.length;
        if (size>=(capacity>>1) || capacity<=DEFAYLT_CAPACITY) return;//注意复杂震荡度：扩容倍数与缩容倍数相乘=1

        int new1=capacity>>1;//half
        E[] newElement= (E[]) new Object[new1];
        for (int i=0;i<size;i++){
            newElement[i]=elements[i];
        }
        elements=newElement;
    }



}
