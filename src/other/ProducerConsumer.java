package other;

/**
 * 操作系统中的生产者与消费者模型
 * 
 * @author dell
 *
 */
public class ProducerConsumer {

	static final int N = 100;// 定义缓冲区大小的常量
	static producer p = new producer();// 初始化一个新的生产者线程
	static consumer c = new consumer();// 初始化一个新的消费者线程
	static our_monitor mon = new our_monitor();//// 初始化一个新的管程

	public static void main(String[] args) {
		p.start();// 开始生产者线程
		c.start();// 开始消费者线程
	}

	static class producer extends Thread {
		@Override
		public void run() {// run方法包含了线程代码
			int item;
			while (true) {// 生产者循环
				item = produce_item();
				mon.insert(item);
			}
		}

		private int produce_item() {
			// 实际生产
			return 0;
		}
	}

	static class consumer extends Thread {
		@Override
		public void run() {
			int item;
			while (true) {
				item = mon.remove();
				consume_item(item);
			}
		}

		private void consume_item(int item) {
			// 实际消费
		}
	}

	static class our_monitor {// 管程
		private int buffer[] = new int[N];
		private int count = 0, lo = 0, hi = 0;// 计数器和索引

		public synchronized void insert(int val) {
			if (count == N) {
				go_to_sleep();// 如果缓冲区满了，则进入休眠
			}
			buffer[hi] = val;// 向缓冲区中插入一个新的数据项
			hi = (hi + 1) % N;// 设置下一个数据项的槽
			count = count + 1;// 缓冲区中的数据项又多了一项
			if (count == 1) {
				notify();// 如果消费者正在休眠，将其唤醒
			}
		}

		public synchronized int remove() {
			int val;
			if (count == 0) {
				go_to_sleep();// 如果缓冲区空了，则进入休眠
			}
			val = buffer[lo];// 从缓冲区取出一个数据项
			lo = (lo + 1) % N;// 设置待取出数据项的槽
			count = count + 1;// 缓冲区的数据项数目减少1
			if (count == N - 1) {
				notify();// 如果生产者正在休眠，则将其唤醒
			}
			return val;
		}

		private void go_to_sleep() {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
