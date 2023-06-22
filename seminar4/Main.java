package seminar4;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(5);
        tree.add(4);
        tree.add(6);
        System.out.println(tree.contains(7));
    }
}
