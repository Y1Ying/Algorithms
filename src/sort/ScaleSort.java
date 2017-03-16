package sort;

/**
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k， 并且k相对于数组来说比较小。
 * 
 * 请选择一个合适的排序算法针对这个数据进行排序。给定一个int数组A， 同时给定A的大小n和题意中的k，请返回排序后的数组。
 * 
 * @author dell
 *
 */
public class ScaleSort {
	public int[] getMinKNumsByHeap(int[] arr, int k) {
		if (k < 1 || k > arr.length) {
			return arr;
		}
		int[] kHeap = new int[k];
		for (int i = 0; i != k; i++) {
			heapInset(kHeap, arr[i], i);
		}
		for (int i = k; i != arr.length; i++) {
			if (arr[i] < kHeap[0]) {
				kHeap[0] = arr[i];
				heapify(kHeap, 0, k);
			}
		}
		return kHeap;
	}

	public void heapInset(int[] arr, int value, int index) {
		arr[index] = value;
		while (index != 0) {
			int parent = (index - 1) / 2;
			if (arr[parent] < arr[index]) {
				swap(arr, parent, index);
				index = parent;
			} else {
				break;
			}
		}

	}

	public void heapify(int[] arr, int index, int heapSize) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int largest = index;
		while (left < heapSize) {
			if (arr[left] > arr[right]) {
				largest = left;
			}
			if (right < heapSize && arr[right] > arr[largest]) {
				largest = right;
			}
			if (largest != index) {
				swap(arr, largest, index);
			} else {
				break;
			}
			index = largest;
			left = index * 2 + 1;
			right = index * 2 + 2;
		}

	}

	public void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

}
