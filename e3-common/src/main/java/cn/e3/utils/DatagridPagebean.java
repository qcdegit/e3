package cn.e3.utils;

import java.io.Serializable;
import java.util.List;

public class DatagridPagebean<T> implements Serializable {
    //总记录数
    private Long total;
    //查询结果数据
    private List<T> rows;
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    public List<T> getRows() {
        return rows;
    }
    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    
}
