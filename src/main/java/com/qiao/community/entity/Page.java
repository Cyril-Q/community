package com.qiao.community.entity;

/**
 * 封装分页相关的信息
 * @author apple
 * @create 2021-08-04 下午5:13
 */
public class Page {
    //当前页码
    private Integer current = 1;
    //显示上限
    private Integer limit = 10;
    //数据总数（用于计算总页数）
    private Integer rows;
    //查询路径（用于复用分页链接）
    private String path;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        if (current >= 1 && current <= Math.ceil(rows / (limit * 1.0))) {
            this.current = current;
        }
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        if (rows >= 0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //获取当前页的起始行
    public Integer getOffset() {
        return (current - 1) * limit;
    }

    //获取总页数
    public Integer getTotal(){
        if (rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }


    //获取起始页码
    public Integer getFrom(){
        Integer from = current - 2;
        if (current + 2 > getTotal()) {
            return (getTotal() - 4) < 1 ? 1 : (getTotal() - 4);
        }
        return from < 1 ? 1 : from;
    }

    //获取结束页码
    public Integer getTo() {
        Integer to = current + 2;
        Integer total = getTotal();
        if (getFrom() == 1) {
            return 5 > total ? total : 5;
        }
        return to > total ? total : to;
    }
}
