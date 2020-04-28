package leetcode;

public class Problem_187_Repeated_DNA_Sequences {

}

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
       List list= new ArrayList<>();
        
        if(s == null || s.length() < 10){
            return list;
        }
        Set<String> seen = new HashSet<>();

		Set<String> out = new HashSet<>();

		for (int i = 0; i < s.length()-9; i++) {

			String temp = s.substring(i, i + 10);

			if (!seen.add(temp) ) {
				out.add(temp);
			} 
		}

        list.addAll(out);
		return list;
    }
}