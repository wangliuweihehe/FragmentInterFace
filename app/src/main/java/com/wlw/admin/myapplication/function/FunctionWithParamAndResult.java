package com.wlw.admin.myapplication.function;

public abstract class FunctionWithParamAndResult<Result, Param> extends Function {
    public FunctionWithParamAndResult(String functionName) {
        super(functionName);
    }

    public abstract Result function(Param param);
}
