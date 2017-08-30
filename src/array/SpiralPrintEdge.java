package array;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 * @author dell
 *
 */
public class SpiralPrintEdge {
	/**
	 * 在矩阵中用左上角的左边（tR,tC）和右下角坐标（dR,dC）可以表示一个子矩阵
	 */
	public static void spiralOrderPrint(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = matrix.length-1;
		int dC = matrix[0].length-1;
		while (tR <= dR && tC <= dC) {
			printEdge(matrix, tR++, tC++, dR--, dC--);
		}
	}

	public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
		// 矩阵只有一行
		if (tR == dR) {
			for (int i = tR; i < dR; i++) {
				System.out.println(m[tR][i] + " ");
			}
		} else if (tC == dC) {
			// 只有一列
			for (int i = tC; i < dC; i++) {
				System.out.println(m[i][tC] + " ");
			}
		} else {
			// 一般情况
			int curC = tC;
			int curR = tR;
			while (curC != dC) {
				System.out.println(m[tR][curC] + " ");
				curC++;
			}
			while (curR != dR) {
				System.out.println(m[curR][dC] + " ");
				curR++;
			}
			while (curC != tC) {
				System.out.println(m[dR][curC] + " ");
				curC--;
			}
			while (curR != tR) {
				System.out.println(m[curR][tC] + " ");
				curR--;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		spiralOrderPrint(matrix);

	}

}
