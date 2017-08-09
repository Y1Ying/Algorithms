package array;

/**
 * 给定一个矩阵，其中的值有正，有负，有0，求返回子矩阵的最大累加和
 * 
 * @author dell
 *
 */
public class SubMatrixMaxSum {

	public static int maxSum(int[][] m) {
		if (m == null || m.length == 0 || m[0].length == 0) {
			return 0;
		}
		int[] s = null;//累加数组
		int cur = Integer.MIN_VALUE;
		int max = 0;
		for (int i = 0; i != m.length; i++) {
			s = new int[m[0].length];
			for (int j = i; j != m.length; j++) {
				cur = 0;
				for (int k = 0; k != m.length; k++) {
					s[k] += m[j][k];
					cur += s[k];
					max = Math.max(cur, max);
					cur = cur < 0 ? 0 : cur;
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[][] matrix = { { -90, 48, 78 }, { 64, -40, 64 }, { -81, -7, 66 } };
		System.out.println(maxSum(matrix));

	}
}
