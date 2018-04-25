package mm.webapp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import mm.webapp.db.GenericDAO;
import mm.webapp.db.MUserDAO;
import mm.webapp.model.Admin;
import mm.webapp.model.MUser;

@Controller
@SessionAttributes("Addformobj")
@DependsOn("GenericDAOBean")
public class UserController extends SecurityProvider 
{
	//Global variables (performance patch)
	@Autowired
	GenericDAO dao;
//	@Autowired
//	MUserDAO mdao;
//	@Autowired
//	ItemDAO idao;
//	@Autowired
//	DataService service;
	
	@PostConstruct
	public void init()
	{
		System.out.println("\nIn constructor of the UserController");
		if(dao==null)
			System.out.println("WARNING: dao is null for some reason");
		else
			System.out.println("SUCCESS: dao has be initialized");
	/*	if(mdao==null)
			System.out.println("WARNING: mdao is null for some reason");
		else
			System.out.println("SUCCESS: tdao has be initialized");
		if(idao==null)
			System.out.println("WARNING: idao is null for some reason");
		else
			System.out.println("SUCCESS: idao has be initialized");
		if(service==null)
			System.out.println("WARNING: service is null for some reason");
		else
			System.out.println("SUCCESS: service has be initialized");*/
		System.out.println("Successfully initialized the UserController\n");
	}
	
	
	
	@RequestMapping(value="/add_user" , method=RequestMethod.GET)
	public ModelAndView add_user()
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At add_user");
		
		ModelAndView mav = new ModelAndView("add_user");
		mav.addObject("command", new MUser());
		mav.addObject("success_message", "Add a New User");
		return mav;
	}
	
	@RequestMapping(value="/add_user" , method=RequestMethod.POST)
	public ModelAndView add_user(@Valid MUser muser, BindingResult result)
	{	
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At addUser");
		System.out.println(muser);
		
		//Return handle
		ModelAndView mav = new ModelAndView("add_user");
	
		//Handling form validation errors
		double c=-1;boolean b=false;
/*		try{
				c = new Double(MUser.getCommission()).doubleValue();
				if(c<0||c>100)
				{
					b=true;
					mav.addObject("commission_error", "Please enter a commission value between 0 and 100");
					System.out.println(c);
				}
			}
		catch(Exception e)
		{
			b=true;
			mav.addObject("commission_error", "Please enter a valid commission");
			System.out.println(e);
		}*/ 
		if (result.hasErrors() && muser!=null || b)
		 {			 
	         System.out.println("Validation error: BindingResult has errors");
			 System.out.println("Error count = " + result.getErrorCount());
			 List<ObjectError> errlist = result.getAllErrors();
			 for(ObjectError e : errlist)
				 System.out.println(e.getDefaultMessage());
	         System.out.println();
	         
			 //Providing the view with useful error messages
			 /*if(MUser.getName().length()<3 || MUser.getName().length()>100)
				 mav.addObject("name_error", "Name must be between 3 and 100 characters long");
			 
			 if(MUser.getAddress().length()<3 || MUser.getAddress().length()>100)
				 mav.addObject("address_error", "Address must be between 3 and 100 characters long");
			 
			 if(MUser.getPhone().length()<10 || MUser.getPhone().length()>20 )
				 mav.addObject("phone_error", "Phone number must contain between 10 and 20 digits");*/

			 mav.addObject("command", muser);
	         return mav;
	     }
		
		//Add user to database
		if(dao.insertNew(muser))
			System.out.println("New user added to MUser table");

		mav.addObject("success_message", "User added successfully!");
		mav.addObject("command", new MUser());
		return mav;
	}
	

	@RequestMapping(value="/edit_user" , method=RequestMethod.GET)
	public ModelAndView edit_user(@RequestParam String userId)
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At edit_user");
		System.out.println("@RequestParam = " + userId);
		
		MUser muser = (MUser) dao.retrieve(MUser.class,Integer.parseInt(userId));
		System.out.println(muser);
		
		ModelAndView mav = new ModelAndView("edit_user");
		mav.addObject("userId", userId);
		mav.addObject("command", muser);
		mav.addObject("success_message","Edit Details for User");
		return mav;
	}
	
	@RequestMapping(value="/edit_user" , method=RequestMethod.POST)
	public ModelAndView edit_user(@RequestParam String userId, @Valid MUser muser, BindingResult result)
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At editUser");
		System.out.println(muser);
		
		//Return handle
		ModelAndView mav = new ModelAndView();
			
		//Handling form validation errors
		double c=-1;boolean b=false;
/*	try
		{
			c = new Double(MUser.getCommission()).doubleValue();
			if(c<0||c>100)
			{
				b=true;
				mav.addObject("commission_error", "Please enter a commission value between 0 and 100");
				System.out.println(c);
			}
		}
		catch(Exception e)
		{
			b=true;
			mav.addObject("commission_error", "Please enter a valid commission");
			System.out.println(e);
		} */
		if (result.hasErrors() && muser!=null || b)
		{
			System.out.println("Validation error: BindingResult has errors");
			System.out.println("Error count = " + result.getErrorCount());
			List<ObjectError> errlist = result.getAllErrors();
			for(ObjectError e : errlist)
				System.out.println(e.getDefaultMessage());
			System.out.println();
			
			//Providing the view with useful error messages
			/*if(MUser.getName().length()<3 || MUser.getName().length()>100)
				 mav.addObject("name_error", "Name must be between 3 and 100 characters long");
					 
			if(MUser.getAddress().length()<3 || MUser.getAddress().length()>100)
				 mav.addObject("address_error", "Address must be between 3 and 100 characters long");
					 
			if(MUser.getPhone().length()<10 || MUser.getPhone().length()>20 )
				 mav.addObject("phone_error", "Phone number must contain between 10 and 20 digits");*/
			
			mav.addObject("userId", userId);
			mav.addObject("command", muser);
			mav.addObject("param", userId);
			mav.setViewName("edit_user");
			
			return mav;
		}
		
		//Put edited user into database
		MUser mr = (MUser) dao.retrieve(MUser.class, Integer.parseInt(userId));
		
		
		mr.setUsername(muser.getUsername());
		mr.setPassword(muser.getPassword());
		mr.setVoucherPermissionModify(muser.getVoucherPermissionModify());
		mr.setVoucherPermissionDelete(muser.getVoucherPermissionDelete());
		mr.setAdministrationPref(muser.getAdministrationPref());
		mr.setTranasctionPref(muser.getTranasctionPref());
		mr.setDisplayPref(muser.getDisplayPref());
		
		if(dao.insertUpdate(mr))
			System.out.println("User successfully updated: " + muser.getUsername());
			
		mav.addObject("userId", userId);
		mav.addObject("command", muser);
		mav.addObject("param", userId);
		mav.setViewName("edit_user");
		mav.addObject("success_message", "User edited successfully!");
		
		return mav;
	}
	
	
	
}
