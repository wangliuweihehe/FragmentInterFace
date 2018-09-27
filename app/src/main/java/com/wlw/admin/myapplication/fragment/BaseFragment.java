package com.wlw.admin.myapplication.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.wlw.admin.myapplication.function.FunctionManager;

public class BaseFragment extends Fragment {
    protected FunctionManager functionManager;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        functionManager = FunctionManager.getInstance();
    }
}
