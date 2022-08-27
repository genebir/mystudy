package org.genebir.day02;

public class Main {
    public static void main(String[] args) {
        LinkedListNode<String> ll = new LinkedListNode<>();

        int check = ll.append("test0");
        int check1 = ll.append("test1");
        int check2 = ll.append("test2");
        int check3 = ll.append("test3");
        ll.append("test4");
        ll.append("test5");
        ll.append("test6");
        ll.append("test7");
        ll.append("test8");
        ll.append("test9");

        System.out.println(ll.get(1));
        int delcheck = ll.deleteByData("test1");
        ll.retrieve();
        ll.replace(1, "test11");
        ll.append("test4");
        ll.append("test5");
        System.out.println(ll.findIndex("test1"));
        System.out.println(ll.findIndex("test4"));
//        System.out.println(delcheck);
        ll.retrieve();
    }
}
