package com.fmjava.core.pojo.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeLong
 * @Date: 2022/01/09/11:14
 * @Description:
 */
@Getter@Setter
public class PageResult implements Serializable {
    private Long total; // 总记录数
    private List rows; // 当前页结果

    public PageResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
