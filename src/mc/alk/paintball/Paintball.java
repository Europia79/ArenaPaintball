package mc.alk.paintball;

import mc.alk.arena.BattleArena;
import mc.alk.arena.util.Log;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
public class Paintball extends JavaPlugin{

	@Override
	public void onEnable(){
		/// Registers this plugin with BattleArena with a Paintball match type, for 1v1, 1v4, 2v2,etc matches
		/// this: our plugin
		/// "Paintball": The name of our event
		/// "pb": the name of our command ( who really wants to type in the entire word paintball?)
		/// PaintballArena.class: which arena should this event use
		/// Register a Paintball 
		BattleArena.registerMatchType(this, "Paintball", "pb", PaintballArena.class);

		/// Allow the damage to be set through the config.yml, if it exists and has the section: 'damage: <value>'
		/// Like 'damage: 15'
		FileConfiguration config = getConfig();
		PaintballArena.damage = config.getInt("damage", 20);
		Log.info("[" + getName()+ "] v" + getDescription().getVersion()+ " enabled!");
	}

	@Override
	public void onDisable(){
		Log.info("[" + getName()+ "] v" + getDescription().getVersion()+ " stopping!");
	}

}
