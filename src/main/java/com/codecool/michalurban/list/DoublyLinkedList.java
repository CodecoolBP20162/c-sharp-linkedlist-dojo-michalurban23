package com.codecool.michalurban.list;

import com.codecool.michalurban.node.Node;
import com.codecool.michalurban.node.DoubleDirectionNode;

public class DoublyLinkedList extends LinkedList {

    @Override
    void addFirst(Object o) {

        Node first = new DoubleDirectionNode();
        first.setData(o);

        setHead(first);
        setLast(first);
    }

    @Override
    void addNext(Object o) {

        DoubleDirectionNode newNode = new DoubleDirectionNode();
        newNode.setData(o);
        newNode.setPrevious(getLast());

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
                DoubleDirectionNode followingNode = (DoubleDirectionNode) getNode(1);
                followingNode.setPrevious(null);
                setHead(followingNode);
            }
        } else if (index == size() - 1) {
            Node secondToLast = getNode(index);
            secondToLast.setNext(null);
            setLast(secondToLast);
        } else {
            DoubleDirectionNode followingNode = (DoubleDirectionNode) getNode(index + 1);
            getNode(index - 1).setNext(followingNode);
            followingNode.setPrevious(getNode(index - 1));
        }
    }

    @Override
    void adjustPointers(int index, Object o) {

        DoubleDirectionNode node = new DoubleDirectionNode(o);
        node.setNext(getNode(index));

        if (index == 0) {
            setHead(node);
        } else {
            node.setPrevious(getNode(index - 1));
            getNode(index-1).setNext(node);
        }
    }

}
