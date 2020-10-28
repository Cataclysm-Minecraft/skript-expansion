package com.github.snowpyon.skriptexpansion;

import ch.njol.skript.registrations.Classes;
import ch.njol.skript.variables.Variables;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class SkriptExpansion extends PlaceholderExpansion {

    private final static Replacement<Player> UUID_REPLACEMENT = new Replacement<>(p -> p.getUniqueId().toString(),
            "(uuid of player|player's? uuid|uuid)");
    private final static Replacement<Player> NAME_REPLACEMENT = new Replacement<>(Player::getName,
            "(name of player|player's? name|player|name)");
    private final static Replacement<Player> DISPLAY_NAME_REPLACEMENT = new Replacement<>(Player::getDisplayName,
            "(display name of player|player's? display name|display name)");

    @Override
    public String getIdentifier() {
        return "skript";
    }

    @Override
    public String getAuthor() {
        return "Snow-Pyon";
    }

    @Override
    public String getVersion() {
        return "1.2.0";
    }

    @Override
    public String getRequiredPlugin() {
        return "Skript";
    }

    @Override
    public String onPlaceholderRequest(Player p, String params) {
        String varName = Replacement.applyAll(params, p, UUID_REPLACEMENT, NAME_REPLACEMENT, DISPLAY_NAME_REPLACEMENT);
        return Classes.toString(Variables.getVariable(varName.toLowerCase(), null, false));
    }

}
