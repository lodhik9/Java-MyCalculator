# Calculator App

This is a web application built using **Java Servlets** and **JSP**. It allows users to perform basic arithmetic operations and provides a random programming joke each time a calculation is performed.

---

### 1.Technologies Used

---

- Java
- Servlets
- JSP
- HTML
- CSS

---

### 2.Getting Started

---

To run this application locally, you'll need a Java Development Environment (JDK) and a web server like Apache Tomcat.

1. Clone the repository or download the source code.
2. Import the project into your preferred Java IDE (e.g., Eclipse, IntelliJ IDEA).
3. Configure the web server to deploy the application.
4. Run the application and access it through the configured URL (e.g., `http://localhost:8080/CalculatorApp`).

---

### 3.Usage

---

1. On the main page, enter two numbers in the provided input fields.
2. The application will display the result and a random programming joke.
3. You can perform additional calculations or refresh the page to get a new joke.

---

### 4.Features

---

- User-friendly interface with input fields for numbers and operation buttons.
- Performs basic arithmetic operations (addition, subtraction, multiplication, and division).
- Displays the calculation result on the page.

---

### 5.File Structure and Code

---

- `MyServlet.java`: The main servlet class that handles the HTTP requests, performs calculations, and generates random jokes.

_[src/main/java/MyPackage/MyServlet.java](src/main/java/MyPackage/MyServlet.java)_

```java
package myPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String[] jokes = {
		    "Why do Java developers wear glasses? Because they don't C#!",
		    "I told my computer I needed a break, and now it won't stop sending me Kit Kat bars.",
		    "Why don't programmers like nature? It has too many bugs.",
		    "How many programmers does it take to change a light bulb? None, it's a hardware problem.",
		    "Why did the programmer quit his job? Because he didn't get arrays.",
		    "How do you keep a programmer in the shower forever? Give them a bottle of shampoo with the instructions: Lather. Rinse. Repeat.",
		    "Why do programmers always mix up Halloween and Christmas? Because Oct 31 == Dec 25.",
		    "Why did the programmer go broke? Because he used up all his cache.",
		    "Why did the JavaScript developer leave? Because they didn't get enough events.",
		    "Why did the developer go broke? Too many console logs."
		};

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str1 = request.getParameter("num1");
		String str2 = request.getParameter("num2");
		String str3 = request.getParameter("bt1");

		// These values are in the String format. Type-cast to int
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);

		int ans;
		if(str3.equals("1")) ans = num1 + num2;
		else if(str3.equals("2")) ans = num1 - num2;
		else if(str3.equals("3")) ans = num1 * num2;
		else ans = num1 / num2;

		int randomIndex = (int) (Math.random() * jokes.length);
		String randomJoke = jokes[randomIndex];

		//response.getWriter().append("Ans =  " + ans);
		//Redirect this to the JSP page.
		response.sendRedirect("ResultPage.jsp?ans=" + ans + "&joke=" + randomJoke);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
```

- `index.html`: The HTML file for the main page, containing the form for user input

_[src/main/webapp/index.html](src/main/webapp/index.html)_

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Calculator</title>
<link rel="stylesheet" href="style.css" />

</head>
<body>
<img src="images/giphy.gif"/>
<h1>Hello, how are you?</h1>
<form action="MyServlet">
	<input name="num1" placeholder="First Number"></input>
	<input name="num2" placeholder="Second Number"></input>

	<button name="bt1" value="1"> + </button>
	<button name="bt1" value="2"> - </button>
	<button name="bt1" value="3"> * </button>
	<button name="bt1" value="4"> / </button>
</form>


</body>
</html>
```

- `ResultPage.jsp`: The JSP file that displays the calculation result and the random joke.
  _[src/main/webapp/ResultPage.jsp](src/main/webapp/ResultPage.jsp)_

```jsp
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
```

- `style.css`: The CSS file containing the styles for the application.

_[src/main/webapp/style.css](src/main/webapp/style.css)_

```css
@charset "ISO-8859-1";
body {
  font-size: 40px;
  text-align: center;
  background: linear-gradient(to right, #2b40ff, #07121a);
}

h1,
h3 {
  color: white;
  margin: 15px;
}

input,
button {
  font-size: 40px;
  color: white;
  border-radius: 5%;
  background-color: black;
  border: 2px solid white;
}

img {
  width: 20%;
  height: 20%;
  margin-top: 20px;
}
img:hover {
  -ms-transform: scale(1.1); /* IE 9 */
  -webkit-transform: scale(1.1); /* Safari 3-8 */
  transform: scale(1.1);
}
```

---

### 6.Contributing

---

Contributions are welcome! If you find any issues or have suggestions for improvement, please open an issue or submit a pull request.

---

### 7.License

---

This project is licensed under the [MIT License](LICENSE).
