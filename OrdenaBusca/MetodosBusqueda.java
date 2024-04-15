
/**
 *
 * @author mmm
 */
public class MetodosBusqueda {

    public static int binarySearch(Comparable[] arr, Comparable key) {
        int low = 0, high = arr.length - 1, current;
        while (low <= high) {
            current = low + (high - low) / 2;
            if (arr[current].equals(key)) {
                return current;
            } else if (arr[current].compareTo(key) > 0) {
                high = current - 1;
            } else {
                low = current + 1;
            }
        }
        return -1;
    }

    public static int linearSearch(Object[] arr, Object key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public static int sentinelLinearSearch(Object[] arr, Object key) {
        int n = arr.length - 1;
        Object last = arr[n];
        arr[n] = key;
        int i = 0;
        while (arr[i] != key) {
            i++;
        }
        arr[n] = last;
        if (i < n - 1 || arr[i].equals(key)) {
            return i;
        } else {
            return -1;
        }
    }
}
