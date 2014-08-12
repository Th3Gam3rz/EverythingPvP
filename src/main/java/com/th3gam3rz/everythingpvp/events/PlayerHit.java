package com.th3gam3rz.everythingpvp.events;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;

import com.th3gam3rz.everythingpvp.managers.SettingsManager;

public class PlayerHit implements Listener {

	@SuppressWarnings("unused")
	private Plugin p;

	public PlayerHit(Plugin p) {
		this.p = p;
		p.getServer().getPluginManager().registerEvents(this, p);
	}

	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		Entity entityDamager = e.getDamager();
		Entity entityVictim = e.getEntity();
		if (!(entityDamager instanceof Player)) {
			return;
		}
		Player damager = (Player) entityDamager;
		if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("Red") && damager.hasPermission("pvp.blood.see")){
			damager.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getLocation().distance(entityVictim.getLocation()) <= 5 && (p.hasPermission("pvp.blood.see") || p.isOp())){
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
				}
			}
		}
		if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("DarkRed") && damager.hasPermission("pvp.blood.see")){
			damager.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_WIRE);
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getLocation().distance(entityVictim.getLocation()) <= 5 && (p.hasPermission("pvp.blood.see") || p.isOp())){
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_WIRE);
				}
			}
		}
		if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("Blue") && damager.hasPermission("pvp.blood.see")){
			damager.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.DIAMOND_BLOCK);
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getLocation().distance(entityVictim.getLocation()) <= 5 && (p.hasPermission("pvp.blood.see") || p.isOp())){
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.DIAMOND_BLOCK);
				}
			}
		}
		if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("DarkBlue") && damager.hasPermission("pvp.blood.see")){
			damager.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.LAPIS_BLOCK);
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getLocation().distance(entityVictim.getLocation()) <= 5 && (p.hasPermission("pvp.blood.see") || p.isOp())){
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.LAPIS_BLOCK);
				}
			}
		}
		if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("Green") && damager.hasPermission("pvp.blood.see")){
			damager.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.EMERALD_BLOCK);
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getLocation().distance(entityVictim.getLocation()) <= 5 && (p.hasPermission("pvp.blood.see") || p.isOp())){
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.EMERALD_BLOCK);
				}
			}
		}
		if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("DarkGreen") && damager.hasPermission("pvp.blood.see")){
			damager.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.LEAVES_2);
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getLocation().distance(entityVictim.getLocation()) <= 5 && (p.hasPermission("pvp.blood.see") || p.isOp())){
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.LEAVES_2);
				}
			}
		}
		if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("Multi") && damager.hasPermission("pvp.blood.see")){
			damager.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
			damager.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_WIRE);
			damager.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.DIAMOND_BLOCK);
			damager.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.LAPIS_BLOCK);
			damager.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.EMERALD_BLOCK);
			damager.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.LEAVES_2);
			for(Player p : Bukkit.getOnlinePlayers()){
				if(p.getLocation().distance(entityVictim.getLocation()) <= 5 && (p.hasPermission("pvp.blood.see") || p.isOp())){
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_WIRE);
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.DIAMOND_BLOCK);
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.LAPIS_BLOCK);
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.EMERALD_BLOCK);
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.LEAVES_2);
				}
			}
		}
		if(entityVictim instanceof Player){
			Player victim = (Player) entityVictim;
			if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("Red") && victim.hasPermission("pvp.blood.see")){
				victim.playEffect(victim.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
			}
			if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("DarkRed") && victim.hasPermission("pvp.blood.see")){
				victim.playEffect(victim.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_WIRE);
			}
			if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("Blue") && victim.hasPermission("pvp.blood.see")){
				victim.playEffect(victim.getLocation(), Effect.STEP_SOUND, Material.DIAMOND_BLOCK);
			}
			if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("DarkBlue") && victim.hasPermission("pvp.blood.see")){
				victim.playEffect(victim.getLocation(), Effect.STEP_SOUND, Material.LAPIS_BLOCK);
			}
			if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("Green") && victim.hasPermission("pvp.blood.see")){
				victim.playEffect(victim.getLocation(), Effect.STEP_SOUND, Material.EMERALD_BLOCK);
			}
			if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("DarkGreen") && victim.hasPermission("pvp.blood.see")){
				victim.playEffect(victim.getLocation(), Effect.STEP_SOUND, Material.LEAVES_2);
			}
			if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("Multi") && victim.hasPermission("pvp.blood.see")){
				victim.playEffect(victim.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
				victim.playEffect(victim.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_WIRE);
				victim.playEffect(victim.getLocation(), Effect.STEP_SOUND, Material.DIAMOND_BLOCK);
				victim.playEffect(victim.getLocation(), Effect.STEP_SOUND, Material.LAPIS_BLOCK);
				victim.playEffect(victim.getLocation(), Effect.STEP_SOUND, Material.EMERALD_BLOCK);
				victim.playEffect(victim.getLocation(), Effect.STEP_SOUND, Material.LEAVES_2);
			}
		}
		for(Player p : Bukkit.getOnlinePlayers()){
			if(p.getLocation().distance(entityVictim.getLocation()) <= 5){
				if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("Red") && (p.hasPermission("pvp.blood.see") || p.isOp())){
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
				}
				if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("DarkRed") && (p.hasPermission("pvp.blood.see") || p.isOp())){
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_WIRE);
				}
				if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("Blue") && (p.hasPermission("pvp.blood.see") || p.isOp())){
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.DIAMOND_BLOCK);
				}
				if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("DarkBlue") && (p.hasPermission("pvp.blood.see") || p.isOp())){
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.LAPIS_BLOCK);
				}
				if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("Green") && (p.hasPermission("pvp.blood.see") || p.isOp())){
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.EMERALD_BLOCK);
				}
				if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("DarkGreen") && (p.hasPermission("pvp.blood.see") || p.isOp())){
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.LEAVES_2);
				}
				if(SettingsManager.getInstance().getSettings().getString("BloodColor").equalsIgnoreCase("Multi") && (p.hasPermission("pvp.blood.see") || p.isOp())){
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_WIRE);
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.DIAMOND_BLOCK);
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.LAPIS_BLOCK);
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.EMERALD_BLOCK);
					p.playEffect(entityVictim.getLocation(), Effect.STEP_SOUND, Material.LEAVES_2);
				}
			}
		}
	}

}
