package com.th3gam3rz.everythingpvp.events;

import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

import com.th3gam3rz.everythingpvp.EverythingPvP;
import com.th3gam3rz.everythingpvp.managers.ChatManager;
import com.th3gam3rz.everythingpvp.managers.SettingsManager;

public class PlayerKill implements Listener {
	
	@SuppressWarnings("unused")
	private Plugin plugin;
	
	public PlayerKill(Plugin p){
		this.plugin = p;
		p.getServer().getPluginManager().registerEvents(this, p);
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		if(SettingsManager.getInstance().getSettings().getBoolean("Economy") != true){
			return;
		}
		Player p = e.getEntity();
		if(p.getKiller() == null)
			return;
		Player killer = p.getKiller();
		if(p.hasPermission("pvp.playerdrop.exempt") || p.isOp()){
			return;
		}
		double r = EverythingPvP.econ.getBalance(p);
		if(r < 0){
			ChatManager.getInstance().error("No money can be taken for the player's balance is less than 0.", killer);
			return;
		}
		double amount = r;
		int percentage = SettingsManager.getInstance().getSettings().getInt("PercentageDroppedOnDeath");
		if(percentage < 0 || percentage > 100){
			ChatManager.getInstance().error("Invalid percentage entered in config.yml. Please contact a server admin.", killer);
			return;
		}
		double tempAmount = amount / 100;
		double amountToDrop = tempAmount * percentage;
		EconomyResponse r1 = EverythingPvP.econ.withdrawPlayer(p, amountToDrop);
		if(!r1.transactionSuccess()){
			ChatManager.getInstance().error("Unable to take money from " + p.getName(), killer);
			return;
		}
		EconomyResponse r2 = EverythingPvP.econ.depositPlayer(killer, amountToDrop);
		if(!r2.transactionSuccess()){
			ChatManager.getInstance().error("Unable to add money to your balance. Sending money back to " + p.getName(), killer);
			EconomyResponse r3 = EverythingPvP.econ.depositPlayer(p, amountToDrop);
			if(r3.transactionSuccess()){
				ChatManager.getInstance().info(killer.getName() + " was unable to recieve " + amountToDrop + " of your balance so you have got it back!", p);
				return;
			}
			return;
		}
		ChatManager.getInstance().info("You took " + amountToDrop + " from " + p.getName() + "'s balance!", killer);
		return;
	}

}
