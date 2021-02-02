package myservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import myentities.Account;

/**
 * Servlet implementation class AddAccount
 */
@WebServlet("/AddAccount")
public class AddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		int no;
		String nm,ty,bl;
		
		
		try
		{
			no=Integer.parseInt(request.getParameter("ano"));
			nm=request.getParameter("anm");
			ty=request.getParameter("atyp");
			bl=request.getParameter("bal");
			
			Session ses;
			Configuration cfg=new Configuration().configure();
			SessionFactory sf=cfg.addAnnotatedClass(Account.class).buildSessionFactory();
			
			ses=sf.getCurrentSession();
			ses.beginTransaction();
			
			Account obj=new Account();
			obj.setAcnumber(no);
			obj.setAcname(nm);
			obj.setActype(ty);
			obj.setBalamount(bl);
			
			ses.save(obj);
			ses.getTransaction().commit();
			
			out.println("Account opened");
			out.println("<br>");
			out.println("<a href='index.jsp'>Back</a>");
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
	}

}
