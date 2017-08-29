package br.edu.facear.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.RequestDispatcher;

import br.edu.facear.model.Cliente;
import br.edu.facear.service.ClienteService;

/**
 * Servlet implementation class ObterClienteServlet
 */
@WebServlet("/ObterClienteServlet")
public class ObterClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObterClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Passo1: Obter parametro id pela url	
		String id = request.getParameter("id");
		
		String nextPage = "/listarCliente.jsp";
		//Passo2: Converter id para inteiro
		if(id != null) {
			
			Integer x = new Integer(Integer.parseInt(id));
		
		
		//Passo3: Inserir lógica para chamar service
		ClienteService service = new ClienteService();
		Cliente c = service.obterClientePorId(x);
		
		request.setAttribute("Cliente", c);
		nextPage = "/detalhesCliente.jsp";
		}
		//Passo4: Redirecionar para detalhesClientes.jsp
		RequestDispatcher rd = (RequestDispatcher) getServletContext().getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}


}
