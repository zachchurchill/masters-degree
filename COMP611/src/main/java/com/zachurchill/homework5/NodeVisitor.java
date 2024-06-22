package com.zachurchill.homework5;

public interface NodeVisitor
{
    public void preVisit(Node expr);
    public void visit(Node expr);
    public void postVisit(Node expr);
}
