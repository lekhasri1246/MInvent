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
import mm.webapp.db.ItemDAO;
import mm.webapp.model.Item;
import mm.webapp.model.Account;
import mm.webapp.model.AccountDisplay;
import mm.webapp.model.Accountgroup;
import mm.webapp.model.AccountgroupDisplay;
import mm.webapp.model.Admin;
import mm.webapp.model.Itemgroup;
import mm.webapp.model.ItemgroupDisplay;
import mm.webapp.model.ItemDisplay;
import mm.webapp.model.Materialcentre;
import mm.webapp.model.MaterialcentreDisplay;
import mm.webapp.model.Munit;
import mm.webapp.model.MunitDisplay;


@Controller
@DependsOn("GenericDAOBean")
public class ItemController extends SecurityProvider {
	@Autowired
	GenericDAO dao;
	@Autowired
	ItemDAO idao;	
	@PostConstruct
	public void init()
	{
		System.out.println("\nIn constructor of the UserController");
		if(dao==null)
			System.out.println("WARNING: dao is null for some reason");
		else
			System.out.println("SUCCESS: dao has be initialized");
		if(idao==null)
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
		System.out.println("Success`fully initialized the UserController\n");
	}
	@RequestMapping(value="/add_ItemGroup" , method=RequestMethod.GET)
	public ModelAndView add_ItemGroup()
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At add_ItemGroup");
		
		ModelAndView mav = new ModelAndView("add_ItemGroup");
		mav.addObject("command", new Itemgroup());
		mav.addObject("success_message", "Add a New Item group");
		return mav;
	}
	
	@RequestMapping(value="/add_ItemGroup" , method=RequestMethod.POST)
	public ModelAndView add_ItemGroup(@Valid Itemgroup igroup, BindingResult result)
	{	
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At add Item group");
		System.out.println(igroup);
		
		//Return handle
		ModelAndView mav = new ModelAndView("add_ItemGroup");
	
		//Handling form validation errors
		double c=-1;boolean b=false;
		if (result.hasErrors() && igroup!=null || b)
		 {			 
	         System.out.println("Validation error: BindingResult has errors");
			 System.out.println("Error count = " + result.getErrorCount());
			 List<ObjectError> errlist = result.getAllErrors();
			 for(ObjectError e : errlist)
				 System.out.println(e.getDefaultMessage());
	         System.out.println();
	         
			 mav.addObject("command", igroup);
	         return mav;
	     }
		
		//Add user to database
		if(dao.insertNew(igroup))
			System.out.println("New Item Group added to ItemGroup table");

		mav.addObject("success_message", "ItemGroup added successfully!");
		mav.addObject("command", new Itemgroup());
		return mav;
	}

	@RequestMapping(value="/add_item" , method=RequestMethod.GET )
	public ModelAndView add_item()
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At add_item");
		//ItemGroupMap will be used to select Item group from a drop-down box
				Map<Integer,String> itemGroupMap= new LinkedHashMap<Integer,String>();
				for(Itemgroup i:idao.getItemgroupList())
					itemGroupMap.put(i.getId(),i.getIGName());
				System.out.println(itemGroupMap);	

		
		ModelAndView mav = new ModelAndView("add_item");
		mav.addObject("command", new Item());
		mav.addObject("itemGroupMap", itemGroupMap);
			
		return mav;
		}

	@RequestMapping(value="/add_item" , method=RequestMethod.POST)
	public ModelAndView add_item(@Valid Item item, BindingResult result)
	{	
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At add Item ");
		System.out.println(item);
		ModelAndView mav = new ModelAndView("add_item");
		//Handling form validation errors
				double c=-1;boolean b=false;
		if (result.hasErrors() && item!=null || b)
		 {			 
	         System.out.println("Validation error: BindingResult has errors");
			 System.out.println("Error count = " + result.getErrorCount());
			 List<ObjectError> errlist = result.getAllErrors();
			 for(ObjectError e : errlist)
				 System.out.println(e.getDefaultMessage());
	         System.out.println();
	         
			 mav.addObject("command", item);
	         return mav;
	     }
		
		//Add user to database
		if(dao.insertNew(item))
			System.out.println("New Item addded to Item table");

		mav.addObject("success_message", "New Item added successfully!");
		mav.addObject("command", new Item());
		return mav;
	}
	
	@RequestMapping(value="/itemgroup_list" , method=RequestMethod.GET )
	public ModelAndView itemgroup_list()
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At itemgroup_list");
		
		ModelAndView mav = new ModelAndView("itemgroup_list");
		
		//AccountMap will be used to select account from a drop-down box
				Map<Integer,String> itemgroupMap= new LinkedHashMap<Integer,String>();
				for(Itemgroup i:idao.getItemgroupList())
					itemgroupMap.put(i.getId(),i.getIGName());
							
				System.out.println(itemgroupMap);	
		
		mav.addObject("itemgroupMap", itemgroupMap);
		mav.addObject("command", new ItemgroupDisplay());
		
		return mav;
	}
	
	@RequestMapping(value="/modify_itemgroup" , method=RequestMethod.GET)
	public ModelAndView modify_itemgroup(@RequestParam int id)
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At modify_itemgroup");
		
		Itemgroup ig = (Itemgroup) dao.retrieve(Itemgroup.class, id);
		ItemgroupDisplay igDisplay =	SupportModules.generateItemgroupDisplay(ig) ;
		
				
		ModelAndView mav = new ModelAndView("modify_itemgroup");
		mav.addObject("igId",id);
		mav.addObject("command", ig);
	
		return mav;
	}

	@RequestMapping(value="/modify_itemgroup" , method=RequestMethod.POST)
	public ModelAndView modify_itemgroup(@RequestParam int igId,ItemgroupDisplay igDisplay, BindingResult result)
	{
		//Security Check
				if(isLoggedIn == false)
					return new ModelAndView("login","command",new Admin());
				System.out.println("At modify_itemgroup post");
				System.out.println(igDisplay);
				
				//Transfer
				Itemgroup ig = (Itemgroup) dao.retrieve(Itemgroup.class, igId);
				ig.setIGName(igDisplay.getIGName());
	
				
				//Add Materialcentre to database and then to Item collection
				if(dao.insertUpdate(ig))
					System.out.println("Itemgroup updated successfully");
				
				//Return handle
				ModelAndView mav = new ModelAndView("modify_itemgroup");
				
				List<Itemgroup> igList = idao.getItemgroupList();
				List<ItemgroupDisplay> igDisplayList = new ArrayList<ItemgroupDisplay>();
				for(Itemgroup itemgroup : igList)
					igDisplayList.add(SupportModules.generateItemgroupDisplay(itemgroup));
				
				mav.addObject("itemgroups", igDisplayList);
				mav.addObject("success_message", "Itemgroup updated successfully: " + ig.getIGName());
		
				mav.addObject("command", ig);
				return mav;
	}
	
	
	@RequestMapping(value="/item_list" , method=RequestMethod.GET )
	public ModelAndView item_list()
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At item_list");
		
		ModelAndView mav = new ModelAndView("item_list");
		
		//AccountMap will be used to select account from a drop-down box
				Map<Integer,String> itemMap= new LinkedHashMap<Integer,String>();
				for(Item i:idao.getItemList())
					itemMap.put(i.getId(),i.getIName());
							
				System.out.println(itemMap);	
		
		mav.addObject("itemMap", itemMap);
		mav.addObject("command", new ItemDisplay());
		
		return mav;
	}

	@RequestMapping(value="/modify_item" , method=RequestMethod.GET)
	public ModelAndView modify_item(@RequestParam int id)
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At modify_item");
		
		Item itm = (Item) dao.retrieve(Item.class, id);
		ItemDisplay itmDisplay =	SupportModules.generateItemDisplay(itm) ;
		
		//AccountGroupMap will be used to select account group from a drop-down box
		Map<Integer,String> itemGroupMap= new LinkedHashMap<Integer,String>();
		for(Itemgroup i:idao.getItemgroupList())
			itemGroupMap.put(i.getId(),i.getIGName());
				
		System.out.println(itemGroupMap);	


		
		ModelAndView mav = new ModelAndView("modify_item");
		mav.addObject("itemId",id);
		mav.addObject("command", itm);
		mav.addObject("itemGroupMap", itemGroupMap);
		return mav;
	}
	
	@RequestMapping(value="/modify_item" , method=RequestMethod.POST)
	public ModelAndView modify_item(@RequestParam int itemId,ItemDisplay itmDisplay, BindingResult result)
	{
		//Security Check
				if(isLoggedIn == false)
					return new ModelAndView("login","command",new Admin());
				System.out.println("At Modify_item post");
				System.out.println(itmDisplay);
				
				//Transfer
				Item itm = (Item) dao.retrieve(Item.class, itemId);
				itm.setIGid(itmDisplay.getIGid());
				itm.setIName(itmDisplay.getIName());
				itm.setItemdesc(itmDisplay.getItemdesc());
				itm.setOpeningStock(itmDisplay.getOpeningStock());
				itm.setUnitsType(itmDisplay.getUnitsType());
				
				//Add Item to database and then to Item collection
				if(dao.insertUpdate(itm))
					System.out.println("Item updated successfully");
				
				//Return handle
				ModelAndView mav = new ModelAndView("modify_item");
				
				List<Item> itmList = idao.getItemList();
				List<ItemDisplay> itmDisplayList = new ArrayList<ItemDisplay>();
				for(Item item : itmList)
					itmDisplayList.add(SupportModules.generateItemDisplay(item));
				
				mav.addObject("items", itmDisplayList);
				mav.addObject("success_message", "Item updated successfully: " + itm.getIName());
		
				mav.addObject("command", itm);
				return mav;
	}

	@RequestMapping(value="/add_materialcentre" , method=RequestMethod.GET )
	public ModelAndView add_materialcentre()
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At add_materialcentre");
		
		
		ModelAndView mav = new ModelAndView("add_materialcentre");
		mav.addObject("command", new Materialcentre());

			
		return mav;
		}	
	
	@RequestMapping(value="/add_materialcentre" , method=RequestMethod.POST)
	public ModelAndView add_materialcentre(@Valid Materialcentre mc, BindingResult result)
	{	
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At add material centre ");
		System.out.println(mc);
		ModelAndView mav = new ModelAndView("add_materialcentre");
		//Handling form validation errors
				double c=-1;boolean b=false;
		if (result.hasErrors() && mc!=null || b)
		 {			 
	         System.out.println("Validation error: BindingResult has errors");
			 System.out.println("Error count = " + result.getErrorCount());
			 List<ObjectError> errlist = result.getAllErrors();
			 for(ObjectError e : errlist)
				 System.out.println(e.getDefaultMessage());
	         System.out.println();
	         
			 mav.addObject("command", mc);
	         return mav;
	     }
		
		//Add user to database
		if(dao.insertNew(mc))
			System.out.println("New material centre addded to material_centre table");

		mav.addObject("success_message", "New material centre added successfully!");
		mav.addObject("command", new Materialcentre());
		return mav;
	}
	
	@RequestMapping(value="/materialcentre_list" , method=RequestMethod.GET )
	public ModelAndView materialcentre_list()
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At materialcentre_list");
		
		ModelAndView mav = new ModelAndView("materialcentre_list");
		
		//AccountMap will be used to select account from a drop-down box
				Map<Integer,String> materialMap= new LinkedHashMap<Integer,String>();
				for(Materialcentre i:idao.getMaterialcentreList())
					materialMap.put(i.getId(),i.getName());
							
				System.out.println(materialMap);	
		
		mav.addObject("materialMap", materialMap);
		mav.addObject("command", new MaterialcentreDisplay());
		
		return mav;
	}

	@RequestMapping(value="/modify_materialcentre" , method=RequestMethod.GET)
	public ModelAndView modify_materialcentre(@RequestParam int id)
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At modify_materialcentre");
		
		Materialcentre mc = (Materialcentre) dao.retrieve(Materialcentre.class, id);
		MaterialcentreDisplay mcDisplay =	SupportModules.generateMaterialcentreDisplay(mc) ;
		
				
		ModelAndView mav = new ModelAndView("modify_materialcentre");
		mav.addObject("mcId",id);
		mav.addObject("command", mc);
	
		return mav;
	}

	@RequestMapping(value="/modify_materialcentre" , method=RequestMethod.POST)
	public ModelAndView modify_materialcentre(@RequestParam int mcId,MaterialcentreDisplay mcDisplay, BindingResult result)
	{
		//Security Check
				if(isLoggedIn == false)
					return new ModelAndView("login","command",new Admin());
				System.out.println("At modify_materialcentre post");
				System.out.println(mcDisplay);
				
				//Transfer
				Materialcentre mc = (Materialcentre) dao.retrieve(Materialcentre.class, mcId);
				mc.setName(mcDisplay.getName());
				mc.setStock_Account(mcDisplay.getStock_Account());
				mc.setTransfered(mcDisplay.getTransfered());
				mc.setAddress(mcDisplay.getAddress());
				
				//Add Materialcentre to database and then to Item collection
				if(dao.insertUpdate(mc))
					System.out.println("Material centre updated successfully");
				
				//Return handle
				ModelAndView mav = new ModelAndView("modify_materialcentre");
				
				List<Materialcentre> mcList = idao.getMaterialcentreList();
				List<MaterialcentreDisplay> mcDisplayList = new ArrayList<MaterialcentreDisplay>();
				for(Materialcentre material : mcList)
					mcDisplayList.add(SupportModules.generateMaterialcentreDisplay(material));
				
				mav.addObject("materialcentres", mcDisplayList);
				mav.addObject("success_message", "Material centre updated successfully: " + mc.getName());
		
				mav.addObject("command", mc);
				return mav;
	}
	
	@RequestMapping(value="/add_munit" , method=RequestMethod.GET )
	public ModelAndView add_munit()
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At add_munit");
		
		
		ModelAndView mav = new ModelAndView("add_munit");
		mav.addObject("command", new Munit());

			
		return mav;
		}	

	@RequestMapping(value="/add_munit" , method=RequestMethod.POST)
	public ModelAndView add_munit(@Valid Munit munit, BindingResult result)
	{	
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At add Munit");
		System.out.println(munit);
		ModelAndView mav = new ModelAndView("add_munit");
		//Handling form validation errors
				double c=-1;boolean b=false;
		if (result.hasErrors() && munit!=null || b)
		 {			 
	         System.out.println("Validation error: BindingResult has errors");
			 System.out.println("Error count = " + result.getErrorCount());
			 List<ObjectError> errlist = result.getAllErrors();
			 for(ObjectError e : errlist)
				 System.out.println(e.getDefaultMessage());
	         System.out.println();
	         
			 mav.addObject("command", munit);
	         return mav;
	     }
		
		//Add user to database
		if(dao.insertNew(munit))
			System.out.println("New Unit addded to MUnit table");

		mav.addObject("success_message", "New Unit added successfully!");
		mav.addObject("command", new Munit());
		return mav;
	}
	

	@RequestMapping(value="/munit_list" , method=RequestMethod.GET )
	public ModelAndView munit_list()
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At munit_list");
		
		ModelAndView mav = new ModelAndView("munit_list");
		
		//MunitMap will be used to select account from a drop-down box
				Map<Integer,String> munitMap= new LinkedHashMap<Integer,String>();
				for(Munit i:idao.getMunitList())
					munitMap.put(i.getId(),i.getName());
							
				System.out.println(munitMap);	
		
		mav.addObject("munitMap", munitMap);
		mav.addObject("command", new MunitDisplay());
		
		return mav;
	}
	@RequestMapping(value="/modify_munit" , method=RequestMethod.GET)
	public ModelAndView modify_munit(@RequestParam int id)
	{
		//Security Check
		if(isLoggedIn == false)
			return new ModelAndView("login","command",new Admin());
		System.out.println("At modify_munit");
		
		Munit munit = (Munit) dao.retrieve(Munit.class, id);
		MunitDisplay munitDisplay =	SupportModules.generateMunitDisplay(munit) ;
		
				
		ModelAndView mav = new ModelAndView("modify_munit");
		mav.addObject("munitId",id);
		mav.addObject("command", munit);
	
		return mav;
	}
	
	
	@RequestMapping(value="/modify_munit" , method=RequestMethod.POST)
	public ModelAndView modify_munit(@RequestParam int munitId,MunitDisplay muDisplay, BindingResult result)
	{
		//Security Check
				if(isLoggedIn == false)
					return new ModelAndView("login","command",new Admin());
				System.out.println("At modify_munit post");
				System.out.println(muDisplay);
				
				//Transfer
				Munit munit = (Munit) dao.retrieve(Munit.class, munitId);
				munit.setName(muDisplay.getName());
				munit.setComments(muDisplay.getComments());
				
				//Add Materialcentre to database and then to Item collection
				if(dao.insertUpdate(munit))
					System.out.println("Unit updated successfully");
				
				//Return handle
				ModelAndView mav = new ModelAndView("modify_munit");
				
				List<Munit> mList = idao.getMunitList();
				List<MunitDisplay> mDisplayList = new ArrayList<MunitDisplay>();
				for(Munit mn : mList)
					mDisplayList.add(SupportModules.generateMunitDisplay(mn));
				
				mav.addObject("munits", mDisplayList);
				mav.addObject("success_message", "Unit updated successfully: " + munit.getName());
		
				mav.addObject("command", munit);
				return mav;
	}
	


}
