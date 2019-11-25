package dynamicprogramming.wildcard;

public class WildcardMatching {
    public static void main(String args[]){
        System.out.println(isMatch("xbylmnz", "x?y?*z"));
    }

    private static boolean isMatch(String str, String pattern) {
        boolean T[][] = new boolean[str.length() + 1][pattern.length() + 1];
        T[0][0] = true;
        for(int i=1; i < T.length;i++){
            for(int j=1; j < T[0].length; j++){
                if(str.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?'){
                    T[i][j] = T[i-1][j-1];
                } else if(pattern.charAt(j-1)=='*'){
                    T[i][j] = T[i-1][j] || T[i][j-1];
                }
            }
        }
        return T[str.length()][pattern.length()];
    }
}
