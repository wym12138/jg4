public class main {
    public static int fib(int n){//递归求数
        if (n<=1){
            return n;
        }
        return fib(n-1)+fib(n-2);

    }

    public static int fib2(int n){
        if (n<=1){
            return n;
        }
        int first=0;
        int second=1;
        for (int i=0;i<n-1;i++){
            int sum=first+second;
            first=second;
            second=sum;
        }
        return second;

    }

    public static void main(String[] args) {
        System.out.println(fib(20));

    }


}
