package com.wlw.admin.myapplication.function;

public abstract class FunctionWithParamNoResult<Param> extends Function {

    protected FunctionWithParamNoResult(String functionName) {
        super(functionName);
    }
    public abstract void function(Param param);
}
