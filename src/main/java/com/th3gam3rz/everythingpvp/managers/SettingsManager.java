package com.th3gam3rz.everythingpvp.managers;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class SettingsManager {

	private SettingsManager() {
	}
	
	static SettingsManager instance = new SettingsManager();
	
	public static SettingsManager getInstance(){
		return instance;
	}
	
	Plugin p;
	File settingsFile;
	FileConfiguration settings;
	
	public void setup(Plugin p){
		this.p = p;
		settings = p.getConfig();
		settings.options().copyDefaults(true);
		settingsFile = new File(p.getDataFolder(), "config.yml");
		saveSettings();
	}
	
	public FileConfiguration getSettings(){
		return settings;
	}
	
	public void saveSettings(){
		try{
			settings.save(settingsFile);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void reload(){
		settings = YamlConfiguration.loadConfiguration(settingsFile);
	}
	
	public PluginDescriptionFile getPluginInfo(){
		return p.getDescription();
	}

}
