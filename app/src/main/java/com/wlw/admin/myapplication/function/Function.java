package com.wlw.admin.myapplication.function;

public abstract class Function {
    private String functionName;

    Function(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionName() {
        return functionName;
    }
}
