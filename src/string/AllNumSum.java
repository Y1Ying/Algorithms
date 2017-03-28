package string;

/**
 * 给定一个字符串str,求其中全部数字串所代表的数字之和
 * 
 * 忽略小数点字符 如果紧贴数字的左侧出现字符“-”，连续出现数量为奇数时，数字为负，偶数时，为正
 * 
 * @author dell
 *
 */
public class AllNumSum {

	public static int numSum(String str) {
		if (str == null && str.length() == 0) {
			return 0;
		}
		char[] arr = str.toCharArray();
		int num = 0;
		int res = 0;
		boolean posi = true;
		int cur = 0;
		for (int i = 0; i < arr.length; i++) {
			cur = arr[i] - '0';
			if (cur < 0 || cur > 9) {
				res += num;
				num = 0;
				if (arr[i] == '-') {
					if (i > 0 && arr[i - 1] == '-') {
						posi = !posi;
					}
				} else {
					posi = true;
				}
			} else {
				num = num * 10 + (posi ? cur : -cur);
			}
		}
		res += num;
		return res;
	}

	public static void main(String[] args) {
		String test = "1K-100ABC500D-T--100F200G!!100H---300";
		System.out.println(numSum(test));

	}
}
