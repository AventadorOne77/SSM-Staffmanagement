package org.lanqiao.ssm.controller;

import com.alibaba.fastjson.JSON;
import org.lanqiao.ssm.pojo.Condition;
import org.lanqiao.ssm.pojo.Emp;
import org.lanqiao.ssm.pojo.job;
import org.lanqiao.ssm.service.IEmpService;
import org.lanqiao.ssm.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmpController {
    @Autowired
    IEmpService empService;

    @RequestMapping("/findPage.do")
    public String startPage(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("utf-8");
        int pageNum = 1;
        int pageSize = 5;
        String currentPage = req.getParameter("currentPage");//获取当前页
        String name1 = req.getParameter("serEname");//获取搜索框内容
        String method = req.getParameter("method");//获取方法

        //当获取的方法不为空时，进行删除||回显和修改操作
        if (!StringUtils.isEmpty(method)) {
            if (method.equals("deleteEmp")) {
                this.removeEmp(req, resp);
            } else if (method.equals("reLook")) {
                System.out.println("12121222222222222222222");
                this.getEmp(req, resp);
            }
        }
        //当前页是null 则证明开始打开界面
        if (!StringUtils.isEmpty(currentPage)) {
            pageNum = Integer.parseInt(currentPage);
        }
        System.out.println(pageNum + method);
        Condition condition = new Condition();
        //当搜索框的值不为空时，condition.seteName
        if (!StringUtils.isEmpty(name1)) {
            condition.seteName(name1.toString());
        } else {
            name1 = "";
        }
        int num = empService.coutName(new Condition(name1));
        PageModel pageModel = new PageModel(pageNum, num, pageSize);
        //    从哪条开始
        condition.setCurrentPage(pageModel.getStartIndex());
        //    显示几条数据
        condition.setPageSize(pageSize);
        List<Emp> empList = empService.getEmpByName(condition);
        req.setAttribute("currentPageNum", pageNum);
        req.setAttribute("empList", empList);
        req.setAttribute("name1", name1);
        req.setAttribute("pm", pageModel);
        return "emplist";
    }


    public void removeEmp(HttpServletRequest req, HttpServletResponse resp) {
        String empno = req.getParameter("empno");//获取empno
        //如果empno不为空，则删除；否则返回emplist.jsp
        if (!StringUtils.isEmpty(empno)) {
            int no = Integer.parseInt(empno);
            empService.remove(no);
        } else {
            try {
                resp.sendRedirect("emplist");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //    模态框回显
    @RequestMapping("/reLook.do")
    public void getEmp(HttpServletRequest req, HttpServletResponse resp) {
        String empno = req.getParameter("empno");
        resp.setContentType("text/json");
        PrintWriter out = null;
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //如果empno不为空 则将进行回显
        if (!StringUtils.isEmpty(empno)) {
            int no = Integer.parseInt(empno);
            Emp emp = empService.findEmpById(no);//根据ID查员工信息
            //创建一个MAP对象
            Map<String, Object> returnMap = new HashMap<>();
            //将要传递给前端模态框的值都放在map
            returnMap.put("emp", emp);
            System.out.println(emp);
            String mapStr = JSON.toJSONString(returnMap);
            System.out.println(mapStr);
            out.print(mapStr);
        }
    }

    //获取所有职位
    @RequestMapping("/job.do")
    public void jobList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out =resp.getWriter();
        List<job> jobs = empService.jobList();
        System.out.println(jobs);
        String jobStr = JSON.toJSONString(jobs);
        out.print(jobStr);

    }
}
