import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String codigo = request.getParameter("codigo");
        String nome = request.getParameter("nome");
        double valorUnitario = Double.parseDouble(request.getParameter("valorUnitario"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String dataCompra = request.getParameter("dataCompra");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Produtos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Dados do Produto</h1>");
            out.println("<p>Código: " + codigo + "</p>");
            out.println("<p>Nome: " + nome + "</p>");
            out.println("<p>Valor Unitário: " + valorUnitario + "</p>");
            out.println("<p>Quantidade: " + quantidade + "</p>");
            out.println("<p>Data da Compra: " + dataCompra + "</p>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}