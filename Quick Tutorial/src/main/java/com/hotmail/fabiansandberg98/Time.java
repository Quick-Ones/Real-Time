/*
 * 
 * Skype: neeh98
 * Bukkit: AdobeGFX
 * GitHub: AdobeGFX
 * Minecraft: AdobeGFX
 * YouTube: imTrelyx
 * Try out this server: play.prisonz.net
 * 
 */

package com.hotmail.fabiansandberg98;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Time extends JavaPlugin {

	public void onDisable() {
		System.out.println("Plugin disabled.");
	}

	public void onEnable() {
		System.out.println("Plugin enabled.");
	}

	public boolean onCommand(CommandSender sender, Command command, String cmd,
			String[] args) {
		if (cmd.equalsIgnoreCase("time")) {
			
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			
			if (!(sender instanceof Player)) {
				sender.sendMessage(format.format(date));
				
			} else {
				Player p = (Player) sender;
				if (!p.hasPermission("time.time")) {
					p.sendMessage(ChatColor.DARK_RED + "You do not have acces to that command!");
					
				} else if (args.length > 0) {
					p.sendMessage(ChatColor.DARK_RED + "Too many arguments!");
					
				} else {
					p.sendMessage(ChatColor.GOLD + format.format(date));
				}
			}
		}
		return false;
	}
}
