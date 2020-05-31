package fr.benco11.butilities.commands;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import fr.benco11.butilities.BUtilities;

public class CommandReport implements CommandExecutor {
	private int i = 1;
	private File user = new File("bUtilities/usercache.yml");
	private YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(user);
	private BUtilities main;
	
	public CommandReport(BUtilities bUtilities) {
		this.main = bUtilities;
	}

	@SuppressWarnings({ "deprecation"})
	@Override
	public boolean onCommand(CommandSender player, Command cmd, String msg, String[] args) {
		if(args.length == 0) return false;
		else {
			if(args[0].equalsIgnoreCase("list")) {
				if(player.hasPermission("butilities.reportlist")) {
					player.sendMessage("§6Liste des reports : \n \n");
					int i = 1;
					while(yamlFile.isConfigurationSection("report." + i)) {
						i++;
					}
					i--;
					for(int a = 0; a < i; a++) {
						player.sendMessage("§" + main.getConfig().getString("messages.player.color") + "- ID : " + (a + 1) + " || De : " + yamlFile.getString("report." + (a + 1) + ".by") + " || Accusé : " + yamlFile.getString("report." + (a + 1) + ".cheater") + " || Date : " + yamlFile.getString("report." + (a + 1) + ".date") + " || Accusation : " + 
					    yamlFile.getString("report." + (a + 1) + ".cheat") + " \n");
					}
				} else {
					player.sendMessage("§4Tu n'as pas la permission !");
				}
			} else if(args[0].equalsIgnoreCase("delete")) {
				if(player.hasPermission("butilities.reportdelete")) {
					if(args.length == 2) {
						if(yamlFile.isConfigurationSection("report." + args[1])) {
							yamlFile.set("report." + args[1], null);
							try {
								yamlFile.save(user);
							} catch (IOException e) {
								e.printStackTrace();
							}
							player.sendMessage("§" + main.succes + "Tu viens de supprimer le report avec l'ID " + args[1] + " !");
						} else {
							player.sendMessage("§" + main.error + "Cet ID de report n'existe pas !");
						}
					} else {
						return false;
					}
				} 
			} else if(args[0].equalsIgnoreCase("clear")){
				if(player.hasPermission("butilities.reportclear")) {
					int i = 1;
					while(yamlFile.isConfigurationSection("report." + i)) {
						yamlFile.set("report." + i, null);
						i++;
					}
					try {
						yamlFile.save(user);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					player.sendMessage("§" + main.succes + "Tu viens de supprimer touts les reports !");
				}
			} else {
				Player joueur = Bukkit.getPlayer(args[0]);
				OfflinePlayer jou2 = Bukkit.getOfflinePlayer(args[0]);
				if(args.length > 2 || args.length == 2) {
					if(joueur != null) {
						player.sendMessage("§" + main.succes + "Tu viens de report " + args[0]);
						while(yamlFile.isConfigurationSection("report." + i)) {
							i++;
						}
						StringBuilder sb = new StringBuilder();
						for(int i = 1; i < args.length; i++) {
							sb.append(args[i] + " ");
						}
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
						LocalDateTime localDate = LocalDateTime.now();
						yamlFile.createSection("report." + i);
						yamlFile.createSection("report." + i + ".by");
						yamlFile.createSection("report." + i + ".cheater");
						yamlFile.createSection("report." + i + ".cheat");
						yamlFile.createSection("report." + i + ".date");
						yamlFile.set("report." + i + ".by", player.getName());
						yamlFile.set("report." + i + ".cheater", joueur.getName());
						yamlFile.set("report." + this.i + ".cheat", sb.toString());
						yamlFile.set("report." + this.i + ".date", dtf.format(localDate));
						try {
							yamlFile.save(user);
						} catch (IOException e) {
							e.printStackTrace();
						}
						Player players[] = Bukkit.getOnlinePlayers();
						for(Player play : players) {
							if(play.hasPermission("butilities.reportlist")) {
								play.sendMessage("§6§lNouveau report !");
							}
						}
					} else if(!(yamlFile.contains("players." + jou2.getUniqueId()))){
						return false;
					} else {
						player.sendMessage("§" + main.succes + "Tu viens de report " + args[0]);
						while(yamlFile.isConfigurationSection("report." + i)) {
							i++;
						}
						StringBuilder sb = new StringBuilder();
						for(int i = 1; i < args.length; i++) {
							sb.append(args[i] + " ");
						}
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
						LocalDateTime localDate = LocalDateTime.now();
						yamlFile.createSection("report." + i);
						yamlFile.createSection("report." + i + ".by");
						yamlFile.createSection("report." + i + ".cheater");
						yamlFile.createSection("report." + i + ".cheat");
						yamlFile.createSection("report." + i + ".date");
						yamlFile.set("report." + i + ".by", player.getName());
						yamlFile.set("report." + i + ".cheater", jou2.getName());
						yamlFile.set("report." + this.i + ".cheat", sb.toString());
						yamlFile.set("report." + this.i + ".date", dtf.format(localDate));
						try {
							yamlFile.save(user);
						} catch (IOException e) {
							e.printStackTrace();
						}
						Player players[] = Bukkit.getOnlinePlayers();
						for(Player play : players) {
							if(play.hasPermission("butilities.reportlist")) {
								play.sendMessage("§6§lNouveau report !");
							}
						}
					}
					
				} else {
					return false;
				}
			}
			
			return true;
		}
	}

}
