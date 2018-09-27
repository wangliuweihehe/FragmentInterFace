package com.wlw.admin.myapplication;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.wlw.admin.myapplication.fragment.ChatFragment;
import com.wlw.admin.myapplication.fragment.CompanyFragment;
import com.wlw.admin.myapplication.fragment.HomeFragment;
import com.wlw.admin.myapplication.fragment.MineFragment;
import com.wlw.admin.myapplication.function.FunctionManager;
import com.wlw.admin.myapplication.function.FunctionNoParamNoResult;
import com.wlw.admin.myapplication.function.FunctionNoParamWithResult;
import com.wlw.admin.myapplication.function.FunctionWithParamAndResult;
import com.wlw.admin.myapplication.function.FunctionWithParamNoResult;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    private ChatFragment chatFragment;
    private CompanyFragment companyFragment;
    private MineFragment mineFragment;
    public String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TAG = getClass().getSimpleName();
        initView();
        initFunctions();
    }

    private void initView() {
        showHomeFragment();
        bottomNavigationView = findViewById(R.id.design_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener((menuItem) -> {
            switch (menuItem.getItemId()) {
                case R.id.item_home:
                    showHomeFragment();
                    break;
                case R.id.item_chat:
                    showChatFragment();
                    break;
                case R.id.item_company:
                    showCompanyFragment();
                    break;
                case R.id.item_mine:
                    showMineFragment();
                    break;
            }
            return true;
        });
        initFunctions();
    }

    private void initFunctions() {
        FunctionManager functionManager = FunctionManager.getInstance();
        functionManager.addNoParamNoResult(new FunctionNoParamNoResult(HomeFragment.FUNCTION_NAME) {
            @Override
            public void function() {
                Toast.makeText(MainActivity.this, "HomeFragmentClicked", Toast.LENGTH_SHORT).show();
            }
        }).addWithParamNoResult(new FunctionWithParamNoResult<Integer>(ChatFragment.FUNCTION_NAME) {
            @Override
            public void function(Integer position) {
                changeSelectedTab(position);
            }
        }).addNoParamWithResult(new FunctionNoParamWithResult<String>(CompanyFragment.FUNCTION_NAME) {
            @Override
            public String function() {
                return "无参数有返回值";
            }
        }).addParamAndResult(new FunctionWithParamAndResult<String, Integer>(MineFragment.FUNCTION_NAME) {
            @Override
            public String function(Integer param) {
                changeSelectedTab(param);
                return "有参数有返回值";
            }
        });

    }

    private void changeSelectedTab(int position) {
        Menu menu = bottomNavigationView.getMenu();
        int itemId = menu.getItem(position).getItemId();
        bottomNavigationView.setSelectedItemId(itemId);
        switch (position) {
            case 0:
                showHomeFragment();
                break;
            case 1:
                showChatFragment();
                break;
            case 2:
                showCompanyFragment();
                break;
            case 3:
                showMineFragment();
                break;
        }
    }

    private void showHomeFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
            fragmentTransaction.add(R.id.fl_content, homeFragment).commit();
        } else {
            showFragment(fragmentTransaction, homeFragment);
        }

    }

    private void showChatFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (chatFragment == null) {
            chatFragment = new ChatFragment();
            fragmentTransaction.add(R.id.fl_content, chatFragment).commit();
        } else {
            showFragment(fragmentTransaction, chatFragment);
        }

    }

    private void showCompanyFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (companyFragment == null) {
            companyFragment = new CompanyFragment();
            fragmentTransaction.add(R.id.fl_content, companyFragment).commit();
        } else {
            showFragment(fragmentTransaction, companyFragment);
        }

    }

    private void showMineFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (mineFragment == null) {
            mineFragment = new MineFragment();
            fragmentTransaction.add(R.id.fl_content, mineFragment).commit();
        } else {
            showFragment(fragmentTransaction, mineFragment);
        }

    }

    private void showFragment(FragmentTransaction fragmentTransaction, Fragment fragment) {
        if (fragment != null) {
            hideFragment(fragmentTransaction);
            fragmentTransaction.show(fragment).commit();
        }
    }

    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if (homeFragment != null)
            fragmentTransaction.hide(homeFragment);
        if (chatFragment != null)
            fragmentTransaction.hide(chatFragment);
        if (companyFragment != null)
            fragmentTransaction.hide(companyFragment);
        if (mineFragment != null)
            fragmentTransaction.hide(mineFragment);

    }
}
