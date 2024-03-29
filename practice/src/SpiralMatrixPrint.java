public class SpiralMatrixPrint {
    public static void main(String args[]){
        int m=4, n=8, length = 6;
        String str = "abcdef";
        new SpiralMatrixPrint().convert("abcdef");
    }
    private enum Dir {

        RIGHT, DOWN, LEFT, UP;
    }

    public String convert(String input) {
        double dRoot = Math.sqrt(input.length());
        int root;
        if (Double.compare(dRoot, (int) dRoot) == 0) {
            root = (int) dRoot;
        } else {
            root = (int) dRoot + 1;
        }

        char[][] out = new char[root][root];

        spiral(out, 0, 0, root, input);
        StringBuilder sb = new StringBuilder();

        for (char[] line : out) {
            sb.append(line);
        }

        return sb.toString();
    }

    private void spiral(char[][] out, int i, int j, int size, String input) {
        Dir direction = Dir.RIGHT;

        if (size > 0) {
            if (size == 1) {
                out[i][j] = input.charAt(0);
            } else {
                for (int k = 0; k < 4 * (size - 1); k++) {
                    int di = (k != 0 && k % (size - 1) == 0 ? size - 1 : k % (size - 1));
                    switch (direction) {
                        case RIGHT:
                            out[i][j + di] = input.charAt(k);
                            break;
                        case DOWN:
                            out[i + di][j + size - 1] = input.charAt(k);
                            break;
                        case LEFT:
                            out[i + size - 1][j + size - 1 - di] = input.charAt(k);
                            break;
                        case UP:
                            out[i + size - 1 - di][j] = input.charAt(k);
                            break;
                    }
                    if (k != 0 && (k % (size - 1) == 0)) //Change direction
                    {
                        direction = Dir.values()[direction.ordinal() + 1];
                    }
                }
            }
            spiral(out, i + 1, j + 1, size - 2, input.substring(4 * (size - 1)));
        } else {
            return;
        }
    }
}
