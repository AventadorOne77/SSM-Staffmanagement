<%@ page import="org.lanqiao.ssm.utils.PageModel" %>
<%@ page import="org.lanqiao.ssm.pojo.Emp" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: huwei
  Date: 2018-12-29
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>列表</title>
    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap-datetimepicker.css">
    <script type="text/javascript" src="/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="/js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#job option").remove();
            $("#serjob").append("<option></option>")
            $.ajax({
                url: "/job.do",

            });
            //添加
            $("#add").click(function () {
                $("#job option").remove();
                $.ajax({
                    url: "/job.do",
                    success: function (data) {
                        var jobList = eval(data);
                        $.each(jobList, function (index, obj) {
                            var job = eval(obj);
                            $("#job").append("<option value=" + job.jname + ">" + job.jname + "</option>")
                        })
                        $('#addModal').modal({
                            show: true//模态框显示
                        })
                    }
                })
            })


            $(".update").click(function () {
                var empno = $(this).parent().parent().children('td:eq(0)').text();
                $.ajax({
                    url: "/reLook.do",
                    data: {"empno": empno},
                    success: function (data) {
                        //处理ajax返回的map类型的eison字符串
                        $.each(data, function (name, value) {
                            if (name == "emp") {//name是map的键，value值是map的值
                                var emp = eval(value)
                                alert(emp.job)
                                $("#empno").val(emp.empno);
                                $("#ename").val(emp.ename);
                                $("#hiredate").val(new Date(emp.hiredate).toLocaleDateString().replace(/\//g, '-'));
                                $("#job").val(emp.job);
                                $("#sal").val(emp.sal);
                            } else if (name == "currentPageNum") {
                                //给模态框的隐藏域设置当前页数
                                $("#updatecurrentPageNum").val(value);
                            }
                        });
                        $('#addModal').modal({
                            show: true//模态框显示
                        });
                    }
                })

            })


            //通过js提交
            $("#save").click(function () {
                $("#addForm").submit();
            })
            //引入时间控件
            $('.form_datetime').datetimepicker({
                format: 'yyyy-mm-dd',
                language: "zh-CN",
                minView: "month",
                autoclose: true,
                todayBtn: true
            });
        })

    </script>
</head>
<body>
<center>
    <button type="button" id="add" class="btn btn-info">添加员工</button>
</center>
<br>
<form action="/findPage.do" method="post">
    <div class="form-group">
    <label class="control-label">姓名</label>
    <div>
        <div class="input-group  col-xs-11" style="float:left;">

            <input type="text" class="form-control " name="serEname" placeholder="请输入查询姓名"
                   value="<%=request.getAttribute("name1")%>">
        </div>
        <div class="col-xs-1">
            <button type="submit" value="搜索" style="font-size: 20px ;background-color: deepskyblue"> 搜 索<span
                    class=" glyphicon glyphicon-search " style="float:left; font-size: 28px;"><i
                    class="icon-th"></i></span></button>
        </div>
    </div>

    </div><br>

</form>
<input type="hidden" id="currentPageNum" name="currentPageNum" value="<%=request.getAttribute("currentPageNum")%>">
<h1>员工信息</h1>
<table class="table table-hover">
    <thead>
    <th>工号</th>
    <th>姓名</th>
    <th>职位</th>
    <th>入职时间</th>
    <th>薪资</th>
    <th colspan="2">操作</th>
    </thead>
    <tbody>
    <%
        PageModel pm = (PageModel) request.getAttribute("pm");
        List<Emp> empList = (List<Emp>) request.getAttribute("empList");
    %>
    <c:forEach begin="0" items="<%=empList%>" var="emp">
        <tr>
            <td>${emp.empno}</td>
            <td>${emp.ename}</td>
            <td>${emp.job}</td>
            <td><fmt:formatDate value='${emp.hiredate}' pattern='yyyy-MM-dd'/></td>
            <td>${emp.sal}</td>
            <td>
                <a href="/findPage.do?method=deleteEmp&empno=${emp.empno}&currentPage=<%=request.getAttribute("currentPageNum")%>&serEname=<%=request.getAttribute("name1")%>"><span
                        style="float:left; font-size: large">删除</span></a></td>
            <td><a class="update"><span style="float:left; font-size: large">修改</span></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="modal fade" tabindex="-1" id="addModal" role="dialog" aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="gridSystemModalLabel">新增</h4>
            </div>
            <div class="modal-body">
                <form role="form" id="addForm"
                      action="/findPage.do?method=addUpdate&currentPage=<%=request.getAttribute("currentPageNum")%>"
                      method="POST">
                    <input type="hidden" id="updatecurrentPageNum" value="<%=request.getAttribute("currentPageNum")%>">
                    <div class="form-group" style="display: none">
                        <label for="empno" class="control-label">员工编号:</label>
                        <input type="text" class="form-control" id="empno" name="empno">
                    </div>
                    <div class="form-group">
                        <label for="ename" class="control-label">员工姓名:</label>
                        <input type="text" class="form-control" id="ename" name="ename">
                    </div>

                    <div class="form-group">
                        <label for="job" class="control-label">员工职位:</label>
                        <select class="form-control" id="job" name="job">
                        </select>
                    </div>

                    <div class="form-group input-append date form_datetime ">
                        <div>
                            <label for="hiredate" class="control-label">入职时间:</label>
                        </div>

                        <div>
                            <div class="input-group  col-xs-11" style="float:left;">
                                <input type="text" class="form-control" id="hiredate" name="hiredate" value="" readonly>
                            </div>
                            <div class="col-xs-1">
                                <span class="add-on glyphicon glyphicon-calendar" style="font-size: x-large"><i
                                        class="icon-th"></i></span>
                            </div>
                        </div>
                    </div>
                    <br>


                    <div class="form-group">
                        <label for="sal" class="control-label">薪资:</label>
                        <div class="input-group">
                            <div class="input-group-addon">$</div>
                            <input type="text" class="form-control" id="sal" name="sal">
                            <div class="input-group-addon">.00</div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="save" class="btn btn-primary">提交</button>
            </div>
        </div>

    </div><!-- /.modal-content -->
</div>
<nav aria-label="Page navigation" style="float: right">
    <ul class="pagination">
        <li class="previous"><a
                href="/findPage.do?currentPage=<%=pm.getStartPage()%>&serEname=<%=request.getAttribute("name1")%>"><span
                aria-hidden="true">&larr;</span> 首页</a></li>
        <li>
            <a href="/findPage.do?currentPage=<%=pm.getPrePageNum()%>&serEname=<%=request.getAttribute("name1")%>"
               aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <%
            int pageNum = pm.getTotalPageNum();
            for (int num = 1; num <= pageNum; num++) {
        %>
        <li><a href="/findPage.do?currentPage=<%=num%>&serEname=<%=request.getAttribute("name1")%>"><%=num%>
        </a></li>
        <%
            }
        %>

        <li>
            <a href="/findPage.do?currentPage=<%=pm.getNextPageNum()%>&serEname=<%=request.getAttribute("name1")%>"
               aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>

        <li class="next"><a
                href="/findPage.do?currentPage=<%=pm.getEndPage()%>&serEname=<%=request.getAttribute("name1")%>">末尾页<span
                aria-hidden="true">&rarr;</span></a></li>
    </ul>
</nav>
<h2><a href="/findPage.do">123456789</a></h2>
</body>
</html>
