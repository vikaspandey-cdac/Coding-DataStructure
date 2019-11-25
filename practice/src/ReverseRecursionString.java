public class ReverseRecursionString {
    public static void main(String args[]){
        System.out.println(reverseString("Vikas"));
    }

    private static String reverseString(String str) {
        if(str.length() == 0){
            return str;
        }
        return reverseString(str.substring(1))+str.charAt(0);
    }
}
