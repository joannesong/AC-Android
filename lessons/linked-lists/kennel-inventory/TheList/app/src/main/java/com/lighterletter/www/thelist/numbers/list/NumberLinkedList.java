package com.lighterletter.www.thelist.numbers.list;

/**
 * A singly linked list from: http://www.sanfoundry.com/java-program-implement-singly-linked-list/
 */

public class NumberLinkedList {

    private NumberNode head;
    private NumberNode tail;
    private int size;

    public NumberLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void insertAtStart(int val) {
        NumberNode newNumberNode = new NumberNode(val, null);
        size++;
        if (head == null) {
            head = newNumberNode;
            tail = head;
        } else {
            newNumberNode.setNext(head);
            head = newNumberNode;
        }
    }

    public void insertAtEnd(int val) {
        NumberNode newNumberNode = new NumberNode(val, null);
        size++;
        if (head == null) {
            head = newNumberNode;
            tail = head;
        } else {
            tail.setNext(newNumberNode);
            tail = newNumberNode;
        }
    }

    public void insertAtPos(int val, int pos) {
        NumberNode newNumberNode = new NumberNode(val, null);
        NumberNode numberNode = head;
        pos = pos - 1;
        for (int i = 1; i < size; i++) {
            if (i == pos) {
                NumberNode tmp = numberNode.getNext();
                numberNode.setNext(newNumberNode);
                newNumberNode.setNext(tmp);
                break;
            }
            numberNode = numberNode.getNext();
        }
        size++;
    }

    public void deleteAtPos(int pos) {
        if (pos == 1) {
            head = head.getNext();
            size--;
            return;
        }
        if (pos == size) {
            NumberNode s = head;
            NumberNode t = head;
            while (s != tail) {
                t = s;
                s = s.getNext();
            }
            tail = t;
            tail.setNext(null);
            size--;
            return;
        }
        NumberNode numberNode = head;
        pos = pos - 1;
        for (int i = 1; i < size - 1; i++) {
            if (i == pos) {
                NumberNode tmp = numberNode.getNext();
                tmp = tmp.getNext();
                numberNode.setNext(tmp);
                break;
            }
            numberNode = numberNode.getNext();
        }
        size--;
    }

    public String display() {
        StringBuilder builder = new StringBuilder();

        builder.append("\nSingly Linked List = ");
        if (size == 0) {
            builder.append("empty\n");
            return builder.toString();
        }

        if (head.getNext() == null) {
            builder.append(head.getData());
            return builder.toString();
        }
        NumberNode numberNode;
        builder.append(head.getData()).append("->");
        numberNode = head.getNext();
        while (numberNode.getNext() != null) {
            builder.append(numberNode.getData()).append("->");
            numberNode = numberNode.getNext();
        }
        builder.append(numberNode.getData()).append("\n");
        return builder.toString();
    }
}