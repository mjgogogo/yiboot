package com.personal.yiboot.common.page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页请求对象
 */
public class PageResult<T> implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 5502307232891992272L;

    /**
     * 当前页号
     */
    private int pageIndex = 1;

    /**
     * 每页显示条数
     */
    private int pageSize = 10;

    /**
     * 总条数
     */
    private long total;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 返回结果集
     */
    private List<T> list;

    /**
     * 空构造方法
     */
    public PageResult() {
    }

    /**
     * 默认构造方法
     *
     * @param pageIndex  当前页码
     * @param totalCount 数据库中总记录条数
     * @param pageSize   本页容量
     * @param list       本页包含的数据
     */
    public PageResult(List<T> list, long totalCount, int pageIndex, int pageSize, int pages) {
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        this.total = totalCount;
        this.pages = pages;
        this.list = list;
    }

    /**
     * 构造方法
     *
     * @param totalCount totalCount
     * @param list       list
     */
    public PageResult(List<T> list, long totalCount) {
        this.list = list;
        this.total = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex + 1;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
