package org.lanqiao.ssm.pojo;

import java.util.Set;

public class Dept {
    private Integer deptno;
    private String dname;
    private String loc;
    //表示当前部门的员工集合
    public Set<Emp> empSet;
    public Dept() {
    }

    public Dept(Integer deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public Dept(String dname, String loc) {
        this.dname = dname;
        this.loc = loc;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Set<Emp> getEmpSet() {
        return empSet;
    }

    public void setEmpSet(Set<Emp> empSet) {
        this.empSet = empSet;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                ", empSet=" + empSet +
                '}';
    }
}
