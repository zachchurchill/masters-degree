package com.zachurchill.homework5;

public class Node implements Visitable<NodeVisitor>
{
    private String name;
    private Node leftChild;
    private Node rightChild;

    public Node(String name) {
        this.name = name;
    }

    public Node(String name, Node left, Node right) {
        this(name);
        leftChild = left;
        rightChild = right;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(NodeVisitor visitor)
    {
        visitor.preVisit(this);

        if (leftChild != null) {
            leftChild.accept(visitor);
        }

        visitor.visit(this);

        if (rightChild != null) {
            rightChild.accept(visitor);
        }

        visitor.postVisit(this);
    }
}
