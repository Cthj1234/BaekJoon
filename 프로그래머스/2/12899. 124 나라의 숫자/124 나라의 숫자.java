class Solution {
    public String solution(int num){
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            if(num % 3 == 0){
                sb.append("4");
                num--;
            }else if (num % 3 == 1){
                sb.append("1");
            }else{
                sb.append("2");
            }

            num /= 3;
        }
        return sb.reverse().toString();
    }

}