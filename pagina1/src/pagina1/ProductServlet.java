package pagina1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtendo os parâmetros enviados pelo formulário
        String codigo = request.getParameter("codigo");
        String nome = request.getParameter("nome");
        double valorUnitario = Double.parseDouble(request.getParameter("valor_unitario"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String dataCompraStr = request.getParameter("data_compra");
        
        // Convertendo a data da compra para o formato desejado (opcional)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dataCompra = null;
        try {
            dataCompra = dateFormat.parse(dataCompraStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        // Aqui você pode fazer o processamento necessário com os dados recebidos
        
        // Exemplo de saída dos dados recebidos
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Dados Recebidos:</h2>");
        response.getWriter().println("Código: " + codigo + "<br>");
        response.getWriter().println("Nome: " + nome + "<br>");
        response.getWriter().println("Valor Unitário: " + valorUnitario + "<br>");
        response.getWriter().println("Quantidade: " + quantidade + "<br>");
        response.getWriter().println("Data da Compra: " + dateFormat.format(dataCompra) + "<br>");
        response.getWriter().println("</body></html>");
    }
}
