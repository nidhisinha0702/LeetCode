package Contest;

import java.util.*;

public class MostCommonResponse {
    public static String mostCommonResponse(List<List<String>> responses) {
        Map<String, Integer> counter = new HashMap<>();
        
        for (List<String> day : responses) {
            Set<String> uniqueResponses = new HashSet<>(day); // Remove duplicates in a day
            for (String resp : uniqueResponses) {
                counter.put(resp, counter.getOrDefault(resp, 0) + 1);
            }
        }
        
        int maxCount = 0;
        String result = "";
        
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            String response = entry.getKey();
            int count = entry.getValue();
            
            if (count > maxCount || (count == maxCount && response.compareTo(result) < 0)) {
                maxCount = count;
                result = response;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> responses1 = Arrays.asList(
            Arrays.asList("good", "ok", "good", "ok"),
            Arrays.asList("ok", "bad", "good", "ok", "ok"),
            Arrays.asList("good"),
            Arrays.asList("bad")
        );
        System.out.println(mostCommonResponse(responses1)); // Output: good
        
        List<List<String>> responses2 = Arrays.asList(
            Arrays.asList("good", "ok", "good"),
            Arrays.asList("ok", "bad"),
            Arrays.asList("bad", "notsure"),
            Arrays.asList("great", "good")
        );
        System.out.println(mostCommonResponse(responses2)); // Output: bad
    }
}
