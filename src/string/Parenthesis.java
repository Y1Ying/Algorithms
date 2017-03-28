package string;

/**
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 * 
 * @author dell
 *
 */
public class Parenthesis {

	public boolean chkParenthesis(String str) {
		if (str == null && str.length() == 0) {
			return false;
		}
		char[] arr = str.toCharArray();
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				num++;
			} else if (arr[i] == ')') {
				num--;
			} else {
				return false;
			}
		}
		if (num == 0) {
			return true;
		} else {
			return false;
		}
	}

}
