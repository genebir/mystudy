package org.genebir.day02;

public class Main {
    public static void main(String[] args) {
        LinkedListNode<String> ll = new LinkedListNode<>();

        int check = ll.append("test0");
        int check1 = ll.append("test1");
        int check2 = ll.append("test2");
        int check3 = ll.append("test3");
        int delcheck = ll.delete(0);
        ll.append("test4");
        ll.append("test5");
//        System.out.println(delcheck);
        ll.retrieve();
    }
}
