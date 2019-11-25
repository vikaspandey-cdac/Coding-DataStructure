public class StringPermutationAlgorith {
    public static void main(String[] args){
        String str = "AABC";
        int count[] = {2, 1, 1};
        char[] result = new char[str.length()];
        permutate(new char[]{'A', 'B', 'C'},count, 0, result);
    }

    private static void permutate(char[] str, int[] count, int level, char[] result) {
        if (level == result.length) {
            System.out.println(new String(result));
            return;
        }
        for(int i=0; i<str.length; i++){
            if(count[i]==0)
                continue;
            result[level] = str[i];
            count[i]--;
            permutate(str,count, level+1, result);
            count[i]++;
        }
    }
}
