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


public class SaveAddFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SaveAddFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmOperationDao fod = new FilmOperationDaoImpl();
		String title=request.getParameter("title");
		String description = request.getParameter("description");
		String language = request.getParameter("language");
		Film film = new Film();
		film.setDescription(description);
		film.setTitle(title);
		film.setLanguage(language);
		try {
			int flag = fod.saveAddFilm(film);
			if(flag==1){
				request.setAttribute("msg", "添加数据成功");
			}else{
				request.setAttribute("msg", "添加数据失败");
			}
			
			request.getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
