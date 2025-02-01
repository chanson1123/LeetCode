package interview;

class Solution1 {
	
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		String str = "42";
		System.out.print((int)(Long.MIN_VALUE));
	}
	
    public int myAtoi(String s) {
        char[] str = s.toCharArray();
        long res = 0;
        int i = 0;
        while(i < str.length && str[i] == ' '){
            i++;
        }
        boolean sign = true;
        if(str[i] == '-'){
            sign = false;
            i++;
        }
        if(str[i] == '+'){
            sign = true;
            i++;
        }
        while(i < str.length && str[i] == '0'){
            i++;
        }
        while(i < str.length){
            if(str[i] < '0' || str[i] > '9'){
                break;
            }else{
                res = res*10 + (str[i] - '0');
            }
            i++;
        }
        if(sign == true && res > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(sign == false && res > Integer.MAX_VALUE){
            return Integer.MIN_VALUE;
        }
        if(sign == false){
            return -(int)res;
        }
        return (int)res;
    }
}
