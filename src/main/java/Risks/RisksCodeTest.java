package Risks;

import java.util.ArrayList;
import java.util.List;

public class RisksCodeTest {
    public int[] getSumIndex(int[] numbs, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbs.length; i++) {
            for (int j = i + 1; j < numbs.length; j++) {
                if (numbs[i] + numbs[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public boolean isPalindrome(String text) {
        boolean result = true;
        text = text.toLowerCase();
        List<Character> textArray = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            char item = text.charAt(i);
            if (item >= 'a' && item <= 'z') {
                textArray.add(item);
            }
        }
        int length = textArray.size();
        int mid = textArray.size() / 2;
        for (int i = 0; i < mid; i++) {
            int right = length - i - 1;
            if (textArray.get(i) != textArray.get(right)) {
                return false;
            }
        }
        return true;
    }
}
