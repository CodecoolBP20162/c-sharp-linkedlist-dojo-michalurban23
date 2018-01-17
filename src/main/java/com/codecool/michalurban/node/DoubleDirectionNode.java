package com.codecool.michalurban.node;

public class DoubleDirectionNode extends Node {

    private Node previous;

    public DoubleDirectionNode() {

    }

    public DoubleDirectionNode(Object data) {

        super(data);
    }

    public DoubleDirectionNode(Object data, Node previous) {

        super(data);
        this.previous = previous;
    }

    public DoubleDirectionNode(Object data, Node next, Node previous) {

        super(data, next);
        this.previous = previous;
    }

    public Node getPrevious() {

        return previous;
    }

    public void setPrevious(Node previous) {

        this.previous = previous;
    }
}
