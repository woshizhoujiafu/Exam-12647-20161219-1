package hand.zjf.test;

import java.sql.Connection;

import hand.zjf.connection.ConnectionFactory;

public class Test {
	public static void main(String[] args){
		ConnectionFactory conf = ConnectionFactory.getInstance();
		Connection connection = conf.getConnection();
		 System.out.println(connection);
	}
}
