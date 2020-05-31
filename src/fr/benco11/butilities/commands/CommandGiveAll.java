package fr.benco11.butilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.benco11.butilities.BUtilities;


public class CommandGiveAll implements CommandExecutor {

	boolean ret;
	boolean finish = false;
	private BUtilities main;
	public CommandGiveAll(BUtilities bUtilities) {
		this.main = bUtilities;
	}
	@SuppressWarnings({"deprecation", "unused" })
	@Override
	public boolean onCommand(CommandSender player, Command cmd, String msg, String[] args) {
		if(args.length == 0 || args.length > 3) return false;
		else {
			finish = false;
			if(args.length == 3) {
				Player joueur[] = Bukkit.getServer().getOnlinePlayers();
				Material m = Material.matchMaterial(args[0]);
				if(m != null) {
					int quant = -1;
					quant = Integer.parseInt(args[1]);
					Short meta = -1;
					meta = Short.parseShort(args[2]);
					if(quant != -1 && meta != -1 && meta > 0 && quant > 0 && quant < 500) {
						ItemStack item = new ItemStack(m, quant, meta);
						if(item != null) {
							for(Player a : joueur) {
								ret = a.getInventory().addItem(item) != null;
								if(!ret) {
									break;
								}
							}
						} else {
							finish = true;
							player.sendMessage("§" + main.error + "La metadata de l'item est incorrecte !");
						}
					} else {
						finish = true;
						player.sendMessage("§" + main.error + "Veuilliez rentrer un metadate positif et une quantité comprise entre 1 et 500 !");
					}
				} else {
					finish = true;
					player.sendMessage("§" + main.error + "L'item est incorrecte (essayer de rentrer l'ID) !");
				}
			}
			
			if(args.length == 2) {
				Player joueur[] = Bukkit.getServer().getOnlinePlayers();
				Material m = Material.matchMaterial(args[0]);
				if(m != null) {
					int quant = -1;
					quant = Integer.parseInt(args[1]);
					if(quant != -1 && quant > 0 && quant < 500) {
						ItemStack item = new ItemStack(m, quant);
						if(item != null) {
							for(Player a : joueur) {
								ret = a.getInventory().addItem(item) != null;
								if(!ret) {
									break;
								}
							}
						}
					} else {
						finish = true;
						player.sendMessage("§" + main.error + "Veuilliez rentrer un metadate positif et une quantité comprise entre 1 et 500 !");
					}
				} else {
					finish = true;
					player.sendMessage("§" + main.error + "L'item est incorrecte (essayer de rentrer l'ID) !");
				}
			}
			
			if(args.length == 1) {
				Player joueur[] = Bukkit.getServer().getOnlinePlayers();
				Material m = Material.matchMaterial(args[0]);
				if(m != null) {
					ItemStack item = new ItemStack(m, 1);
					if(item != null) {
						for(Player a : joueur) {
							ret = a.getInventory().addItem(item) != null;
							if(!ret) {
								break;
							}
						}
					}
				} else {
					finish = true;
					player.sendMessage("§" + main.error + "L'item est incorrecte (essayer de rentrer l'ID) !");
				}
			}
			
			if(ret && finish == false) {
				player.sendMessage("§" + main.succes + "Tu viens de give à tout le monde l'item : " + args[0]);
			} else if(finish == false){
				player.sendMessage("§" + main.error + "Veuilliez remplire correctement les champs !");
			}
			return true;
		}
	}

}
