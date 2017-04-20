package sort;

/**
 * 有两个从小到大排序以后的数组A和B，其中A的末端有足够的缓冲空容纳B。请编写一个方法，将B合并入A并排序。
 * 给定两个有序int数组A和B，A中的缓冲空用0填充，同时给定A和B的真实大小int n和int m，请返回合并后的数组。
 * 
 * @author dell
 *
 */
public class Merge {
	public static int[] mergeAB(int[] A, int[] B) {
		int index = A.length + B.length - 1;
		int i = A.length - 1;
		int j = B.length - 1;
		while (i >= 0 && j >= 0) {
			if (A[i] > B[j]) {
				A[index] = A[i];
				i--;
				index--;
			} else {
				A[index] = B[j];
				j--;
				index--;
			}
		}
		while (j >= 0) {
			A[index] = B[j];
			j--;
			index--;
		}
		return A;
	}

}
