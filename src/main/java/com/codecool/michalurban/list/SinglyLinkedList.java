package com.codecool.michalurban.list;

import com.codecool.michalurban.node.Node;
import com.codecool.michalurban.node.SingleDirectionNode;

public class SinglyLinkedList extends LinkedList {

    @Override
    void addFirst(Object o) {

        Node first = new SingleDirectionNode();
        first.setData(o);

        setHead(first);
        setLast(first);
    }

    @Override
    void addNext(Object o) {

        Node newNode = new SingleDirectionNode();
        newNode.setData(o);

        getLast().setNext(newNode);
        setLast(newNode);
    }

    @Override
    void adjustPointers(int index) {

        if (index == 0) {
            if (size() == 1) {
                setHead(null);
                setLast(null);
            } else {
                setHead(getNode(1));
            }
        } else if (index == size() - 1) {
            Node secondToLast = getNode(index);
            secondToLast.setNext(null);
            setLast(secondToLast);
        } else {
            getNode(index - 1).setNext(getNode(index + 1));
        }
    }

    @Override
    void adjustPointers(int index, Object o) {

        Node node = new SingleDirectionNode(o);
        node.setNext(getNode(index));

        if (index == 0) {
            setHead(node);
        } else {
            getNode(index-1).setNext(node);
        }
    }

}
