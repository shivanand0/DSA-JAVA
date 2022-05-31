import javax.swing.text.html.HTML.Tag;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // System.out.println(Integer.MIN_VALUE);
        int nums[], target, totalElements;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Number of elements in array: ");
        totalElements = in.nextInt();
        nums = new int[totalElements];

        System.out.println("Enter" + totalElements + " array elements: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(i + 1 + ": ");
            nums[i] = in.nextInt();
        }

        System.out.print("Enter Target: ");
        target = in.nextInt();

        // int[] nums = {6,5,4,767,34,65,-4,-3,65};
        // int target = 4;

        int ans = linearSearch(nums, target);

        //search in range array call
        // int ans = searchInRange(arr, target, 1, 4);

        if (ans != -1)
            System.out.println("target found on index: " + ans);
        else
            System.out.println("target not found on");

    }

    // search the element return the index if find, if not find then return 0 or -1
    static int linearSearch(int[] arr, int target) {
        if (arr.length == 0)
            return -1;

        for (int index = 0; index < arr.length; index++) {
            // check if array element is equal to target
            if (arr[index] == target) {
                return index;
            }
        }

        // means failed, target is not in array
        return -1;
    }

    static int searchInRange(int[] arr, int target, int start, int end) {

        if (arr.length == 0) {
            return -1;
        }

        // run a for loop
        for (int index = start; index <= end; index++) {
            // check for element at every index if it is = target
            int element = arr[index];
            if (element == target) {
                return index;
            }
        }
        // this line will execute if none of the return statements above have executed
        // hence the target not found
        return -1;
    }
}