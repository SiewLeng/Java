public class MergeSort {
    static void merge(int[] arr, int l, int m, int r) {
        // l_arr is inclusive of m 
        if (l < r) {
            int[] l_arr = new int[m - l + 1];
            int[] r_arr = new int[r - m];
            for (int i = 0; i < m - l + 1; i++) {
                l_arr[i] = arr[i + l];
            } 
            for (int i = 0; i < r - m; i++) {
                r_arr[i] = arr[i + m + 1];
            }
            System.out.println("l: " + l + " m: " + m + " r: " + r);
            System.out.println("\nl_arr: ");
            for (int i= 0; i < l_arr.length; i++) {
                System.out.print(l_arr[i]);
            }
            System.out.println("\nr_arr: ");
            for (int i= 0; i < r_arr.length; i++) {
                System.out.print(r_arr[i]);
            }
            int l_p = 0;
            int r_p = 0;
            while (l_p < m - l + 1 && r_p < r - m) {
                if (arr[l_p] <= arr[r_p]) {
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
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8, 10};
        for (int i= 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        merge(arr, 0, 3, arr.length - 1);
        System.out.println("");
        for (int i= 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
