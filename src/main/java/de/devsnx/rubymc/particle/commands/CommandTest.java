package de.devsnx.rubymc.particle.commands;

import de.devsnx.rubymc.particle.utils.Utils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author DevSnx
 * @since 23.02.2023
 */
public class CommandTest implements CommandExecutor {

    @Override
    public boolean onCommand( CommandSender sender,  Command command,  String label,  String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        Player pSender = (Player) sender;
        Location loc = pSender.getLocation();
        //Utils.spawnCircle(loc, pSender, 5);
        Utils.createSquare(pSender, loc, 2, 5);

        return true;
    }
}
