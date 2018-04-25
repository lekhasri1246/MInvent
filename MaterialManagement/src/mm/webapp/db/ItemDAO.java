package mm.webapp.db;
import java.util.*;

import org.hibernate.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import mm.webapp.db.SessionManager;
import mm.webapp.model.Itemgroup;
import mm.webapp.model.Item;
import mm.webapp.model.Materialcentre;
import mm.webapp.model.Munit;

@Component("ItemDAOBean")
@Scope("singleton")


public class ItemDAO {
	/* Get the sessionFactory object from a SessionFactoryManager class*/
	SessionFactory sessionFactory;

	public ItemDAO() {
		this.sessionFactory = SessionManager.getSessionFactory(); 
		System.out.println("Constructed a Item DAO instance ..... ok!");
	}
	
	@SuppressWarnings("unchecked")
	public List<Itemgroup> getItemgroupList()
	{
		Session session = sessionFactory.openSession();
		ArrayList<Itemgroup> itemgroupArrayList = null;
		
		try
		{
		 session.beginTransaction();
		 itemgroupArrayList = (ArrayList<Itemgroup>) session.createQuery("from Itemgroup").list();
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
		return itemgroupArrayList;
	}

	@SuppressWarnings("unchecked")
	public List<Item> getItemList()
	{
		Session session = sessionFactory.openSession();
		ArrayList<Item> itemArrayList = null;
		
		try
		{
		 session.beginTransaction();
		 itemArrayList = (ArrayList<Item>) session.createQuery("from Item").list();
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
		return itemArrayList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Materialcentre> getMaterialcentreList()
	{
		Session session = sessionFactory.openSession();
		ArrayList<Materialcentre> materialcentreArrayList = null;
		
		try
		{
		 session.beginTransaction();
		 materialcentreArrayList = (ArrayList<Materialcentre>) session.createQuery("from Materialcentre").list();
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
		return materialcentreArrayList;
	}

	@SuppressWarnings("unchecked")
	public List<Munit> getMunitList()
	{
		Session session = sessionFactory.openSession();
		ArrayList<Munit> munitArrayList = null;
		
		try
		{
		 session.beginTransaction();
		 munitArrayList = (ArrayList<Munit>) session.createQuery("from Munit").list();
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
		return munitArrayList;
	}


}





























