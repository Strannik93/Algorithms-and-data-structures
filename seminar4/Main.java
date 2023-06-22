package seminar4;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.print();
        tree.add(5);
        tree.add(4);
        tree.add(6);
        tree.add(6);
        tree.add(10);
        tree.add(1);
        tree.add(20);
        tree.add(15);
        tree.add(35);
        tree.add(3);
        tree.add(40);
        tree.add(8);
        tree.add(50);
        tree.add(29);
        tree.add(45);
        tree.add(33);
        tree.add(70);
        tree.add(62);
        tree.add(67);
        tree.add(9);
        System.out.println(tree.contains(7));
        tree.print();
    }
}
