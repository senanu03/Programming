package InterviewRelatedAssignment.tier1;

import java.util.HashMap;
import java.util.Map;

public class Length_Of_Longest_Substring_WithoutRepeating_Characters {
    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> lastSeen = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0;
             right < s.length();
             right++) {

            char current = s.charAt(right);

            // If character was already seen inside
            // the current window, move left.
            if (lastSeen.containsKey(current)) {

                left = Math.max(
                        left,
                        lastSeen.get(current) + 1
                );
            }

            lastSeen.put(current, right);

            maxLength = Math.max(
                    maxLength,
                    right - left + 1
            );
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }
}
