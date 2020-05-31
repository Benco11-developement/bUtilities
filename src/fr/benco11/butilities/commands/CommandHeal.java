package fr.benco11.butilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.benco11.butilities.BUtilities;

public class CommandHeal implements CommandExecutor {

	private BUtilities main;

	public CommandHeal(BUtilities bUtilities) {
		this.main = bUtilities;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender player, Command cmd, String msg, String[] args) {
		if(player instanceof Player) {
			Player joueur = (Player) player;
			if(cmd.getName().equalsIgnoreCase("feed")) {
				if(player instanceof Player) {
					if(args.length > 1) {
						player.sendMessage("§" + main.error + "Veuilliez entrer des options valides !");
					} else {
						if(args.length == 1) {
							joueur = Bukkit.getPlayer(args[0]);
						} 
						
						if(joueur != null) {
							joueur.setFoodLevel(20);
							if(joueur == player) {
								player.sendMessage("§" + main.succes + "Vous avez été rassasié !");
							} else {
								player.sendMessage("§" + main.succes + joueur.getName() + " a été rassasié !");
							}
							
						} else {
							player.sendMessage("§" + main.error + "Veuillez entrer un pseudo valide!");
						}		
					}
				} else {
					player.sendMessage("§" + main.error + "Vous n'êtes pas un joueur !");
				}
				return true;
			} else if(cmd.getName().equalsIgnoreCase("heal")) {
				if(player instanceof Player) {
					if(args.length > 1) {
						player.sendMessage("§" + main.error + "Veuilliez entrer des options valides !");
					} else {
						if(args.length == 1) {
							joueur = Bukkit.getPlayer(args[0]);
						} 
						
						if(joueur != null) {
							joueur.setFoodLevel(20);
							joueur.setHealth(20.0);
							if(joueur == player) {
								player.sendMessage("§" + main.succes + "Vous avez récupéré votre vie !");
							} else {
								player.sendMessage("§" + main.succes + joueur.getName() + " a récupéré sa vie !");
							}
							
						} else {
							player.sendMessage("§" + main.error + "Veuillez entrer un pseudo valide!");
						}		
					}
					
				} else {
					player.sendMessage("§" + main.error + "Vous n'êtes pas un joueur");
				}
				return true;
			}
			
			return false;
		} else {
			player.sendMessage("§" + main.error + "Vous n'êtes pas un joueur");
			return true;
		}
	}

}
