package fr.benco11.butilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.benco11.butilities.BUtilities;

public class CommandGm implements CommandExecutor {
	
	private BUtilities main;

	public CommandGm(BUtilities bUtilities) {
		this.main = bUtilities;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender player, Command cmd, String msg, String[] args) {
		
		if(player instanceof Player) {
			if(args.length == 0) {
				player.sendMessage("§" + main.error + "Tu dois entrer un gamemode !");
			} else {
				Player joueur = (Player) player;
				if(args.length > 2) {
					player.sendMessage("§" + main.error + "Tu dois entrer un gamemode correct !");
					
				} else if(args.length == 2){
					joueur = Bukkit.getPlayer(args[1]);
				}
				
				if(joueur != null) {
						if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("2")) {
							if(args[0].equalsIgnoreCase("0")) {
								joueur.setGameMode(GameMode.SURVIVAL);
							} else if(args[0].equalsIgnoreCase("1")) {
								joueur.setGameMode(GameMode.CREATIVE);
							} else if(args[0].equalsIgnoreCase("2")) {
								joueur.setGameMode(GameMode.ADVENTURE);
							}
							player.sendMessage((joueur == player) ? "§" + main.succes + "Tu viens de passer en gamemode " + args[0] : "§" + main.succes + "Le joueur " + joueur.getName() + " viens de passer en gamemode " + args[0]);
						} else if(args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("adventure")){
							if(args[0].equalsIgnoreCase("survival")) {
								joueur.setGameMode(GameMode.SURVIVAL);
							} else if(args[0].equalsIgnoreCase("creative")) {
								joueur.setGameMode(GameMode.CREATIVE);
							} else if(args[0].equalsIgnoreCase("adventure")) {
								joueur.setGameMode(GameMode.ADVENTURE);
							}
							player.sendMessage((joueur == player) ? "§" + main.succes + "Tu viens de passer en " + args[0] : "§" + main.succes + "Le joueur " + joueur.getName() + " viens de passer en " + args[0]);
						} else {
							player.sendMessage("§" + main.error + "Tu dois entrer 0, 1 ou 2 !");
						}
						
				} else {
					player.sendMessage("§" + main.error + "Tu dois entrer un pseudo valide !");
				}
				
				return true;
			}
			
		}
		
		return false;
	}

}
