package com.xxt.algorithm.day01;

/**
 * 查找位置并插入
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * @author xiantao.xiang
 * @date 2022-05-22 21:40
 **/
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length;
        int res = -1;
        while (low <= high) {
            int middle = (high - low / 2) + low;
            if (target == nums[middle]) {
                return middle;
            }
            if (target > nums[middle]) {
                low = middle + 1;
            }
            if (target < nums[middle]) {
                high = middle - 1;
            }
            res = middle;
        }
        //走到这里说明目标值没有在循环中
        //如果目标值小于该位置的值
        if (target < nums[res]) {
            return res;
        }
        if (target > nums[res]) {
            return res + 1;
        }
        return -1;
    }

}
