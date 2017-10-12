package string;

public class Permutation {

	public static void permutation(char[] chars) {
		// 输入较验
		if (chars == null || chars.length < 1) {
			return;
		}
		// 进行排列操作
		permutation(chars, 0);
	}

	/**
	 * 求字符数组的排列
	 *
	 * @param chars
	 *            待排列的字符串
	 * @param begin
	 *            当前处理的位置
	 */
	public static void permutation(char[] chars, int begin) {
		// 如果是最后一个元素了，就输出排列结果
		if (chars.length - 1 == begin) {
			System.out.print(new String(chars) + " ");
		} else {
			char tmp;
			// 对当前还未处理的字符串进行处理，每个字符都可以作为当前处理位置的元素
			for (int i = begin; i < chars.length; i++) {
				// 下面是交换元素的位置
				tmp = chars[begin];
				chars[begin] = chars[i];
				chars[i] = tmp;
				// 处理下一个位置
				permutation(chars, begin + 1);
			}
		}
	}

	public static void main(String[] args) {
		char[] c1 = { 'a', 'b', 'c' };
		permutation(c1);
		System.out.println("=========");
		char[] c2 = { 'a', 'b', 'c', 'd' };
		permutation(c2);
	}

}
