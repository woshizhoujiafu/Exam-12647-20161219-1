package hand.zjf.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hand.zjf.dao.FilmOperationDao;
import hand.zjf.dao.impl.FilmOperationDaoImpl;
import hand.zjf.entity.Film;

public class ModifyFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmOperationDao fod = new FilmOperationDaoImpl();
		int filmId = Integer.parseInt(request.getParameter("filmId"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String language = request.getParameter("language");
		Film film = new Film();
		film.setFilmId(filmId);
		film.setDescription(description);
		film.setLanguage(language);
		film.setTitle(title);
		try {
			int flag = fod.saveModifyFilm(film);
			if(flag==1){
				request.setAttribute("msg", "ÐÞ¸Ä³É¹¦");
			}else{
				request.setAttribute("msg", "±à¼­Ê§°Ü");
			}
			request.getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
