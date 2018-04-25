package mm.webapp.db;
import java.util.*;

import org.hibernate.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import mm.webapp.model.MUser;
import mm.webapp.db.SessionManager;



@Component("MUserDAOBean")
@Scope("singleton")
public class MUserDAO 
{
	/* Get the sessionFactory object from a SessionFactoryManager class*/
	SessionFactory sessionFactory;
	
	public MUserDAO()
	{
		this.sessionFactory = SessionManager.getSessionFactory(); 
		System.out.println("Constructed a MUserDAO instance ..... ok!");
	}
	
	
	@SuppressWarnings("unchecked")
	public List<MUser> getMUserList()
	{
		Session session = sessionFactory.openSession();
		ArrayList<MUser> MUserArrayList = null;
		
		try
		{
		 session.beginTransaction();
		 MUserArrayList = (ArrayList<MUser>) session.createQuery("from MUser").list();
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
		return MUserArrayList;
	}
}