package jdbc_libarary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CRUD {
	

		
		public Connection getConnection() throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymsdb", "root", "root");
			return connection;
		}
		
		public int signUp(User user) throws Exception
		{
			Connection connection=getConnection();
			PreparedStatement statement=connection.prepareStatement("Insert into user values(?,?,?,?,?)");
			statement.setInt(1, user.getId());
			statement.setString(2, user.getName());
			statement.setLong(3, user.getPhone());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getPassword());
			
			int res=statement.executeUpdate();
			connection.close();
			return res;
			
			
		}
		public ResultSet logIn(User user, String email, String Password) throws Exception
		{
			Connection connection=getConnection();
			PreparedStatement statement=connection.prepareStatement("select * from user where email=?");
			statement.setString(1, user.getEmail());	
			//statement.setLong(2, user.getPhone());	
			ResultSet res=statement.executeQuery();
			return res;
	     }
		
		/////////////////////////////////////////Books Method/////////////////////////////////////////////////
		public ResultSet getAll() throws Exception
		{
			Connection connection=getConnection();
			PreparedStatement statement=connection.prepareStatement("Select * from book");
			ResultSet set=statement.executeQuery();
			return set;
		}
		public int addBook(Book book) throws Exception
		{
			Connection connection=getConnection();
			PreparedStatement statement=connection.prepareStatement("Insert into book values (?,?,?,?,?)");
			statement.setInt(1, book.getId());
			statement.setString(2, book.getName());
			statement.setString(3, book.getAuthor());
			statement.setDouble(4, book.getPrice());
			statement.setString(5, book.getGenre());
			int set=statement.executeUpdate();
			return set;
			
		}
		
		public int deleteBook(int id) throws Exception
		{
			Connection connection=getConnection();
			PreparedStatement statement=connection.prepareStatement("delete from book where id=?");
			statement.setInt(1, id);
			int res1=statement.executeUpdate();
			connection.close();
			return res1;
		}
		
		public int updateBook(Book book) throws Exception
		{
			Connection connection=getConnection();
			PreparedStatement statement=connection.prepareStatement("update book set name=?, author=?, price=?, genre=? where id=?");
			statement.setInt(5, book.getId());
			statement.setString(1, book.getName());
			statement.setString(2, book.getAuthor());
			statement.setDouble(3, book.getPrice());
			statement.setString(4, book.getGenre());
			
			int res2=statement.executeUpdate();
			connection.close();
			return res2;
		}
		
		public ResultSet bookNameById(int id) throws Exception
		{
			Connection connection=getConnection();
			PreparedStatement statement=connection.prepareStatement("select * from book where id=?");
			statement.setInt(1, id);
			ResultSet resultset1=statement.executeQuery();
			return resultset1;
			
			
		}
		
		public ResultSet bookNameByName(String name) throws Exception
		{
			Connection connection=getConnection();
			PreparedStatement statement=connection.prepareStatement("select * from book where name=?");
			statement.setString(1, name);
			ResultSet resultset1=statement.executeQuery();
			return resultset1;
			
			
		}
		
		public ResultSet bookNameByAuthor(String author) throws Exception
		{
			Connection connection=getConnection();
			PreparedStatement statement=connection.prepareStatement("select * from book where author=?");
			statement.setString(1, author);
			ResultSet resultset1=statement.executeQuery();
			return resultset1;
			
			
		}
		
		public ResultSet bookNameByGenre(String genre) throws Exception
		{
			Connection connection=getConnection();
			PreparedStatement statement=connection.prepareStatement("select * from book where genre=?");
			statement.setString(1, genre);
			ResultSet resultset1=statement.executeQuery();
			return resultset1;
			
			
		}
		
		public ResultSet updateUser(User user) throws Exception
		{
			Connection connection=getConnection();
			PreparedStatement statement=connection.prepareStatement("update user set name=?,email=?, password=?  where id=?");
			statement.setInt(1, user.getId());
			ResultSet resultset1=statement.executeQuery();
			return resultset1;
			
			
		}

	}



