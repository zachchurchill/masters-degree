package com.zachurchill.homework6;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Heap {
    private ArrayList<Integer> data;
    private int childrenPerNode;

    public Heap(int childrenPerNode) {
        this.childrenPerNode = childrenPerNode;
        this.data = new ArrayList<Integer>();
    }
    
    public Heap(int childrenPerNode, ArrayList<Integer> startingData) {
        this.childrenPerNode = childrenPerNode;
        this.data = startingData;
    }

    //  Returns the index where a given node's parent is stored in the array
    //  This works for binary heaps, but you'll have to modify it to pass the
    //  test cases for heaps with more children per node.
    private int parentPosition(int childPosition) {
        return (childPosition - 1) / this.childrenPerNode;
    }

    //  Returns the index where a given child of a parent node is stored.
    //  childIndex is 0-based, so in a binary heap, it can be 0 or 1.
    //  This works for binary heaps, but you'll have to modify it to pass the
    //  test cases for heaps with more children per node.
    private int childPosition(int parentPosition, int childIndex) {
        return this.childrenPerNode * parentPosition + childIndex + 1;
    }

    public List<Integer> getData() {
        return data;
    }

    public void add(Integer val) {
        int childPos = this.data.size();
        this.data.add(val);        
        int parentPos = this.parentPosition(childPos);
        while (childPos != 0 && this.data.get(childPos) <= this.data.get(parentPos)) {
            Collections.swap(this.data, childPos, parentPos);
            childPos = parentPos;
            parentPos = this.parentPosition(childPos);
        }
    }

    public boolean isHeap() {
        for (int i = 0; i < this.data.size(); ++i) {
          if (!this.heapCondition(i)) {
            return false;
          }
        }
        return true;
    }

    private boolean heapCondition(int parentPos) {
        ArrayList<Boolean> comparisons = new ArrayList<>();
        int value = this.data.get(parentPos);
        for (int i = 0; i < this.childrenPerNode; ++i) {
            int childPos = this.childPosition(parentPos, i);
            if (childPos < this.data.size()) {
                comparisons.add(value <= this.data.get(childPos));
            }
        }
        return comparisons.size() > 0 ? Collections.min(comparisons) : true;
    }

    public Integer extractMin() {
        int minValue = this.data.get(0);
        if (this.data.size() == 1) {
          this.data.remove(0);
          return minValue;
        }

        this.data.set(0, this.data.remove(this.data.size() - 1));
        int parentPos = 0;
        while (!heapCondition(parentPos)) {
            int nextParentPos = this.childPosition(parentPos, 0);
            for (int i = 1; i < this.childrenPerNode; ++i) {
                int otherChildPos = this.childPosition(parentPos, i);
                if (otherChildPos < this.data.size() && this.data.get(otherChildPos) < this.data.get(nextParentPos)) {
                   nextParentPos = otherChildPos;
                }
            }
            Collections.swap(this.data, parentPos, nextParentPos);
            parentPos = nextParentPos;
        }
        return minValue;
    }

    public static void main(String[] args) {
        
    }
}
