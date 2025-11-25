package com.demo;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author harold
 * @date 2025/11/25 14:14
 */
public class AlgorithmTests {


    @Test
    void testInsertionSort() {
        //插入排序
        int[] arr = {5, 4, 3, 2, 1};
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int position = i - 1;
            while (position >= 0) {
                if (arr[position] > temp) {
                    arr[position + 1] = arr[position];
                } else {
                    break;
                }
                position--;
            }
            arr[position + 1] = temp;
        }
    }

    @Test
    void testIntersection() {
        int[] arr1 = {5, 4, 3, 2, 1};
        int[] arr2 = {5, 4, 3, 2, 1};
        Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
        Set<Integer> result = set1.parallelStream().filter(set2::contains).collect(Collectors.toSet());
        System.out.println(result);
    }

    @Test
    void testListSort() {
        List<Integer> list = new ArrayList<>();
        list.hashCode();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.sort((o1, o2) -> o2 - o1);

        list.stream().sorted().collect(Collectors.toList());
    }


    @Test
    void testHashMap() {
        Object a = new Object();
        System.out.println(a.hashCode());
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "1");

    }


    @Test
    void testSortable() {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println("排序前: " + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("排序后: " + Arrays.toString(arr));
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
}
