class ReverseString {
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length / 2; i++) {
            // swap i with c.length - 1- i 
            char tmp = c[i];
            c[i] = c[c.length - 1 - i];
            c[c.length - 1 - i] = tmp;
        }
        return new String(c);
    }
}
 
