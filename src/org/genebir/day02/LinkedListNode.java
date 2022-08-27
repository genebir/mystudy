package org.genebir.day02;

import java.util.Objects;

// LinkedList 복습삼아 구현해보기
public class LinkedListNode<T> {
    Node header = new Node();
    int index = 0;

    class Node {
        int idx;
        T data;
        Node next;

        @Override
        public String toString() {
            return "[" + idx + ", " + data + "]";
        }
    }

    int append(T data) {
        Node end = new Node();
        Node n = header;
        int success = 0;
        try {
            end.data = data;
            end.idx = index++;
            System.out.println(end + " append succeed");
            while(n.next != null) {
                n = n.next;
            }
            n.next = end;
            success = 1;
        } catch (Exception e) {
            e.printStackTrace();
            success = 0;
        }
        return success;
    }

    int delete(int index) {
        Node n = header;
        int success;
        try {
            while(n.next != null) {
                if(n.next.idx == index) {
                    n.next = n.next.next;
                    while(n.next != null) {
                        System.out.println("deleting....");
                        n.idx--;
                        n = n.next;
                    }
                    n.idx--;
                    this.index--;

                    break;
                }
                n = n.next;
            }
            success = 1;
        } catch (Exception e) {
            success = 0;
        }
        return 0;

    }

    void retrieve() {
        Node n = header;
        System.out.print("[");
        while(n.next != null) {
            if(n.data != null)
                System.out.print("[" + n.idx + ", " + n.data + "], ");

            n = n.next;
        }
        System.out.println(n.data + "]");
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedListNode<?> that = (LinkedListNode<?>) o;
        return Objects.equals(header, that.header);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header);
    }

}
