class Solution_28 {

    public static int[] compute_kmp_fail(String p) {
        int[] fail = new int[p.length()];
        for (int i = 0; i < fail.length; i++) {
            fail[i] = 0;
        }
        int len = 0; // len represent the length of prefix and subfix match
        int i = 1;
        while (i < p.length()) {
            if (p.charAt(i) == p.charAt(len)) {
                len ++;
                fail[i] = len;
                i++;
            } else {
                // p.charAt(i) != p.charAt(len)
                if (len == 0) {
                    i++;
                } else {
                    len = fail[len - 1];
                }
            }
        }
        return fail;
    }

    public static int find_kmp(String t, String p) {
        int i = 0; // track index of text, t
        int j = 0; // track index of pattern, p
        int[] fail = compute_kmp_fail(p);
        while (i < t.length()) {
            if (t.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                if (j == p.length()) return i - p.length();
            } else {
                // t.charAt(i) != p.charAt(j)
                if (j == 0) {
                    i++;
                } else {
                    j = fail[j - 1];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        /*
        String p = "abacab";
        String t = "abacaabaccabacabaabb";
        */
        String p = "amalgamation";
        String t = "atcamalgamaxyamalgamation";
        for (int index: compute_kmp_fail(p)) {
            System.out.print(index);
        }
        System.out.println("\nResult: " + find_kmp(t, p));
    }
} 