package com.diaoxinqiang.bookapp.utils;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.diaoxinqiang.bookapp.activities.MainActivity;
import com.diaoxinqiang.bookapp.bean.Book;
import com.diaoxinqiang.bookapp.bean.BookCategory;
import com.diaoxinqiang.bookapp.bean.Books;
import com.diaoxinqiang.bookapp.bean.CategoryItem;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by Administrator on 2015/12/9.
 */
public class ConnectUtil {

    private Context context;
    private RequestQueue requestQueue;
    private static ConnectUtil instance;


    public static ConnectUtil getInstance(Context context) {
        if(instance==null){
            instance = new ConnectUtil(context);
        }
        return  instance;
    }
    private ConnectUtil(Context context) {
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);
    }

    public void connectTogetCategory(String url) {
//        ImageSpan
        JsonRequest jsonRequest =new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
               String result = response.toString();
                LogUtil.i(result);
                //解析json
                BookCategory category = JSON.parseObject(result, BookCategory.class);
                //将数据传给view层
                LogUtil.i(category.toString());
                List<CategoryItem> categoryItems = category.getResult();
                ((MainActivity)context).UpdateSideListView(categoryItems);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("connect", error.toString());
                //页面提示.
            }
        });
        requestQueue.add(jsonRequest);
    }

    public void connectToGetBooks(String url) {
        JsonRequest jsonRequest =new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String result = response.toString();
                LogUtil.i(result);
                //解析json
                Books books =JSON.parseObject(result,Books.class);
                LogUtil.i(books.toString());
               List<Book> bookList =books.getResult().getData();
                ((MainActivity)context).UpDateMainListView(bookList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("connect", error.toString());
                //页面提示.
            }
        });
        requestQueue.add(jsonRequest);
    }
}
