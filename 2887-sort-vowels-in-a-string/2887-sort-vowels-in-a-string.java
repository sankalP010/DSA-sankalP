class Solution {
    public String sortVowels(String s) {

        //Create arraylist to store vowel list and position
        ArrayList<Character> vowelList = new ArrayList<>();
        ArrayList<Integer> vowelPosition = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                vowelList.add(c);
                vowelPosition.add(i);
            }
        }

        //Sort Vowel list
        Collections.sort(vowelList);
        char[] result = s.toCharArray();

        //Replace vowel by keeping consonants at same place
        for(int i = 0; i < vowelPosition.size(); i++){
            result[vowelPosition.get(i)] = vowelList.get(i);
        }

        return new String(result);
    }
}