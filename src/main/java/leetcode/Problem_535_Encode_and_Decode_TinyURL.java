package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem_535_Encode_and_Decode_TinyURL {

    List<String> map;
    int count = 0;
    String prefix;

    public Problem_535_Encode_and_Decode_TinyURL() {
        map = new ArrayList<String>();
        prefix = "http://tinyurl.com/";
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.add(longUrl);
        return prefix + (count++);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int idx = Integer.parseInt(shortUrl.substring(prefix.length())); 
        return map.get(idx);
    }
}