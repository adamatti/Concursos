package jpa;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import samples.jpa.SampleJPA;
public class DBTest {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	@Before
	public void setUp() throws Exception {
		//LogManager.getLogManager().setLevel("org.hibernate", Level.WARNING);
	}
	@Test
	public void testJPA() throws Throwable {		
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("local.hsqldb");
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			SampleJPA e= new SampleJPA();
			e.setTitle("Marcelo");
			em.persist(e);
			e.setTitle("Adamatti");
			em.remove(e);
			
			e = em.find(SampleJPA.class, new Long(1));
			e.setTitle("Pittigliani2");
			
			tx.commit();
			em.close();
			emf.close();
		} catch (Throwable t){
			t.printStackTrace();
			throw t;
		}
	}
	@Test
	public void testHSQLDB() throws Throwable{
		try {
			Class.forName("org.hsqldb.jdbcDriver").newInstance();
	        Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/jboss", "sa", "SA");
	        PreparedStatement ps = conn.prepareStatement("select * from Test");
	        //ResultSet rs = ps.executeQuery();
	        //rs.close();
	        ps.close();
	        conn.close();
		} catch (Throwable t){
			t.printStackTrace();
			throw t;
		}
	}
	@Test
	public void testMYSQL() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jboss", "root", "java");
        PreparedStatement ps = conn.prepareStatement("select * from Test");
        //ResultSet rs = ps.executeQuery();
        //rs.close();
        ps.close();
        conn.close();
	}
}
