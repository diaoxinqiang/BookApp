package com.diaoxinqiang.bookapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2015/12/9.
 */
public class BookCategory {
    /**
     * resultcode : 200
     * reason : success
     * result : [{"id":"242","catalog":"中国文学"},{"id":"252","catalog":"人物传记"},{"id":"244","catalog":"儿童文学"},{"id":"248","catalog":"历史"},{"id":"257","catalog":"哲学"},{"id":"243","catalog":"外国文学"},{"id":"247","catalog":"小说"},{"id":"251","catalog":"心灵鸡汤"},{"id":"253","catalog":"心理学"},{"id":"250","catalog":"成功励志"},{"id":"249","catalog":"教育"},{"id":"245","catalog":"散文"},{"id":"256","catalog":"理财"},{"id":"254","catalog":"管理"},{"id":"246","catalog":"经典名著"},{"id":"255","catalog":"经济"},{"id":"258","catalog":"计算机"}]
     * error_code : 0
     */

    private String resultcode;
    private String reason;
    private int error_code;
    /**
     * id : 242
     * catalog : 中国文学
     */

    private List<CategoryItem> result;

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public void setResult(List<CategoryItem> result) {
        this.result = result;
    }

    public String getResultcode() {
        return resultcode;
    }

    public String getReason() {
        return reason;
    }

    public int getError_code() {
        return error_code;
    }

    public List<CategoryItem> getResult() {
        return result;
    }



    @Override
    public String toString() {
        return "BookCategory{" +
                "resultcode='" + resultcode + '\'' +
                ", reason='" + reason + '\'' +
                ", error_code=" + error_code +
                ", result=" + result +
                '}';
    }
}
