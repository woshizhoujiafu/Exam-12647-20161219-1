package hand.zjf.dao;

import java.sql.SQLException;
import java.util.List;

import hand.zjf.entity.Film;

public interface FilmOperationDao {
	public List<Film> getFilmList() throws SQLException;
	
	public List getLanguage() throws SQLException;
	
	public int saveAddFilm(Film film) throws SQLException;
	
	public int deleteFilm(int filmId) throws SQLException;

}
