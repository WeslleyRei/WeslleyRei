package me.weslleyruas.kits;

import java.util.List;

import me.weslleyruas.kits.cooldown;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class kit extends JavaPlugin{
	static String kit_pegou = configs.GetConfig("mensagens").getString("mensagens.kit_pegou");
	static String kit_nao_existe = configs.GetConfig("mensagens").getString("mensagens.kit_nao_existe");
	static String kit_lista = configs.GetConfig("mensagens").getString("mensagens.kit_lista");
	static String kit_lista_nao_existe = configs.GetConfig("mensagens").getString("mensagens.kit_lista_nao_existe");
	@SuppressWarnings("deprecation")
	public static void pegarkit1arg(String m, Player p){
		List<String> kits = configs.GetConfig("lista").getStringList("kits");
		if(kits.contains(m)){
			List<String> check = configs.GetConfig("kits").getStringList(m);
			if(!check.isEmpty()){
				for(int i = 0; i < check.size(); i++){
					String z = check.get(i);
					String[] x = z.split(":");
					//itens sem metadata
					if(x[1] == "0"){
						int id = Integer.valueOf(x[0]);
						int quantidade = Integer.valueOf(x[2]);
						p.getInventory().addItem(new ItemStack(id, quantidade));
						}
					//itens com metadata
					else{
						int id = Integer.valueOf(x[0]);
						byte meta = Byte.valueOf(x[1]);
						int quantidade = Integer.valueOf(x[2]);
						p.getInventory().addItem(new ItemStack(id, quantidade, meta));					
					}
				}
				p.sendMessage(kit_pegou.replace("&", "§").replace("$kitpegou$", m));
			}
			}
		else{
			p.sendMessage(kit_nao_existe.replace("&", "§"));
		}
	}
	public static void pegarkit0arg(Player p){
		List<String> kits = configs.GetConfig("lista").getStringList("kits");
		if(!kits.isEmpty()){
			String m = String.valueOf(cooldown.lista.get(p));
				for(int i = 0; i < cooldown.lista.get(p).size(); i++){
					if(m.contains(kits.get(i))){
						String x = kits.get(i);
						kits.remove(x);
						kits.add("&4" + x + "&r");
					}
				}
				String kit = String.valueOf(kits);
				p.sendMessage("Legenda: &4kit&r = Usado > &akit&r = Disponivel" ); 
				p.sendMessage(kit_lista.replace("&", "§") + kit.replace("[", "").replace("]", "").replace("&", "§"));
		}
		else{
			p.sendMessage(kit_lista_nao_existe.replace("&", "§"));
		}
	}

}
