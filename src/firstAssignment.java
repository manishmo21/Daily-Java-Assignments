
import java.util.Arrays;

public class firstAssignment {

    public static int findPeak(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }
        if (arr[0] >= arr[1]) {
            return arr[0];
        }
        if (arr[n - 1] >= arr[n - 2]) {
            return arr[n - 1];
        }
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
                return arr[i];
            }
        }
        return -1; // No peak found
    }

    public static int[] reverseArray(int[] arr) {
        int[] reversedArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArr[i] = arr[arr.length - 1 - i];
        }
        return reversedArr;
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 20, 15};

        int peak = findPeak(arr);
        System.out.println("Peak Element: " + peak);

        int[] reversedArr = reverseArray(arr);
        System.out.println("Reversed Array: " + Arrays.toString(reversedArr));
    }
}


