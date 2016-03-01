package me.weslleyruas.kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class cooldown extends JavaPlugin{
	final static HashMap<Player, List<String>> lista = new HashMap<Player, List<String>>();
	final static List<String> todoskitsdoindividuo = new ArrayList<String>();
	@SuppressWarnings("null")
	public static void z(final Player p, final String nomekit, final int delay, final Plugin plugin){		
			/* SE A LISTA NAO FOR IGUAL A NULL VAI FAZER ISSO */
			String m = String.valueOf(lista.get(p));
			if(m == null){
				if (m.contains(nomekit)) {
					p.sendMessage("Espera o delay cabron");
				}
				else{
					todoskitsdoindividuo.add(nomekit);
					lista.put(p, todoskitsdoindividuo);
					kit.pegarkit1arg(nomekit, p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				          public void run() {
				        	  while(todoskitsdoindividuo.contains(nomekit)){
					        	  	todoskitsdoindividuo.remove(nomekit);
					        	  	}
				        	  todoskitsdoindividuo.addAll(lista.get(p));
								lista.put(p, todoskitsdoindividuo);
								p.sendMessage("Ja pode pegar o kit: " + nomekit + " denovo");
				          }
				        }
				        , 200L);
					}
			}
			/* SE A LISTA FOR IGUAL A NULL VAI FAZER ISSO */
			else{
				if(m.contains(nomekit)){
					p.sendMessage("Espere o delay, el cabron!");
					p.sendMessage(m);
					}
				else{
					todoskitsdoindividuo.add(nomekit);
					lista.put(p, todoskitsdoindividuo);
					kit.pegarkit1arg(nomekit, p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				          public void run() {
				        	  while(todoskitsdoindividuo.contains(nomekit)){
				        	  	todoskitsdoindividuo.remove(nomekit);
				        	  	}
				        	  	todoskitsdoindividuo.addAll(lista.get(p));
								lista.put(p, todoskitsdoindividuo);
								p.sendMessage("Ja pode pegar o kit: " + nomekit + " denovo");
				          }
				        }
				        , 200L);
					}
				}
				
	}
}
