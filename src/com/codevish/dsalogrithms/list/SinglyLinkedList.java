package com.codevish.dsalogrithms.list;

public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode {
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

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        ListNode previous = head;
        ListNode current = previous.next;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        previous.next = null;
    }

    public void insert(int position, int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position < 1) {
            System.out.println(
                    "Please provide valid position starting from 1, we don't support 0 or negative values..motherfucker");
            return;
        }

        ListNode newNode = new ListNode(data);

        if (position == 1) {
            newNode.next = head;
            head = newNode;
        }

        ListNode current = head;
        ListNode nextPointer = current.next;
        int positionCounter = 1;
        while (positionCounter < position - 1) {
            current = nextPointer;
            nextPointer = nextPointer.next;
            positionCounter++;
        }
        current.next = newNode;
        newNode.next = nextPointer;
    }

    public void delete(int position) {
        if (head == null) {
            System.out.println("List is empty");
        }
        if (position < 1) {
            System.out.println(
                    "Please provide valid position starting from 1, we don't support 0 or negative values..motherfucker");
        }
        if (position == 1) {
            head = head.next;
            return;
        }
        ListNode current = head.next;

        int positionCounter = 1;

        while (positionCounter < position - 1) {
            current = current.next;
            positionCounter++;
        }

        current.next = current.next.next;
    }

    public boolean find(int key) {
        if (head == null) {
            System.out.println("List is empty and does not have any elements.");
            return false;
        }

        int count = 0;

        ListNode temp = head;
        while (temp != null) {
            if (key == temp.data) {
                count++;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public ListNode reverseIterate(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode previous = null;
        ListNode current = head;

        while(current != null) {
            ListNode temp = current.next;
            current.next = previous;

            previous = current;
            current = temp;
        }
        return previous;
    }

    public ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public ListNode reverseRecursive2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseRecursive2(head.next);
        ListNode headNext = head.next;
        headNext.next = head;
        head.next = null;
        return newHead;

    }

    public int length() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public ListNode getMiddleElement(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slowPointer = head, fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
        }
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "-->");
            currentNode = currentNode.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        list.display();

        ListNode middleElement = list.getMiddleElement(list.head);

        System.out.println("Middle element : "+middleElement.data);

        list.display();
    }

}
