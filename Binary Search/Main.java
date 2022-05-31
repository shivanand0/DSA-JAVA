/*
    1. find middle element
    2. check if target > middle element -> search at right
    3. else -> search at left
    4. if taget == middle -> found
    5. Binary search needs sorted array
    6. if array is sorted in ascending order
        -> target < arr[mid] => end = mid - 1 //search in left 
        -> target > arr[mid1 => start = mid + 1 //search in right
    7. if array is sorted in descending order
        -> target < arr[mid] => start = mid + 1 //search in right
        -> target > arr[mid1 => end = mid - 1 //search in left
    8. if we don't know if array is in decending or ascending order
        -> if arr[start] > arr[end] => descending
        -> if arr[start] < arr[end] => ascending
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int nums[], target, totalElements;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Number of elements in array: ");
        totalElements = in.nextInt();
        nums = new int[totalElements];

        System.out.println("Enter " + totalElements + " array elements on ascending or descending order: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(i + 1 + ": ");
            nums[i] = in.nextInt();
        }

        System.out.print("Enter Target: ");
        target = in.nextInt();

        // int[] nums = {6,5,4,767,34,65,-4,-3,65};
        // int target = 4;

        int ans = binarySearch(nums, target);

        //search in range array call
        // int ans = searchInRange(arr, target, 1, 4);

        if (ans != -1)
            System.out.println("target found on index: " + ans);
        else
            System.out.println("target not found on");
    }

    static int binarySearch(int[] arr, int target){
        if(arr.length == 0)
            return -1;

        int start = 0, end = arr.length-1;
        boolean arrIsAscending = true;
        //check if array is ascending or decending
        //we can sort the array before finding target
        if(arr[start] > arr[end])
            arrIsAscending = false;

        System.out.println(arrIsAscending);

        while(start <= end){
            //int mid = (start+end/2) mid might exceed the int limit - possibility
            int mid = start + (end - start) / 2; 

            if(target == arr[mid])
            {
                return mid;
            }
            if(target < arr[mid])
            {
                int check = arrIsAscending ? (end = mid - 1): (start = mid + 1);
            }
            else if(target > arr[mid]){
                int check = arrIsAscending ? (start = mid + 1): (end = mid - 1);
            }
        }
        //means failed
        return -1;
    }
}
