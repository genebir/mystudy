package org.genebir.day02.linkedlist;

import java.util.Objects;

// 객체 활용도 가능.

public class Main {

    public static void main(String[] args) {
        LinkedListNode<User> ll = new LinkedListNode<>();
        User yeom = new User(1, "염기승", "010-7387-4686");

        ll.append(yeom);
        ll.append(new User(2, "송현아", "010-2568-4462"));
        ll.append(new User(3, "정경민", "010-1111-1111"));
        ll.append(new User(4, "염정아", "010-2222-2222"));

        System.out.println(ll.findIndex(yeom));
        System.out.println(ll.findIndex(new User(2, "송현아", "010-2568-4462")));
        System.out.println(ll.get(1));

        ll.retrieve();
    }
}

class User {
    int id;
    String name;
    String phone;

    public User(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone);
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", phone: " + phone;
    }
}
