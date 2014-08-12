package com.th3gam3rz.everythingpvp.managers;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ChatManager {

	private ChatManager() {
	}
	
	private static ChatManager instance = new ChatManager();
	
	public static ChatManager getInstance(){
		return instance;
	}
	
	private static String PREFIX = ChatColor.GRAY + "[" + ChatColor.AQUA + "EverythingPvP" + ChatColor.GRAY + "] ";
	
	private static String getPrefix(){
		return PREFIX;
	}
	
	public void error(String msg, CommandSender sender){
		sender.sendMessage(getPrefix() + ChatColor.RED + msg);
	}
	
	public void info(String msg, CommandSender sender){
		sender.sendMessage(getPrefix() + ChatColor.GREEN + msg);
	}

}
