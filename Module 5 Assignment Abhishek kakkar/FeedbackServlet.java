import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/submitFeedback")
public class FeedbackServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String feedbackType = request.getParameter("feedbackType");
        String comments = request.getParameter("comments");

        String dateTime = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'>");
        out.println("<title>Feedback Submitted</title></head><body>");
        out.println("<h2>Thank you, " + escapeHtml(name)
                + " for your feedback!</h2>");
        out.println("<p>Email: " + escapeHtml(email) + "</p>");
        out.println("<p>Feedback Type: " + escapeHtml(feedbackType) + "</p>");
        out.println("<p>Comments: " + escapeHtml(comments) + "</p>");
        out.println("<p>Date and Time: " + dateTime + "</p>");
        out.println("</body></html>");
    }

    private String escapeHtml(String value) {
        if (value == null) return "";
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#x27;");
    }
}
