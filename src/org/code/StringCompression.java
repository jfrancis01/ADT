package org.code;

public class StringCompression {

	public static void main(String[] args) {
		StringCompression sc = new StringCompression();
		System.out.println(sc.compress(new char[] {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
	}
	
	public int compress(char[] chars) {
		int index = 0;
		int run = 0;
		StringBuilder sb = new StringBuilder();
		while(index < chars.length) {
			char current = chars[index];
			run = index + 1;
			int count = 0;
			while(run < chars.length && chars[run] == current) {
				count++;
				run++;
			}
			if(count + 1 > 1) {
				sb.append(current);
				sb.append(count + 1);
			}
			else{
				sb.append(current);
			}
			if(run == index + 1) {
				index++;
			}
			else {
				index = run;
			}
		}
		for(int i = 0; i < sb.length(); i++) {
			chars[i]= sb.charAt(i);
		}
		System.out.println(sb.toString());
		return sb.toString().length();
	}

}
