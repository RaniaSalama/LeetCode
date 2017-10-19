class ReverseWords {
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        int start = 0;
        while(i < c.length) {
            if(c[i] == ' ') { // start reversing from the start!
                int index = 0;
                for(int j = start; j < start + (i-start)/2; j++) {
                    char tmp = c[j];
                    c[j] = c[i-1-index];
                    c[i-1-index] = tmp;
                    index++;
                }
                start = i+1;
            }
            i++;
        }
        // Reverse last!
        int index = 0;
        for(int j = start; j < start + (i-start)/2; j++) {
            char tmp = c[j];
            c[j] = c[i-1-index];
            c[i-1-index] = tmp;
            index++;
        }
        return new String(c);
    }
}
