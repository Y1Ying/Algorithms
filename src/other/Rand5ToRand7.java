package other;

/**
 * 给定一个等概率随机产生1-5的随机函数rand1To5如下 public int rand1To5(){ return
 * (int)(Math.random() * 5)+1 } 除此之外，不能使用任何额外的随机机制，请用rand1To5实现等概率随机产生1-7的随机函数
 * 
 * @author dell
 *
 */
public class Rand5ToRand7 {
	public static int rand1To5() {
		return (int) (Math.random() * 5) + 1;
	}

	public static int rand1To7() {
		int num = 0;
		do {
			num = (rand1To5() - 1) * 5 + rand1To5() - 1;
		} while (num > 20);
		return num % 7 + 1;
	}

	// 给定一个以p概率产生0，以1-p概率产生1的随机函数rand01p，用rand01p实现等概率随机产生1-6的随机函数rand1To6
	public static int rand01p() {
		// 可随意改变P
		double p = 0.83;
		return Math.random() < p ? 0 : 1;
	}

	// 0,1,2,3
	public static int rand0To3() {
		return rand01p() * 2 + rand01p();
	}

	public static int rand1To6() {
		int num = 0;
		do {
			// 0-15
			num = rand0To3() * 4 + rand0To3();
		} while (num > 11);
		return num % 6 + 1;
	}

	// 给定一个等概率产生1-M的随机函数rand1ToM 不使用任何额外的随机机制，有两个输入参数，分别为n,m
	// 用rand1ToM实现等概率随机产生1-n的随机函数rand1ToN

	public static int rand1ToM(int m) {
		return (int) (Math.random() * m) + 1;
	}

	public static int rand1ToN(int n, int m) {
		int[] nMSys = getMSysNum(n - 1, m);
		int[] randNum = getRanMSysNumLessN(nMSys, m);
		return getNumFormMSysNum(randNum, m) + 1;
	}

	// 将value转换为m进制数
	public static int[] getMSysNum(int value, int m) {
		int[] res = new int[32];
		int index = res.length - 1;
		while (value != 0) {
			res[index--] = value % m;
			value = value / m;
		}
		return res;
	}

	// 等概率随机产生一个0-nMSys范围的数，只不过是用m进制表示
	public static int[] getRanMSysNumLessN(int[] nMSys, int m) {
		int[] res = new int[nMSys.length];
		int start = 0;
		while (nMSys[start] == 0) {
			start++;
		}
		int index = start;
		boolean lastEqual = true;
		while (index != nMSys.length) {
			res[index] = rand1ToM(m) - 1;
			if (lastEqual) {
				if (res[index] > nMSys[index]) {
					index = start;
					lastEqual = true;
					continue;
				} else {
					lastEqual = res[index] == nMSys[index];
				}
			}
			index++;
		}
		return res;
	}

	// 将m进制的数转化为十进制的数
	public static int getNumFormMSysNum(int[] mSysNum, int m) {
		int res = 0;
		for (int i = 0; i < mSysNum.length; i++) {
			res = mSysNum[i] + res * m;
		}
		return res;
	}

	public static void printCountArray(int[] countArr) {
		for (int i = 0; i != countArr.length; i++) {
			System.out.println(i + " appears " + countArr[i] + " times");
		}
	}

	public static void main(String[] args) {
		int testTimes = 1000000;
//		int[] countArr1 = new int[8];
//		for (int i = 0; i != testTimes; i++) {
//			countArr1[rand1To7()]++;
//		}
//		printCountArray(countArr1);
//
//		System.out.println("=====================");
//
//		int[] countArr2 = new int[7];
//		for (int i = 0; i != testTimes; i++) {
//			countArr2[rand1To6()]++;
//		}
//		printCountArray(countArr2);
//
//		System.out.println("=====================");

		int n = 17;
		int m = 3;
		int[] countArr3 = new int[n + 1];
		for (int i = 0; i != 2000000; i++) {
			countArr3[rand1ToN(n, m)]++;
		}
		printCountArray(countArr3);

		System.out.println("=====================");

	}
}
