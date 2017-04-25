package permutation;

/**
 * n个人站队，他们的编号依次从1到n，要求编号为a的人必须在编号为b的人的左边，但不要求一定相邻，请问共有多少种排法？
 * 
 * 第二问如果要求a必须在b的左边，并且一定要相邻，请问一共有多少种排法？
 * 
 * 给定人数n及两个人的编号a和b，请返回一个两个元素的数组，其中两个元素依次为两个问题的答案。保证人数小于等于10。
 * 
 * @author dell
 *
 */
public class StandInLine {
	public int[] getWays(int n, int a, int b) {
		if (n == 0) {
			return null;
		}
		int[] arr = new int[2];
		// 第一问：有n!种可能，有一半的情况A在B左边，另一半A在B右边
		arr[0] = go(n) / 2;
		// 第二问：将A和B当做一个人 就只有n-1种情况
		arr[1] = go(n - 1);
		return arr;
	}

	public int go(int n) {
		int res = 1;
		for (int i = 1; i <= n; i++) {
			res *= i;
		}
		return res;
	}

}
