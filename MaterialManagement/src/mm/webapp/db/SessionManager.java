package mm.webapp.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager
{
	static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	SessionManager()
	{
		System.out.println("In constructor of SessionManager");
	}
	
	public static SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) 
	{
		SessionManager.sessionFactory = sessionFactory;
	}
	
	public static void inValidateSessionFactory()
	{
		SessionManager.sessionFactory.close();
	}
	
	public static void reOpenSessionFactory()
	{
		SessionManager.sessionFactory = new Configuration().configure().buildSessionFactory();
	}
}