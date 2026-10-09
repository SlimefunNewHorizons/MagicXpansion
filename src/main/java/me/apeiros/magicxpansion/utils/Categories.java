package me.apeiros.magicxpansion.utils;

import dev.drake.infinitylib.groups.MultiGroup;
import dev.drake.infinitylib.groups.SubGroup;
import io.github.thebusybiscuit.slimefun4.api.items.CustomItem;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import me.apeiros.magicxpansion.MagicXpansion;
import org.bukkit.Material;

public final class Categories {

    private Categories() {}

   public static final ItemGroup GENERAL = new SubGroup(
            "magicxpansion_general",
            new CustomItem(Material.ENCHANTED_BOOK, "&6MagicXpansion &7- &aGeneral", "", "&a⇨ Click to open")
    );

   public static final ItemGroup RESOURCES = new SubGroup(
            "magicxpansion_resources",
            new CustomItem(Material.NETHERITE_INGOT, "&6MagicXpansion &7- &bResources", "", "&b⇨ Click to open")
   );

   public static final ItemGroup MAGICAL = new SubGroup(
            "magicxpansion_magical",
            new CustomItem(Material.BLAZE_POWDER, "&6MagicXpansion &7- &eMagical Items", "", "&e⇨ Click to open")
   );

   public static final ItemGroup TOOLS = new SubGroup(
            "magicxpansion_tools",
            new CustomItem(Material.IRON_PICKAXE, "&6MagicXpansion &7- &dTools", "", "&d⇨ Click to open")
   );

   public static final ItemGroup WEAPONS = new SubGroup(
            "magicxpansion_weapons",
            new CustomItem(Material.NETHERITE_SWORD, "&6MagicXpansion &7- &cWeapons", "", "&c⇨ Click to open")
   );

   public static final ItemGroup ARMOR = new SubGroup(
            "magicxpansion_armor",
            new CustomItem(Material.DIAMOND_CHESTPLATE, "&6MagicXpansion &7- &cArmor", "", "&c⇨ Click to open")
   );

   public static final ItemGroup MACHINES = new SubGroup(
           "magicxpansion_machines",
           new CustomItem(Material.PISTON, "&6MagicXpansion &7- &eMachines", "", "&e⇨ Click to open")
   );

   public static final ItemGroup MAIN = new MultiGroup(
            "magicxpansion",
            new CustomItem(Material.END_PORTAL_FRAME, "&6MagicXpansion", "", "&5⇨ Click to open"),
            GENERAL, RESOURCES, MAGICAL, TOOLS, WEAPONS, ARMOR, MACHINES
   );
}