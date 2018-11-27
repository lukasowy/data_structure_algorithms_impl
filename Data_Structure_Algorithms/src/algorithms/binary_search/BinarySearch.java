package algorithms.binary_search;

public class BinarySearch {

    public static boolean binarySearchRecursive(int[] array, int x, int left, int right) {
        if (left > right)
            return false;

        int mid = left + ((right - left) / 2);

        if (array[mid] == x)
            return true;
        else if (x < array[mid])
            return binarySearchRecursive(array, x, left, mid - 1);
        else
            return binarySearchRecursive(array, x, mid + 1, right);


    }

    public static boolean binarySearchRecursive(int[] array, int x) {
        return binarySearchRecursive(array, x, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 6, 21, 43};

        System.out.println(binarySearchRecursive(array, 21));
    }
}
