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


public class ShowModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShowModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmOperationDao fod = new FilmOperationDaoImpl();
		String filmId = request.getParameter("filmId");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String language = request.getParameter("language");
		List<String> list = new ArrayList<>();
		System.out.println(description);
		try {
			list = fod.getLanguage();
			request.setAttribute("list", list);
			request.setAttribute("filmId", filmId);
			request.setAttribute("title", title);
			request.setAttribute("description", description);
			request.setAttribute("language", language);
			request.getRequestDispatcher("/jsp/modifyFilm.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
