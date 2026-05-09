public class MergeSort {
    static void printArray(String name, int[] arr) {
        System.out.println(String.format("\n%s: ", name));
        for (int i= 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
    }

    static void sortArray(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sortArray(arr, l, m);
            sortArray(arr, m + 1, r);
            merge(arr, l, m , r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
        // l_arr is inclusive of m 
        // r_arr starts from (m + 1)
        if (l < r) {
            int[] l_arr = new int[m - l + 1];
            int[] r_arr = new int[r - m];
            for (int i = 0; i < m - l + 1; i++) {
                l_arr[i] = arr[i + l];
            } 
            for (int i = 0; i < r - m; i++) {
                r_arr[i] = arr[i + m + 1];
            }
            int l_p = 0;
            int r_p = 0;
            while (l_p < m - l + 1 && r_p < r - m) {
                if (l_arr[l_p] <= r_arr[r_p]) {
                    arr[l_p + r_p + l] = l_arr[l_p];
                    l_p += 1;
                } else {
                    arr[l_p + r_p + l] = r_arr[r_p];
                    r_p += 1;
                }
            }
            while (l_p < m - l + 1) {
                arr[l_p + r_p + l] = l_arr[l_p];
                l_p += 1;
            }
            while (r_p < r - m) {
                arr[l_p + r_p + l] = r_arr[r_p];
                r_p += 1;
            }
        } else {
            System.out.println("l must be smaller than r!");
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6 , 5, 4, 3, 2, 1};
        // int[] arr = {2, 6, 3, 7, 9, 8, 7, 10, 5, 4, 1};
        printArray("arr", arr);
        sortArray(arr, 0, arr.length - 1);
        printArray("arr", arr);
    }
}
