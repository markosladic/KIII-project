package mk.ukim.finki.wpaud.web.servlet;

import mk.ukim.finki.wpaud.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "category-servlet", urlPatterns = "/categories")
public class CategoryServlet extends HttpServlet {

    private final CategoryService categoryService;

    public CategoryServlet(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();

        String ipAddress = req.getRemoteAddr();
        String clientAgent = req.getHeader("User-Agent");

        pw.println("<html>");
        pw.println("<head>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h3>User Info</h3>");
        pw.println("Ip Address: " + ipAddress + "</br>");
        pw.println("Client Agent: " + clientAgent);
        pw.println("<h3>Category list</h3>");
        pw.println("<ul>");
        categoryService.listCategories()
                .forEach(e -> pw.format("<li>%s (%s)</li>", e.getName(), e.getDescription()));
        pw.println("</ul>");
        pw.println("<h3>Add Category</h3>");
        pw.println("<form method='post' action='/servlet/category'>");
        pw.println("<label for='name'>Name</label>");
        pw.println("<input id='name' type='text' name='name'>");
        pw.println("<label for='desc'>Description</label>");
        pw.println("<input id='desc' type='text' name='desc'>");
        pw.println("<input type='submit' value='Submit'>");
        pw.println("</form>");
        pw.println("</body>");
        pw.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("name");
        String categoryDesc = req.getParameter("desc");
        categoryService.create(categoryName, categoryDesc);
        resp.sendRedirect("/categories");
    }
}
