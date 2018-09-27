package com.wlw.admin.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wlw.admin.myapplication.R;
import com.wlw.admin.myapplication.function.NoFunctionException;

public class MineFragment extends BaseFragment {
    public static final String FUNCTION_NAME = MineFragment.class.getName() + "WPAR";

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
                String s = functionManager.invokeWithParamAndResult(FUNCTION_NAME, 0, String.class);
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            } catch (NoFunctionException e) {
                e.printStackTrace();
            }
        });
    }
}
