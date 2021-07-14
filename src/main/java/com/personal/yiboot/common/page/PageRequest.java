package com.personal.yiboot.common.page;


import com.personal.yiboot.constant.NumberConsts;

/**
 * 分页请求对象
 */
public class PageRequest {
    /**
     * 每页显示条数
     */
    private Integer pageSize = 10;
    /**
     * 当前页码
     */
    private Integer pageIndex = 1;
    /**
     * 分页查询 是否查询count值 true-是,false-否
     */
    private Boolean countSql;

    public PageRequest() {
    }

    public PageRequest(Integer pageIndex, Integer pageSize) {
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Boolean getCountSql() {
        return countSql;
    }

    public void setCountSql(Boolean countSql) {
        this.countSql = countSql;
    }

    /**
     * (+) count查询
     * (-) 分页列表查询
     * 返回对象 Page
     */
    public void onlyCount() {
        this.pageSize = NumberConsts.NEGATIVE_ONE;
    }

    /**
     * (-) count查询
     * (+) 分页列表查询
     * 返回对象 Page
     */
    public void cancelCount() {
        this.countSql = false;
    }

    /**
     * (+) count查询
     * (+) 非分页列表查询
     * 返回对象 Page
     */
    public void queryAll() {
        this.pageIndex = NumberConsts.ONE;
        this.pageSize = NumberConsts.ZERO;
    }

    /**
     * 计算跳过行数
     *
     * @return
     */
    public int skip() {
        return (pageIndex - 1) * pageSize;
    }
}
