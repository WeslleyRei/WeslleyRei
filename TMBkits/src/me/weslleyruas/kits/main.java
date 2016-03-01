package me.weslleyruas.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin{
	List<String> msg = new ArrayList<String>();
	public static main instance;
	public void onEnable(){
		instance = this;
		configs.CreateConfig("kits");
		configs.CreateConfig("lista");
		configs.CreateConfig("mensagens");
		msg.addAll(configs.GetConfig("mensagens").getStringList("mensagens"));
		if(msg.isEmpty()){
			configs.GetConfig("mensagens").set("mensagens.kit_pegou", "&aVoce recebeu o kit: &c$kitpegou$");
			configs.GetConfig("mensagens").set("mensagens.kit_nao_existe", "&cEsse kit nao existe!");
			configs.GetConfig("mensagens").set("mensagens.kit_lista", "&bLista de kits:&a ");
			configs.GetConfig("mensagens").set("mensagens.kit_lista_nao_existe", "&cNao existe nenhum kit");
			configs.GetConfig("mensagens").set("mensagens.setkit_setado", "&aO kit: &c$setkitsetado$ &afoi setado!");
			configs.GetConfig("mensagens").set("mensagens.delkit_nao_existe_esse_kit", "&cNao existe um kit com esse nome");
			configs.GetConfig("mensagens").set("mensagens.delkit_kit_apagado", "&aO kit: &c$kitdeletado$ &afoi apagado");
			configs.GetConfig("mensagens").set("mensagens.kit_em_delay", "&aEsse kit ja foi usado, aguarde o cooldown!");
			configs.SaveConfig("mensagens");
		}
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("setkit")){
				setkit.setarkit(p, args[0]);
				}
		if(cmd.getName().equalsIgnoreCase("kit")){
			if(args.length == 1){
				cooldown.z(p, args[0], 5, this);
				}
			if(args.length == 0){
				kit.pegarkit0arg(p);
				}
			
				}
		if(cmd.getName().equalsIgnoreCase("delkit")){
			if(args.length == 1){
				delkit.deletarkit(args[0], p);
			}
		}
			return false; 
		}
}
