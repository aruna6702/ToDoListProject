package dao_classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import java.sql.Blob;

import dto_classes.User;

public class Dao {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
		return con;
	}
	public static int saveUser(User u) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("insert into user_project values(?,?,?,?,?,?)");
		pst.setInt(1, u.getUserid());
		pst.setString(2, u.getUsername());
		pst.setString(3, u.getUseremail());
		pst.setLong(4, u.getUsercontact());
		pst.setString(6, u.getUserpassword());
		
		Blob imageBlob = new SerialBlob(u.getUserimage());
		pst.setBlob(5, imageBlob);
		
		int res = pst.executeUpdate();
		return res;
	}
	public User findByEmail(String email) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from user_project where useremail=?");
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			User u = new User();
			u.setUserid(rs.getInt(1));
			u.setUsername(rs.getString(2));
			u.setUseremail(rs.getString(3));
			u.setUsercontact(rs.getLong(4));
			u.setUserpassword(rs.getString(6));
			//convert blob into byte[]
			Blob imageBlob = rs.getBlob(5);
			byte[] image = imageBlob.getBytes(1, (int)imageBlob.length());
			
			u.setUserimage(image);
			
			return u;
		}
		else {
			return null;
		}
	}
}
