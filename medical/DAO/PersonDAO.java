package project.medical.DAO;

import project.medical.core.*;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class PersonDAO {
    private Connection myCon;
	
	public PersonDAO() throws Exception{
		Properties prop = new Properties();
		prop.load(new FileInputStream("sql/person.properties"));
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		String dburl = prop.getProperty("dburl");
	
		myCon= DriverManager.getConnection(dburl,user,password);
		System.out.println("Connect Successfull");
	}
	// Get all mom from table into a list
	public  List<Mom> getAllMom() throws Exception {
		
		List<Mom> listAllMom = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myCon.createStatement();
			myRs = myStmt.executeQuery("select * from mom");
			
			while (myRs.next()) {
				Mom tempMom = convertRowToMom(myRs);
				listAllMom.add(tempMom);
			}

			return listAllMom;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	// Get all child from table into a list
	public  List<Child> getAllChild() throws Exception {
		
		List<Child> listAllChild = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myCon.createStatement();
			myRs = myStmt.executeQuery("select * from child");
			
			while (myRs.next()) {
				Child tempChild = convertRowToChild(myRs);
				listAllChild.add(tempChild);
			}

			return listAllChild;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	
	// Adding a mom object to table
	public void addMom(Mom newMom) throws Exception{
		PreparedStatement myStmt = null;
		try {
		String sql  = "Insert into mom"
				+ "(ID, LastName, FirstName, DateOfBirth, Gender,Occupation,Address,Email,PhoneNumber)"
				+ " values (?, ? ,? , ?, ?, ?, ?, ?, ?, ?, ?) " ;
		
		myStmt  = myCon.prepareStatement(sql);
		
		myStmt.setString(1, newMom.getId());
		myStmt.setString(2, newMom.getLastName());
		myStmt.setString(3, newMom.getFirstName());
		myStmt.setString(4, newMom.getDateOfBirth());
		myStmt.setString(5, newMom.getGender());
		myStmt.setString(6, newMom.getOccupation());
		myStmt.setString(7, newMom.getAddress());
		myStmt.setString(8, newMom.getEmail());
		myStmt.setString(9, newMom.getPhoneNumber());
		
		
		myStmt.executeUpdate();
	    }
	    finally {
	    	myStmt.close();
	    }
	}	
	
	// Adding a person object to table
	public void addChild(Child newChild) throws Exception{
		PreparedStatement myStmt = null;
		try {
		String sql  = "Insert into child"
				+ "(ID, LastName, FirstName, DateOfBirth, Gender ,Address)"
				+ " values (?, ? ,? , ?, ?, ? ) " ;
		
		myStmt  = myCon.prepareStatement(sql);
		
		myStmt.setString(1, newChild.getId());
		myStmt.setString(2, newChild.getLastName());
		myStmt.setString(3, newChild.getFirstName());
		myStmt.setString(4, newChild.getDateOfBirth());
		myStmt.setString(5, newChild.getGender());
		myStmt.setString(6, newChild.getAddress());

	
		myStmt.executeUpdate();
	    }
	    finally {
	    	myStmt.close();
	    }
	}	
	
	// Converting one person in table -> object person
	private Person convertRowToPerson(ResultSet myRs) throws SQLException {
		
		String id = myRs.getString("Id");
		String lastName = myRs.getString("LastName");
		String firstName = myRs.getString("FirstName");
		String dateOfBirth = myRs.getString("DateOfBirth");
		String gender = myRs.getString("Gender");
		String email = myRs.getString("Email");
		String address = myRs.getString("Address");
		String phoneNumber = myRs.getString("PhoneNumber");
		String occupation  = myRs.getString("Occupation");

		
		Person tempPerson= new Person(id, lastName, firstName, dateOfBirth, gender, occupation, address, email, phoneNumber) ;
		
		return tempPerson;
	}
	
	// Converting one mom in table -> object mom
	private Mom convertRowToMom(ResultSet myRs) throws SQLException {
		
		String id = myRs.getString("Id");
		String lastName = myRs.getString("LastName");
		String firstName = myRs.getString("FirstName");
		String dateOfBirth = myRs.getString("DateOfBirth");
		String gender = myRs.getString("Gender");
		String email = myRs.getString("Email");
		String address = myRs.getString("Address");
		String phoneNumber = myRs.getString("PhoneNumber");
		String occupation  = myRs.getString("Occupation");

		
		Mom tempMom= new Mom(id, lastName, firstName, dateOfBirth, gender, occupation, address, email, phoneNumber) ;
		
		return tempMom;
	}
	
	// Converting one child in table -> object child
	private Child convertRowToChild(ResultSet myRs) throws SQLException {
		
		String id = myRs.getString("Id");
		String lastName = myRs.getString("LastName");
		String firstName = myRs.getString("FirstName");
		String dateOfBirth = myRs.getString("DateOfBirth");
		String gender = myRs.getString("Gender");
		String address = myRs.getString("Address");
		

		
		Child tempMom= new Child(id, lastName, firstName, dateOfBirth, gender, address) ;
		
		return tempMom;
	}
	
	// Update one Person
	public void updatePerson(Person thePerson) throws SQLException {
		PreparedStatement myStmt = null;
		try {
		     String sql =  "UPDATE person "
					+ " SET LastName = ?, FirstName = ?, DateOfBirth=?,"
					+ "Gender= ?, Email = ?, Address = ?, PhoneNumber = ?, Occupation = ?,"
					+ " WHERE ID = ?" ;
			myStmt = myCon.prepareStatement(sql);
			
			myStmt.setString(1, thePerson.getLastName());
			myStmt.setString(2, thePerson.getFirstName());
			myStmt.setString(3, thePerson.getDateOfBirth());
			myStmt.setString(4, thePerson.getGender());
			myStmt.setString(8, thePerson.getOccupation());
			myStmt.setString(6, thePerson.getAddress());
			myStmt.setString(5, thePerson.getEmail());
			myStmt.setString(7, thePerson.getPhoneNumber());
			myStmt.setString(9, thePerson.getId());
			
			myStmt.executeUpdate(); 
		}
		finally {
			close(myStmt,null);
		}
	}
	
	// Update one Mom
	public void updateMom(Mom theMom) throws SQLException {
		PreparedStatement myStmt = null;
		try {
		     String sql =  "UPDATE mom "
					+ " SET LastName = ?, FirstName = ?, DateOfBirth=?,"
					+ "Gender= ?, Email = ?, Address = ?, PhoneNumber = ?, Occupation = ?,"
					+ " WHERE ID = ?" ;
			myStmt = myCon.prepareStatement(sql);
			
			myStmt.setString(1, theMom.getLastName());
			myStmt.setString(2, theMom.getFirstName());
			myStmt.setString(3, theMom.getDateOfBirth());
			myStmt.setString(4, theMom.getGender());
			myStmt.setString(8, theMom.getOccupation());
			myStmt.setString(6, theMom.getAddress());
			myStmt.setString(5, theMom.getEmail());
			myStmt.setString(7, theMom.getPhoneNumber());
			myStmt.setString(9, theMom.getId());
			
			myStmt.executeUpdate(); 
		}
		finally {
			close(myStmt,null);
		}
	}

	// Update one Child
	public void updateChild(Mom theChild) throws SQLException {
		PreparedStatement myStmt = null;
		try {
		     String sql =  "UPDATE child "
					+ " SET LastName = ?, FirstName = ?, DateOfBirth=?,"
					+ "Gender= ?, Address = ?"
					+ " WHERE ID = ?" ;
			myStmt = myCon.prepareStatement(sql);
			
			myStmt.setString(1, theChild.getLastName());
			myStmt.setString(2, theChild.getFirstName());
			myStmt.setString(3, theChild.getDateOfBirth());
			myStmt.setString(4, theChild.getGender());
			myStmt.setString(5, theChild.getAddress());
			myStmt.setString(6, theChild.getId());
			
			myStmt.executeUpdate(); 
		}
		finally {
			close(myStmt,null);
		}
	}
	
	private static void close(Connection myCon, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myCon != null) {
			myCon.close();
		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}

	public static void main(String[] args) throws Exception {
		PersonDAO dao = new PersonDAO();
		System.out.println(dao.getAllMom());
		System.out.println(dao.getAllChild());

	}


}
