package org.genebir.day01.linked_list;

public class Main {
    // 생성만 LinkedList를 테스트해보자
    public static void main(String[] args) {

        Node node = new Node("1");
        node.append("2");
        node.append("3");
        node.append("4");
        node.delete("2");

        node.retrieve();
    }

}
