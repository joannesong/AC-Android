public class Main {
    public static void main(String[] args) {
        int[] array = {0, 1, 5, 6, 10, 13, 22, 64, 75};
        int target = 5;

        System.out.println(iterativeBinarySearch(array, target));
        
        System.out.println(recursiveBinarySearch(array, target));

    }

    // Iterative approach
    public static int iterativeBinarySearch(int[] array, int target) {
        int min = 0;
        int max = array.length - 1;

        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (target < array[mid]) {
                max = mid - 1;
            } else if (target > array[mid]) {
                min = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    // Recursive approach
    public static int recursiveBinarySearch(int[] array, int target) {
        return recursiveBinarySearch(array, target, 0, array.length - 1);
    }

    public static int recursiveBinarySearch(int[] array, int target, int min, int max) {
        if (min > max) {
            return -1;
        }

        int mid = (min + max) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            return recursiveBinarySearch(array, target, mid + 1, max);
        } else {
            return recursiveBinarySearch(array, target, min, mid - 1);
        }
    }
}
