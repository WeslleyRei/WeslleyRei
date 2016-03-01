package me.weslleyruas.delaycomandos;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class utils extends JavaPlugin{
	public static ArrayList<Player> dly = new ArrayList<Player>();
	
	public static void x(String l, String event){
		event = l;
	}
	public static void z(final Player p, String m, int delay, Plugin plugin, PlayerCommandPreprocessEvent e){
		if (!dly.contains(p)) {
			dly.add(p);
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					dly.remove(p);
					}
					}, delay * 20L);
					}else{
					e.setCancelled(true);
					p.sendMessage(m.replace("&", "§"));}}}
