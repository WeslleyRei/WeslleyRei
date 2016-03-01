package me.weslleyruas.testconection;

import java.io.File;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin{
	public void onEnable(){
		File config = new File(getDataFolder(), "config.yml");
		if (!config.exists())
		{
			getConfig().set("dados", "root,vertrigo,localhost,3306,weslleyrei");
			saveConfig();
		}
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("set")){
			
			
		}
		if(cmd.getName().equalsIgnoreCase("ver")){
			
		}
		return false;
		
	}
}
