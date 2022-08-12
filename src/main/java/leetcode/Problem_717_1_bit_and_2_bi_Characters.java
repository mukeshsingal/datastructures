package leetcode;

// https://leetcode.com/problems/1-bit-and-2-bit-characters/

public class Problem_717_1_bit_and_2_bi_Characters {
    public boolean isOneBitCharacterRecursive(int[] bits) {
        return util(bits, 0);
    }

    public boolean util(int[] bits, int current) {

        if(current == bits.length) {
            return false;
        }
        if(current == bits.length - 1) {
            return true;
        }

        if(bits[current] == 0) {
            return util(bits, current + 1);
        }
        else {
            return util(bits, current + 2);
        }
    }

    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        int index = 0;
        boolean last = false;

        while(index < len){
            if(bits[index] == 0) {
                index++;
                last = true;
                continue;
            }
            if(bits[index] == 1) {
                last = false;
                index += 2;
            }
        }
        return last;
    }
}
