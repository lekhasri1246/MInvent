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
import mm.webapp.db.AccountDAO;
import mm.webapp.model.Account;
import mm.webapp.model.AccountDisplay;
import mm.webapp.model.Admin;
import mm.webapp.model.Accountgroup;
import mm.webapp.model.AccountgroupDisplay;

@Controller
@SessionAttributes("Addformobj")
@DependsOn("GenericDAOBean")
public class AccountController extends SecurityProvider{
	//Global variables (performance patch)
	@Autowired
	GenericDAO dao;
	@Autowired
	AccountDAO adao;	
	@PostConstruct
	public void init()
	{
		System.out.println("\nIn constructor of the UserController");
		if(dao==null)
			System.out.println("WARNING: dao is null for some reason");
		else
			System.out.println("SUCCESS: dao has be initialized");
		if(adao==null)
			System.out.println("WARNING: adao is null for some reason");
		else
			System.out.println("SUCCESS: adao has be initialized");
	/*	if(idao==null)
			System.out.println("WARNING: idao is null for some reason");
		else
			System.out.println("SUCCESS: idao has be initialized");
		if(service==null)
			System.out.println("WARNING: service is null for some reason");
		else
			System.out.println("SUCCESS: service has be initialized");*/
		System.out.println("Successfully initialized the UserController\n");
	}
	@RequestMapping(value="/add_AccountGroup" , method=RequestMethod.GET)
	public ModelAndView add_AccountGroup()
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At add_accountgroup");
		
		ModelAndView mav = new ModelAndView("add_AccountGroup");
		mav.addObject("command", new Accountgroup());
		mav.addObject("success_message", "Add a New Account group");
		return mav;
	}
	
	@RequestMapping(value="/add_AccountGroup" , method=RequestMethod.POST)
	public ModelAndView add_AccountGroup(@Valid Accountgroup agroup, BindingResult result)
	{	
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At add account group");
		System.out.println(agroup);
		
		//Return handle
		ModelAndView mav = new ModelAndView("add_AccountGroup");
	
		//Handling form validation errors
		double c=-1;;

		if (result.hasErrors() && agroup!=null)
		 {			 
	         System.out.println("Validation error: BindingResult has errors");
			 System.out.println("Error count = " + result.getErrorCount());
			 List<ObjectError> errlist = result.getAllErrors();
			 for(ObjectError e : errlist)
				 System.out.println(e.getDefaultMessage());
	         System.out.println();
	         
			 
			 mav.addObject("command", agroup);
	         return mav;
	     }
		
		//Add user to database
		if(dao.insertNew(agroup))
			System.out.println("New Account Group added to AccountGroup table");

		mav.addObject("success_message", "AccountGroup added successfully!");
		mav.addObject("command", new Accountgroup());
		return mav;
	}
	
	@RequestMapping(value="/add_Account" , method=RequestMethod.GET )
	public ModelAndView add_Account()
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At add_Account");
		//AccountGroupMap will be used to select account group from a drop-down box
				Map<Integer,String> accountGroupMap= new LinkedHashMap<Integer,String>();
				for(Accountgroup a:adao.getAccountgroupList())
					accountGroupMap.put(a.getId(),a.getGName());
				System.out.println(accountGroupMap);	

		
		ModelAndView mav = new ModelAndView("add_Account");
		mav.addObject("command", new Account());
		mav.addObject("accountGroupMap", accountGroupMap);
			
		return mav;
		}

	@RequestMapping(value="/add_Account" , method=RequestMethod.POST)
	public ModelAndView add_Account(@Valid Account account, BindingResult result)
	{	
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At add account ");
		System.out.println(account);
		ModelAndView mav = new ModelAndView("add_Account");
		//Handling form validation errors
				double c=-1;boolean b=false;
		if (result.hasErrors() && account!=null || b)
		 {			 
	         System.out.println("Validation error: BindingResult has errors");
			 System.out.println("Error count = " + result.getErrorCount());
			 List<ObjectError> errlist = result.getAllErrors();
			 for(ObjectError e : errlist)
				 System.out.println(e.getDefaultMessage());
	         System.out.println();
	         
			 mav.addObject("command", account);
	         return mav;
	     }
		
		//Add user to database
		if(dao.insertNew(account))
			System.out.println("New Account addded to account table");

		mav.addObject("success_message", "New Account added successfully!");
		mav.addObject("command", new Account());
		return mav;
	}
	
	@RequestMapping(value="/account_list" , method=RequestMethod.GET )
	public ModelAndView account_list()
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At account_list");
		
		ModelAndView mav = new ModelAndView("account_list");
		
		//AccountMap will be used to select account from a drop-down box
				Map<Integer,String> accountMap= new LinkedHashMap<Integer,String>();
				for(Account a:adao.getAccountList())
					accountMap.put(a.getId(),a.getAName());
				System.out.println(accountMap);	
		
		mav.addObject("accountMap", accountMap);
		mav.addObject("command", new AccountDisplay());
		
		return mav;
	}
	
	
	
	
	@RequestMapping(value="/modify_account" , method=RequestMethod.GET)
	public ModelAndView modify_account(@RequestParam int id)
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At modify_account");
		
		Account accnt = (Account) dao.retrieve(Account.class, id);
		AccountDisplay accntDisplay =	SupportModules.generateAccountDisplay(accnt) ;
		
		//AccountGroupMap will be used to select account group from a drop-down box
		Map<Integer,String> accountGroupMap= new LinkedHashMap<Integer,String>();
		for(Accountgroup a:adao.getAccountgroupList())
			accountGroupMap.put(a.getId(),a.getGName());
		System.out.println(accountGroupMap);	


		
		ModelAndView mav = new ModelAndView("modify_account");
		mav.addObject("accntId",id);
		mav.addObject("command", accnt);
		mav.addObject("accountGroupMap", accountGroupMap);
		return mav;
	}
	
	@RequestMapping(value="/modify_account" , method=RequestMethod.POST)
	public ModelAndView modify_account(@RequestParam int accntId,AccountDisplay accntDisplay, BindingResult result)
	{
		//Security Check
				if(isLoggedIn == false)
					return new ModelAndView("login","command",new Admin());
				System.out.println("At Modify_account post");
				System.out.println(accntDisplay);
				
				//Transfer
				Account accnt = (Account) dao.retrieve(Account.class, accntId);
				accnt.setAName(accntDisplay.getAName());
				accnt.setGId(accntDisplay.getGId());
				accnt.setAddress(accntDisplay.getAddress());
				accnt.setOpenBalance(accntDisplay.getOpenBalance());
				accnt.setPhone(accntDisplay.getPhone());
				
				//Add Account to database and then to account collection
				if(dao.insertUpdate(accnt))
					System.out.println("Account updated successfully");
				
				//Return handle
				ModelAndView mav = new ModelAndView("modify_account");
				
				List<Account> accntList = adao.getAccountList();
				List<AccountDisplay> accntDisplayList = new ArrayList<AccountDisplay>();
				for(Account act : accntList)
					accntDisplayList.add(SupportModules.generateAccountDisplay(act));
				
				mav.addObject("accounts", accntDisplayList);
				mav.addObject("success_message", "Account updated successfully: " + accnt.getAName());
				mav.addObject("command", accnt);
				return mav;
	}

	
	@RequestMapping(value="/accountgroup_list" , method=RequestMethod.GET )
	public ModelAndView accountgroup_list()
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At accountgroup_list");
		
		ModelAndView mav = new ModelAndView("accountgroup_list");
		
		//AccountMap will be used to select account from a drop-down box
				Map<Integer,String> accountgroupMap= new LinkedHashMap<Integer,String>();
				for(Accountgroup a:adao.getAccountgroupList())
					accountgroupMap.put(a.getId(),a.getGName());
				System.out.println(accountgroupMap);	
		
		mav.addObject("accountgroupMap", accountgroupMap);
		mav.addObject("command", new AccountgroupDisplay());
		
		return mav;
	}

	@RequestMapping(value="/modify_accountgroup" , method=RequestMethod.GET)
	public ModelAndView modify_accountgroup(@RequestParam int id)
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At modify_accountgroup");
		
		Accountgroup accntgrp = (Accountgroup) dao.retrieve(Accountgroup.class, id);
		AccountgroupDisplay accntgrpDisplay =	SupportModules.generateAccountgroupDisplay(accntgrp) ;
		
		
		
		ModelAndView mav = new ModelAndView("modify_accountgroup");
		mav.addObject("accntgrpId",id);
		mav.addObject("command", accntgrp);
		
		return mav;
	}
	
	@RequestMapping(value="/modify_accountgroup" , method=RequestMethod.POST)
	public ModelAndView modify_accountgroup(@RequestParam int accntgrpId,AccountgroupDisplay accntgrpDisplay, BindingResult result)
	{
		//Security Check
				if(isLoggedIn == false)
					return new ModelAndView("login","command",new Admin());
				System.out.println("At modify_accountgroup post");
				System.out.println(accntgrpDisplay);
				
				//Transfer
				Accountgroup accntgrp = (Accountgroup) dao.retrieve(Accountgroup.class, accntgrpId);
				accntgrp.setGName(accntgrpDisplay.getGName());
				accntgrp.setGType(accntgrpDisplay.getGType());
				
				//Add Account to database and then to account collection
				if(dao.insertUpdate(accntgrp))
					System.out.println("Account group updated successfully");
				
				//Return handle
				ModelAndView mav = new ModelAndView("modify_accountgroup");
				
				List<Accountgroup> accntgrpList = adao.getAccountgroupList();
					
				List<AccountgroupDisplay> accntgrpDisplayList = new ArrayList<AccountgroupDisplay>();
				for(Accountgroup act : accntgrpList)
					accntgrpDisplayList.add(SupportModules.generateAccountgroupDisplay(act));
				
				mav.addObject("accountgroups", accntgrpDisplayList);
				mav.addObject("success_message", "Account group updated successfully: " + accntgrp.getGName());
				mav.addObject("command", accntgrp);
				return mav;
	}


}
