package hand.zjf.dao.impl;


import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hand.zjf.connection.ConnectionFactory;
import hand.zjf.dao.FilmOperationDao;
import hand.zjf.entity.Film;

public class FilmOperationDaoImpl implements FilmOperationDao{
	
	@Override
	public List<Film> getFilmList() throws SQLException{
		ResultSet rSet;
		List<Film> list = new ArrayList<>();
		ConnectionFactory conf = ConnectionFactory.getInstance();
		Connection connection = conf.getConnection();
		String sql = "select film_id,title,description,l.name from film f,language l where f.language_id=l.language_id";
		PreparedStatement ps = connection.prepareStatement(sql);
		rSet = ps.executeQuery();
		while(rSet.next()){
			Film film = new Film();
			film.setFilmId(rSet.getInt("film_id"));
			film.setDescription(rSet.getString("description"));
			film.setTitle(rSet.getString("title"));
			film.setLanguage(rSet.getString("l.name"));
			list.add(film);
		}
		return list;
	}

	@Override
	public List getLanguage() throws SQLException{
		// TODO Auto-generated method stub
		ResultSet rSet;
		Set<String> set = new HashSet();
		ConnectionFactory conf = ConnectionFactory.getInstance();
		Connection connection = conf.getConnection();
		String sql = "select name from language";
		PreparedStatement ps = connection.prepareStatement(sql);
		rSet = ps.executeQuery();
		while(rSet.next()){
			set.add(rSet.getString("name"));
		}
		List<String> list = new ArrayList<>(set);
		return list;
	}

	@Override
	public int saveAddFilm(Film film) throws SQLException {

//		ResultSet rSet1;
		ConnectionFactory conf = ConnectionFactory.getInstance();
		Connection connection = conf.getConnection();
		String sql1 = "insert into film(description,title,language_id) values(?,?,?)";
//		String sql2 = "select language_id from language where name = ?";
		PreparedStatement ps = connection.prepareStatement(sql1);
//		PreparedStatement ps1 = connection.prepareStatement(sql2);

//		ps1.setString(1, film.getLanguage());
//		rSet1 = ps1.executeQuery();
//		int languageId = 0;
//		while(rSet1.next()){
//			 languageId = rSet1.getInt("language_id");
//		}
		ps.setString(1,film.getDescription());
		ps.setString(2, film.getTitle());
		ps.setInt(3, 3);
	    ps.execute();
		return 1;
	}

	@Override
	public int deleteFilm(int filmId) throws SQLException {
		int biaoji=0;
		ConnectionFactory conf = ConnectionFactory.getInstance();
		Connection connection = conf.getConnection();
		String sql = "delete from film where film_id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, filmId);
		boolean flag = ps.execute();
		if(flag)
			biaoji=1;
		return biaoji;
	}
}
