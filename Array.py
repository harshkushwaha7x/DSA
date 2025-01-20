# Rotate an Array by d – Counterclockwise or Left

import java.util.Arrays;

class Array {
    
    static void rotateArr(int[] arr, int d) {
        int n = arr.length;
  
        for (int i = 0; i < d; i++) {
            int first = arr[0];
            for (int j = 0; j < n - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[n - 1] = first;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int d = 2;

        rotateArr(arr, d);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}


# Rearrange Array Elements by Sign

import java.util.Arrays;

class Array {
    
    static void rightRotate(int[] arr, int start, int end) {
        int temp = arr[end];
        for (int i = end; i > start; i--) {
            arr[i] = arr[i - 1];
        }
        arr[start] = temp;
    }

    static void rearrange(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0 && i % 2 == 1) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < 0) {
                        rightRotate(arr, i, j);
                        break;
                    }
                }
            }
            else if (arr[i] < 0 && i % 2 == 0) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] >= 0) {
                        rightRotate(arr, i, j);
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -4, -1, 4};

        rearrange(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
