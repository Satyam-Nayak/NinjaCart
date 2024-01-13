class Solution {
    void pushZerosToEnd(int[] arr, int n) {
        int index_0 = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                // Swap non-zero element with the first zero encountered
                int temp = arr[i];
                arr[i] = arr[index_0];
                arr[index_0] = temp;
                index_0++;
            }
        }
    }
}

