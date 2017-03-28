package string;

/**
 * 请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，
 * 
 * 并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
 * 
 * 补充：给定一个字符串类型的数组chas[]，其中只含有数组字符和“*”字符，把所有的“*”字符挪到chas的左边，
 * 
 * 数字字符挪到chas的右边
 * 
 * @author dell
 *
 */
public class Replacement {
	public static void replace(char[] chas) {
		if (chas == null || chas.length == 0) {
			return;
		}
		int num = 0;
		int len = 0;
		for (len = 0; len < chas.length && chas[len] != 0; len++) {
			if (chas[len] == ' ') {
				num++;
			}
		}
		int j = len + num * 2 - 1;
		for (int i = len - 1; i > -1; i--) {
			if (chas[i] != ' ') {
				chas[j--] = chas[i];
			} else {
				chas[j--] = '0';
				chas[j--] = '2';
				chas[j--] = '%';
			}
		}
	}

	public static void modify(char[] arr) {
		if (arr == null && arr.length == 0) {
			return;
		}
		int j = arr.length - 1;
		for (int i = arr.length - 1; i > -1; i--) {
			if (arr[i] != '*') {
				arr[j--] = arr[i];
			}
		}
		for (; j > -1;) {
			arr[j--] = '*';
		}
	}

	public static void main(String[] args) {
		char[] chas1 = { 'a', ' ', 'b', ' ', ' ', 'c', 0, 0, 0, 0, 0, 0, 0, 0, };
		replace(chas1);
		System.out.println(String.valueOf(chas1));

		char[] chas2 = { '1', '2', '*', '*', '3', '4', '5' };
		modify(chas2);
		System.out.println(String.valueOf(chas2));
	}
}
