import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] arr = new int[n+1][2];
        for(int i=0;i<n;i++){
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
        }
        arr[n][0] = newInterval[0];
        arr[n][1] = newInterval[1];

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        int st = arr[0][0];
        int end = arr[0][1];

        List<int[]> result = new ArrayList<>();

        for(int i=1;i<n+1;i++){
            if(arr[i][0] > end){
                result.add(new int[]{st, end});
                st = arr[i][0];
                end = arr[i][1];
            }
            else{
                end = Math.max(end, arr[i][1]);
            }
        }
        
        result.add(new int[]{st, end});

        return result.toArray(new int[result.size()][]);
    }
}
