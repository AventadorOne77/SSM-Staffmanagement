package org.lanqiao.ssm.pojo;
public class Condition {
    private int deptno;
    private int empno;
    private String ename;
    private int currentPage;
    private int pageSize;

    public Condition() {

    }

    public Condition(String ename) {
        this.ename = ename;
    }

    public Condition(String ename, int currentPage, int pageSize) {
        this.ename = ename;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public Condition(int deptno, int empno, String ename, int currentPage, int pageSize) {
        this.deptno = deptno;
        this.empno = empno;
        this.ename = ename;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public Condition(int empno, String ename, int currentPage, int pageSize) {
        this.empno = empno;
        this.ename = ename;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public Condition(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String geteName() {
        return ename;
    }

    public void seteName(String ename) {
        this.ename = ename;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "deptno=" + deptno +
                ", empno=" + empno +
                ", ename='" + ename + '\'' +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
