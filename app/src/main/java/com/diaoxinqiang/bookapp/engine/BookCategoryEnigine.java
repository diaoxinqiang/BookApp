package com.diaoxinqiang.bookapp.engine;

import android.content.Context;
import android.util.Log;

import com.diaoxinqiang.bookapp.utils.ConnectUtil;
import com.diaoxinqiang.bookapp.utils.Constant;
import com.diaoxinqiang.bookapp.utils.UrlUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/12/10.
 */
public class BookCategoryEnigine {
    private Context context;

    public BookCategoryEnigine(Context context) {
        this.context = context;
    }
    public   void getBookCategory(){

        String url =Constant.CATEGORYURL;//请求接口地址
        Map<String, Object> params = new HashMap<String, Object>();//请求参数
        params.put("key",Constant.KEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","json");//返回数据的格式,xml或json，默认json
        url = url+"?"+ UrlUtil.urlencode(params);
        Log.i("BookCategoryEnigine",url);
        ConnectUtil.getInstance(context).connectTogetCategory(url);

    }

}
