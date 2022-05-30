package com.xxt.algorithm.day02;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序
 * 方案1：先把原数组按照绝对值进行排序，再平方
 * 方案2：直接平方，然后排序
 * 方案3：把数组从第一个0处拆分为两个数组，分别平方，再利用两个指针分别指向两个数组最小的值，进行排序
 * 方案4：直接用两个指针指向数组的两端，向中间靠拢，并依次进行比较
 *
 * @author xiantao.xiang
 * @date 2022-05-23 21:34
 **/
public class DubboPoint {

    public static void main(String[] args) {
        int[] a = new int[]{-4, -1, 0, 3, 10, 11};
        Arrays.stream(new DubboPoint().sortedSquares(a)).forEach(System.out::println);
    }

    public int[] sortedSquares(int[] nums) {
        int startPointOfNonNegativeNumber = -1;
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                startPointOfNonNegativeNumber = i;
            } else {
                break;
            }
        }
        int left = startPointOfNonNegativeNumber;
        int right = startPointOfNonNegativeNumber + 1;
        int point = 0;
        int[] res = new int[nums.length];
        while (left >= 0 || right < length) {
            if (left < 0) {
                res[point] = nums[right] * nums[right];
                right++;
            } else if (right == length) {
                res[point] = nums[left] * nums[left];
                left--;
            } else if (nums[left] * nums[left] < nums[right] * nums[right]) {
                res[point] = nums[left] * nums[left];
                left--;
            } else {
                res[point] = nums[right] * nums[right];
                right++;
            }
            point++;
        }
        return res;
    }

}
