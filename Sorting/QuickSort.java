package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr ={10,80,30,20,70};
//        System.out.println(Arrays.toString(sort(arr,0,arr.length-1)));
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int []arr,int low,int high){
        if(low>=high) return ;
        int start=low;
        int end=high;
        int mid=start+(end-start)/2;
        int pivot=arr[mid];
        while(start<=end){
            while(arr[start]<pivot) start++;
            while(arr[end]>pivot) end--;
            if(start<=end){
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
        }
        sort(arr,low,end);
        sort(arr,start,high);
    }
//    public static void sort(int []arr,int low,int high){
//        if(low>=high) return;
//        int swapMarker=low;
//        int pivot=arr[high];
//        int curr_index=low;
//        while(curr_index<=high){
//            if(arr[curr_index]<pivot) {
//                curr_index++;
//            }
//            else{
//                swapMarker++;
//                if(arr[curr_index]>arr[swapMarker]){
//                    int temp=arr[curr_index];
//                    arr[curr_index]=arr[swapMarker];
//                    arr[swapMarker]=temp;
//                }
//                else{
//                    curr_index++;
//                }
//            }
//        }
//        sort(arr,low,swapMarker);
//        sort(arr,swapMarker,high);
//    }
}
