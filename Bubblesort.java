
public class Bubblesort {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Bubblesort sorter = new Bubblesort();
        int[] a = new int[] { 3, 1, 2, 7, 4, 9, 10, 49, 332, 68, 29 };
        sorter.sort(a);
        System.out.println(a);
    }
}