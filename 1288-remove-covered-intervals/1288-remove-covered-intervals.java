class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); 
            }
            return Integer.compare(b[1], a[1]);     
        });
        int count = 1;
        int[] prev = intervals[0];
        for (int i = 0; i < intervals.length; i++) {
            int[] row = intervals[i];
            if(row[1] > prev[1]){
                prev = row;
                count++;
            }
        }
        return count;
    }
}