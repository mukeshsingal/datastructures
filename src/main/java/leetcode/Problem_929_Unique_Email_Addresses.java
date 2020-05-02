package leetcode;

public class Problem_929_Unique_Email_Addresses {
    
}
class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet();
        for(String email : emails) {
            
            String[] parts = email.split("@");
            
            String name = parts[0];
            
            int index = name.indexOf("+");
            if(index != -1) {
                name = name.substring(0, index);
            }
            name = name.replace(".", "");
            uniqueEmails.add(name + "@" + parts[1]);
        }
        return uniqueEmails.size();
    }
}