package fr.benco11.butilities.commands;

import java.io.File;
import java.net.InetSocketAddress;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import fr.benco11.butilities.BUtilities;

public class CommandCheck implements CommandExecutor {
	
	private File user = new File("bUtilities/usercache.yml");
	private YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(user);
	private BUtilities main;

	public CommandCheck(BUtilities bUtilities) {
		this.main = bUtilities;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender player, Command cmd, String msg, String[] args) {
		if(args.length == 0 || args.length > 1) return false;
		else {
			Player joueur = Bukkit.getPlayer(args[0]);
			OfflinePlayer jou2 = Bukkit.getOfflinePlayer(args[0]);
			if(joueur != null) {
				UUID uuid = joueur.getUniqueId();
				InetSocketAddress ip = joueur.getAddress();
				player.sendMessage("§6Joueur " + joueur.getName() + "\n \n§f- UUID : " + uuid + "\n- IP : " + ip);
			} else {
				if(!(yamlFile.contains("players." + jou2.getUniqueId()))) {
					player.sendMessage("§" + main.error + "Veuillez entrer un joueur qui s'est déjà connecté !");
				} else {
					player.sendMessage("§6Joueur " + jou2.getName() + "\n \n§f- UUID : " + jou2.getUniqueId() + "\n- IP : " + yamlFile.getString("players." + jou2.getUniqueId() + ".ip"));
				}
			}
			return true;
		}
	}

}
