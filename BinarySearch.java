
public class BinarySearch {
    public static int searchStart(int[] arr, int val) {
        int l, r, mid;
        l = 0;
        r = arr.length - 1;
        mid = l + (r - l) / 2;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] >= val) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (arr[mid] != val) {
            return -1;
        }
        return mid;
    }

    public static int searchEnd(int[] arr, int val) {
        int l, r, mid;
        l = 0;
        r = arr.length - 1;
        mid = l + (r - l) / 2;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] <= val) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (arr[mid - 1] != val) {
            return -1;
        }
        return mid - 1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 8, 8, 8, 8, 9, 10, 13, 15 };
        System.out.println(searchStart(arr, 8));
        System.out.println(searchEnd(arr, 8));
    }
}
