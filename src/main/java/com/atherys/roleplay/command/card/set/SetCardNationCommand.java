package com.atherys.roleplay.command.card.set;

import com.atherys.core.command.ParameterizedCommand;
import com.atherys.core.command.PlayerCommand;
import com.atherys.core.command.annotation.Aliases;
import com.atherys.core.command.annotation.Description;
import com.atherys.roleplay.AtherysRoleplay;
import com.atherys.roleplay.card.Nation;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

import javax.annotation.Nonnull;

@Aliases("nation")
@Description("Sets the nation of your character.")
public class SetCardNationCommand implements ParameterizedCommand, PlayerCommand {

    @Nonnull
    @Override
    public CommandResult execute(@Nonnull Player source, @Nonnull CommandContext args) throws CommandException {
        AtherysRoleplay.getInstance().getCardFacade().setCardNation(source, args.<Nation>getOne("nation").orElse(null));
        return CommandResult.success();
    }

    @Override
    public CommandElement[] getArguments() {
        return new CommandElement[]{
                GenericArguments.choices(
                        Text.of("nation"), AtherysRoleplay.getInstance().getCardFacade().getChoices())
        };
    }
}


