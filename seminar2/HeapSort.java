package seminar2;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{11,4,2,1,5,10,6,3,9,8};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // Строим кучу (группируем) O(n)
        for (int i = arr.length/2-1; i >= 0; i--) {
            heap(arr, arr.length, i);
        }

        // Извлечение элементов из кучи один за другим O(n.log(n))
        for (int i = arr.length-1; i >= 0; i--) {
            // Перемещение текущего корня в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызов процедуры на уменьшенной куче
            heap(arr, i, 0);
        } 
    }

    private static void heap(int[] arr, int size, int root) {
        // O(log(n))
        int larg = root; // инициализация наибольшего элемента
        int left = 2*root+1; // определяем левый
        int right = 2*root+2; // определяем правый
        // Если левый дочерний элемент больше корня
        if (left < size && arr[left] > arr[larg]) larg = left;
        // Если правый больше, чем самый большой элемент
        if (right < size && arr[right] > arr[larg]) larg = right;
        // Если самый большой элемент не корень
        if (larg != root) {
            int temp = arr[root];
            arr[root] = arr[larg];
            arr[larg] = temp;
            // Рекурсивное преобразование в двоичную кучу затронутое поддерево
            heap(arr, size, larg);
        }
    }
}
