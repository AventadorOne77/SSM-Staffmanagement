package org.lanqiao.ssm.pojo;

import java.util.Date;

public class Emp {
    private  Integer empno;
    private  String ename;
    private String job;
    private Date hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;
    private Dept dept;

    public Emp() {
    }

    public Emp(String ename, String job, Date hiredate, Double sal) {
        this.ename = ename;
        this.job = job;
        this.hiredate = hiredate;
        this.sal = sal;
    }

    public Emp(Integer empno, String ename, String job, Date hiredate, Double sal) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.hiredate = hiredate;
        this.sal = sal;
    }

    public Emp(Integer empno, String ename, String job, Date hiredate, Double sal, Double comm, Integer deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    public Emp(String ename, String job, Date hiredate, Double sal, Double comm, Integer deptno) {
        this.ename = ename;
        this.job = job;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Double getComm() {
        return comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptno=" + deptno +
                ", dept=" + dept +
                '}';
    }
}
