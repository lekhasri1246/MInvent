package mm.webapp.db;
import java.util.*;

import org.hibernate.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import mm.webapp.model.Accountgroup;
import mm.webapp.model.Account;
import mm.webapp.db.SessionManager;


@Component("AccountDAOBean")
@Scope("singleton")
public class AccountDAO {

	/* Get the sessionFactory object from a SessionFactoryManager class*/
	SessionFactory sessionFactory;

	public AccountDAO() {
		this.sessionFactory = SessionManager.getSessionFactory(); 
		System.out.println("Constructed a Account DAO instance ..... ok!");
	}
	@SuppressWarnings("unchecked")
	public List<Accountgroup> getAccountgroupList()
	{
		Session session = sessionFactory.openSession();
		ArrayList<Accountgroup> accountgroupArrayList = null;
		
		try
		{
		 session.beginTransaction();
		 accountgroupArrayList = (ArrayList<Accountgroup>) session.createQuery("from Accountgroup").list();
		 session.getTransaction().commit();	 
		 session.close();
		}

		catch(Exception e)
		{
			//Roll back
			if(session!=null)
			{
				session.getTransaction().rollback();
				System.out.println("Transaction rollbacked!");
				if(session.isOpen())
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
		}
		return accountgroupArrayList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Account> getAccountList()
	{
		Session session = sessionFactory.openSession();
		ArrayList<Account> accountArrayList = null;
		
		try
		{
		 session.beginTransaction();
		 accountArrayList = (ArrayList<Account>) session.createQuery("from Account").list();
		 session.getTransaction().commit();	 
		 session.close();
		}

		catch(Exception e)
		{
			//Roll back
			if(session!=null)
			{
				session.getTransaction().rollback();
				System.out.println("Transaction rollbacked!");
				if(session.isOpen())
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
		}
		return accountArrayList;
	}

	
}
