package me.silver.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

@CommandAlias("wr")
public class WaveRoom extends BaseCommand {

    private static HashMap<Player, ArrayList<Location>> corners = new HashMap<>();

    @Default
    @Subcommand("create")
    public static void onCreate(CommandSender sender) {
        sender.sendMessage("This worked?");
    }

    // Totally not ripped off from World Edit
    @Subcommand("pos1")
    public static void setLeft(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player)sender;

            if (!corners.containsKey(player)) {
                corners.put(player, new ArrayList<>(2));
            }

            corners.get(player).set(0, player.getLocation());

            player.sendMessage("Set first point to " + player.getLocation().toString());
        } else {
            sender.sendMessage("Error: Command must be sent by a player");
        }
    }

    @Subcommand("pos2")
    public static void setRight(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player)sender;

            if (!corners.containsKey(player)) {
                corners.put(player, new ArrayList<>(2));
            }

            corners.get(player).set(1, player.getLocation());
            player.sendMessage("Set second point to " + player.getLocation().toString());
        } else {
            sender.sendMessage("Error: Command must be sent by a player");
        }
    }

}
