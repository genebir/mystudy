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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return idx == node.idx && Objects.equals(data, node.data) && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idx, data, next);
        }
    }

    // 추가하기!
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

    // index로 검색하는 get
    Node get(int index) {
        Node n = header;
        Node findNode = null;
        try{
            while(n.next != null) {
                if(n.next.idx == index) {
                    findNode = n.next;
                    break;
                }
                n = n.next;
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
        int idx = -1; // 찾을 수 없으면 -1을 리턴
        try {
            while(n.next != null) {
                if(n.next.data.equals(data)) {
                    idx = n.next.idx;
                    break;
                }
                n = n.next;
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
        try {
            while(n.next != null) {
                if(n.next.idx == index) {
                    n.next.data = data;
                    success = 1;
                    break;
                }
                n = n.next;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    // index로 삭제하는 delete
    int delete(int index) {
        Node n = header;
        int success;
        try {
            while(n.next != null) {
                if(n.next.idx == index) {
                    System.out.println(n.next + " delete succeed");
                    n.next = n.next.next;
                    while(n.next != null) {
                        n = n.next;
                        n.idx--;
                    }
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
    // data로 삭제하는 deleteByData
    int deleteByData(T data) {
        Node n = header;
        int success;
        try {
            while (n.next != null) {
                if(n.next.data.equals(data)) {
                    System.out.println(n.next + " delete succeed");
                    n.next = n.next.next;
                    while(n.next != null) {
                        n = n.next;
                        n.idx--;
                    }
                    this.index--;
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
                System.out.print("[" + n.idx + ", " + n.data + "], ");

            n = n.next;
        }
        System.out.println("[" + n.idx + ", " + n.data + "]");
    }



}
