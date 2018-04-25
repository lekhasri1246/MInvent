package mm.webapp.db;

import java.io.File;

import org.springframework.stereotype.Service;


@Service("BackupRestoreServiceBean")
public class BackupRestoreService
{
	BackupRestoreService()
	{
		System.out.println("Constructed a BackupRestoreDB instance ..... ok!");
	}
	public boolean backupToLocal(String u, String p, String dbname, String path)
	{
		//EXAMPLE: backupToLocal("root","root","wool_records_db","C:\\backup\\backup.sql");	
		Process process;
		Runtime runtime = Runtime.getRuntime();
		File backupFolder = new File("C:\\backup");
		backupFolder.mkdirs();
		
		try 
		{
			String execString = "mysqldump -u "+u+" -p"+p+" -B "+dbname+" -r "+path;
			System.out.println("Calling: " + execString);
			process = runtime.exec(execString);
			int processComplete = process.waitFor();
			if(processComplete == 0)
			{	
				System.out.println("Backup created successfully!");
				return true;
			}
			else
			{
				System.out.println("Could not create the backup");
				return false;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean restoreFromLocal(String u, String p, String path)
	{
		//EXAMPLE:	Runtime.getRuntime().exec("mysql -u USERNAME -pPASSWORD < C:\\temp\\restore.sql");	
		Process process;
		Runtime runtime = Runtime.getRuntime();
		try
		{
			//mysql -u root -proot --execute "SOURCE C:\\backup\\x.sql"
			String execString = "mysql -u "+u+" -p"+p+" --execute \"SOURCE " + path + "\"";
			System.out.println("Calling: " + execString);
			process = runtime.exec(execString);
			int processComplete = process.waitFor();
			if(processComplete == 0)
			{	
				System.out.println("Restored successfully!");
				return true;
			}
			else
			{
				System.out.println("Could Not Restore");
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
}
