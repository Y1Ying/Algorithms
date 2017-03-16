package sort;

/**
 * 基数排序：将元素按照各位放入0-9号桶中，然后按照十位，百位..没有的补零
 * 
 * @author dell
 *
 */
public class RadixSort {
	public int[] radixSort(int[] A) {
		if (A == null || A.length < 2) {
			return null;
		}
		int a = 1;// 除数，分离出关键字的各个整数位
		int m = 1;// 指向的位数
		int k = 0;// 最后输出的结果
		// 高维表示0-9个桶，低维表示每个关键字各个位上的余数,每个桶内可能有n个值
		int[][] number = new int[10][A.length];
		// 创建一个数组表示number数组的每一个桶里面的数目，
		int[] count = new int[10];
		while (m <= 4) {
			for (int j = 0; j < A.length; j++) {
				int lsd = ((A[j] / a) % 10);// 得到余数
				number[lsd][count[lsd]] = A[j];
				count[lsd]++;// 余数为lsd,在哪个桶内也确定，因此将桶内的数目自加
			}
			for (int p = 0; p < 10; p++) {
				// 将桶内的值取出，重新放入到数组中
				if (count[p] != 0) {// 判断在哪个桶内的并且在该桶内的关键字的个数不为0
					for (int q = 0; q < count[p]; q++) {
						A[k] = number[p][q];
						k++;
					}
				}
				count[p] = 0;
			}
			k = 0;
			a *= 10;
			m++;
		}
		return A;
	}

}
