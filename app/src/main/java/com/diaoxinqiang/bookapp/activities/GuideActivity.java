package com.diaoxinqiang.bookapp.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.diaoxinqiang.bookapp.Fragment.RippleFragment;
import com.diaoxinqiang.bookapp.R;
import com.diaoxinqiang.bookapp.utils.LogUtil;
import com.diaoxinqiang.bookapp.view.ColorAnimationView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.ViewById;

@Fullscreen
@EActivity(R.layout.activity_guide)
public class GuideActivity extends FragmentActivity {
    private static final int[] resource = new int[]{R.drawable.welcome1, R.drawable.welcome4,
            R.drawable.welcome3, R.drawable.welcome4};
    private static final String TAG = MainActivity.class.getSimpleName();

    @ViewById(R.id.ColorAnimationView)
    ColorAnimationView colorAnimationView;

    @ViewById(R.id.viewPager)
    ViewPager viewPager;

    @ViewById(R.id.rl_root)
    RelativeLayout rl_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    //    @UiThread
//    public void testURl() {
//        BookCategoryEnigine bookCategoryEnigine = new BookCategoryEnigine(this);
//        bookCategoryEnigine.getBookCategory();
//    }
    @AfterViews
    public void initViewPager() {
        //        setContentView(R.layout.activity_main);
        MyFragmentStatePager adpter = new MyFragmentStatePager(getSupportFragmentManager());
//        ColorAnimationView colorAnimationView = (ColorAnimationView) findViewById(R.id.ColorAnimationView);
//        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(adpter);
        /**
         *  首先，你必须在 设置 Viewpager的 adapter 之后在调用这个方法
         *  第二点，setmViewPager(ViewPager mViewPager,Object obj, int count, int... colors)
         *         第一个参数 是 你需要传人的 viewpager
         *         第二个参数 是 一个实现了ColorAnimationView.OnPageChangeListener接口的Object,用来实现回调
         *         第三个参数 是 viewpager 的 孩子数量
         *         第四个参数 int... colors ，你需要设置的颜色变化值~~ 如何你传人 空，那么触发默认设置的颜色动画
         * */
        /**
         *  Frist: You need call this method after you set the Viewpager adpter;
         * Second: setmViewPager(ViewPager mViewPager,Object obj， int count, int... colors)
         *          so,you can set any length colors to make the animation more cool!
         * Third: If you call this method like below, make the colors no data, it will create
         *          a change color by default.
         * */
        colorAnimationView.setmViewPager(viewPager, resource.length);
        colorAnimationView.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("TAG", "onPageScrolled");
            }

            @Override
            public void onPageSelected(int position) {
                Log.e("TAG", "onPageSelected");
                if (position == 3) {
                    showNextGuideView();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e("TAG", "onPageScrollStateChanged");
            }
        });
        // Four : Also ,you can call this method like this:
        // colorAnimationView.setmViewPager(viewPager,this,resource.length,0xffFF8080,0xff8080FF,0xffffffff,0xff80ff80);
    }

    private void showNextGuideView() {
        GuideActivity.this.rl_root.removeAllViews();
//        LogUtil.i("work");
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        RippleLinearLayout rippleLinearLayout = new RippleLinearLayout(GuideActivity.this);
//        rippleLinearLayout.setBackgroundColor(Color.TRANSPARENT);
//        rippleLinearLayout.setLayoutParams(params);
//
//        LinearLayout.LayoutParams params1 =new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        FlatTextView textview =new FlatTextView(GuideActivity.this);
//        textview.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                LogUtil.i("xxx");
//                Intent intent = new Intent(GuideActivity.this, TestActivity.class);
//                startActivity(intent);
//                return false;
//            }
//        });
//        params1.gravity = Gravity.CENTER;
//        textview.setGravity(Gravity.CENTER);
//        textview.setLayoutParams(params);
//        textview.setText("立即体验");
//        textview.setTextSize(DisplayUtils.dp2px(GuideActivity.this,25));
//        rippleLinearLayout.addView(textview);
//
//        rl_root.addView(rippleLinearLayout);
        RippleFragment rippleFragment = new RippleFragment();
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.rl_root,rippleFragment);
        transaction.show(rippleFragment);
        transaction.commit();

        LogUtil.i("work");
    }

    public class MyFragmentStatePager
            extends FragmentStatePagerAdapter {

        public MyFragmentStatePager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new MyFragment(position);
        }

        @Override
        public int getCount() {
            return resource.length;
        }
    }

    @SuppressLint("ValidFragment")
    public class MyFragment
            extends Fragment {
        private int position;

        public MyFragment(int position) {
            this.position = position;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            ImageView imageView = new ImageView(getActivity());

            imageView.setImageResource(resource[position]);

            return imageView;
        }
    }
}
