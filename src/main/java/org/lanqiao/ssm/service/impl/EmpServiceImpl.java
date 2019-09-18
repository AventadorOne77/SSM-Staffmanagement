package org.lanqiao.ssm.service.impl;

import org.lanqiao.ssm.mapper.EmpMapper;
import org.lanqiao.ssm.pojo.Condition;
import org.lanqiao.ssm.pojo.Emp;
import org.lanqiao.ssm.pojo.job;
import org.lanqiao.ssm.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements IEmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public Emp findEmpById(Integer empno) {
        Emp emp = empMapper.selectEmpById(empno);
        return emp;
    }

    @Override
    public List<Emp> getEmpByName(Condition condition) {
        return empMapper.findByName(condition);
    }

    @Override
    public List<Emp> getEmpByNone(Condition condition) {
        return empMapper.findByNone(condition);
    }

    @Override
    public List<Emp> getAll() {
        List<Emp> empList = empMapper.selectEmpList();
        for(Emp emp : empList){
            System.out.println("emp=================="+emp);
        }
        return  empList;
    }

    @Override
    public void remove(Integer empno) {
        empMapper.deleteEmp(empno);
    }

    @Override
    public void addEmp(Emp emp) {
        empMapper.insertEmp(emp);
    }

    @Override
    public List<job> jobList() {
        return empMapper.findAllJob();
    }

    @Override
    public void modifyEmp(Emp emp) {
        empMapper.updatePerson(emp);
    }

    @Override
    public long totalRecord() {
        return empMapper.getEmpTotalNum();
    }



    @Override
    public int coutName(Condition condition) {
        return empMapper.nameCount(condition);
    }
}
