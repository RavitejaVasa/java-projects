package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.BankService;

/**
 * Servlet implementation class Registerservlet
 */
@WebServlet("/register")
public class Registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registerservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Customer c = new Customer();
    	BankService bc = new BankService();
        c.setAcno(Integer.parseInt(request.getParameter("accno")));
        c.setUname(request.getParameter("uname"));
        c.setBalance(Integer.parseInt(request.getParameter("bal")));
        
        bc.addcustomer(c);
        response.sendRedirect("./Login.jsp");
    }
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
