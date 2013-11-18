<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Name Collector</title>
	</head>
	<body>
		<h4>Complete and submit the form to create your own portfolio.</h4>

		<s:form action="ImageUpload" method="post" enctype="multipart/form-data">

   				<s:file name="pic" label="Picture"/>

   				<s:submit/>
		</s:form>
</body>
</html>