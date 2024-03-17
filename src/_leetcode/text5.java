package _leetcode;
//有效的括号..........栈类似

import java.util.HashMap;
import java.util.Stack;

public class text5 {
    public boolean isValid(String s){//效率太低，浪费内存
        while (s.contains("{}")||s.contains("()")||s.contains("[]")){
            s=s.replace("{}","");
            s=s.replace("()","");
            s=s.replace("[]","");
        }
        return s.isEmpty();
    }

    public boolean isValid2(String s){
        Stack<Character> stack=new Stack<>();
        int len=s.length();
        for (int i=0;i<len;i++){
            char c=s.charAt(i);//返回每个字符
            if (c=='('||c=='['||c=='{'){//左括号
                stack.push(c);
            }else {
                if (stack.isEmpty()) return false;
                char left=stack.pop();
                if (left=='('&&c!=')') return false;
                if (left=='{'&&c!='}') return false;
                if (left=='['&&c!=']') return false;

            }
        }
        return stack.isEmpty();
    }

    private static HashMap<Character,Character> map=new HashMap<>();
    //containsKey有得做
    //get左得右
    static {
        map.put('(',')');
    }






}
