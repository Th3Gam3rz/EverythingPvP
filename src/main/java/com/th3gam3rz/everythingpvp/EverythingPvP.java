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
						SettingsManager.getInstance().saveSettings();
						SettingsManager.getInstance().reload();
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
						SettingsManager.getInstance().saveSettings();
						SettingsManager.getInstance().reload();
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
						SettingsManager.getInstance().saveSettings();
						SettingsManager.getInstance().reload();
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
						SettingsManager.getInstance().saveSettings();
						SettingsManager.getInstance().reload();
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
						SettingsManager.getInstance().saveSettings();
						SettingsManager.getInstance().reload();
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
						SettingsManager.getInstance().saveSettings();
						SettingsManager.getInstance().reload();
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
						SettingsManager.getInstance().saveSettings();
						SettingsManager.getInstance().reload();
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
		if(c.getName().equalsIgnoreCase("playerdrop")){
			if(s.isOp() || s.hasPermission("pvp.playerdrop")){
				if(args.length == 0){
					ChatManager.getInstance().info("The current percentage dropped on death is " + SettingsManager.getInstance().getSettings().getInt("PercentageDroppedOnDeath") + ".", s);
					ChatManager.getInstance().info("To change it, type /playerdrop <new value>. It must be a whole number between 0 and 100, inclusive.", s);
					return true;
				}
				if(args.length > 1){
					ChatManager.getInstance().error("Too many arguments!", s);
					return true;
				}
				int arg;
				try{
					arg = Integer.parseInt(args[0]);
				}catch(NumberFormatException e){
					ChatManager.getInstance().error("The number you entered is not a whole number!", s);
					return true;
				}
				if(arg < 0 || arg > 100){
					ChatManager.getInstance().error("Error: The number you entered is less than 0 or greater than 100.", s);
					return true;
				}
				SettingsManager.getInstance().getSettings().set("PercentageDroppedOnDeath", arg);
				SettingsManager.getInstance().saveSettings();
				SettingsManager.getInstance().reload();
				ChatManager.getInstance().info("Set the percentage dropped on death to " + arg, s);
				return true;
			}
			ChatManager.getInstance().error("You do not have permission to do that!", s);
			return true;
		}
		return false;
	}

}
