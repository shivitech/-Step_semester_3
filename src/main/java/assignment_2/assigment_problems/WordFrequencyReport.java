import java.util.*;

public class WordFrequencyReport {

    static void printFilteredWordFrequency(String feedback) {
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

        // Normalize: lowercase and strip periods/commas
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");

        // Split on whitespace
        String[] words = cleaned.split("\\s+");

        // Count frequencies, skipping stop words
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            if (!stopWords.contains(word) && !word.isEmpty()) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }

        // Sort by count descending
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freqMap.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
        // great: 2
        // mentor: 1
        // session: 1
        // clear: 1
    }
}