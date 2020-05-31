package fr.benco11.butilities.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import fr.benco11.butilities.BUtilities;

public class CommandBienvenue implements CommandExecutor {

	private BUtilities main;
	private File user = new File("bUtilities/usercache.yml");
	private YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(user);
	public CommandBienvenue(BUtilities bUtilities) {
		this.main = bUtilities;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender player, Command cmd, String msg, String[] args) {
		if(player instanceof Player) {
			if(main.getConfig().getBoolean("config.bvn") == true) {
				Player play = (Player) player;
				Player joueur[] = Bukkit.getOnlinePlayers();
				for(Player pl : joueur) {
					if(yamlFile.getBoolean("players." + pl.getUniqueId() + ".bvn") == true) {
						if((!(yamlFile.getString("players." + pl.getUniqueId() + ".bvnC").contains(play.getName()))) && pl.getUniqueId() != play.getUniqueId()) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), main.getConfig().getString("config.bvncmd").replaceAll("%player%", play.getName()));
							Bukkit.broadcastMessage("§a" + play.getName() + " souhaite la bienvenue à : " + pl.getName());
							yamlFile.set("players." + pl.getUniqueId() + ".bvnC", yamlFile.get("players." + pl.getUniqueId() + ".bvnC") + " " + play.getName());
							try {
								yamlFile.save(user);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
				player.sendMessage("§" + main.succes + "Tu viens de dire bienvenue à touts les nouveaux joueurs !");
				return true;
			} else {
				player.sendMessage("§4Cette commande est désactivé !");
				return true;
			}
			
		}
		return false;
	}
}


