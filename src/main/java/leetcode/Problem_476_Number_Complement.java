package leetcode;

public class Problem_476_Number_Complement {

    public int findComplement(int num) {
        int count = 0;
        int x = num;

        while(x != 0) {
            count++;
            x = x >> 1;
        }

        int mask = 0;
        for(int i = 0; i < count; i++) {
            mask = ((mask << 1) | 1);
        }

        return num ^ mask;
    }
}