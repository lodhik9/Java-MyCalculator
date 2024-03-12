<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator Result Page</title>
<link rel="stylesheet" href="style.css" />

</head>
<body>
<img src="images/joke.gif"/>
<h1>Joke of the Day!</h1>
<h3><%=request.getParameter("joke")%></h3>
<form action="MyServlet">
	<input name="num1" placeholder="First Number"></input>
	<input name="num2" placeholder="Second Number"></input>
	
	<button name="bt1" value="1"> + </button>
	<button name="bt1" value="2"> - </button>
	<button name="bt1" value="3"> * </button>
	<button name="bt1" value="4"> / </button>
</form>

<h1>Ans=<%=request.getParameter("ans")%></h1>

</body>
</html>