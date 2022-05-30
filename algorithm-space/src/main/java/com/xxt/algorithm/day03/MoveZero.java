package com.xxt.algorithm.day03;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * @author xiantao.xiang
 * @date 2022-05-24 22:00
 **/
public class MoveZero {

    /**
     * 解法1：首位指针
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int startPoint = 0;
        int endPoint = nums.length - 1;
        while (startPoint < endPoint) {
            if (nums[startPoint] != 0) {
                startPoint++;
            }
            if (nums[startPoint] == 0) {
                for (int i = startPoint; i < endPoint; i++) {
                    nums[i] = nums[i + 1];
                }
                nums[endPoint] = 0;
                endPoint--;
            }
        }
    }


    /**
     * 解法2：快慢指针
     *
     * @param nums nums
     */
    public void moveZeroes2(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
        }
    }
}
