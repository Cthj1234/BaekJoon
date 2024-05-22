class Solution {
    public String solution(String number, int k) {
        int len = number.length() - k;
        int idx = 0;
        StringBuilder sb = new StringBuilder();

        while (len > 0) {
            char max = '0';
            for (int i = idx; i <= number.length() - len; i++) {
                if(number.charAt(i) > max) {
                    idx = i + 1;
                    max = number.charAt(i);
                    if(max == '9') break;
                }
            }
            sb.append(max);
            len--;
        }

        return sb.toString();
    }
}