<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="shortcut icon" href="http://localhost/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
<style>
table {
   width: 100%;
   min-width: 700px;
}

table, th, td {
   border: 1px solid gray;
}
</style>
</head>
<body>

<script>
	$.ajax({
		url : "/scott/dept/select"	// HomeAjaxController.java
		, method : "GET"
		, dataType : "json"
		, success : function(data, callback, xhr) {
			let select = $("#selDept");
			for (var i = 0; i < data.length; i++) {
				let option = $("<option>").val(data[i].deptno).text(data[i].dname);
				$(select).append(option)
			}
			console.log(data)
		}, error : function(xhr, errorType) {
			alert(errorType);
		}
	});
	
	$(function() {	
		$("#selDept").click();
		
		$("#selDept").on("change", function() {
			let deptno = $(this).val();
			
			$.ajax({
				url : "/scott/emp/select/" + deptno	// HomeAjaxController.java
				, method : "GET"
				, dataType : "json"
				, success : function(data, callback, xhr) {
					let tbody = $("tbody");
					$(tbody).empty();
					
					if(data.length == 0) {
						let tr = $("<tr>");
						let td = $("<td>")
							.attr("colspan", "9")
							.css("text-align", "center")
							.text("employee does not exist.");
						$(tr).append(td);
						$(tbody).append(tr);
						
						return;
					}
					
					for (var i = 0; i < data.length; i++) {
						let tr = $("<tr>");
						let check = $("<td>").html("<input type='checkbox' name='ckbEmp' data-empno='\${data[i].empno}'>");
						let empno = $("<td>").text(data[i].empno);
						let ename = $("<td>").text(data[i].ename);
						let job = $("<td>").text(data[i].job);
						let hiredate = $("<td>").text(data[i].hiredate);
						let mgr = $("<td>").text(data[i].mgr);
						let sal = $("<td>").text(data[i].sal);
						let comm = $("<td>").text(data[i].comm);
						let deptno = $("<td>").text(data[i].deptno);
						
						
						$(tr)
						.append(check)
						.append(empno)
						.append(ename)
						.append(job)
						.append(hiredate)
						.append(mgr)
						.append(sal)
						.append(comm)
						.append(deptno);
						
						$(tbody).append(tr);
					}
					console.log(data)
				}, error : function(xhr, errorType) {
					alert(errorType);
				}
			});
		})
	})
</script>

<h3>ex05_deptEmp.jsp</h3>
   <select id="selDept" name="deptno">
      <c:forEach items="${ deptList }" var="dto">
         <option value="${ dto.deptno }">${ dto.dname }</option>
      </c:forEach>
   </select>
   <br>
   <br>
   <table>
      <thead>
         <tr>
            <th><input type="checkbox" id="ckbAll" name="ckbAll">전체
               선택</th>
            <th>empno</th>
            <th>ename</th>
            <th>job</th>
            <th>hiredate</th>
            <th>mgr</th>
            <th>sal</th>
            <th>comm</th>
            <th>deptno</th>
         </tr>
      </thead>
      <tbody>

         <c:choose>
            <c:when test="${  not empty empList }">
               <c:forEach items="${ empList }" var="dto">
                  <tr>
                     <td><input type="checkbox" name="ckbEmp"
                        data-empno="${ dto.empno }"></td>
                     <td>${ dto.empno }</td>
                     <td>${ dto.ename }</td>
                     <td>${ dto.job }</td>
                     <td>${ dto.hiredate }</td>
                     <td>${ dto.mgr }</td>
                     <td>${ dto.sal }</td>
                     <td>${ dto.comm }</td>
                     <td>${ dto.deptno }</td>
                  </tr>
               </c:forEach>
            </c:when>
            <c:otherwise>
               <tr>
                  <td colspan="9" style="text-align: center">employee does not
                     exist.</td>
               </tr>
            </c:otherwise>
         </c:choose>

      </tbody>
      <tfoot>
         <tr>
            <td colspan="9" style="text-align: center">
               <button id="checkedEmpno">선택한 empno 확인</button>
            </td>
         </tr>
      </tfoot>
   </table>

   <p id="demo"></p>
</body>
</html>