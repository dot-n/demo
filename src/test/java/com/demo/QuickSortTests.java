package com.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 *
 * @author harold
 * @date 2025/11/25 18:06
 */
public class QuickSortTests {
    // ... existing code ...

    public int partitionArray(int[] nums, int left, int right) {
        if (nums.length <= 1) {
            return left;
        }
        int maxIndex = nums.length - 1;
        int pivotIndex = right;
        int pivot = nums[pivotIndex];
        right--;

        while (true) {
            while (left < maxIndex && nums[left] < pivot) {
                left++;
            }
            while (right >= 0 && nums[right] > pivot) {
                right--;
            }
            if (left >= right) {
                break;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        int temp = nums[left];
        nums[left] = nums[pivotIndex];
        nums[pivotIndex] = temp;
        return left;
    }

    /**
     * 快速排序主函数
     * @param nums 待排序数组
     */
    public void quickSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        quickSortHelper(nums, 0, nums.length - 1);
    }

    /**
     * 快速排序递归辅助函数
     * @param nums 数组
     * @param left 左边界
     * @param right 右边界
     */
    private void quickSortHelper(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        // 获取分区点
        int pivotIndex = partitionArray(nums, left, right);

        // 递归排序左半部分
        quickSortHelper(nums, left, pivotIndex - 1);

        // 递归排序右半部分
        quickSortHelper(nums, pivotIndex + 1, right);
    }

    @Test
    void testQuickSort() {
        int[] arr = {5, 4, 3, 2, 5, 1, 9, 0};
        System.out.println("排序前: " + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("排序后: " + Arrays.toString(arr));

        // 测试边界情况
        int[] arr2 = {};
        quickSort(arr2);
        System.out.println("空数组: " + Arrays.toString(arr2));

        int[] arr3 = {1};
        quickSort(arr3);
        System.out.println("单元素: " + Arrays.toString(arr3));

        int[] arr4 = {3, 3, 3, 3};
        quickSort(arr4);
        System.out.println("相同元素: " + Arrays.toString(arr4));
    }

}
