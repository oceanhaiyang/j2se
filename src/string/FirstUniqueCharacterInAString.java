package string;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInAString {
    int[] CHAR = new int[26];

    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println(new FirstUniqueCharacterInAString().firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        if (s == null || s.isEmpty()) return -1;

        for (int i = 0; i < s.length(); i++)
            CHAR[s.charAt(i)-'a']++;

        for (int i = 0; i <s.length() ; i++) {
            if (CHAR[s.charAt(i)-'a'] == 1)
                return i;
        }

        return -1;
    }
}

