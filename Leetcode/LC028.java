package Leetcode;

public class LC028 {
	public int strStr(String haystack, String needle) {
        for(int i=0;i<=haystack.length()-needle.length();i++){
            if(compare(haystack,i,needle)){
                return i;
            }
        }
        return -1;
    }

    private boolean compare(String haystack, int index, String needle){
        for(int i=0;i<needle.length();i++){
            if(needle.charAt(i)!=haystack.charAt(index+i)){
                return false;
            }
        }
        return true;
    }
}
