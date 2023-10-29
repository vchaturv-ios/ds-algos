package com.codevish.dsalogrithms.list;

import static java.lang.System.*;

public class LinkedList {
    ListNode head;

    class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void display() {
        ListNode current = head;
        while (current != null) {
            out.print(current.data + "-->");
            current = current.next;
        }
        out.println("NULL");
    }


    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        for (int i = 5; i > 0; i--) l1.addFirst(i);

        l1.display();
    }
}
