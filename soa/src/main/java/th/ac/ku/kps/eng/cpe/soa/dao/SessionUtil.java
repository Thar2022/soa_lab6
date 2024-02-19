package th.ac.ku.kps.eng.cpe.soa.dao;
import th.ac.ku.kps.eng.cpe.soa.model.*;

import java.sql.SQLException;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
	private static SessionUtil instance = new SessionUtil();
	private SessionFactory sessionFactory;

	public static SessionUtil getInstance() {
		return instance;
	}

	private SessionUtil() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
	}

	public static Session getSession() {
		Session session = getInstance().sessionFactory.openSession();
		return session;
	}

	public static void main(String[] args) throws SQLException {
		CustomerDAO c = new CustomerDAO();
		c.addCustomer(new Customer("S1", new HashSet<Phonenumber>()));
		for (Customer cs : c.getAllCustomers())
			System.out.println(cs.getName());
	}
}