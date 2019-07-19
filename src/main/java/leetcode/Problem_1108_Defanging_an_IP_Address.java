package leetcode;

public class Problem_1108_Defanging_an_IP_Address {

    public String defangIPaddr(String address) {
        String res = "";
        for(int i = 0; i < address.length(); i++) {
            if(address.charAt(i) == '.'){
                res += "[.]";
            }
            else{
                res += address.charAt(i);
            }
        }
        return res;
    }
}