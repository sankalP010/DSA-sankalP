import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private final Map<Character, String> digitToLetters = new HashMap<>();
    
    public Solution() {
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        
        backtrack(combinations, digits, new StringBuilder(), 0);
        
        return combinations;
    }
    
    private void backtrack(List<String> combinations, String digits, StringBuilder current, int index) {
        if (index == digits.length()) {
            combinations.add(current.toString());
            return;
        }
        
        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);
        
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(combinations, digits, current, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
