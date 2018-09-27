package com.wlw.admin.myapplication.function;

public abstract class FunctionNoParamWithResult<Result> extends Function {
    protected FunctionNoParamWithResult(String functionName) {
        super(functionName);
    }
    public abstract Result function();
}
