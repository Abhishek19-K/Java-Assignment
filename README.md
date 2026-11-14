# Module 5 – Java Servlet Web Application

FeedbackApp assignment using HTML, Servlet, and `web.xml`.

## Files
- `feedback.html` – feedback form
- `FeedbackServlet.java` – processes POST form data and displays the response
- `web.xml` – servlet mapping

## Run
1. Create a Java web application in your IDE.
2. Put `feedback.html` in the web application's web root.
3. Put `FeedbackServlet.java` in the Java source folder (add a package declaration and matching `web.xml` class name if your project uses packages).
4. Put `web.xml` in `WEB-INF`.
5. Deploy to a Servlet-compatible server such as Tomcat 9 (this code uses `javax.servlet`).
6. Open `feedback.html` through the deployed application.

The servlet uses `@WebServlet` and also includes the requested `web.xml` mapping.
