package leetcode;

class Problem_657_Judge_Route_Circle {
    public boolean judgeCircle(String moves) {
        int l = 0;
        int r = 0;
        int t = 0;
        int d = 0;
        char[] chars = moves.toCharArray();
        for(char c: chars){
            if(c == 'U') t++;
            else if(c == 'D') d++;
            else if(c == 'L') l++;
            else if(c == 'R') r++;
            else return false;
        }
        if(l == r && t == d) {
            return true;
        }
        else {
            return false;
        }

    }
}
