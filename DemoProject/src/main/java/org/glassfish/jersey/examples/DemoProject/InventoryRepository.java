package org.glassfish.jersey.examples.DemoProject;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import org.glassfish.jersey.examples.DemoProject.InventoryDB;

public class InventoryRepository {

	public List<Fruits> getFruits() {
		List<Fruits> fruits = new ArrayList<>();
		try {
			Connection conn = InventoryDB.initializeDatabase();   // Initialized the DB
			java.sql.PreparedStatement st = conn.prepareStatement("select * from inventory");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Fruits a = new Fruits();
				a.setName(rs.getString(1));
				a.setQuantity(rs.getInt(2));
				fruits.add(a);
			}
		} catch(Exception ex) {
			System.out.println(ex);
		}
		return fruits;
	}

	public Fruits getFruit(String name) {
		Fruits a = new Fruits();
		try {
			Connection conn = InventoryDB.initializeDatabase();   // Initialized the DB
			java.sql.PreparedStatement st = conn.prepareStatement("select * from inventory where name=?");
			st.setString(1, name);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				a.setName(rs.getString(1));
				a.setQuantity(rs.getInt(2));
			}
		} catch(Exception ex) {
			System.out.println(ex);
		}
		return a;
	}

	public void createFruits(Fruits a1) {
		try {
			Connection conn = InventoryDB.initializeDatabase();   // Initialized the DB
			java.sql.PreparedStatement st = conn.prepareStatement("insert into inventory values(?,?)");
			st.setString(1, a1.getName());
			st.setInt(2, a1.getQuantity());
			st.executeUpdate();
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}

	public void updateFruits(Fruits a1) {
		try {
			Connection conn = InventoryDB.initializeDatabase();   // Initialized the DB
			java.sql.PreparedStatement st = conn.prepareStatement("update inventory set quantity=? where name=?");
			st.setString(2, a1.getName());
			st.setInt(1, a1.getQuantity());
			st.executeUpdate();

		} catch(Exception ex) {
			System.out.println(ex);
		}
	}

	public void deleteFruits(String name) {
		try {
			Connection conn = InventoryDB.initializeDatabase();   // Initialized the DB
			java.sql.PreparedStatement st = conn.prepareStatement("delete from inventory where name=?");
			st.setString(1, name);
			st.executeUpdate();

		} catch(Exception ex) {
			System.out.println(ex);
		}
	}

	public void deleteAll() {
		try {
			Connection conn = InventoryDB.initializeDatabase();   // Initialized the DB
			java.sql.PreparedStatement st = conn.prepareStatement("delete from inventory");
			st.executeUpdate();
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
