package bitOperation;

/**
 * 不用任何额外变量交换两个整数的值
 * 
 * @author dell
 *
 */
public class Swap {

	public static void main(String[] args) {
		int a = 4;
		int b = 3;

		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		System.out.println("a=" + a);
		System.out.println("b=" + b);
	}
}
