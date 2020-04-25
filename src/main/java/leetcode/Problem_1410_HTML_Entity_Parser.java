import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public String entityParser(String text) {
        Map<String,String> map = new LinkedHashMap<>();
        map.put("&quot;","\"");
        map.put("&apos;","\'");
        map.put("&gt;",">");
        map.put("&lt;","<");
        map.put("&frasl;","/");
        map.put("&amp;","&");
        
        for (Map.Entry<String, String> entry : map.entrySet()) {
            text = text.replace(entry.getKey(),entry.getValue());
        }

        return text;        
    }
}