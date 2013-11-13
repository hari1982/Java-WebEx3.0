<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Name Collector</title>
	</head>
	<body>
		<h4>Enter your Name:</h4>
		<s:form action="HelloWorld">
			<s:textfield name="name" label="Your Name"/>
			<s:submit/>
		</s:form>
	</body>
</html>