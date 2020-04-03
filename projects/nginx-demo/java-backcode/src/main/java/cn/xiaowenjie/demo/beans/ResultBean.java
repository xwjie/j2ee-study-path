package cn.xiaowenjie.demo.beans;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * @author 晓风轻
 * @param <T>
 */
@Data
public class ResultBean<T> implements Serializable {
    private T data;

    private int code;

    private String msg;

    public ResultBean(){

    }

    public ResultBean(T data){
        this.data = data;
    }
}
