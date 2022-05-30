package com.xxt.algorithm.day03;

/**
 * 两数之和（有序数组）
 *
 * @author xiantao.xiang
 * @date 2022-05-24 23:09
 **/
public class TwoSum {
    public static void main(String[] args) {
        int[] arg = new int[]{2, 7, 11, 15};
        new TwoSum().twoSum(arg, 9);
    }

    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int[] result = new int[2];
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                break;
            }
            if (numbers[start] + numbers[end] > target) {
                end--;
            }
            if (numbers[start] + numbers[end] < target) {
                start++;
            }
        }
        return result;
    }
}
