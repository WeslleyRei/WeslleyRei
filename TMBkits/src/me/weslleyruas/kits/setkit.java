package me.weslleyruas.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class setkit extends JavaPlugin{
	static String setkit_setado = configs.GetConfig("mensagens").getString("mensagens.setkit_setado");
	@SuppressWarnings("deprecation")
	public static void setarkit(Player p, String nomekit){
		ArrayList<String> itens = new ArrayList<String>();
		for(int i = 0; i < 35; i++){
			ItemStack z = p.getInventory().getItem(i);
			if(z != null){
				int x = z.getTypeId();
				byte v = z.getData().getData();
				String c = String.valueOf(x) + ":" + String.valueOf(v) + ":" + z.getAmount();
				String m = String.valueOf(c);
				itens.add(m);
			}
		}
			if(!itens.isEmpty()){
				List<String> lista = configs.GetConfig("lista").getStringList("kits");
				if(!lista.contains(nomekit)){				
					lista.add(nomekit);
					}
				configs.GetConfig("lista").set("kits", lista);
				configs.GetConfig("kits").set(nomekit, itens);
				configs.SaveConfig("lista");
				configs.SaveConfig("kits");
				p.sendMessage(setkit_setado.replace("&", "§").replace("$setkitsetado$", nomekit));
			}
			else{
				p.sendMessage("Nao tem nenhum item no seu inventario!");
			}
			}}
