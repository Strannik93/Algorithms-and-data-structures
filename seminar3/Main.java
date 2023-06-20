package seminar3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Односвязный список");
        Linlist list = new Linlist();
        list.addFirst(1);
        list.removeLast();
        list.addFirst(0);
        list.addLast(2);
        list.removeLast();
        list.addLast(3);
        list.addLast(2);
        list.addFirst(5);
        list.print();
        System.out.println();
        list.revert();
        list.print();
        System.out.println();
        if (!list.contains(3)){
            System.out.println("Элемента с таким значением не существует");
        }
        System.out.println("Двусвязный список");
        Dlinlist list2 = new Dlinlist();
        list2.addFirst(1);
        list2.print();
        list2.addFirst(3);
        list2.print();
        list2.addLast(5);
        list2.addLast(4);
        list2.addLast(7);
        list2.print();
        list2.removeFirst();
        list2.removeLast();
        list2.print();
        list2.revert();
        list2.print();
    }
}
