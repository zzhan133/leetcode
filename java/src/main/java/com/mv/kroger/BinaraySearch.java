package com.mv.kroger;

public class BinaraySearch {

	public void quickSort(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		quickSort(nums, 0, nums.length - 1);
	}

	private void quickSort(int[] nums, int low, int high) {
		if (low < high) {
			int pivot = partition(nums, low, high);
			quickSort(nums, low, pivot - 1);
			quickSort(nums, pivot + 1, high);
		}
	}

	private int partition(int arr[], int low, int high) {
		int origHigh = high;
		int compareValue = arr[high];
		while (low < high) {
			while (low < high && arr[low] <= compareValue)
				low++;
			while (low < high && arr[high] >= compareValue)
				high--;
			if (low < high) {
				int tmp = arr[low];
				arr[low] = arr[high];
				arr[high] = tmp;
			}
		}
		if (low == high) {
			arr[origHigh] = arr[low];
			arr[low] = compareValue;

		}
		return low;

	}

	public int binarySearch(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			throw new IllegalArgumentException();
		}
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (target == nums[middle]) {
				return middle;
			} else if (target < nums[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}

		return -1;
	}

	private int binarySearch(int[] nums, int left, int right, int target) {
		if (left > right) {
			return -1;
		}
		int middle = (left + right) / 2;
		if (target == nums[middle]) {
			return middle;
		} else if (target < nums[middle]) {
			return binarySearch(nums, left, middle - 1, target);
		} else {
			return binarySearch(nums, middle + 1, right, target);
		}
	}

}
