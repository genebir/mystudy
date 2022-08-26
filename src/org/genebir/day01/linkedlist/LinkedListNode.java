package org.genebir.day01.linkedlist;

// LinkedList 구현
public class LinkedListNode<T> {
    Node header;

    class Node {
        T data;
        Node next = null;
    }

    public LinkedListNode() {
        header = new Node();
    }

    protected void append(T data) {
        Node end = new Node();
        end.data = data;
        Node n = header;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    // 삭제하는 delete 메소드 구현
    protected void delete(T data) {
        Node n = header;
        while(n.next != null) {
            if(n.next.data.equals(data)) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    // 출력하는 retrieve
    protected void retrieve() {
        Node n = header.next;
        while(n.next != null) {
            System.out.print(n.data +", ");
            n = n.next;
        }
        System.out.println(n.data);
    }

}
