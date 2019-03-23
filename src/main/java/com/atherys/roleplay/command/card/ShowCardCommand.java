package com.atherys.roleplay.command.card;

import com.atherys.core.command.annotation.Aliases;
import com.atherys.core.command.annotation.Description;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;

import javax.annotation.Nonnull;

@Aliases("show")
@Description("Displays your own character card.")
public class ShowCardCommand implements CommandExecutor {

    @Nonnull
    @Override
    public CommandResult execute(@Nonnull CommandSource src, @Nonnull CommandContext args) throws CommandException {
        if(!(src instanceof Player)) return CommandResult.empty();
        Player player = ((Player) src).getPlayer().get();
        //CardManager.getInstance().getCard(player).createView().show(player);
        return CommandResult.success();
    }
}
