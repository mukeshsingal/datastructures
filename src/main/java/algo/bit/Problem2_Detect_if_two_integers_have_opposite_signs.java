package algo.bit;

class Problem2_Detect_if_two_integers_have_opposite_signs {
    public static void main(String[] args) {
        int x = -12, y = -13;
        if(checkIfSameSign(x, y)) {
            System.out.println("Yes both are same");
        }
        else {
            System.out.println("No both are not same");
        }
    }

    static boolean checkIfSameSign(int x, int y) {
        return (x ^ y) > 0;
    }
}