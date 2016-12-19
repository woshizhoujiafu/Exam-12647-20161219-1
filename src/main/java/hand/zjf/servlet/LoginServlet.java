package hand.zjf.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hand.zjf.dao.LoginDao;
import hand.zjf.dao.impl.LoginDaoImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		LoginDao loginDao = new LoginDaoImpl();
		HttpSession session = request.getSession();
		try {
			if((loginDao.getFirstName(firstName))==1){
				
				session.setAttribute("flag", "success");
				request.getRequestDispatcher("/jsp/userOperation.jsp").forward(request, response);
			}else{
				session.setAttribute("flag", "error");
				response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
