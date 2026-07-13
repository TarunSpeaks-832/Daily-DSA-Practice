class Solution {

    List<Integer> list = new ArrayList<>();

    public List<Integer> sequentialDigits(int low, int high) {

        for (int digit = 1; digit <= 9; digit++) {
            sequenceDigits(digit, low, high);
        }

        Collections.sort(list);
        return list;
    }

    private void sequenceDigits(int num, int low, int high) {

        // Build num recursively
        // Example:
        // nextNum = num * 10 + ...
        if(num > high){
            return;
        }
        if(num >= low){
            list.add(num);
        }
        int lastDigit = num%10;

        if (lastDigit == 9) {
            return;
        }

        num = num*10 + (lastDigit+1);
        sequenceDigits(num,low,high);

    }

    private int firstDigit(int num) {
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }
}