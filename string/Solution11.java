package string;

public class Solution11 {

	public static void main(String[] args) {
		Solution11 s = new Solution11();
		String input = new String("a3b1c2d1");
		String result = s.decode(input);
		System.out.println(result);
	}
	
	public String encode(String input) {
		if(input == null) {
			return input;
		}
		StringBuilder sb = new StringBuilder();
		int j = 0;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) != input.charAt(j)) {
				sb.append(input.charAt(j));
				sb.append(i - j);
				j = i;
			}
		}
		sb.append(input.charAt(j));
		sb.append(input.length() - j);
		return sb.toString();
	}
	
	public String decode(String input) {
		if(input == null) {
			return input;
		}
		StringBuilder sb = new StringBuilder();
		int j = 1;
		for(int i = 0; i < input.length(); i+=2) {
			int num = input.charAt(j) - '0';
			for(int x = 1; x <= num; x++) {
				sb.append(input.charAt(i));
			}
			j+=2;
		}
		return new String(sb);
	}
}
