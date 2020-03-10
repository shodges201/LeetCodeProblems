import java.util.*;

class Solution {
    public static boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < A.length; i++) {
            if (map.get(A[i]) == null) {
                map.put(A[i], 1);
            } else {
                map.put(A[i], map.get(A[i]) + 1);
            }
        }
        Integer[] B = new Integer[A.length];
        for (int i = 0; i < A.length; ++i)
            B[i] = A[i];
        Arrays.sort(B, Comparator.comparingInt(Math::abs));
        for (int i = 0; i < B.length; i++) {
            if (map.get(B[i]) == 0) {
                continue;
            } else if (map.get(B[i] * 2) == null || map.get(B[i] * 2) == 0) {
                return false;
            } else if (map.get(B[i]) > 0) {
                if (map.get(B[i] * 2) > 0) {
                    map.put(B[i], map.get(B[i]) - 1);
                    map.put(B[i] * 2, map.get(B[i] * 2) - 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = { -1, 4, 6, 8, -4, 6, -6, 3, -2, 3, -3, -8 };
        System.out.println(canReorderDoubled(array));
    }
}