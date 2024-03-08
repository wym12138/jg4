public class Assert {
    public static void test(boolean value){
        if(!value) try {
            throw new Exception("未通过");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
