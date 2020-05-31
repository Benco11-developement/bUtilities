package fr.benco11.butilities.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.benco11.butilities.BUtilities;

public class CommandTop implements CommandExecutor {

	private BUtilities main;

	public CommandTop(BUtilities bUtilities) {
		this.main = bUtilities;
	}

	@SuppressWarnings({ "unused" })
	@Override
	public boolean onCommand(CommandSender player, Command cmd, String msg, String[] args) {
		if(player instanceof Player) {
			Player joueur = (Player) player;
			if(args.length > 0) {
				joueur.sendMessage("§" + main.error + "Veuillez utiliser correctement la commande !");
			} else {
				int startx = joueur.getLocation().getBlockX();
				int endx = joueur.getLocation().getBlockX();
				int starty = joueur.getLocation().getBlockY() + 2;
				int startz = joueur.getLocation().getBlockZ();
				int endz = joueur.getLocation().getBlockZ();
				int endy = 256;
				int cY = 0;
				boolean fin = false;
				World world = joueur.getWorld();
				for (int y = starty; y < endy; y++) {
					for (int x = startx; x == endx; x++) {
	                    for (int z = startz; z == endz; z++) {
	                        Block block = world.getBlockAt(new Location(world, x, y, z));
	                        cY = -10000;
	                        if(block.getType() != Material.AIR){
	                        	if(world.getBlockAt(x, y+1, z).getType() == Material.AIR) {
	                        		if(world.getBlockAt(x, y+2, z).getType() == Material.AIR) {
			                        	cY = y;
			                        	fin = true;
			                        	break;
	                        		} 
	                        	} 
	                        }
	                        
	                        break;
	                    }
	                    break;
	                }
					
					if(fin == true) {
						break;
					}
					
	            }
				
				if(cY == -10000) {
					joueur.sendMessage("§6Il n'y a pas de block au dessus de vous...");
				} else {
					joueur.teleport(new Location(joueur.getWorld(), startx + 0.5, cY + 1, startz + 0.5));
					joueur.sendMessage("§" + main.succes + "Vous avez été téléporté avec succès !");
				}
				
				return true;
			}
			
		} else {
			player.sendMessage("§" + main.error + "Vous n'êtes pas un joueur !");
		}
		return false;
	}

}
