package com.dstealer.algrothims.recursion;

/**
 * 反转字符串
 */
public class ReversingString {
    public static String reserve(String str) {
        if ("".equals(str)) {
            return str;
        } else {
            String head = str.substring(0, 1);
            String tail = reserve(str.substring(1));
            return tail + head;
        }
    }

    /**
     * 反转字符串,空格需要保留 例如 :    this is a      <=>    siht si a
     *
     * @param str
     * @return
     */
    public static String reserveNonEmpty(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0, j = 0; i < chars.length; ) {
            while (i < chars.length && chars[i] == ' ') {
                i++;
            }
            j = i;
            while (j < chars.length && chars[j] != ' ') {
                j++;
            }

            for (int x = i, y = j - 1; y > x; x++, y--) {
                char t = chars[x];
                chars[x] = chars[y];
                chars[y] = t;

            }
            i = j;
        }
        return new String(chars);
    }
}
