package me.weslleyruas.home;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin{
	HashMap<String,FileConfiguration> Configs = new HashMap<String,FileConfiguration>();
	public void onEnable()
	  {
		CreateConfig("locais");
		CreateConfig("lista");
		System.out.println(this.getName() + ">> iniciado!");
	  	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("sethome")){
			if(args.length == 0){
				p.sendMessage("Utilize: /sethome <nomedahome>");
			}
			if(args.length == 1){
				ArrayList<String> lista = new ArrayList<String>();
					if(args[0].length() < 9){
						lista.addAll(GetConfig("lista").getStringList(p.getName()));
						Location casa = p.getLocation();
						GetConfig("locais").set(p.getName() + "." + args[0] + ".X", casa.getX());
						GetConfig("locais").set(p.getName() + "." + args[0] + ".Y", casa.getY());
						GetConfig("locais").set(p.getName() + "." + args[0] + ".Z", casa.getZ());
						GetConfig("locais").set(p.getName() + "." + args[0] + ".Pitch", casa.getPitch());
						GetConfig("locais").set(p.getName() + "." + args[0] + ".Yaw", casa.getYaw());
						GetConfig("locais").set(p.getName() + "." + args[0] + ".world", casa.getWorld().getName());
						p.sendMessage("A home §4" + args[0] + " §rfoi setada");
						lista.add(args[0]); 
						GetConfig("lista").set(p.getName(), lista);
						SaveConfig("lista");
						SaveConfig("locais");
					}
					else{
						p.sendMessage("Utilize um nome com menos de 8 characters");
					}
				}
			}
		if(cmd.getName().equalsIgnoreCase("home")){
			if(args.length == 0){
				p.sendMessage("Utilize: /home <nomedahome>");
			}
			if(args.length == 1){
				ArrayList<String> lista = new ArrayList<String>();
				lista.addAll(GetConfig("lista").getStringList(p.getName()));
				if(lista.contains(args[0])){
					double x = GetConfig("locais").getDouble(p.getName() + "." + args[0] + ".X");
					double y = GetConfig("locais").getDouble(p.getName() + "." + args[0] + ".Y");
					double z = GetConfig("locais").getDouble(p.getName() + "." + args[0] + ".Z");
					float pitch = GetConfig("locais").getInt(p.getName() + "." + args[0] + ".Pitch");
					float yaw = GetConfig("locais").getInt(p.getName() + "." + args[0] + ".Yaw");
					String world = GetConfig("locais").getString(p.getName() + "." + args[0] + ".world");
					Location bolada = new Location(Bukkit.getWorld(world),x,y,z);
					bolada.setPitch(pitch);
					bolada.setYaw(yaw);
					p.teleport(bolada);
					p.sendMessage("Voce foi teleportado para a home: §4" + args[0]);
					}
				else{
					p.sendMessage("Essa home nao existe");
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("delhome")){
			if(args.length == 0){
				p.sendMessage("Utilize: /delhome <nomedahome>");				
			}
			if(args.length == 1){
				ArrayList<String> lista = new ArrayList<String>();
				lista.addAll(GetConfig("lista").getStringList(p.getName()));
				if(lista.contains(args[0])){
					lista.remove(args[0]);
					GetConfig("lista").set(p.getName(), lista);
					GetConfig("locais").set(p.getName() + "." + args[0], null);
					p.sendMessage("Voce apagou a home: §4" + args[0]);
					SaveConfig("lista");
					SaveConfig("locais");
					}
				else{
					p.sendMessage("A home: §4" + args[0] + " §rnao existe");
				}
				
			}
		}
		if(cmd.getName().equalsIgnoreCase("listhomes")){
			ArrayList<String> homes = new ArrayList<String>();
			homes.addAll(GetConfig("lista").getStringList(p.getName()));
			if(!homes.isEmpty()){
			p.sendMessage("Lista de todas as suas homes: §d" + homes);}
			else{p.sendMessage("Voce nao tem nenhuma home setada");}
		}
		return false; 
	}
	
	public void CreateConfig(String Name){
		if (!getDataFolder().exists()) {
			getDataFolder().mkdir();
		    }
			File configz = new File(getDataFolder(), Name+".yml");
			if(!configz.exists()){
				if(this.getResource(Name+".yml") != null){
					saveResource(Name+".yml", false);
				}
				else
				{
					try {
						configz.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	public FileConfiguration GetConfig(String Name){
			if (!getDataFolder().exists()) {
				getDataFolder().mkdir();
		    }
			
			File configz = new File(getDataFolder(), Name+".yml");
	        
			if(!configz.exists()){
				saveResource(Name+".yml", false);
			}
			
			
			if(!Configs.containsKey(Name)){
				Configs.put(Name, YamlConfiguration.loadConfiguration(configz));
			}
			
			return Configs.get(Name);
		}
	public void SaveConfig(String Name){
			if(Configs.containsKey(Name)){
				File configz = new File(getDataFolder(), Name+".yml");
				try {
					Configs.get(Name).save(configz);
					Configs.remove(Name);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

}
