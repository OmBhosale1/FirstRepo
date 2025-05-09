package Java_CaseStudy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class CaseStudy {

	static Scanner sc = new Scanner(System.in);
	public CaseStudy() {
		// TODO Auto-generated constructor stub
	}


	public static void addBulkCoins() throws SQLException {
		Connection con = CreateMyConnection.getConnection();
		System.out.println("Enter how many coins you want to insert ?");
		int count = sc.nextInt();
		for(int i=0 ; i<count ;i++ ) {
		System.out.println("Enter the Country, Denomination , Year of Minting , Current Value , Date Aquired ");
		String country = sc.next();
		int denomination= sc.nextInt() ;
		int yom =sc.nextInt();
		double curretval = sc.nextDouble() ;
		sc.nextLine() ;
	    String dateaquired =sc.nextLine() ;
		String query = "insert into CoinDb value(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, country);
		pstmt.setInt(2, denomination);
		pstmt.setInt(3, yom);
		pstmt.setDouble(4, curretval);
		pstmt.setDate(5, java.sql.Date.valueOf(dateaquired));
		
		pstmt.executeUpdate();
		System.out.println("Coin Added succesfully");
		}
	}

	public static void listOnCurrentVal() throws SQLException {
		Connection con = CreateMyConnection.getConnection();
		String query = "select * from CoinDb order by CurrentValue asc ";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();	
		
		ResultSetMetaData rmd = rs.getMetaData();
		int countcolumn = rmd.getColumnCount();
		
		for(int i=1 ; i<=countcolumn ; i++ ) {
			System.out.print(rmd.getColumnName(i)+"      ");
		}
		System.out.println("\n");
		while(rs.next()) {
			for(int i=1 ;i<=countcolumn ; i++) {
				System.out.print(rs.getObject(rmd.getColumnName(i))+"            ");
			}
			System.out.println("\n");
		}



	}

	public static void listOnYOM() throws SQLException {
		Connection con = CreateMyConnection.getConnection();
		System.out.println("Enter the Year of minting name- ");
		int yom = sc.nextInt();
		String query = "select * from CoinDb where yom=? ";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1,yom);
		ResultSet rs = pstmt.executeQuery();	
		
		ResultSetMetaData rmd = rs.getMetaData();
		int countcolumn = rmd.getColumnCount();
		
		for(int i=1 ; i<=countcolumn ; i++ ) {
			System.out.print(rmd.getColumnName(i)+"      ");
		}
		System.out.println("\n");
		while(rs.next()) {
			for(int i=1 ;i<=countcolumn ; i++) {
				System.out.print(rs.getObject(rmd.getColumnName(i))+"            ");
			}
			System.out.println("\n");
		}


	}

	public static void listOnCountry() throws SQLException {
		Connection con = CreateMyConnection.getConnection();
		System.out.println("Enter the Country name- ");
		String Country = sc.next();
		String query = "select * from CoinDb where Country=? ";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1,Country);
		ResultSet rs = pstmt.executeQuery();	
		
		ResultSetMetaData rmd = rs.getMetaData();
		int countcolumn = rmd.getColumnCount();
		
		for(int i=1 ; i<=countcolumn ; i++ ) {
			System.out.print(rmd.getColumnName(i)+"      ");
		}
		System.out.println("\n");
		while(rs.next()) {
			for(int i=1 ;i<=countcolumn ; i++) {
				System.out.print(rs.getObject(rmd.getColumnName(i))+"            ");
			}
			System.out.println("\n");
		}

		
	}

	public static void showDatabase() throws SQLException {
		Connection con = CreateMyConnection.getConnection();
		System.out.println("The Whole collection ");
		
		String query = "select * from CoinDb ";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		ResultSetMetaData rmd = rs.getMetaData();
		int countcolumn = rmd.getColumnCount();
		
		for(int i=1 ; i<=countcolumn ; i++ ) {
			System.out.print(rmd.getColumnName(i)+"      ");
		}
		System.out.println("\n");
		while(rs.next()) {
			for(int i=1 ;i<=countcolumn ; i++) {
				System.out.print(rs.getObject(rmd.getColumnName(i))+"            ");
			}
			System.out.println("\n");
		}

		

		
	}

	public static void searchAC() throws SQLException {
		Connection con = CreateMyConnection.getConnection();
		System.out.println("Enter the Aquired date and Country ");
		
		String query = "select * from CoinDb where DateAquired=? and Country=?";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		int DateAquired= sc.nextInt();
		String country = sc.next();
		pstmt.setInt(1, DateAquired);
		pstmt.setString(2, country);
		
		ResultSet rs = pstmt.executeQuery();
		
		ResultSetMetaData rmd = rs.getMetaData();
		int countcolumn = rmd.getColumnCount();
		
		for(int i=1 ; i<=countcolumn ; i++ ) {
			System.out.print(rmd.getColumnName(i)+"      ");
		}
		System.out.println("\n");
		while(rs.next()) {
			for(int i=1 ;i<=countcolumn ; i++) {
				System.out.print(rs.getObject(rmd.getColumnName(i))+"            ");
			}
			System.out.println("\n");
		}

		
	}

	public static void searchCDY() throws SQLException {
		Connection con = CreateMyConnection.getConnection();
		System.out.println("Enter the Country and Denomination and Year of Minting ");
		String query = "select * from CoinDb where Country=? and Denomination=? and yom=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		String country = sc.next();
		int Denomination= sc.nextInt();
		int yom= sc.nextInt();
		pstmt.setString(1, country);
		pstmt.setInt(2, Denomination);
		pstmt.setInt(3, yom);
		ResultSet rs = pstmt.executeQuery();
		
		ResultSetMetaData rmd = rs.getMetaData();
		int countcolumn = rmd.getColumnCount();
		
		for(int i=1 ; i<=countcolumn ; i++ ) {
			System.out.print(rmd.getColumnName(i)+"      ");
		}
		System.out.println("\n");
		while(rs.next()) {
			for(int i=1 ;i<=countcolumn ; i++) {
				System.out.print(rs.getObject(rmd.getColumnName(i))+"            ");
			}
			System.out.println("\n");
		}
	}

	public static void searchCY() throws SQLException {
		
		Connection con = CreateMyConnection.getConnection();
		System.out.println("Enter the Country and Year of Minting");
		String query = "select * from CoinDb where Country=? and yom=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		String country = sc.next();
		int yom= sc.nextInt();
		pstmt.setString(1, country);
		pstmt.setInt(2, yom);
		ResultSet rs = pstmt.executeQuery();
		
		ResultSetMetaData rmd = rs.getMetaData();
		int countcolumn = rmd.getColumnCount();
		
		for(int i=1 ; i<=countcolumn ; i++ ) {
			System.out.print(rmd.getColumnName(i)+"      ");
		}
		System.out.println("\n");
		while(rs.next()) {
			for(int i=1 ;i<=countcolumn ; i++) {
				System.out.print(rs.getObject(rmd.getColumnName(i))+"            ");
			}
			System.out.println("\n");
		}

		
	}

	public static void searchCD() throws SQLException {
		Connection con = CreateMyConnection.getConnection();
		System.out.println("Enter the Country and Denomination");
		String query = "select * from CoinDb where Country=? and Denomination=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		String country = sc.next();
		int denomination= sc.nextInt();
		pstmt.setString(1, country);
		pstmt.setInt(2, denomination);
		ResultSet rs = pstmt.executeQuery();
		
		ResultSetMetaData rmd = rs.getMetaData();
		int countcolumn = rmd.getColumnCount();
		
		for(int i=1 ; i<=countcolumn ; i++ ) {
			System.out.print(rmd.getColumnName(i)+"      ");
		}
		System.out.println("\n");
		while(rs.next()) {
			for(int i=1 ;i<=countcolumn ; i++) {
				System.out.print(rs.getObject(rmd.getColumnName(i))+"            ");
			}
			System.out.println("\n");
		}
	}

	public static void addCoin() throws SQLException {
	Connection con = CreateMyConnection.getConnection();
	System.out.println("Enter the Country, Denomination , Year of Minting , Current Value , Date Aquired ");
	String country = sc.next();
	int denomination= sc.nextInt() ;
	int yom =sc.nextInt();
	double curretval = sc.nextDouble() ;
	sc.nextLine() ;
    String dateaquired =sc.nextLine() ;
	String query = "insert into CoinDb value(?,?,?,?,?)";
	PreparedStatement pstmt = con.prepareStatement(query);
	pstmt.setString(1, country);
	pstmt.setInt(2, denomination);
	pstmt.setInt(3, yom);
	pstmt.setDouble(4, curretval);
	pstmt.setDate(5, java.sql.Date.valueOf(dateaquired));
	
	pstmt.executeUpdate();
	System.out.println("Coin Added succesfully");
	
	}	
}
