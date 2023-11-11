package dfs;

public class CountAndSay {

	public static void main(String[] args) {
		CountAndSay s = new CountAndSay();
		System.out.println(s.countAndSay(4));
	}
	
	public String countAndSay(int n) {
        return dfs(n);
    }
	
	private String dfs(int n) {
		if(n == 1) {
			return "1";
		}
		//不需要每次递归带着本次结果
		StringBuilder result = new StringBuilder();
		// 21
		char[] arr = dfs(n - 1).toCharArray();
		int i = 0;
		for(int j = 0; j < arr.length; j++) {
			if(arr[j] != arr[i]) {
				result.append(j - i);
				result.append(arr[i]);
				i = j;
			}
		}
		result.append(arr.length - i);
		result.append(arr[i]);
		return result.toString();
	}
	
}
