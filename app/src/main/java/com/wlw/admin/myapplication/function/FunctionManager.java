package com.wlw.admin.myapplication.function;

import android.text.TextUtils;
import android.util.Log;

import java.util.HashMap;

public class FunctionManager {
    private static FunctionManager functionManager;

    public static FunctionManager getInstance() {
        if (functionManager == null) {
            synchronized (FunctionManager.class) {
                if (functionManager == null) {
                    functionManager = new FunctionManager();
                }
            }
        }
        return functionManager;
    }

    private HashMap<String, FunctionNoParamNoResult> noParamNoResultHashMap;
    private HashMap<String, FunctionWithParamNoResult> withParamNoResultHashMap;
    private HashMap<String, FunctionNoParamWithResult> noParamWithResultHashMap;
    private HashMap<String, FunctionWithParamAndResult> withParamAndResultHashMap;

    private FunctionManager() {
        noParamNoResultHashMap = new HashMap<>();
        withParamNoResultHashMap = new HashMap<>();
        noParamWithResultHashMap = new HashMap<>();
        withParamAndResultHashMap = new HashMap<>();
    }

    public FunctionManager addNoParamNoResult(FunctionNoParamNoResult functionNoParamNoResult) {
        Log.e("FunctionManager",functionNoParamNoResult.getFunctionName());
        noParamNoResultHashMap.put(functionNoParamNoResult.getFunctionName(), functionNoParamNoResult);
        return this;
    }

    public FunctionManager addWithParamNoResult(FunctionWithParamNoResult functionWithParamNoResult) {
        withParamNoResultHashMap.put(functionWithParamNoResult.getFunctionName(), functionWithParamNoResult);
        return this;
    }

    public FunctionManager addNoParamWithResult(FunctionNoParamWithResult functionNoParamWithResult) {
        noParamWithResultHashMap.put(functionNoParamWithResult.getFunctionName(), functionNoParamWithResult);
        return this;
    }

    public FunctionManager addParamAndResult(FunctionWithParamAndResult functionWithParamAndResult) {
        withParamAndResultHashMap.put(functionWithParamAndResult.getFunctionName(), functionWithParamAndResult);
        return this;
    }

    public void invokeNoParamNoResult(String funName) throws NoFunctionException {
        if (TextUtils.isEmpty(funName))
            return;
        if (noParamNoResultHashMap != null) {
            FunctionNoParamNoResult functionNoParamNoResult = noParamNoResultHashMap.get(funName);
            if (functionNoParamNoResult != null)
                functionNoParamNoResult.function();
            else
                throw new NoFunctionException();
        }
    }

    public <Param> void invokeWithParamNoResult(String funName, Param param) throws NoFunctionException {
        if (TextUtils.isEmpty(funName))
            return;
        if (withParamNoResultHashMap != null) {
            FunctionWithParamNoResult functionWithParamNoResult = withParamNoResultHashMap.get(funName);
            if (functionWithParamNoResult != null)
                functionWithParamNoResult.function(param);
            else
                throw new NoFunctionException();
        }
    }

    public <Result> Result invokeNoParamWithResult(String funName, Class<Result> cls) throws NoFunctionException {
        if (TextUtils.isEmpty(funName))
            return null;
        if (noParamWithResultHashMap != null) {
            FunctionNoParamWithResult functionNoParamWithResult = noParamWithResultHashMap.get(funName);
            if (functionNoParamWithResult != null)
                if (cls != null) {
                    return cls.cast(functionNoParamWithResult.function());
                } else {
                    return ((Result) functionNoParamWithResult.function());
                }

            else
                throw new NoFunctionException();
        }
        return null;
    }

    public <Result, Param> Result invokeWithParamAndResult(String funName, Param param, Class<Result> cls) throws NoFunctionException {
        if (TextUtils.isEmpty(funName))
            return null;
        if (withParamAndResultHashMap != null) {
            FunctionWithParamAndResult functionWithParamAndResult = withParamAndResultHashMap.get(funName);
            if (functionWithParamAndResult != null)
                if (cls != null) {
                    return cls.cast(functionWithParamAndResult.function(param));
                } else {
                    return ((Result) functionWithParamAndResult.function(param));
                }
            else
                throw new NoFunctionException();
        }
        return null;
    }

}
