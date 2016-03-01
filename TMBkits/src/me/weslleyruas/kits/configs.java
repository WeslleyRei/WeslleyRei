package me.weslleyruas.kits;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class configs extends JavaPlugin{
	static HashMap<String,FileConfiguration> Configs = new HashMap<String,FileConfiguration>();
    
	public static void CreateConfig(String Name){
		if (!main.instance.getDataFolder().exists()) {
			main.instance.getDataFolder().mkdir();
		    }
			File configz = new File(main.instance.getDataFolder(), Name+".yml");
			if(!configz.exists()){
				if(main.instance.getResource(Name+".yml") != null){
					main.instance.saveResource(Name+".yml", false);
				}
				else
				{
					try {
						configz.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	public static FileConfiguration GetConfig(String Name){
			if (!main.instance.getDataFolder().exists()) {
				main.instance.getDataFolder().mkdir();
		    }
			
			File configz = new File(main.instance.getDataFolder(), Name+".yml");
	        
			if(!configz.exists()){
				main.instance.saveResource(Name+".yml", false);
			}
			
			
			if(!Configs.containsKey(Name)){
				Configs.put(Name, YamlConfiguration.loadConfiguration(configz));
			}
			
			return Configs.get(Name);
		}
	public static void SaveConfig(String Name){
			if(Configs.containsKey(Name)){
				File configz = new File(main.instance.getDataFolder(), Name+".yml");
				try {
					Configs.get(Name).save(configz);
					Configs.remove(Name);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

}
