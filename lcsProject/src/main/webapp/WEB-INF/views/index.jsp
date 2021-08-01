<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage = "error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find LCS</title>
</head>
<body>
<h1>Please Enter The Strings</h1>
<br>
<br>
<br>
<br>

	<form action="findLcs" method="post">
		<input type="text" name="string1"><br> 
		<input type="text" name="string2"><br> 
		<input type="text" name="string3"><br>
		<input type="submit">
	</form>
	
	
	<hr/>
	<div id="displayDiv" style="display:none">
		<div id="processedData"></div>
	</div>
    <script>
	jQuery(document).ready(function($) {
 
		$("#submit").click(function(){
			var sdata = {};
			sdata["string1"] = $("string1").val();
			sdata["string2"] = $("string2").val();
			sdata["string3"] = $("string3").val();
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "findLCS",
				data : JSON.stringify(data),
				dataType : 'json',				
				success : function(data) {
					$('#processedData').html(JSON.stringify(data));
					$('#displayDiv').show();
				}
			});
		});
 
	});
    </script>	
</body>
</html>