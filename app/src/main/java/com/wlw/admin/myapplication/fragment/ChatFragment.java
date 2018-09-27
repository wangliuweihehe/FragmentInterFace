package com.wlw.admin.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.wlw.admin.myapplication.R;
import com.wlw.admin.myapplication.function.FunctionNoParamNoResult;
import com.wlw.admin.myapplication.function.NoFunctionException;

public class ChatFragment extends BaseFragment {
    public static final String FUNCTION_NAME = ChatFragment.class.getName() + "WPNR";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_simple_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.btn);
        button.setOnClickListener((v) -> {
                    try {
                        functionManager.invokeWithParamNoResult(FUNCTION_NAME, 2);
                    } catch (NoFunctionException e) {
                        e.printStackTrace();
                    }
                });
    }
}
