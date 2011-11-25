package samples;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebInitParam;
/**
 * 
 * @author Marcelo Adamatti
 * http://www.mastertheboss.com/java-ee-16-articles/241-servlet-30-on-jboss-as-6-tutorial.html
 */
@WebServlet(
	name="testServlet", 
	urlPatterns={"/hello"},
	initParams={@WebInitParam(name="simpleParam", value="paramValue") } )  
public class SampleServlet extends HttpServlet{
	private Logger logger = Logger.getLogger(this.getClass().getName());
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		PrintWriter out = response.getWriter();  
        String simpleParam = getServletConfig().getInitParameter("simpleParam");  
        out.println("Hello World "+simpleParam);  
        out.close();  
    } 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
         doGet(request,response);  
    }  
}
