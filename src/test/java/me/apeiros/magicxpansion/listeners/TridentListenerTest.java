package me.apeiros.magicxpansion.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.projectiles.BlockProjectileSource;
import org.bukkit.projectiles.ProjectileSource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

class TridentListenerTest {

    // Exercise the real handler without registering a plugin in a live server.
    private final TridentListener listener = mock(TridentListener.class, CALLS_REAL_METHODS);

    @Test
    void dispenserProjectileDoesNotCastBlockSourceToEntity() {
        assertIgnored(EntityType.TRIDENT, mock(BlockProjectileSource.class));
    }

    @Test
    void projectileWithoutShooterIsIgnored() {
        assertIgnored(EntityType.TRIDENT, null);
    }

    @Test
    void mobProjectileIsIgnored() {
        assertIgnored(EntityType.TRIDENT, mock(Skeleton.class));
    }

    @Test
    void playerArrowDoesNotInspectOffhandOrReceiveTridentBoost() {
        Player player = mock(Player.class);
        assertIgnored(EntityType.ARROW, player);
        verifyNoInteractions(player);
    }

    private void assertIgnored(EntityType type, ProjectileSource source) {
        Projectile projectile = mock(Projectile.class);
        when(projectile.getType()).thenReturn(type);
        when(projectile.getShooter()).thenReturn(source);

        assertDoesNotThrow(() -> listener.onTridentShoot(new ProjectileLaunchEvent(projectile)));

        verify(projectile, never()).getVelocity();
        verify(projectile, never()).setVelocity(any());
    }
}
