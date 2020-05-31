package fr.benco11.butilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.benco11.butilities.BUtilities;

public class CommandStaff implements CommandExecutor {

	private BUtilities main;

	public CommandStaff(BUtilities bUtilities) {
		this.main = bUtilities;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender player, Command cmd, String msg, String[] args) {
		Player joueur[] = Bukkit.getOnlinePlayers();
		StringBuilder sb = new StringBuilder();
		for(Player pl : joueur) {
			if(main.getConfig().getString("config.stafflist").contains(pl.getName())) {
				sb.append(pl.getName() + " ");
			}
		}
		player.sendMessage("§6Il y'a " + ChatColor.translateAlternateColorCodes('&', (sb.toString())) + "comme staff en ligne !");
		return true;
	}

}
