class DecodeString {
    public String decodeString(String s) {
        StringBuilder decode = new StringBuilder("");
        char[] c = s.toCharArray();
        int index = 0;
        while(index < c.length) {
            if(c[index] < '0' || c[index] > '9') { // not digit.
                decode.append(c[index++]);
            } else if(c[index] == ']' || c[index] == '[') {
                index++;
            } else { // digit
                int k = c[index++] - '0';
                while(index < c.length && c[index] != '[') {
                    k = (k * 10) + (c[index++] - '0');
                }
                StringBuilder subStringBuilder = new StringBuilder("");
                index++; // skip [.
                int matchOpen = 1;
                int matchClose = 0;
                while(index < c.length && matchOpen != matchClose) {
                    if(c[index] == '[') {
                        matchOpen++;
                    } else if(c[index] == ']') {
                        matchClose++;
                    }
                    if(matchOpen != matchClose)
                        subStringBuilder.append(c[index]);
                    index++;
                }
                String substring = decodeString(subStringBuilder.toString());
                for(int kk = 0; kk < k; kk++) {
                    decode.append(substring);
                }
            }
        }
        return decode.toString();
    }
}
