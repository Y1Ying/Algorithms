package other;

import java.util.Scanner;

/**
 * 给定一个十进制的正整数number，选择从里面去掉一部分数字，希望保留下来的数字组成的正整数最大。
 * 
 * @author dell
 *
 */
public class CutMaxNum {

	/**
	 * 思路:从左到右找第一次出现比后面小的数，找到后s就记录下这个数的位置，然后删除
	 * 这个位置数字，例如87784201(s记录第二个7位置)，如没找到，s值就是记录最后一个
	 * 字符，这时其实是三种情况，全部相等或者从左到右递减，或者中间也可能有相等情况， 反正这时s位置记录的数字是最右边最小的 例如：
	 * 987654321(s记录1的位置) 77777777777(s记录最后一个7的位置) 98877777666555(s记录最后一个5的位置)
	 * case明显有错,这代码只能跑50%,目前觉得是最优解法
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			StringBuilder sb = new StringBuilder();
			sb.append(scanner.next());
			int cut = scanner.nextInt();
			int count = 0;// 记录删除个数
			while (count < cut) {
				int len = sb.length() - 1;
				int deleteNum = 0;
				while (deleteNum < len && sb.codePointAt(deleteNum) >= sb.codePointAt(deleteNum + 1)) {
					deleteNum++;
				}
				count++;
				sb.deleteCharAt(deleteNum);
			}
			System.out.println(sb);
		}
	}
}
