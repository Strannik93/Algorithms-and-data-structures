import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        task4();
    }
    
    // Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N. 
    public static void task1(){ // O(n)
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число N: ");
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        // O(n^2)
        System.out.println(sum);
        sc.close();
    }

    // Написать алгоритм поиска простых чисел (делятся только на себя и на 1) 
    // в диапозоне от 1 до N.
    public static void task2(){  // O(n^2)
        boolean flag;
        for (int i = 2; i <= 1000; i++) {
            flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0){
                    flag = false;
                }
            }
            if (flag){
                System.out.print(i + " ");
            }
        }
        for (int i = 0; i < 10; i++) {
            //...
        }
    }

    // Необходимо написать алгоритм поиска всех доступных комбинаций 
    // (посчитать количество) 
    // для количества кубиков K с количеством граней N
    public static void task3(){
        int count = 4;
        int faces = 6;
        System.out.println(recursiveCount(1, count, faces)); 
    }

    public static int recursiveCount(int countNow, int MaxCount, int faces){ //O(n^k)
        int count = 0;
        for (int i = 0; i < faces; i++) {
            if (countNow == MaxCount){
                count++;
            }
            else{
                count += recursiveCount(countNow+1, MaxCount, faces);
            }
        }
        return count;

        // for (int i = 0; i < faces; i++) {  //O(n^4)
        //     for (int j = 0; j < faces; j++) {
        //         for (int j2 = 0; j2 < faces; j2++) {
        //             for (int k = 0; k < faces; k++) {
        //                 count ++;
        //             }
        //         }
        //     }
        // }
        // return count;
    }

    // Пишем алгоритм поиска нужного числа последовательности Фибоначчи. 
    // Считаем, что  1 и 2 значения последовательности равны 1

    public static void task4(){
        int n = 50;
        Date startDate = new Date();
        System.out.println(fb(n));
        Date endDate = new Date();
        System.out.print("Решение через рекурсию: ");
        System.out.println(endDate.getTime() - startDate.getTime());
        Date startDate2 = new Date();
        System.out.println(fb2(n));
        Date endDate2 = new Date();
        System.out.print("Решение линейное: ");
        long chis = endDate2.getTime() - startDate2.getTime();
        System.out.println(chis);
    }

    public static int fb(int num){
        // 1 1 2 3
        // On = On-1 + On-2
        if (num <= 2){
            return 1;
        }
        else{
            return fb(num-1) + fb(num-2);
        }
    }

    public static int fb2(int num){
        if (num <= 2){
            return 1;
        }
        int [] numbers = new int[num];
        numbers[0] = 1;
        numbers[1] = 1;
        for (int i = 2; i < numbers.length; i++) {
            numbers[i] = numbers[i-1] + numbers[i-2];
        }
        return numbers[num-1];
    }
}