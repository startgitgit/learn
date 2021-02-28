package alg;

public class QuickSort {
    public int[] sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int start, int end) {
        int i = start, j = end;
        int standard = arr[start];
        while (i < j) {
            while (i < j && arr[j] > standard) {
                j--;
            }
            while (i < j && arr[i] <= standard) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, start, i);
        quickSort(arr, i + 1, end);
        quickSort(arr, start, i - 1);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
