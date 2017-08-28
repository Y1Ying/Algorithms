package other;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 一个工厂制造的产品形状都是长方体，它们的高度都是h，长和宽都相等，一共有六个 型号，他们的长宽分别为1*1， 2*2， 3*3， 4*4， 5*5，
 * 6*6.这些产品通常使用一个 6*6*h 的长方体包裹包装然后邮寄给客户。因为邮费很贵，所以工厂要想方设法的减小每
 * 个订单运送时的包裹数量。他们很需要有一个好的程序帮他们解决这个问题从而节省费用 。现在这个程序由你来设计。
 * 
 * Input
 * 
 * 输入文件包括几行，每一行代表一个订单。每个订单里的一行包括六个整数，中间用
 * 空格隔开，分别为1*1至6*6这六种产品的数量。输入文件将以6个0组成的一行结尾。
 * 
 * Output
 * 
 * 除了输入的最后一行6个0以外，输入文件里每一行对应着输出文件的一行，每一行输 出一个整数代表对应的订单所需的最小包裹数。
 * 
 * @author dell
 *
 */

public class BoxNum {
	/**
	 * 对于6*6的一个箱子来说，最多只能放一个6*6或一个5*5或4*4的盒子，所以我们初始
	 * 化需要的箱子数时就是这这几种箱子的个数和，对于3*3的箱子来说，我们可以放一个或2
	 * 个或3个或4个，这我们可以通过整除和取模来确定放了3*3盒子的箱子数，再把它加入到
	 * 总箱子数中，接下来我们就是把1*1和2*2的盒子塞进前面所需的箱子中，当塞不完时再来
	 * 新增盒子，我们首先要将前面的箱子剩余的空间统计出来，并且要以2*2的优先考虑，因
	 * 为我们可以把多余的2*2的位置变为填充4个1*1的，毕竟1*1的只要有空间随处都可以塞。
	 * 所以当我们的箱子要是装了1个5*5的盒子的话，那么它就只能塞1*1的了，一个可以塞11
	 * 个1*1的，对于装了4*4的盒子的话，那么还可以装5个2*2的盒子，暂且不要去转话成1*1
	 * 的，除非没办法只能装1*1的，对于3*3的话就可以根据取模之后一个箱子剩下的空间了，
	 * 如果一个箱子中只放了一个3*3的，那么还剩下3个3*3的空间可以放，我们知道可以放5个
	 * 2*2的和7个1*1的，对于放了2个3*3的箱子，我们剩下的空间可以放3个2*2的以及6个1*1
	 * 的，对于放了3个3*3的箱子，我们只能放1个2*2的和5个1*1的，这样一来我们就统计出了
	 * 此时可以放2*2以及1*1的空间到底有多少，接下来我们就放箱子进去啊，放一个就减一个 ，知道1*1的和2
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		boolean flag = true;
		Map map = new HashMap();
		int temp = 0;
		while (flag) {
			int[] num = new int[6];
			num[0] = scanner.nextInt();
			num[1] = scanner.nextInt();
			num[2] = scanner.nextInt();
			num[3] = scanner.nextInt();
			num[4] = scanner.nextInt();
			num[5] = scanner.nextInt();
			if (num[0] == 0 && num[1] == 0 && num[2] == 0 && num[3] == 0 && num[4] == 0 && num[5] == 0) {
				flag = false;
			} else {
				map.put(temp, num);
				temp++;
			}
		}
		for (int i = 0; i < map.size(); i++) {
			int[] vs = (int[]) map.get(i);
			int boxNum = 0;
			boxNum += vs[3] + vs[4] + vs[5];
			if (vs[2] > 0) {
				if (vs[2] % 4 == 0) {
					boxNum += vs[2] / 4;
				} else {
					boxNum += vs[2] / 4 + 1;
				}
			}
			int for1 = vs[4] * 11;
			int for2 = vs[3] * 5;
			if (vs[2] % 4 == 1) {
				for1 += 7;
				for2 += 5;
			} else if (vs[2] % 4 == 2) {
				for1 += 6;
				for2 += 3;
			} else if (vs[2] % 4 == 3) {
				for1 += 5;
				for2 += 1;
			}

			if (vs[0] < for1) {
				vs[0] = 0;
			} else {
				vs[0] = vs[0] - for1;
			}

			if (vs[1] < for2) {
				if (vs[0] > 0) {
					if (4 * (for2 - vs[1]) - vs[0] >= 0) {
						vs[0] = 0;
					} else {
						vs[0] = vs[0] - 4 * (for2 - vs[1]);
					}
				}
				vs[1] = 0;
			} else {
				vs[1] = vs[1] - for2;
			}
			if (!(vs[0] == 0 && vs[1] == 0)) {
				if (vs[1] > 0) {
					if (vs[1] % 9 == 0) {
						boxNum += vs[1] / 9;
					} else {
						boxNum += vs[1] / 9 + 1;
						if (vs[0] > (9 - (vs[1] % 9)) * 4) {
							if ((vs[0] - (9 - (vs[1] % 9)) * 4) % 36 == 0) {
								boxNum += (vs[0] - (9 - (vs[1] % 9)) * 4) / 36;
							} else {
								boxNum += (vs[0] - (9 - (vs[1] % 9)) * 4) / 36 + 1;
							}
						}
					}

				} else if (vs[0] > 0) {
					if (vs[0] % 36 == 0) {
						boxNum += vs[0] / 36;
					} else {
						boxNum += vs[0] / 36 + 1;
					}
				}
			}
			System.out.println(boxNum);
		}
	}
}
