package me.weslleyruas.checklegacy;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.weslleyruas.checklegacy.json;

public class main extends JavaPlugin implements Listener{
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		System.out.println(this.getName() + ">>> Iniciado!");
	}
	
	@EventHandler
	public void entrou(PlayerJoinEvent e){
		Player p = e.getPlayer();
		UUID uuid2 = p.getUniqueId();
		json.web(p.getName(), "id");
		if(json.uuid != uuid2.toString()){
			p.kickPlayer("Voce esta usando mine falso, devia se envergonhar!");
		}
		else{
			p.sendMessage("Voce esta usando um minecraft Verdadeiro, parabens");
		}
		
	}

}
