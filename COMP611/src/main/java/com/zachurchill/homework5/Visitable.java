package com.zachurchill.homework5;

public interface Visitable<T>
{
    void accept(T visitor);
}
