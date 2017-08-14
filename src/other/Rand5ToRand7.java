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
}
