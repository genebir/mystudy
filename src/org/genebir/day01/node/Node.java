package org.genebir.day01.node;

import java.util.Objects;

// 단방향 Linked List를 자바로 구현해보자
// header가 따로 없어 반쪽짜리임
// Queue
public class Node {

    // 리스트의 노드 내 삽입될 데이터
    protected Object data;
    // 다음 노드에 대한 참조
    protected Node next = null;
    // 생성자를 통해 데이터 입력
    public Node(Object data) {
        this.data = data;
    }
    public Node() {
        this.data = null;
    }

    // 추가하는 append 메소드 구현
    protected void append(Object data) {
        // 데이터의 가장 끝에 넣어줄 수 있게
        Node end = new Node(data);
        Node n = this;
        // next가 null일 때까지 반복하여 끝자리를 찾음
        while(n.next != null) {
            n = n.next;
        }
        // 반복을 마친 후 가장 끝 Node.next에 참조
        n.next = end;
    }

    // 삭제하는 delete 메소드 구현
    protected void delete(Object data) {
        Node n = this;
        // 끝까지 반복하기 위한 Loop
        while(n.next != null) {
            // 주소를 참조하기 때문에 이전에서 찾아서 링크를 끊어줘야함
            // 그렇기 때문에 다음 것을 참조하지 않고 다음의 다음 것을 참조하여 링크를 끊어줌
            if(n.next.data.equals(data)) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
            // 다음 것을 참조하기 때문에 처음 HeadNode는 삭제할 수 없음
        }
    }

    // 출력하는 retrieve
    protected void retrieve() {
        Node n = this;
        while(n.next != null) {
            // 끝까지 반복하여 출력
            System.out.print(n.data +", ");
            n = n.next;
        } // next가 null이면 출력하지 않기 때문에
        // 마지막에 println으로 출력해준다.
        System.out.println(n.data);
    }


    // equals와 hashcode 재정의
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
