package mm.webapp.controller;

import mm.webapp.db.*;
import mm.webapp.model.*;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
 

@Controller
@SessionAttributes 
@PropertySource("classpath:config.properties")
public class FrontController extends SecurityProvider 
{	
	//Global variables (performance patch)
	@Autowired
	GenericDAO dao;
	@Autowired
	BackupRestoreService backupService;
	
	@Autowired
	private Environment env;
	
	String address;
	String database;
	String username;
	String password;
	String url;
	
	@PostConstruct
	public void init()
	{
		System.out.println("\nIn constructor of the FrontController");
		
		isLoggedIn = false;
		if(dao==null)
			System.out.println("WARNING: dao is null for some reason");
		else
			System.out.println("SUCCESS: dao has be initialized");
		if(backupService==null)
			System.out.println("WARNING: backupService is null for some reason");
		else
			System.out.println("SUCCESS: backupService has be initialized");
		
		//Getting database attributes from properties file
		address = env.getProperty("mysql.address");
		database = env.getProperty("mysql.database");
		username = env.getProperty("mysql.username");
		password = env.getProperty("mysql.password");
		url = "jdbc:mysql://" + address + "/" + database;
		
		
		System.out.println("Successfully initialized the FrontController\n");
	}
	
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public static ModelAndView landing()
	{
		//Return the login-page
		ModelAndView mav = new ModelAndView("login","command",new Admin());
		return mav;
	}
	
	@RequestMapping(value="/doLogin" , method=RequestMethod.POST)
	public ModelAndView doLogin(@Valid Admin admin, ModelMap model)
	{
		System.out.println("At doLogin\n");
		System.out.println("Input is:\n" + admin);
		ModelAndView mav;
		Admin authAdmin = (Admin) dao.retrieve(Admin.class, 1);
		System.out.println("Authorised user is:\n" + authAdmin);
		if(authAdmin.getUserName().equals(admin.getUserName()))
		{
			if(authAdmin.getPassword().equals(admin.getPassword()))
			{
				System.out.println("Credentials verified!");
				isLoggedIn=true;
				mav = new ModelAndView("redirect:/home");
				return mav;
			}
		}
		mav = new ModelAndView("login","command",new Admin());
		return mav;
	}
	
	@RequestMapping(value="/home" , method=RequestMethod.GET)
	public ModelAndView home()
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At home");
		
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}	 
	
	@RequestMapping(value="/backup_restore")
	public ModelAndView backup_restore()
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At backup_restore");
		
		ModelAndView mav = new ModelAndView("backup_restore");
		return mav;
	}
	
	@RequestMapping(value="/doBackup")
	public ModelAndView doBackup(@RequestParam String fileName)
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At doBackup");
		
		ModelAndView mav = new ModelAndView("backup_restore");
		
		System.out.println("Received fileName = " + fileName);
		boolean op_success = backupService.backupToLocal(username, password, database, "C:\\backup\\"+fileName+".sql");
		if(op_success == true)
		{
			mav.addObject("success_message", "Backup can be found at C:\\backup\\" + fileName + ".sql");
			return mav;
		}
		else
		{
			mav.addObject("success_message", "Backup failed");
			return mav;
		}
	}
	
	@RequestMapping(value = "/doRestore", method = RequestMethod.POST)
	public ModelAndView doRestore(@ModelAttribute("uploadForm") FileUploadForm uploadForm)
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At doRestore");
		
		List<MultipartFile> files = uploadForm.getFiles();
		String fileName = "";
		
		ModelAndView mav = new ModelAndView("backup_restore");

		if(files!=null && files.size()>0) 
		{	
			for (MultipartFile file : files)
			{
				System.out.println("Filename is = " + file.getOriginalFilename());
				System.out.println("Size of file = " + file.getSize() + "KB");
				fileName = file.getOriginalFilename();
				//Save the file to a temporary location C:\temp and execute the restore command
				try 
				{
					final InputStream is = file.getInputStream();
					
					//Printing contents of file:
					/*
					StringBuilder sb = new StringBuilder();
					String line = "";
					while((line=br.readLine())!=null)
						sb.append(line+"\n");
					System.out.println(sb.toString());
					*/
					
					//Saving the file to C:\temp\restore.sql
					File restoreFolder = new File("C:\\temp");
					restoreFolder.mkdirs();
					final Path destination = Paths.get("C:\\temp\\restore.sql");
					final Path destinationx = Paths.get("C:\\temp\\restorex.sql");
					
					Files.copy(is, destination, StandardCopyOption.REPLACE_EXISTING);
					Files.copy(is, destinationx, StandardCopyOption.REPLACE_EXISTING);
					System.out.println("Created the restore file on C:\\temp\\");
					
					//Perform the restore operation
					boolean op_success = backupService.restoreFromLocal(username, password, "C:\\temp\\restore.sql");

					//Display a web-page that tells user if restore operation was successful or not.
					if(op_success == true)
					{
						mav.addObject("success_message", "Restored database using file: "+fileName);
						return mav;
					}
					else
					{
						mav.addObject("success_message", "Failed to restore");
						return mav;
					}
				}
				catch (Exception e) 
				{
					e.printStackTrace();
					mav.addObject("success_message", "Encountered an exception");
					return mav;
				}
			}
			mav.addObject("success_message", "Restored database using file: "+fileName);
			return mav;
		}
		else
		{
			mav.addObject("success_message","File is not readable!");
			return mav;
		}
	}


	
	@RequestMapping(value="/settings" , method=RequestMethod.GET)
	public ModelAndView settings()
	{
		//Security Check
		if(isLoggedIn == false)
				return new ModelAndView("login","command",new Admin());
		System.out.println("At settings");
		
		ModelAndView mav = new ModelAndView("settings");
		Admin authUser =  (Admin) dao.retrieve(Admin.class, 1);
		String userIP=authUser.getIP();
		mav.addObject("credentials",authUser);
		mav.addObject("userIP",userIP);
		return mav;
	}
	
	@RequestMapping(value="/changePassword" , method=RequestMethod.GET)
	public ModelAndView changePassword(@RequestParam String p)
	{
		//Security Check
		if(isLoggedIn == false)
				return new ModelAndView("login","command",new Admin());
		System.out.println("At changePassword");
		
		//Update the password
		Admin authUser =  (Admin) dao.retrieve(Admin.class, 1);
		authUser.setPassword(p);
		dao.insertUpdate(authUser);
		
		//Sign-out the user
		isLoggedIn = false;
		
		ModelAndView mav = new ModelAndView("redirect:home");
		return mav;
	}
	
	@RequestMapping(value="/changeIP" , method=RequestMethod.GET)
	public ModelAndView changeIP(@RequestParam String p)
	{
		//Security Check
		if(isLoggedIn == false)
				return new ModelAndView("login","command",new Admin());
		System.out.println("At changeIP");
		
		Admin authUser =  (Admin) dao.retrieve(Admin.class, 1);
		String userIP=authUser.getIP();
		ModelAndView mav = new ModelAndView("redirect:home");
		mav.addObject("userIP",userIP);
		System.out.println("current ip value is "+userIP);
		//Update the IP
				
				authUser.setIP(p);
				dao.insertUpdate(authUser);
				
				//Sign-out the user
				isLoggedIn = false;
				
				
				return mav;
			}
	
	@RequestMapping(value="/log_out" , method=RequestMethod.GET)
	public ModelAndView log_out()
	{
		isLoggedIn = false;
		ModelAndView mav = new ModelAndView("login","command",new Admin());
		mav.addObject("success_message", "You have been logged out.");
		return mav;
	}
}