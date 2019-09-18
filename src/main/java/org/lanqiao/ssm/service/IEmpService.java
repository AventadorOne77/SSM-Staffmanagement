package org.lanqiao.ssm.service;

import org.lanqiao.ssm.pojo.Condition;
import org.lanqiao.ssm.pojo.Emp;
import org.lanqiao.ssm.pojo.job;

import java.util.List;

public interface IEmpService {
    public Emp findEmpById(Integer empno);
    public List<Emp> getEmpByName(Condition condition);
    public List<Emp> getEmpByNone(Condition condition);
    public List<Emp> getAll();
    public void remove(Integer empno);
    public void addEmp(Emp emp);
    public List<job> jobList();
    public void modifyEmp(Emp emp);
    public long totalRecord();
//    从第几条开始，看几个
    public int coutName(Condition condition);
}
