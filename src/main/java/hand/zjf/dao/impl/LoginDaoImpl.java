package hand.zjf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import hand.zjf.connection.ConnectionFactory;
import hand.zjf.dao.LoginDao;

public class LoginDaoImpl implements LoginDao {

	@Override
	public int getFirstName(String firstName) throws SQLException{
		// TODO Auto-generated method stub
		ResultSet rSet=null;
		int count=0;
		String sql = "select first_name from actor where first_name = ?";
		ConnectionFactory conf = ConnectionFactory.getInstance();
		Connection connection = conf.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, firstName);
		rSet = ps.executeQuery();
		
		while(rSet.next()){
			count++;
		}
		if(count>0){
			return 1;
		}else{
			return 0;
		}
	}
}
