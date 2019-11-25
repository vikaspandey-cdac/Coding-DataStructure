public class ExceptionTestClass {
    public static void main (String args[]){
        try {
            int i = callMethodA();
            System.out.println(i);
        }catch(Exception e){
           e.printStackTrace();
        }

    }

    private static int callMethodA() throws Exception{

        int a =10;
        Personc obj  = new Personc(){

            @Override
            public int add(int c, int d) {
                return c + d + a;
            }
        };
        return obj.add(19, 20);
        //return a+2;
    }
    abstract static class Personc {
        abstract public int add(int a , int b);
    }
}
