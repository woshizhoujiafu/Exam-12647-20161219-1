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
import hand.zjf.entity.Film;


public class FilmOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FilmOperationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FilmOperationDao fod = new FilmOperationDaoImpl();
		List<Film> film = new ArrayList<>();
		try {
			film = fod.getFilmList();
			request.setAttribute("film", film);
			request.getRequestDispatcher("/jsp/showFlimList.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
