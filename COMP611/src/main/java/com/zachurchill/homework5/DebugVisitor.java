package com.zachurchill.homework5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class DebugVisitor implements Visitor {

    private List<String> debugOutput;
    private Map<Operation, String> operationExpressions;
    
    public DebugVisitor() {
        this.debugOutput = new ArrayList<>();
        this.operationExpressions = new HashMap<>();
        this.operationExpressions.put(Operation.ADD, "AddExpression");
        this.operationExpressions.put(Operation.SUBTRACT, "SubtractExpression");
        this.operationExpressions.put(Operation.MULTIPLY, "MultiplyExpression");
        this.operationExpressions.put(Operation.DIVIDE, "DivideExpression");
    }

    public List<String> getResult() {
        return this.debugOutput;
    }

    @Override
    public void preVisit(BinaryExpression expr) {
        this.debugOutput.add(String.format("preVisit %s", this.operationExpressions.get(expr.getOperation())));
    }

    @Override
    public void visit(BinaryExpression expr) {
        this.debugOutput.add(String.format("visit %s", this.operationExpressions.get(expr.getOperation())));
    }

    @Override
    public void postVisit(BinaryExpression expr) {
        this.debugOutput.add(String.format("postVisit %s", this.operationExpressions.get(expr.getOperation())));
    }

    @Override
    public void visit(ConstantExpression expr) {
        this.debugOutput.add(String.format("visit ConstantExpression %d", expr.getValue()));
    }
}
