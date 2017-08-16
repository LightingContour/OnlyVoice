package com.lightingcontour.onlyvoice;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class GuideActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private NavigationView navigationView;
    private View navigationHeadView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏导航栏.
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_guide);

        //设置沉浸式任务栏.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(Color.TRANSPARENT);
                getWindow()
                        .getDecorView()
                        .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            } else {
                getWindow()
                        .setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }

        init();
    }


    /**
     * 用于初始化ViewPager,TabLayout,NavigationView
     *
     * */
    private void init()
    {
        viewPager = (ViewPager)findViewById(R.id.guidePager);
        tabLayout = (TabLayout)findViewById(R.id.GuideTab);
        GuideFragmentAdapter adapter = new GuideFragmentAdapter(getSupportFragmentManager());

        viewPager.setOffscreenPageLimit(3);
        viewPager.setPageMargin(60);
        //viewPager添加parallax效果
        viewPager.setPageTransformer(false,new CustPagerTransformer(this));

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        //解决图片变灰问题.
        navigationView = (NavigationView)findViewById(R.id.navigation);
        navigationView.setItemIconTintList(null);

        //绑定头部View,为其设置点击监听.
        navigationHeadView = navigationView.getHeaderView(0);
        navigationHeadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GuideActivity.this, "点击了navigationHeadView", Toast.LENGTH_SHORT).show();
            }
        });

        //设置Item的点击监听.
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_camera:
                        break;
                }
                return false;
            }
        });
    }

    //设置FragmentPager适配器
    public class GuideFragmentAdapter extends FragmentPagerAdapter {

        public GuideFragmentAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int positon)
        {
            switch (positon)
            {
                case 0:
                    return new MessageFragment();
                case 1:
                    return new FriendFragment();
                case 2:
                    return new SearchFragment();
            }
            return null;
            /*//原版使用GuideFragment,现分别使用.
            //每次回调getItem方法时新建一个Fragment
            GuideFragment fragment = new GuideFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(GuideFragment.ARG_OBJECT,positon + 1);
            fragment.setArguments(bundle);
            return fragment;*/
        }

        @Override
        public int getCount()
        {
            return 3;//封装三个Fragment
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            //返回该Fragment对应的Title,tabLayout使用.
            switch (position)
            {
                case 0:
                    return "Message";
                case 1:
                    return "Friends";
                case 2:
                    return "Search";
                default:
                    return "SECTION NOT FIND";
            }
        }
    }
}
