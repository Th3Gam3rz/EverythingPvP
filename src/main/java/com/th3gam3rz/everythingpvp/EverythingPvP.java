package com.th3gam3rz.everythingpvp;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.th3gam3rz.everythingpvp.events.PlayerHit;
import com.th3gam3rz.everythingpvp.events.PlayerKill;
import com.th3gam3rz.everythingpvp.managers.ChatManager;
import com.th3gam3rz.everythingpvp.managers.SettingsManager;

public class EverythingPvP extends JavaPlugin {
	
	public static Economy econ = null;

	public void onEnable() {
		SettingsManager.getInstance().setup(this);
		new PlayerHit(this);
		new PlayerKill(this);
		if(!setupEconomy()){
			SettingsManager.getInstance().getSettings().set("Economy", false);
			Bukkit.getLogger().info("Disabled EverythingPvP's economy features due to no Vault dependency!");
			return;
		}
		SettingsManager.getInstance().getSettings().set("Economy", true);
	}
	
	private boolean setupEconomy() {
        	if (getServer().getPluginManager().getPlugin("Vault") == null) {
            		return false;
        	}
        	RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        	if (rsp == null) {
            		return false;
        	}
        	econ = rsp.getProvider();
        	return econ != null;
    	}

	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		if(c.getName().equalsIgnoreCase("blood")){
			if(s.isOp() || s.hasPermission("pvp.blood.change")){
				if(args.length == 0){
					ChatManager.getInstance().error("Please specify a color: Red, DarkRed, Blue, DarkBlue, Green, DarkGreen or Multi!", s);
					return true;
				}
				if(args.length > 1){
					ChatManager.getInstance().error("Too many arguments!", s);
					return true;
				}
				if(args[0].equalsIgnoreCase("Red")){
					try{
						SettingsManager.getInstance().getSettings().set("BloodColor", "Red");
					}catch(Exception e){
						e.printStackTrace();
						ChatManager.getInstance().error("Unable to change the blood color. Try restarting the server!", s);
						return true;
					}
					ChatManager.getInstance().info("Changed the blood color to red!", s);
					return true;
				}
				else if(args[0].equalsIgnoreCase("DarkRed")){
					try{
						SettingsManager.getInstance().getSettings().set("BloodColor", "DarkRed");
					}catch(Exception e){
						e.printStackTrace();
						ChatManager.getInstance().error("Unable to change the blood color. Try restarting the server!", s);
						return true;
					}
					ChatManager.getInstance().info("Changed the blood color to dark red!", s);
					return true;
				}
				else if(args[0].equalsIgnoreCase("Blue")){
					try{
						SettingsManager.getInstance().getSettings().set("BloodColor", "Blue");
					}catch(Exception e){
						e.printStackTrace();
						ChatManager.getInstance().error("Unable to change the blood color. Try restarting the server!", s);
						return true;
					}
					ChatManager.getInstance().info("Changed the blood color to blue!", s);
					return true;
				}
				else if(args[0].equalsIgnoreCase("DarkBlue")){
					try{
						SettingsManager.getInstance().getSettings().set("BloodColor", "DarkBlue");
					}catch(Exception e){
						e.printStackTrace();
						ChatManager.getInstance().error("Unable to change the blood color. Try restarting the server!", s);
						return true;
					}
					ChatManager.getInstance().info("Changed the blood color to dark blue!", s);
					return true;
				}
				else if(args[0].equalsIgnoreCase("Green")){
					try{
						SettingsManager.getInstance().getSettings().set("BloodColor", "Green");
					}catch(Exception e){
						e.printStackTrace();
						ChatManager.getInstance().error("Unable to change the blood color. Try restarting the server!", s);
						return true;
					}
					ChatManager.getInstance().info("Changed the blood color to green!", s);
					return true;
				}
				else if(args[0].equalsIgnoreCase("DarkGreen")){
					try{
						SettingsManager.getInstance().getSettings().set("BloodColor", "DarkGreen");
					}catch(Exception e){
						e.printStackTrace();
						ChatManager.getInstance().error("Unable to change the blood color. Try restarting the server!", s);
						return true;
					}
					ChatManager.getInstance().info("Changed the blood color to dark green!", s);
					return true;
				}
				else if(args[0].equalsIgnoreCase("Multi")){
					try{
						SettingsManager.getInstance().getSettings().set("BloodColor", "Multi");
					}catch(Exception e){
						e.printStackTrace();
						ChatManager.getInstance().error("Unable to change the blood color. Try restarting the server!", s);
						return true;
					}
					ChatManager.getInstance().info("Changed the blood color to multi!", s);
					return true;
				}
				else{
					ChatManager.getInstance().error("Unknown color!", s);
					return true;
				}
			}
			ChatManager.getInstance().error("You do not have permission to do that!", s);
			return true;
		}
		return false;
	}

}
