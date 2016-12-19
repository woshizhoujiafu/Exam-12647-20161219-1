package hand.zjf.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hand.zjf.dao.FilmOperationDao;
import hand.zjf.dao.impl.FilmOperationDaoImpl;

/**
 * Servlet implementation class DeleteFilmServlet
 */
public class DeleteFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmOperationDao fod = new FilmOperationDaoImpl();
		String filmId1 = request.getParameter("filmId");
		int filmId =  Integer.parseInt(filmId1);
		try {
			int flag = fod.deleteFilm(filmId);
			if(flag==1){
				request.setAttribute("msg", "É¾³ý³É¹¦");
			}else{
				request.setAttribute("msg", "É¾³ýÊ§°Ü");
			}
			request.getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
