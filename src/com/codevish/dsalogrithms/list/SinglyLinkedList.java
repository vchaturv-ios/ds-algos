package com.codevish.dsalogrithms.list;

public class SinglyLinkedList {

    ListNode head;

    private class ListNode {
        private int data;
        private ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insertFirst(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }

        ListNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void insert(int data, int position) {
        ListNode node = new ListNode(data);
        if (position == 1) {
            node.next = head;
            head = node;
            return;
        }
        ListNode current = head;
        int counter = 1;

        while (counter < position - 1) {
            current = current.next;
            counter++;
        }

        ListNode newNode = new ListNode(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    public void delete(int position) {
        if (head == null) {
            return;
        }
        if (position == 1) {
            head = head.next;
            return;
        }
        ListNode current = head;

        int counter = 1;

        while(counter < position - 1) {
            current = current.next;
            counter++;
        }

        current.next = current.next.next;
    }

    public void display() {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.data+"-->");
            current = current.next;
        }

        System.out.println("NULL");
    }

    public void deleteFirst() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
        }
        head = head.next;
    }

    public ListNode getMiddleElement() {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public void reverse() {
        if (head == null) {
            return ;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public boolean containsLoop() {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr.next = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode mid = getMiddleElement();

        ListNode current = mid;
        ListNode next = null;
        ListNode previous = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        ListNode right = previous;
        ListNode left = head;

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }

            left = left.next;
            right = right.next;
        }
        return true;
    }

    public boolean checkPalindrom2() {
        if (head == null && head.next == null) {
            return true;
        }
        
        ListNode midNode = findMiddleNode();
        
        ListNode current = midNode;
        ListNode previous = null;
        ListNode next = null;
        
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        ListNode right  = previous;
        ListNode left = head;
        
        while (right != null) {
            if (right.data != left.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    
    public ListNode findMiddleNode() {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    

    public int getNthNodeFromTheEnd(ListNode head, int n) {
        if (head == null) {
            return -1;
        }

        int size = 0;

        ListNode current = head;

        while (current != null) {
            current = current.next;
            size++;
        }

        int positionOf = size - n + 1;

        int i = 1;

        ListNode temp = head;

        while (i < positionOf) {
            temp = temp.next;
            i++;
        }

        return temp.data;
    }

    public void getNthNodeFromTheEndAndDelete(ListNode head, int n) {

        int size = 0;

        ListNode current = head;

        while (current != null) {
            current = current.next;
            size++;
        }

        if (n == size) {
            head = head.next;
            return;
        }

        int positionOf = size - n;

        int i = 1;

        ListNode temp = head;

        while (i < positionOf) {
            temp = temp.next;
            i++;
        }

        temp.next = temp.next.next;
    }

    public void deleteLast() {
        ListNode previous = head;
        ListNode current = previous.next;

        while (previous != null && current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
    }
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        System.out.println("2nd node from the end is >> "+list.getNthNodeFromTheEnd(list.head, 2));

        list.display();
    }
}
