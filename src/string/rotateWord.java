package string;

/**
 * 字符串逆序调整 1.实现将字符串局部所有字符逆序的函数f 2.利用f将字符串所有字符逆序
 * 3.找到逆序后的字符串中每一个单词的区域利用f将每一个单词的区域逆序
 * 
 * @author dell
 *
 */
public class rotateWord {

	public static void rotateWord(char[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		reverse(a, 0, a.length - 1);
		int l = -1;
		int r = -1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != ' ') {
				l = i == 0 || a[i - 1] == ' ' ? i : 1;
				r = i == a.length - 1 || a[i + 1] == ' ' ? i : r;
			}
			if (l != -1 && r != -1) {
				reverse(a, l, r);
				l = -1;
				r = -1;
			}
		}
	}

	public static void reverse(char[] a, int start, int end) {
		char temp = 0;
		while (start < end) {
			temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
	}

	/**
	 * 给定一个字符串类型的数组chas和一个整数size,把大小为size的左半区整体移到右半区，右半区整体移到左半区
	 * 1.将chas[a...size-1]部分逆序 2.将chas[size..N-1]部分逆序 3.再整体逆序
	 */
	public static void rotate1(char[] chas, int size) {
		if (chas == null || size < 0 || size > chas.length) {
			return;
		}
		reverse(chas, 0, size - 1);
		reverse(chas, size, chas.length - 1);
		reverse(chas, 0, chas.length - 1);
	}

}
