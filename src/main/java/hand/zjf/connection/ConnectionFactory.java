package hand.zjf.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionFactory {
	private static String driver=null;
	private static String dburl=null;
	private static String user=null;
	private static String password=null;
	private  Connection connection=null;
	private ConnectionFactory(){}
	
	private static final ConnectionFactory connectionFactory = new ConnectionFactory();
	
	public static ConnectionFactory getInstance(){
		return connectionFactory;
	}
	static{
		Properties properties = new Properties();
		
		InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
		
		try {
			properties.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver = properties.getProperty("driver");
		dburl = properties.getProperty("dburl");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
	}
	
	public Connection getConnection(){
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(dburl, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}

}
