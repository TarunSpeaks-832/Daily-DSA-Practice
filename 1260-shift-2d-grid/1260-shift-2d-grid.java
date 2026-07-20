class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int total = n * m;
        int[] arr = new int[total];
        int x = 0;
        k %= total;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[x++] = grid[i][j];
            }
        }

        reverse(arr, 0, total - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, total - 1);
        
        int idx = 0; 
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(arr[idx++]); 
            }
            result.add(row);
        }

        return result;
    }

    private void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
            l++;
            r--;
        }
    }
}
