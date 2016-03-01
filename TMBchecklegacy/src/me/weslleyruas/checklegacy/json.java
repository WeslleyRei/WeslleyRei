package me.weslleyruas.checklegacy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class json extends JavaPlugin{
	static String uuid = null;
	public static String web(String name, String zer){
		StringBuilder content = new StringBuilder();
		try
		{
		URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + name);
		URLConnection urlConnection = url.openConnection();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line;
		while ((line = bufferedReader.readLine()) != null)
		{
		content.append(line + "\n");
		}
		bufferedReader.close();
		}
		catch(Exception e)
		{
		return null;
		}
		try{
		String lortu = content.toString();
		JSONParser parser = new JSONParser();
		JSONObject jo = (JSONObject) parser.parse(lortu);
		uuid = (String) jo.get(zer);
		return (String) jo.get(zer);
		}
		catch(Exception e){
		return null;
		}
		}

}
