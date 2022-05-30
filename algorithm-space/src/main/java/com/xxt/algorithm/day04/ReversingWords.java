package com.xxt.algorithm.day04;

/**
 * @author xiantao.xiang
 * @date 2022-05-25 21:19
 **/
public class ReversingWords {

    public String reverseWords(String s) {
        final char[] chars = s.toCharArray();
        int ws = 0, we = 0, as = 0;
        while (as < chars.length) {
            if (as == chars.length - 1) {
                while (ws <= we) {
                    char temp = chars[ws];
                    chars[ws] = chars[we];
                    chars[we] = temp;
                    ws++;
                    we--;
                }
                break;
            }
            if (chars[as] != ' ') {
                if (chars[as + 1] != ' ') {
                    we++;
                }
                as++;
            }
            if (chars[as] == ' ') {
                while (ws <= we) {
                    char temp = chars[ws];
                    chars[ws] = chars[we];
                    chars[we] = temp;
                    ws++;
                    we--;
                }
                as++;
                ws = as;
                we = as;
            }
        }
        return new String(chars);
    }

}
