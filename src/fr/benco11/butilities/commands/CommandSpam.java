package fr.benco11.butilities.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.benco11.butilities.BUtilities;

public class CommandSpam implements CommandExecutor {

	private BUtilities main;
	public CommandSpam(BUtilities bUtilities) {
		this.main = bUtilities;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender player, Command cmd, String msg, String[] args) {
		if(args.length != 1) {
			player.sendMessage("§" + main.error + "Veuilliez renter le pseudo d'un joueur !");
		} else {
			String color = "a";
			Player joueur = Bukkit.getPlayer(args[0]);
			Random random = new Random();
			player.sendMessage("§" + main.succes + "Spam commencé sur " + args[0]);
			int b = random.nextInt(15);
			if(b == 1) {b=54000;}
			if(b == 2) {b=7920;}
			if(b == 3) {b=22000;}
			if(b == 4) {b=8800;}
			if(b == 5) {b=3428;}
			if(b == 6) {b=91400;}
			if(b == 7) {b=9200;}
			if(b == 8) {b=7200;}
			if(b == 9) {b=13000;}
			if(b == 10) {b=2941;}
			if(b == 11) {b=35300;}
			if(b == 12) {b=890;}
			if(b == 13) {b=95000;}
			if(b == 14) {b=7690;}
			if(b == 15) {b=24790;}
			if(joueur != null) {
				for(int i = 0; i != b; i++) {
					int a = 1;
					a = random.nextInt(15);
					joueur = Bukkit.getPlayer(args[0]);
					if(joueur == null) {
						break;
					}
					if(a == 1) {joueur.sendMessage("§" + color + " §kJksdgiJGndjgnsdpg8DP52fg0q54dglkjKJGJENkngjdngjdngdjfgndjghskjIHJQNJhgsdgsdjgfsdjghdfjghNGnbdgbdhgbdughdghIud4g");}
					else if(a == 2) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fgiJ?FKngfk?Gdfgg");}
					else if(a == 3) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fgiJ?FKngfk?GsdfsdfdF454g8ù^$gkgg");}
					else if(a == 4) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fngfk?8");}
					else if(a == 5) {joueur.sendMessage("§" + color + " §kJ892?Gddfg");}
					else if(a == 6) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fgiJ?FKng878f4d5g4d5fg4dsfgkjdifgjdfhUndfgnfk?Gdfgg");}
					else if(a == 7) {joueur.sendMessage("§" + color + " §kJ892fgoOn/5d8g5d2dd8g5d9fg5df9g58er5d5f2g5dfg8df5g8df5g8d5£*fgiJ?FKngfk?Gdfgg");}
					else if(a == 8) {joueur.sendMessage("§" + color + " §kJ89fsdsdfsdfsdfsdfsdfsdfsdffgngfk?Gdfgg");}
					else if(a == 9) {joueur.sendMessage("§" + color + " §k?Gdfgg");}
					else if(a == 10) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fgiOKOjidjfgidhgudfhgidjgdsfJ?FKngfk?Gdfgg");}
					else if (a == 11) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fgiJ?FKnPPdfogkdofgjdighr%psdlgdmgpKIKDJFGNDFJGHNJDNRFJGBFIDJGIDFGJDFgfk?Gdfgg");}
					else if(a == 12) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fgiJ?FKngfsdsdfsdflKOkifdjgkdjfgkjgdfjgidjfgierjgidfjgirjgidjfgojriogjdfoigjdoifjgiodfjgdfjgdfgdjgik?Gdfgg");}
					else if(a == 13) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fgiJ?FKngfk?sdfsdfsdfLkdfgkfgkfdgdfkgodfgkofkgodfkgodfkgodfkgofkgodfkgodkfgorijdfjgdfigjdifjgfjdgijdfigjdijgidjfdgijGdfgg");}
					else if(a == 14) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fgiJ?FKngfk?GdfggIkdfgdkdfgjdkfgjkdfjgkdjfgkdjfgkdjfgjdfkgjdfkjgdfkgjdkfgjkdfjgkdjfgkdfjgdkfjgdfgj");}
					else if(a == 15) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fgiJ?FKngsdfsdfPOKoksdofksodkfosdkfosdkfosdkfosdkfoskdfodskfsdfoskdfoksdfkdokfsfk?Gdfgg");}
					if(color == "a") {color="b";}
					else if(color == "b") {color="c";}
					else if(color == "c") {color="9";}
					else if(color == "9") {color="6";}
					else if(color == "6") {color="5";}
					else if(color == "5") {color="e";}
					else if(color == "e") {color="8";}
					else if(color == "8") {color="d";}
					else if(color == "d") {color="1";}
					else if(color == "1") {color="3";}
					else if(color == "3") {color="0";}
					else if(color == "0") {color="2";}
					else if(color == "2") {color="f";}
					else if(color == "f") {color="7";}
					else if(color == "7") {color="4";}
					else if(color == "4") {color="a";}
					a = 1;
					a = random.nextInt(15);
					if(a == 1) {joueur.sendMessage("§" + color + " §kJksdgiJGndjgnsdpg8DP52fg0q54dglkjKJGJENkngjdngjdngdjfgndjghskjIHJQNJhgsdgsdjgfsdjghdfjghNGnbdgbdhgbdughdghIud4g");}
					else if(a == 2) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fgiJ?FKngfk?Gdfgg");}
					else if(a == 3) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fgiJ?FKngfk?GsdfsdfdF454g8ù^$gkgg");}
					else if(a == 4) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fngfk?8");}
					else if(a == 5) {joueur.sendMessage("§" + color + " §kJ892?Gddfg");}
					else if(a == 6) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fgiJ?FKng878f4d5g4d5fg4dsfgkjdifgjdfhUndfgnfk?Gdfgg");}
					else if(a == 7) {joueur.sendMessage("§" + color + " §kJ892fgoOn/5d8g5d2dd8g5d9fg5df9g58er5d5f2g5dfg8df5g8df5g8d5£*fgiJ?FKngfk?Gdfgg");}
					else if(a == 8) {joueur.sendMessage("§" + color + " §kJ89fsdsdfsdfsdfsdfsdfsdfsdffgngfk?Gdfgg");}
					else if(a == 9) {joueur.sendMessage("§" + color + " §k?Gdfgg");}
					else if(a == 10) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fgiOKOjidjfgidhgudfhgidjgdsfJ?FKngfk?Gdfgg");}
					else if (a == 11) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fgiJ?FKnPPdfogkdofgjdighr%psdlgdmgpKIKDJFGNDFJGHNJDNRFJGBFIDJGIDFGJDFgfk?Gdfgg");}
					else if(a == 12) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fgiJ?FKngfsdsdfsdflKOkifdjgkdjfgkjgdfjgidjfgierjgidfjgirjgidjfgojriogjdfoigjdoifjgiodfjgdfjgdfgdjgik?Gdfgg");}
					else if(a == 13) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fgiJ?FKngfk?sdfsdfsdfLkdfgkfgkfdgdfkgodfgkofkgodfkgodfkgodfkgofkgodfkgodkfgorijdfjgdfigjdifjgfjdgijdfigjdijgidjfdgijGdfgg");}
					else if(a == 14) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fgiJ?FKngfk?GdfggIkdfgdkdfgjdkfgjkdfjgkdjfgkdjfgkdjfgjdfkgjdfkjgdfkgjdkfgjkdfjgkdjfgkdfjgdkfjgdfgj");}
					else if(a == 15) {joueur.sendMessage("§" + color + " §kJ892fgoOn/£*fgiJ?FKngsdfsdfPOKoksdofksodkfosdkfosdkfosdkfosdkfoskdfodskfsdfoskdfoksdfkdokfsfk?Gdfgg");}
					if(color == "a") {color="b";}
					else if(color == "b") {color="c";}
					else if(color == "c") {color="9";}
					else if(color == "9") {color="6";}
					else if(color == "6") {color="5";}
					else if(color == "5") {color="e";}
					else if(color == "e") {color="8";}
					else if(color == "8") {color="d";}
					else if(color == "d") {color="1";}
					else if(color == "1") {color="3";}
					else if(color == "3") {color="0";}
					else if(color == "0") {color="2";}
					else if(color == "2") {color="f";}
					else if(color == "f") {color="7";}
					else if(color == "7") {color="4";}
					else if(color == "4") {color="a";}
					
					if(i == b-1) {
						player.sendMessage("§" + main.succes + "Spam de " + args[0] + " fini (côté serveur)");
					}
				}
				
			}
		}
		return true;
	}

}
