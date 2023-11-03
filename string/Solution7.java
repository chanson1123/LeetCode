package string;

public class Solution7 {

	public static void main(String[] args) {
		Solution7 s = new Solution7();
		String input = "I love Microsoft";
		String target = "Microsoft";
		String replacement = "Morgan Stanley";
		String result = s.replace(input, target, replacement);
		System.out.println(result);
	}
	
	public String replace(String input, String target, String replacement) {
		if(input == null || input.length() == 0) {
			return input;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <= input.length() - target.length(); i++) {
			if(!check(input, i, target)) {
				sb.append(input.charAt(i));
			}else {
				sb.append(replacement);
				i = i + target.length() - 1;
			}
		}
		return sb.toString();
	}
	
	private boolean check(String par, int start, String sub) {
		for(int i = 0; i < sub.length(); i++) {
			if(par.charAt(start + i) != sub.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
}
