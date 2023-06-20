package seminar3;

public class Dlinlist {
    private Node head;    
    private Node tail;

    public void addFirst(int value){
        Node node = new Node();
        node.value = value;
        if (head != null){
            head.previous = node;
            node.next = head;
            head = node;
        } else {
            head = node;
            tail = node;
        }
    }

    public void removeFirst(){
        if (head == null){
            System.out.println("Нельзя удалить элемент из пустого списка");
        } 
        else{
            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                head.next.previous = null;
                head = head.next;
            }
        }
    }

    public void addLast(int value){
        Node node = new Node();
        node.value = value;
        if (head != null){
            tail.next = node;
            node.previous = tail;
            tail = node;
        } else {
            head = node;
            tail = node;
        }
    }

    public void removeLast(){
        if (head == null){
            System.out.println("Нельзя удалить элемент из пустого списка");
        } 
        else{
            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                tail.previous.next = null;
                tail = tail.previous;
            }
        }
    }

    public void revert() {
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null) {
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }

    public void print(){
        if (head == null){
            System.out.println("Список пуст");
            return;
        }
        Node node = head;
        while (node != null){
            if (node.next != null) System.out.print(node.value + " -> ");
            else System.out.println(node.value);
            node = node.next;
        }
    }

    private class Node{
        private int value;
        private Node next;
        private Node previous;
    }
}
