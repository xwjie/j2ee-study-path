package cn.xiaowenjie.blogdemo.util;

import cn.xiaowenjie.blogdemo.beans.Blog;
import cn.xiaowenjie.blogdemo.exceptions.CheckException;

public class Check {

    private Check(){

    }

    public static void check(boolean condition, String message, Object... param){
        if(!condition) {
            throw new CheckException(String.format(message, param));
        }
    }

    public static void notEmpty(String value){
        if(value == null || value.trim().length() == 0) {
            throw new CheckException("param is empty");
        }
    }

    public static void notNull(Object value) {
        if(value == null ) {
            throw new CheckException("param is null");
        }
    }
}
