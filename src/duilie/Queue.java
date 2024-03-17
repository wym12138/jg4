package duilie;

import linked.Linkelist2;

public class Queue <E>  {
    private Linkelist2<E> list=new Linkelist2<>();
    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
    public void enQueue(E element){//入队
        list.add(element);
    }

    public E deQueue(){
        E remove = list.remove(0);
        return remove;
    }

    public E front(){
        return list.get(0);
    }


    //用栈实现队列
    //两个栈，instack，outstack
    //出栈观察outstack是否为空



}
