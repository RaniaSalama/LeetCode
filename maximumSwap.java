class Solution {
    public int maximumSwap(int num) {
        char[] numString = (num+"").toCharArray();
        int n = numString.length;
        int[] max = new int[n];
        int[] maxPos = new int[n];
        max[n-1] = numString[n-1] - '0';
        maxPos[n-1] = n-1;
        for(int i = n-2; i >= 0; i--) {
            if (numString[i] - '0' > max[i+1]) {
                max[i] = numString[i] - '0';
                maxPos[i] = i;
            } else {
                max[i] = max[i+1];
                maxPos[i] = maxPos[i+1];
            }
        }
        int pos = 0;
        while(pos < n) {                               
            if((numString[pos] - '0') < max[pos]) { // swap
                char swap = numString[pos];
                numString[pos] = (char) (max[pos] + '0');
                numString[maxPos[pos]] = swap;
                return Integer.parseInt(new String(numString));
            }
            pos++;
        }
        return num;
    }
}
