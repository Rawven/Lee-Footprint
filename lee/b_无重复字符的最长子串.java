import java.util.HashMap;

public class b_无重复字符的最长子串 {
    public static void main(String[] args) {
        lengthOfLongestSubstring("abba");
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * length of longest substring
     * <p>
     * 滑动窗口
     *
     * @param s s
     * @return int
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.isEmpty()) {
            return 0;
        }
        int max = 1, left = 0, i;
        HashMap<Character, Integer> map = new HashMap<>();
        for (i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (left < map.get(s.charAt(i)) + 1) {
                    if (max < i - left) {
                        max = i - left;
                    }
                    left = map.get(s.charAt(i)) + 1;
                }
            }
            map.put(s.charAt(i), i);
        }
        if (max < i - left) {
            max = i - left;
        }
        return max;
    }
}
