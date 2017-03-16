package sort;

/**
 * 计数排序： 有多少数字建立多少桶，将对应的放到桶中,之后将桶中元素倒出
 * 
 * @author dell
 *
 */
public class CountingSort {

  public int[] countingSort(int[] A) {
    int min = A[0];
    int max = A[0];
    for (int a : A) {
      min = Math.min(a, min);
      max = Math.max(a, max);
    }
    int bucketLength = max - min + 1;
    int[] bucket = new int[bucketLength];
    // 放内容
    for (int a : A) {
      bucket[a - min]++;
    }
    // 倒出内容
    int index = 0;
    for (int i = 0; i < bucketLength; i++) {
      for (int j = 0; j < bucket[i]; j++) {
        A[index++] = i + min;
      }
    }
    return A;
  }
}
