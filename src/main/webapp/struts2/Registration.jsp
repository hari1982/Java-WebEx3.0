<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Name Collector</title>
	</head>
	<body>
		<h4>Enter your Name:</h4>
		<s:form action="Register">
		<table>
			<tr><th>Complete the form to create your profile</th></tr>
			<tr>
				<td><s:textfield name="username" label="User Name"/></td>
				<td><s:textfield name="password" label="PassWord"/></td>
				<td><s:textfield name="portfolioName" label="Enter name of a portfolio"/></td>
			</tr>
			<s:submit/>
		</table>
		</s:form>
	</body>
</html>