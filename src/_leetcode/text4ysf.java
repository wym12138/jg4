package _leetcode;

import linked.criclelink2;

public class text4ysf {
    public static void main(String[] args) {
        criclelink2<Integer> list=new criclelink2<>();
        for (int i=1;i<9;i++){
            list.add(i);
        }
        list.reset();//current指向头节点
        while (!list.isEmpty()){//不等于空
            for (int i=0;i<2;i++){
                list.next();
            }
            System.out.println(list.remove());
        }


    }
}
