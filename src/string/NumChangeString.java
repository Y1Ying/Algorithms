package string;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 
 * @author dell
 *
 */
public class NumChangeString {

	public int StrToInt(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] chas = str.toCharArray();
		int flag = 0;
		if (chas[0] == '-') {
			flag = 1;
		}
		int sum = 0;
		for (int i = flag; i < chas.length; i++) {
			if (chas[i] == '+') {
				continue;
			}
			if (chas[i] < 48 || chas[i] > 57) {
				return 0;
			}
			sum = sum * 10 + chas[i] - 48;
		}
		return flag == 1 ? sum * -1 : sum;

	}

}
