package me.apeiros.magicxpansion;

import dev.drake.infinitylib.core.AbstractAddon;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.apeiros.magicxpansion.listeners.CrossbowListener;
import me.apeiros.magicxpansion.listeners.MobDeathListener;
import me.apeiros.magicxpansion.listeners.TridentListener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.apeiros.magicxpansion.setup.Setup;

import javax.annotation.Nonnull;

public class MagicXpansion extends AbstractAddon implements SlimefunAddon {

    private static MagicXpansion instance;

    /**
     * InfinityLib 1.3 exige estas coordenadas en el constructor. Se dejan apuntando a nuestro
     * repo, no al de upstream: son las que usa el enlace de "reportar fallo" que ve el jugador,
     * y mandarlo al repo original seria mandarlo a quien no mantiene esta version.
     *
     * El autoactualizador no se dispara -- esta desarmado en nuestra InfinityLib --, asi que la
     * rama y la clave de config quedan solo por cumplir la firma.
     */
    public MagicXpansion() {
        super("SlimefunNewHorizons", "MagicXpansion", "main", "options.auto-update");
    }

    /**
     * En InfinityLib 1.3 onEnable y onDisable son finales: el punto de entrada del addon pasa a
     * ser enable(), que la libreria llama cuando ya ha dejado listos config y comandos.
     */
    @Override
    protected void enable() {
        instance = this;

        Setup.setup(instance);

        new TridentListener(this);
        new CrossbowListener(this);
        new MobDeathListener(this);
    }

    @Override
    protected void disable() {
        // El addon no deja nada abierto que haya que cerrar a mano.
    }

    @Nonnull
    public static MagicXpansion getInstance() {
        return instance;
    }

    public static boolean doesInvHaveSpace(Inventory inv, ItemStack addedItem) {
        // Returns true if an Inventory has space for an amount of items being added, false if not
        if (inv.addItem(addedItem).isEmpty()) {
            inv.removeItem(addedItem);
            return true;
        } else {
            return false;
        }
    }
}
