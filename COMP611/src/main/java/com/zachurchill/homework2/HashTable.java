package com.zachurchill.homework2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable<E> {
    private List<List<E>> table;

    /**
     * Creates a HashTable with an initial size of ten.
     */
    public HashTable() {
        table = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            table.add(new LinkedList<>());
        }
    }

    /**
     * Adds an object to the HashTable.
     *
     * @return true if it was added, false if it was already present.
     */
    public boolean put(E elem) {
      int slotIndex = elem.hashCode() % 10;
      List<E> chain = this.table.get(slotIndex);
      if (chain.contains(elem)) {
        return false;
      }
      return chain.add(elem);
    }

    /**
     * For testing.
     */
    public List<E> getChain(int index) {
        return table.get(index);
    }

    public static void main(String[] args) {
    }
}
