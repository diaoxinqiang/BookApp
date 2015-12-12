package com.diaoxinqiang.bookapp.activities;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.diaoxinqiang.bookapp.R;
import com.diaoxinqiang.bookapp.adapter.SideListAdapter;
import com.diaoxinqiang.bookapp.adapter.BookListAdapter;
import com.diaoxinqiang.bookapp.bean.Book;
import com.diaoxinqiang.bookapp.bean.CategoryItem;
import com.diaoxinqiang.bookapp.engine.BookCategoryEnigine;
import com.diaoxinqiang.bookapp.engine.BookEnigine;
import com.diaoxinqiang.bookapp.utils.LogUtil;
import com.diaoxinqiang.bookapp.view.ResideLayout;
import com.yalantis.phoenix.PullToRefreshView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EActivity(R.layout.activity_main)
public class MainActivity extends FragmentActivity {

    @ViewById(R.id.pull_to_refresh)
    PullToRefreshView mPullToRefreshView;
    @ViewById(R.id.menu)
    ListView menu;
    @ViewById(R.id.reside_layout)
    ResideLayout resideLayout;

    @ViewById(R.id.text_test)
    TextView tv_test;

    @ViewById(R.id.lv_books)
    ListView lv_books;
    private BookListAdapter bookListAdapter;



    private SideListAdapter sideListAdapter;
    private List<CategoryItem> categoryItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getCategory();

    }

    private void getCategory() {
        BookCategoryEnigine bookCategoryEnigine = new BookCategoryEnigine(this);
        bookCategoryEnigine.getBookCategory();
    }

    @UiThread
    public void UpdateSideListView(List<CategoryItem> categoryItems) {
        LogUtil.i("UpdateSideListView   " + categoryItems.toString());
        sideListAdapter = new SideListAdapter(categoryItems, this);
        menu.setAdapter(sideListAdapter);
        this.categoryItems = categoryItems;
    }

    @AfterViews
    public void initViews() {
//        mPullToRefreshView.setRefreshStyle(PullToRefreshView.MAX_OFFSET_ANIMATION_DURATION);
//        mPullToRefreshView.setRefreshStyle(PullToRefreshView.Sty);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshView.setRefreshing(false);

                    }
                }, 1000);
            }
        });
//        menu.setAdapter();
        menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取该目录下的id.联网获得图书列表.
                getBooksData(position);
                Toast.makeText(MainActivity.this, categoryItems.get(position).getCatalog(),
                        Toast.LENGTH_SHORT).show();

                resideLayout.closePane();
                mPullToRefreshView.setRefreshing(true);
            }
        });
    }

    private void getBooksData(int position) {
        BookEnigine bookEnigine = new BookEnigine(this);
        bookEnigine.getBook(categoryItems.get(position).getId(), 2, 10);
    }

    @UiThread
    public void UpDateMainListView(List<Book> bookList) {
//        tv_test.setText(bookList.toString());
        //设置listViewAdapter
        bookListAdapter  = new BookListAdapter(this,bookList);
        lv_books.setAdapter(bookListAdapter);
        mPullToRefreshView.setRefreshing(false);
    }
}
