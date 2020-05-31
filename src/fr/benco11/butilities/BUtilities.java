package fr.benco11.butilities;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import fr.benco11.butilities.commands.CommandBienvenue;
import fr.benco11.butilities.commands.CommandCheck;
import fr.benco11.butilities.commands.CommandGiveAll;
import fr.benco11.butilities.commands.CommandGm;
import fr.benco11.butilities.commands.CommandHeal;
import fr.benco11.butilities.commands.CommandReport;
import fr.benco11.butilities.commands.CommandSpam;
import fr.benco11.butilities.commands.CommandStaff;
import fr.benco11.butilities.commands.CommandTop;

public class BUtilities extends JavaPlugin {
	
	FileConfiguration config = getConfig();
	public String error;
	public String succes;
	@Override
	public void onEnable() {
		System.out.println("[bUtilities] Demarrage");
        this.saveDefaultConfig();
		
		this.getCommand("gm").setExecutor(new CommandGm(this));
		this.getCommand("heal").setExecutor(new CommandHeal(this));
		this.getCommand("feed").setExecutor(new CommandHeal(this));
		this.getCommand("top").setExecutor(new CommandTop(this));
		this.getCommand("spam").setExecutor(new CommandSpam(this));
		this.getCommand("giveall").setExecutor(new CommandGiveAll(this));
		this.getCommand("check").setExecutor(new CommandCheck(this));
		this.getCommand("report").setExecutor(new CommandReport(this));
		this.getCommand("bienvenue").setExecutor(new CommandBienvenue(this));
		this.getCommand("staff").setExecutor(new CommandStaff(this));
		this.getServer().getPluginManager().registerEvents(new BUtilitiesListener(this), this);
		
		this.succes = config.getString("messages.player.succes");
		this.error = config.getString("messages.player.error");
		
	}
		
	
	@Override
	public void onDisable() {
		System.out.println("[bUtilities] Arret");
	}
	
}
