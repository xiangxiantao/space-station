package com.xxt.algorithm.day01;

/**
 * 二分查找
 *
 * @author xiantao.xiang
 * @date 2022-05-22 21:04
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        final int search = search(nums, 3);
        System.out.println(search);
    }

    /**
     * 如果找到，返回下标值
     * 如果找不到，返回-1
     * 1,3,4,5,6,8
     * 0,1,2,3,4,5
     *
     * @param nums   nums
     * @param target traget
     * @return res
     */
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (end - start) / 2 + start;
            if (target == nums[middle]) {
                return middle;
            }
            if (target < nums[middle]) {
                end = middle - 1;
            }
            if (target > nums[middle]) {
                start = middle + 1;
            }
        }
        return -1;
    }
}
