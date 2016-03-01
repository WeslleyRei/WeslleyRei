package me.weslleyruas.delaycomandos;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener{
	String delay_ativado = getConfig().getString("delay_ativado");
	int tempo_delay = getConfig().getInt("tempo_delay");
	public void onEnable(){
			File config = new File(getDataFolder(), "config.yml");
			if (!config.exists())
			{
				saveDefaultConfig();
			}
			Bukkit.getServer().getPluginManager().registerEvents(this, this);
			System.out.println(this.getName() + ">>> Iniciado!");
			}
@EventHandler
	public void mandoucomando(PlayerCommandPreprocessEvent e){
		final Player p = e.getPlayer();
		utils.z(p, delay_ativado, tempo_delay, this, e);
					}
}