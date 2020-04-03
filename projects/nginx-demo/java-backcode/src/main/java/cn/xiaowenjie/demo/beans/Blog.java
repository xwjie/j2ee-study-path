package cn.xiaowenjie.demo.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 晓风轻
 */
@Data
@AllArgsConstructor
@ToString
public class Blog implements Serializable {

    private long id;

    private String title;

    private String body;
}
