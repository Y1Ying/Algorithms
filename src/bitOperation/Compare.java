package bitOperation;

/**
 * 对于两个32位整数a和b，请设计一个算法返回a和b中较大的。但是不能用任何比较判断。若两数相同，返回任意一个。
 * 
 * @author dell
 *
 */
public class Compare {
	// 第一种方法
	public int getMax1(int a, int b) {
		if (a - b > 0) {
			return a;
		} else if (a - b < 0) {
			return b;
		} else {
			return a;
		}
	}

	// 第二种方法 a-b溢出的情况时就失败
	public int flip(int n) {
		return (n ^ 1);
	}

	public int sign(int n) {
		return flip((n >> 31) & 1);
	}

	public int getMax2(int a, int b) {
		int c = a - b;
		int scA = sign(c);
		int scB = flip(scA);
		return a * scA + b * scB;
	}

	// 第三种 解决溢出情况
	public int getMax3(int a, int b) {
		int c = a - b;
		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(c);
		int difSab = sa ^ sb;
		int sameSab = flip(difSab);
		int resultA = difSab * sa + sameSab * sc;
		int resultB = flip(resultA);
		return a * resultA + b * resultB;
	}
}
