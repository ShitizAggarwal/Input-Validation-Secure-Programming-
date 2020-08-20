

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHealper {

	
	public void Add(Contact person) { 
		PreparedStatement ps=null;
		Connection c=null;
		String insertQuery="insert into PERSON (NAME,MOBILE) VALUES(?,?)";
		try {
			Connection JDBC_CONNECTION=new SQLConnection().getDBConnection();
		
			ps=(PreparedStatement) JDBC_CONNECTION.prepareStatement(insertQuery);
			ps.setString(1, person.name);
			ps.setString(2, person.mobile);
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("insert successfull");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(c!=null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public List<Contact> getPeople(){
		List<Contact> p=new ArrayList<>();
		PreparedStatement ps=null;
		Connection c=null;
		ResultSet resultSet=null;
		try {
			Connection JDBC_CONNECTION=new SQLConnection().getDBConnection();

			ps=(PreparedStatement) JDBC_CONNECTION.prepareStatement("SELECT PERSON_ID,NAME,MOBILE FROM PERSON");
			resultSet=ps.executeQuery();
			if(resultSet==null) {
				return p;
			}
			while(resultSet.next()) {
				Contact person=new Contact(resultSet.getInt("PERSON_ID"),resultSet.getString("NAME"), resultSet.getString("MOBILE"));
				p.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public int delete(String nameOrMobile) {
		int i=0;
		PreparedStatement ps=null; 
		Connection c=null;
		try {
			Connection JDBC_CONNECTION=new SQLConnection().getDBConnection();

			ps=(PreparedStatement) JDBC_CONNECTION.prepareStatement("delete from PERSON where NAME=? or MOBILE=?");
			ps.setString(1, nameOrMobile);
			ps.setString(2, nameOrMobile);
			 i=ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(c!=null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return i;
	}
	
	
}
