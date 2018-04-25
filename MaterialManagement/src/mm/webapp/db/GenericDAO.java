package mm.webapp.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("GenericDAOBean")
@Scope("singleton")
public class GenericDAO 
{
	/* Get the sessionFactory object from a SessionFactoryManager class*/
	SessionFactory sessionFactory;

	public static int accessCount = 0;

	public GenericDAO() 
	{
		this.sessionFactory = SessionManager.getSessionFactory();
		System.out.println("Constructed a GenericDAO instance ..... ok!");
	}
	
	public Boolean insertNew(Object pObj)
	{
		debug();
		Session session = sessionFactory.openSession();

		try 
		{
			session.beginTransaction();
			session.save(pObj);
			session.getTransaction().commit();
			session.close();
		}
		catch (org.hibernate.exception.ConstraintViolationException cve) 
		{
			// Roll back
			session.getTransaction().rollback();
			session.close();
			// Stack trace not required //e.printStackTrace();
			System.out.println("Caught ConstraintViolationException");
			System.out.println("Had to rollback! . . . Everything is fine");
			return false;
		}
		catch (Exception e)
		{
			// Roll back
			if (session != null)
			{
				session.getTransaction().rollback();
				System.out.println("Transaction rollbacked!");
				if (session.isOpen())
				{
					session.close();
					System.out.println("Session Closed");
				}
				else
					System.out.println("\nIt seems that session is not open in the first place\n");
			}
			else
				System.out.println("\nIt seems that session == null\n");

			System.out.println("Here is the stack-trace for caught exception:");
			System.out.println("**************************************************");
			e.printStackTrace();
			System.out.println("**************************************************");
			return false;
		}
		return true;
	}

	// Inserts or Updates the give
	public Boolean insertUpdate(Object pObj) 
	{
		debug();
		Session session = sessionFactory.openSession();

		try
		{
			session.beginTransaction();
			session.saveOrUpdate(pObj);
			session.getTransaction().commit();
			session.close();
		}

		catch (Exception e)
		{
			// Roll back
			if (session != null)
			{
				session.getTransaction().rollback();
				System.out.println("Transaction rollbacked!");
				if (session.isOpen())
				{
					session.close();
					System.out.println("Session Closed");
				}
				else
					System.out.println("\nIt seems that session is not open in the first place\n");
			}
			else
				System.out.println("\nIt seems that session == null\n");

			System.out.println("Here is the stack-trace for caught exception:");
			System.out.println("**************************************************");
			e.printStackTrace();
			System.out.println("**************************************************");
			return false;
		}
		return true;
	}

	// Just to check if Object with given pKey exists (String primary key)
	public Boolean isExist(Class<?> className, String pKey)
	{
		debug();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Object retObject = session.get(className, pKey);
		session.close();
		if (retObject == null)
			return false;
		else
			return true;
	}

	// Just to check if Object with given pKey exists (Integer primary key)
	public Boolean isExist(Class<?> className, int pKey)
	{
		debug();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Object retObject = session.get(className, pKey);
		session.close();
		if (retObject == null)
			return false;
		else
			return true;
	}

	// Retrieve object with given primary key (String primary key)
	public Object retrieve(Class<?> className, String pKey)
	{
		debug();
		Session session = sessionFactory.openSession();

		Object retObject = null;
		try
		{
			session.beginTransaction();
			retObject = session.get(className, pKey);
			session.getTransaction().commit();
			session.close();
		}
		catch (Exception e)
		{
			// Roll back
			if (session != null)
			{
				session.getTransaction().rollback();
				System.out.println("Transaction rollbacked!");
				if (session.isOpen())
				{
					session.close();
					System.out.println("Session Closed");
				}
				else
					System.out.println("\nIt seems that session is not open in the first place\n");
			}
			else
				System.out.println("\nIt seems that session == null\n");

			System.out.println("Here is the stack-trace for caught exception:");
			System.out.println("**************************************************");
			e.printStackTrace();
			System.out.println("**************************************************");
			return null;
		}
		return retObject;
	}

	// Retrieve object with given primary key (Integer primary key)
	public Object retrieve(Class<?> className, int pKey)
	{
		debug();
		Session session = sessionFactory.openSession();

		Object retObject = null;
		try
		{
			session.beginTransaction();
			retObject = session.get(className, pKey);
			session.getTransaction().commit();
			session.close();
		} 
		catch (Exception e)
		{
			// Roll back
			if (session != null)
			{
				session.getTransaction().rollback();
				System.out.println("Transaction rollbacked!");
				if (session.isOpen()) 
				{
					session.close();
					System.out.println("Session Closed");
				} 
				else
					System.out.println("\nIt seems that session is not open in the first place\n");
			} 
			else
				System.out.println("\nIt seems that session == null\n");

			System.out.println("Here is the stack-trace for caught exception:");
			System.out.println("**************************************************");
			e.printStackTrace();
			System.out.println("**************************************************");
			return null;
		}
		return retObject;
	}

	// Removes given object from database
	public Boolean remove(Object pObj)
	{
		debug();
		Session session = sessionFactory.openSession();

		try
		{
			session.beginTransaction();
			session.delete(pObj);
			session.getTransaction().commit();
			session.close();
		}
		catch (Exception e) 
		{
			// Roll back
			session.getTransaction().rollback();
			session.close();
			e.printStackTrace();
			System.out.println("Had to rollback!");
			return false;
		}
		return true;
	}
	
	// Get session factory, to perform custom fetch / write
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	
	// Set session factory, to perform custom fetch / write
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	// Debug operations
	public void debug() 
	{
		accessCount++;
		// System.out.println("Total number of access to DAO = " + accessCount);
	}

}