public class Sort {
    public static User[] bubblesort(User[] users, boolean descending) {
        int n = users.length;
        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < n-1; i++)
            {
                if ((descending && users[i].getUsername().compareTo(users[i + 1].getUsername()) < 0) || // Descending
                    (!descending && users[i].getUsername().compareTo(users[i + 1].getUsername()) > 0)) { // Ascending
                    swap(i, i + 1, users);
                    swapped = true;
                }
            }

        } while (swapped);

        return users;
    }

    public static User[] quicksort(User[] users, boolean descending) {
        quicksortRecursive(users, 0, users.length - 1, descending);

        return users;
    }

    public static void quicksortRecursive(User[] users, int start, int end, boolean descending) {
        if (start >= end) {
            return;
        }

        int pivotIndex = partition(users, start, end, descending);

        quicksortRecursive(users, start, pivotIndex - 1, descending);
        quicksortRecursive(users, pivotIndex + 1, end, descending);
    }

    public static int partition(User[] users, int start, int end, boolean descending) {
        User pivot = users[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if ((descending && users[j].getUsername().compareTo(pivot.getUsername()) > 0) || // Descending
                    (!descending && users[j].getUsername().compareTo(pivot.getUsername()) < 0)) { // Ascending
                i++;
                swap(i, j, users);
            }
        }

        swap(i + 1, end, users);
        return i + 1;
    }

    private static void swap(int x, int y, User[] users) {
        User temp = users[x];
        users[x] = users[y];
        users[y] = temp;
    }
}
