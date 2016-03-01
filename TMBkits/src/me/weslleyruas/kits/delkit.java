package me.weslleyruas.kits;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class delkit extends JavaPlugin{
	static String delkit_nao_existe_esse_kit = configs.GetConfig("mensagens").getString("mensagens.delkit_nao_existe_esse_kit");
	static String delkit_kit_apagado = configs.GetConfig("mensagens").getString("mensagens.delkit_kit_apagado");
	public static void deletarkit(String z, Player p){
		List<String> lista = configs.GetConfig("lista").getStringList("kits");
		if(lista.contains(z)){
			lista.remove(z);
			if(!lista.isEmpty()){
			configs.GetConfig("lista").set("kits", lista);
			}
			else{configs.GetConfig("lista").set("kits", null);
			}
			configs.GetConfig("kits").set(z, null);
			configs.SaveConfig("lista");
			configs.SaveConfig("kits");
			p.sendMessage(delkit_kit_apagado.replace("&", "§").replace("$kitdeletado$", z));
		}
		else{
			p.sendMessage(delkit_nao_existe_esse_kit.replace("&", "§"));
		}
	}

}
