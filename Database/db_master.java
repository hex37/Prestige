import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class db_master {
	
	private String StoredHost ="a";
	private String StoreduName = "c";
	private String StoreduPass = "b"; 	
		
	
	public db_master(){
		connect();
		
	}
		
	public void connect() {
		try{
			Connection con = DriverManage.getconnection(StoredHost, StoreduName, StoreduPass);
		}
		catch ( SQLException err ) {
			System.out.println( err.getMessage( ) );
		}
	}

}

public class data_entry{
	public int id;

	public data_entry(int newid){
		id = newid;
	}
}

public class user_model extends db_master{
	
	
	
	public user_model(){
		super();
		
	}
	
	public user_data_entry getUserByID(int id){
		
	}
	
	public add_user (int id, String name, String pass, int status){
		
	}
	
}

public class user_data_entry extends data_entry{
	public String user;
	public String pass;
	public int status;
	public data_entry(int newid, String newUser, String newPass, int newStatus){
		super(newid);
		user= newUser;
		pass= newPass;
		status = newStatus;
	}
	
}

public class art_model extends db_master{
	
	public art_model(){
		super();
	}
	
}





