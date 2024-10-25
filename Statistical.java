package MyMath;

public class Statistical {

    public int min(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }
        int min = arr[0];          for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public int max(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }
        int max = arr[0];  
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }


    public int sum(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array is null");
        }
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return sum;
    }

    public int count(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array is null");
        }
        return arr.length;
    }

public int avg(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }
        int sum = sum(arr);
        int count = count(arr);
        if (count == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return sum / count;
    }
}