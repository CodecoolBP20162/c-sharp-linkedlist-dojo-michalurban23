package com.codecool.michalurban.list;

import com.codecool.michalurban.node.Node;

import java.util.Iterator;

public abstract class LinkedList implements Iterable {

    private Node head;
    private Node last;
    private int length;

    public LinkedList() {

        this.head = null;
        this.last = null;
        this.length = 0;
    }

    public Iterator iterator() {

        return null; // TODO
    }

    public void add(Object o) {

        if (head == null) {
            addFirst(o);
        } else {
            addNext(o);
        }
        length++;
    }

    public int size() {

        return this.length;
    }

    public Object get(int index) {

        if (index < 0) {
            throw new IllegalArgumentException();
        } else if (index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            return getNode(index).getData();
        }
    }

    public void remove(int index) {

        if (index < 0) {
            throw new IllegalArgumentException();
        } else if (index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            length--;
            adjustPointers(index);
        }
    }

    public void insert(int index, Object o) {

        if (index < 0) {
            throw new IllegalArgumentException();
        } else if (index > size()) {
            throw new IndexOutOfBoundsException();
        } else if (index == size()) {
            add(o);
        } else {
            length++;
            adjustPointers(index, o);
        }
    }

    public Node getHead() {

        return head;
    }

    public Node getLast() {

        return last;
    }

    public void setHead(Node head) {

        this.head = head;
    }

    public void setLast(Node last) {

        this.last = last;
    }

    Node getNode(int index) {

        Node currentNode = getHead();
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    abstract void addFirst(Object o);
    abstract void addNext(Object o);
    abstract void adjustPointers(int index);
    abstract void adjustPointers(int index, Object o);
}
