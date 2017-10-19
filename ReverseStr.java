class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        int i = 0;
        while(i < c.length) {
            // Reverse first k chars!
            if(i + k < c.length) {
                for(int j = i; j < i + (k/2) && j < c.length; j++) {
                    // swap j with i + k - j - 1
                    char tmp = c[j];
                    c[j] = c[2*i + k - j - 1];
                    c[2*i + k - j - 1] = tmp;
                }
            } else {
                for(int j = i; j < i + (c.length - i + 1)/2 && j < c.length; j++) {
                    char tmp = c[j];
                    c[j] = c[c.length - j + i - 1];
                    c[c.length - j + i - 1] = tmp;
                }
            }
            i += 2*k;
        }
        return new String(c);
    }
} 
