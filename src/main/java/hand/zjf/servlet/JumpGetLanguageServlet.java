package hand.zjf.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hand.zjf.dao.FilmOperationDao;
import hand.zjf.dao.impl.FilmOperationDaoImpl;


public class JumpGetLanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public JumpGetLanguageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmOperationDao fod = new FilmOperationDaoImpl();
		List<String> list = new ArrayList<>();
		try {
			list = fod.getLanguage();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/jsp/addFilm.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
