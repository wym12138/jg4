package zhan;

import array.arraylist;

public class stack<E> extends arraylist<E> {
   // private arraylist<E> list= (arraylist<E>) new arraylist<>();//或者只调用一部分的arraylist


    public void push(E element){
        add(element);
    }

    public E pop(){
        return remove(size()-1);
    }

    public E top(){
        return get(size()-1);
    }



}
