package me.weslleyruas.clearchat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("cc")){
			for(int i = 0; i<40; i++){
				Bukkit.broadcastMessage("");
			}
		}
		return false;
		
	}

}
