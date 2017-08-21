package other;

/**
 * 判断一个整数是否是回文整数
 * 
 * @author dell
 *
 */
public class isPalindrome {

	public static boolean palindrome1(int num) {
		char[] ch = Integer.toString(num).toCharArray();
		int begin = 0;
		int end = ch.length - 1;
		while (begin < end) {
			if (ch[begin] == ch[end]) {
				begin++;
				end--;
			} else {
				return false;
			}
		}
		return true;
	}

	public static boolean palindrome2(int num) {
		if (num < 0) {
			return false;
		}
		int div = 1;
		while (num / div >= 10) {
			div *= 10;
		}
		while (num != 0) {
			int l = num / div;
			int r = num % 10;
			if (l != r) {
				return false;
			}
			num = (num % div) / 10;
			div /= 100;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(palindrome1(12211221));
		System.out.println(palindrome2(1221122133));
	}
}
