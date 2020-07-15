// 242. Valid Anagram
// What is anagram?:
// アナグラム（anagram）とは、言葉遊びの一つで、単語または文の中の文字をいくつか入れ替えることによって、全く別の意味にさせる遊びである。 (Wikipedia)

// Accepted
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                count = map.get(c);
            }
            map.put(c, count + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            int count = map.get(c);
            if (count == 0) {
                return false;
            }
            if (count == 1) {
                map.remove(c);
            } else {
                map.put(c, count - 1);
            }
        }
        if (map.size() == 0) {
            return true;
        }
        return false;
    }
}
