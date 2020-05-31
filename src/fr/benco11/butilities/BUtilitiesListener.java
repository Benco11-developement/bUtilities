package fr.benco11.butilities;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class BUtilitiesListener implements Listener {
	private Player player;
	private BUtilities main;
	private File user = new File("bUtilities/usercache.yml");
	private YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(user);
	
	public BUtilitiesListener(BUtilities bUtilities) {
		this.main = bUtilities;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		event.setJoinMessage(null);
		player = event.getPlayer();
		if(main.getConfig().getBoolean("config.firstjoin") == true) {
			if(!(player.hasPlayedBefore())) {
				String bc = main.getConfig().getString("messages.broadcast.firstjoin");
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', bc.replaceAll("%player%", player.getName().replaceAll("%e%", "é"))));
				yamlFile.createSection("players." + player.getUniqueId());
				yamlFile.createSection("players." + player.getUniqueId() + ".ip");
				yamlFile.createSection("players." + player.getUniqueId() + ".name");
				if(main.getConfig().getBoolean("config.bvn") == true) {
					yamlFile.createSection("players." + player.getUniqueId() + ".bvn");
					yamlFile.createSection("players." + player.getUniqueId() + ".bvnC");
				}
				yamlFile.set("players." + player.getUniqueId() + ".name", player.getName());
				yamlFile.set("players." + player.getUniqueId() + ".ip", player.getAddress().toString());
				if(main.getConfig().getBoolean("config.bvn") == true) {
					yamlFile.set("players." + player.getUniqueId() + ".bvnC", '"' + '"');
				}
				try {
					yamlFile.save(user);
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(main.getConfig().getBoolean("config.bvn") == true) {
					task.runTaskLater(main, 20 * 10);
				}
				
			} 
		}
		
		if(main.getConfig().getBoolean("config.join") == true) {
			if(player.hasPlayedBefore()) {
				if(yamlFile.isConfigurationSection("players." + player.getUniqueId())) {
					yamlFile.set("players." + player.getUniqueId() + ".name", player.getName());
					yamlFile.set("players." + player.getUniqueId() + ".ip", player.getAddress().toString());
				} else {
					yamlFile.createSection("players." + player.getUniqueId());
					yamlFile.createSection("players." + player.getUniqueId() + ".ip");
					yamlFile.createSection("players." + player.getUniqueId() + ".name");
					yamlFile.set("players." + player.getUniqueId() + ".name", player.getName());
					yamlFile.set("players." + player.getUniqueId() + ".ip", player.getAddress().toString());
					try {
						yamlFile.save(user);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
					String bc = main.getConfig().getString("messages.broadcast.join");
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', bc.replaceAll("%player%", player.getName()).replaceAll("%e%", "é")));
			}
		}
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent event) {
		event.setQuitMessage(null);
		Player player = event.getPlayer();
		if(main.getConfig().getBoolean("config.leave") == true) {
			if(player.hasPlayedBefore()) {
				String bc = main.getConfig().getString("messages.broadcast.leave");
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', bc.replaceAll("%player%", player.getName()).replaceAll("%e%", "é")));
			}
		}
	}
	
	BukkitRunnable task = new BukkitRunnable() {
		@Override
		public void run() {
			yamlFile.set("players." + player.getUniqueId() + ".bvn", null);
			yamlFile.set("players." + player.getUniqueId() + ".bvnC", null);
			try {
				yamlFile.save(user);
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
	
	};
	
	@SuppressWarnings("deprecation")
	public void onBlockPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		if(player.getAddress().getHostName() == "cooli.minesr.com") {
			File user2 = new File("bUtilities/map.yml");
			YamlConfiguration yamlFile2 = YamlConfiguration.loadConfiguration(user2);
			if(event.getBlockPlaced().getTypeId() == yamlFile2.getInt("bomb")) {
				if(yamlFile2.getInt("map.bomb") < 10) {
					yamlFile2.set("map.bomb", (yamlFile2.getInt("map.bomb") + 1));
				} else {
					event.setCancelled(true);
				}
			} else if(event.getBlockPlaced().getTypeId() == yamlFile2.getInt("seismic_bomb")) {
				if(yamlFile2.getInt("map.seismic_bomb") < 1) {
					yamlFile2.set("map.seismic_bomb", 1);
				} else {
					event.setCancelled(true);
				}
			}
			try {
				yamlFile2.save(user2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
