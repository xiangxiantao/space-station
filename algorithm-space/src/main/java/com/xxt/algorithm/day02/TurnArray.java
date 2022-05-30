package com.xxt.algorithm.day02;

/**
 * @author xiantao.xiang
 * @date 2022-05-24 21:35
 **/
public class TurnArray {

    /**
     * 使用了一个临时数组
     * @param nums nums
     * @param k k
     */
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        int[] temp = new int[size];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % size] = nums[i];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        System.out.println(turn(0, 5, 0));
        System.out.println(turn(0, 5, 1));
        System.out.println(turn(0, 5, 2));
        System.out.println(turn(0, 5, 3));
        System.out.println(turn(0, 5, 4));
        System.out.println(turn(0, 5, 5));
        System.out.println(turn(0, 5, 6));
        System.out.println(turn(0, 5, 7));
        System.out.println(turn(0, 5, 8));
        System.out.println(turn(0, 5, 9));
        System.out.println(turn(0, 5, 10));
    }

    public static int turn(int index, int size, int k) {
        return (index + k) % size;
    }
}
