package _leetcode;

import java.util.Stack;

public class text6 {//用栈实现队列
    private Stack<Integer> inStack=new Stack<>();
    private Stack<Integer> outStack=new Stack<>();

    public void push(int x){//入队
        inStack.push(x);

    }

    public int pop(){
        if (outStack==null){
            int size = inStack.size();
            for (int i=0;i<size;i++) {
                Integer j = inStack.pop();//aaaaaaaaaaaaaaaaaa
                outStack.push(j);
            }

        }
        return outStack.pop();
    }


    public int peek(){
        if (outStack==null){
            int size = inStack.size();
            for (int i=0;i<size;i++) {
                Integer j = inStack.pop();
                outStack.push(j);
            }
        }
        return outStack.peek();
    }

    public boolean empty(){
       // if (inStack.isEmpty()&&outStack.isEmpty()){
       //     return true;
       // }
       // return false;
        return inStack.isEmpty()&&outStack.isEmpty();
    }


}
