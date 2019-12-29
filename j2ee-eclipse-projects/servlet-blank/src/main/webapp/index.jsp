<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<html>
<body>
	<h2>Hello World!</h2>
	<%
		//数据准备 
		String name = "这是一个变量";

		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			list.add("数据" + i);
		}
	%>
	<h1>
		变量:
		<%=name%></h1>
	<table>
		<%
			for (int i = 0; i < list.size(); i++) {
		%>
		<tr>
			<td><b><%=list.get(i)%></b></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>
