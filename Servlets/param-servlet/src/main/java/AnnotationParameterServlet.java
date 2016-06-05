import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sulfur on 20.03.16.
 */
@WebServlet(name = "Servlet", urlPatterns = {"/servlet"}, initParams = {
        @WebInitParam(name = "param1", value = "value1"),
        @WebInitParam(name = "param2", value = "value2")
})
public class AnnotationParameterServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String param1 = getInitParameter("param1");
        String param2 = getInitParameter("param2");

        request.setAttribute("param1",param1);
        request.setAttribute("param2",param2);

        getServletContext().getRequestDispatcher("/sample.jsp").forward(request,response);
    }
}
