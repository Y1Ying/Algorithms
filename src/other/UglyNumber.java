package other;

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 
 * @author dell
 *
 */
public class UglyNumber {

	/**
	 * 如果p是丑数，那么p=2^x * 3^y * 5^z 那么只要赋予x,y,z不同的值就能得到不同的丑数。 如果要顺序找出丑数，要知道下面几个特点。
	 * 对于任何丑数p： （一）那么2*p,3*p,5*p都是丑数，并且2*p<3*p<5*p
	 * （二）如果p<q,那么2*p<2*q,3*p<3*q,5*p<5*q 现在说说算法思想：
	 * 由于1是最小的丑数，那么从1开始，把2*1，3*1，5*1，进行比较，得出最小的就是1 的下一个丑数，也就是2*1，
	 * 这个时候，多了一个丑数‘2’，也就又多了3个可以比较的丑数，2*2，3*2，5*2，
	 * 这个时候就把之前‘1’生成的丑数和‘2’生成的丑数加进来也就是
	 * (3*1,5*1,2*2，3*2，5*2)进行比较，找出最小的。。。。如此循环下去就会发现，
	 * 每次选进来一个丑数，该丑数又会生成3个新的丑数进行比较。
	 * 
	 * 下面说一个O（n）的算法。 在上面的特点中，既然有p<q, 那么2*p<2*q，那么
	 * “我”在前面比你小的数都没被选上，你后面生成新的丑数一定比“我”大吧，那么你乘2 生成的丑数一定比我乘2的大吧，那么在我选上之后你才有机会选上。
	 * 其实每次我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的 数。也就是比较(2*x , 3*y, 5*z)
	 * ，x>=y>=z的，
	 * 
	 * @param index
	 * @return
	 */
	public static int GetUglyNumber(int index) {

		if (index <= 0)
			return 0;
		int[] result = new int[index];
		int count = 0;
		int temp2 = 0;
		int temp3 = 0;
		int temp5 = 0;

		result[0] = 1;
		int tmp = 0;
		while (count < index - 1) {
			tmp = min(result[temp2] * 2, min(result[temp3] * 3, result[temp5] * 5));
			if (tmp == result[temp2] * 2)
				temp2++;
			if (tmp == result[temp3] * 3)
				temp3++;
			if (tmp == result[temp5] * 5)
				temp5++;
			result[++count] = tmp;
		}
		return result[index - 1];
	}

	private static int min(int a, int b) {
		return (a > b) ? b : a;
	}
}
