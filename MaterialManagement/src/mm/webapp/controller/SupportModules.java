package mm.webapp.controller;

import java.sql.Date;
import java.util.Calendar;

import mm.webapp.model.*;

public class SupportModules {
	
	public static AccountDisplay generateAccountDisplay(Account acnt)
	{
		AccountDisplay display = new AccountDisplay();
		display.setAName(acnt.getAName());		
		display.setGId(acnt.getGId());
		display.setAddress(acnt.getAddress());
		display.setOpenBalance(acnt.getOpenBalance());
		display.setPhone(acnt.getPhone());
		display.setId(acnt.getId());
		
		return display;
	}
	
	public static AccountgroupDisplay generateAccountgroupDisplay(Accountgroup acntgrp)
	{
		AccountgroupDisplay display = new AccountgroupDisplay();
		display.setGName(acntgrp.getGName());
		display.setGType(acntgrp.getGType());
			
		display.setId(acntgrp.getId());
		
		return display;
	}

	public static ItemDisplay generateItemDisplay(Item itm)
	{
		ItemDisplay display = new ItemDisplay();
		display.setId(itm.getId());
		display.setIGid(itm.getIGid());
		display.setIName(itm.getIName());
		display.setItemdesc(itm.getItemdesc());
		display.setOpeningStock(itm.getOpeningStock());
		display.setUnitsType(itm.getUnitsType());
			
		return display;
	}
	
	public static ItemgroupDisplay generateItemgroupDisplay(Itemgroup itmgrp)
	{
		ItemgroupDisplay display = new ItemgroupDisplay();
		display.setIGName(itmgrp.getIGName());
		return display;
	}

	public static MaterialcentreDisplay generateMaterialcentreDisplay(Materialcentre mc)
	{
		MaterialcentreDisplay display = new MaterialcentreDisplay();
		display.setId(mc.getId());
		display.setName(mc.getName());
		display.setStock_Account(mc.getStock_Account());
		display.setTransfered(mc.getTransfered());
		display.setAddress(mc.getAddress());
			
		return display;
	}
	
	public static MunitDisplay generateMunitDisplay(Munit mn)
	{
		MunitDisplay display = new MunitDisplay();
		display.setId(mn.getId());
		display.setName(mn.getName());
		display.setComments(mn.getComments());	
		return display;
	}

	
}
