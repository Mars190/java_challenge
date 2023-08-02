import java.util.Arrays;

public class Sort {
    public static String[] quicksort(String[] array) {
        quicksortRecursive(array, 0, array.length - 1);

        return array;
    }

    public static String[] bubblesort(String[] array) {
        int n = array.length;
        boolean swapped;

        System.out.printf("Before bubble-sort: %s\n", Arrays.toString(array));

        do {
            swapped = false;

            for (int i = 0; i < n-1; i++)
            {
                if (array[i].compareTo(array[i + 1]) > 0) // Wenn list[i] weiter hinten im alphabet ist als list[i + 1]
                {
                    swap(i, i + 1, array);
                    swapped = true;
                }
            }

        } while (swapped);

        System.out.printf("After bubble-sort:  %s", Arrays.toString(array));

        return array;
    }

    private static void quicksortRecursive(String[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        String p = array[end];
        int i = start;
        int j = end - 1;

        while (i <= j) {
            while (i <= j && array[i].compareTo(p) < 0) { // Wenn array[i] weiter vorne ist als p
                i++;
            }

            while (j >= i && array[j].compareTo(p) > 0) { // Wenn array[j] weiter hinten ist als p
                j--;
            }

            if (i < j) { // überkreuzung
                swap(i, j, array);
            }
        }

        swap(i, end, array);

        quicksortRecursive(array, start, i - 1);
        quicksortRecursive(array, i + 1, end);
    }

    private static void swap(int x, int y, String[] array) {
        String temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
