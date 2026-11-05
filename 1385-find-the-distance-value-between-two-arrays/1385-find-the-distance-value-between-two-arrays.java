class Solution {
    private boolean notInRange(int[] arr, int low, int high) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= low && arr[mid] <= high) {
                return false; // Found an element in the forbidden range
            } else if (arr[mid] < low) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return true;
    }
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int x : arr1) {
            if (notInRange(arr2, x - d, x + d)) {
                count++;
            }
        }
        return count;
    }
}