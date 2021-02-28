package alg;

public class BinarySearch {
    public int search(int[] arr,int v){
        int n = arr.length;
        if(v > arr[n-1]){
            return n +1;
        }
        int left = 0,right = n-1;
        while (left < right){
            int mid = (left + right) /2;
            if(arr[mid] > v){
                right = mid -1;
            }else if(arr[mid] == v){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left+1;
    }
}
