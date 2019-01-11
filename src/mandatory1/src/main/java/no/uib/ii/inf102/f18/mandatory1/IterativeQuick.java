package mandatory1.src.main.java.no.uib.ii.inf102.f18.mandatory1;

import java.util.SplittableRandom;

/**
 * @author Andrey Belinskiy
 */
@SuppressWarnings("unchecked")
public class IterativeQuick {

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length);
    }

    public static void sort(Comparable[] arr, int lb, int ub) {
        shuffle(arr);
        quickSort(arr, lb, ub);
    }

    private static void quickSort(Comparable[] arr, int lb, int ub) {
        MyDynamicArrayStack<Integer> stack = new MyDynamicArrayStack<>();

        stack.push(lb);
        stack.push(ub);

        while (!stack.empty()) {
            int hi = stack.pop(), lo = stack.pop();
            int p = partition(arr, lo, hi);

            if (p > lo) {
                stack.push(lo);
                stack.push(p);
            }

            if (p + 1 < hi) {
                stack.push(p + 1);
                stack.push(hi);
            }
        }
    }

    public static int partition(Comparable[] arr, int lb, int ub) {
        Comparable pivot = arr[lb];
        int i = lb, j = ub;

        while (true) {
            while (++i < ub && pivot.compareTo(arr[i]) > 0);
            while (pivot.compareTo(arr[--j]) < 0);
            if (i >= j) break;

            swap(i, j, arr);
        }

        swap(lb, j, arr);
        return j;
    }

    private static void swap(int i, int j, Comparable[] arr) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void shuffle(Comparable[] arr) {
        SplittableRandom r = new SplittableRandom();
        for (int i = 0; i < arr.length; i++) {
            int j = r.nextInt(arr.length - i) + i;
            swap(i, j, arr);
        }
    }
}
