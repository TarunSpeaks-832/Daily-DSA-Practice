class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = arr.clone();
        Arrays.sort(temp);
        HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        int rank = 1;
        for (int i = 0; i < temp.length; i++) {
            if (i > 0 && temp[i] == temp[i - 1]) {
                continue;
            }

            ArrayList<Integer> list = map.get(temp[i]);
            for (int index : list) {
                arr[index] = rank;
            }

            rank++;
        }
        return arr;
    }
}