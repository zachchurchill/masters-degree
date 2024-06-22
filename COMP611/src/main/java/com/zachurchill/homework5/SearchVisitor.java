package com.zachurchill.homework5;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements NodeVisitor {

    private ArrayList<String> foundNodes;
    private String searchStr;
    private String path;

    public SearchVisitor(String searchStr) {
        this.foundNodes = new ArrayList<>();
        this.searchStr = searchStr;
        this.path = "";
    }

    public List<String> getResult() {
        return foundNodes;
    }

    @Override
    public void preVisit(Node node) {
        this.path = String.format("%s/%s", this.path, node.getName());
        if (this.path.contains(this.searchStr)) {
          this.foundNodes.add(node.getName());
        }
    }

    @Override
    public void visit(Node node) {
    }

    @Override
    public void postVisit(Node node) {
        if (this.path.endsWith(node.getName())) {
            this.path = this.path.replace(String.format("/%s", node.getName()), "");
        }
    }
}
