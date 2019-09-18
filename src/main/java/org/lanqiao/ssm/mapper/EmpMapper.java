package org.lanqiao.ssm.mapper;

import org.lanqiao.ssm.pojo.Condition;
import org.lanqiao.ssm.pojo.Emp;
import org.lanqiao.ssm.pojo.job;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmpMapper {
    public Emp selectEmpById(Integer emono);
    public List<Emp> findByName(Condition condition);
    public List<Emp> findByNone(Condition condition);
    public List<Emp> selectEmpList();
    public void deleteEmp(Integer empno);
    public void insertEmp(Emp emp);
    public List<job> findAllJob();
    public void updatePerson(Emp emp);
    public Long getEmpTotalNum();
    public int nameCount(Condition condition);
}