package org.genebir.day02.linkedlist;

import java.util.Objects;

// LinkedList 복습삼아 구현해보기
public class LinkedListNode<T> {
    Node header;
    public LinkedListNode() {
        header = new Node();
    }

    class Node {
        T data;
        Node next;

        @Override
        public String toString() {
            return "[" + data + "]";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(data, node.data) && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, next);
        }
    }

    // 추가하기!
    int append(T data) {
        Node end = new Node();
        Node n = header;
        int success = 0;
        try {
            end.data = data;
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

    // index로 검색하는 get
    Node get(int index) {
        Node n = header;
        int idx = 0;
        Node findNode = null;
        try{
            while(n.next != null) {
                if(idx == index) {
                    findNode = n.next;
                    break;
                }
                n = n.next;
                idx++;
            }
            System.out.println(findNode + " get succeed");
            return findNode;
        } catch (Exception e) {
            return findNode;
        }
    }

    // index를 뽑아내는 findIndex
    int findIndex(T data) {
        Node n = header;
        int idx = 0; // 찾을 수 없으면 -1을 리턴
        try {
            while(n.next != null) {
                if(n.next.data.equals(data)) {
                    break;
                }
                n = n.next;
                idx++;
            }
            return idx;
        } catch (Exception e) {
            return idx;
        }
    }

    // index를 찾아 data를 수정하는 replace
    int replace(int index, T data) {
        Node n = header;
        int success = 0;
        int idx = 0;
        try {
            while(n.next != null) {
                if(idx == index) {
                    n.next.data = data;
                    success = 1;
                    break;
                }
                n = n.next;
                idx++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    // index로 삭제하는 delete
    int delete(int index) {
        Node n = header;
        int idx = 0;
        int success;
        try {
            while(n.next != null) {
                if(idx == index) {
                    System.out.println(n.next + " delete succeed");
                    n.next = n.next.next;

                    break;
                }
                idx++;
                n = n.next;
            }
            success = 1;
        } catch (Exception e) {
            success = 0;
        }
        return 0;
    }

    // data로 삭제하는 deleteByData
    int deleteByData(T data) {
        Node n = header;
        int success;
        try {
            while (n.next != null) {
                if(n.next.data.equals(data)) {
                    System.out.println(n.next + " delete succeed");
                    n.next = n.next.next;

                    break;
                }
                n = n.next;
            }
            success = 1;
        } catch (Exception e) {
            success = 0;
        }
        return success;
    }

    // 전체 출력하는 retrieve
    void retrieve() {
        Node n = header;
        System.out.print("[");
        while(n.next != null) {
            if(n.data != null)
                System.out.print("[" + n.data + "], ");

            n = n.next;
        }
        System.out.println("[" + n.data + "]");
    }



}
