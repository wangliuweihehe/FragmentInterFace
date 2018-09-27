package com.wlw.admin.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wlw.admin.myapplication.R;
import com.wlw.admin.myapplication.function.NoFunctionException;

public class HomeFragment extends BaseFragment {
    public static final String FUNCTION_NAME = HomeFragment.class.getName() + "NPNR";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_simple_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btn).setOnClickListener((v) -> {
            try {
                functionManager.invokeNoParamNoResult(FUNCTION_NAME);

            } catch (NoFunctionException e) {
                e.printStackTrace();
            }
        });
    }
}
