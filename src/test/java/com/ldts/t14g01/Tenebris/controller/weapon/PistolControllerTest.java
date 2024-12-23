package com.ldts.t14g01.Tenebris.controller.weapon;

import com.ldts.t14g01.Tenebris.controller.arena.weapon.PistolController;
import com.ldts.t14g01.Tenebris.model.arena._commands.CommandHandler;
import com.ldts.t14g01.Tenebris.model.arena._commands.CreateProjectile;
import com.ldts.t14g01.Tenebris.model.arena.weapons.Pistol;
import com.ldts.t14g01.Tenebris.sound.SoundManager;
import com.ldts.t14g01.Tenebris.utils.Vector2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class PistolControllerTest {
    private PistolController controller;
    private Pistol model;
    private CommandHandler commandHandler;
    private SoundManager soundManager;

    @BeforeEach
    void setUp() {
        this.model = Mockito.mock(Pistol.class);
        this.controller = new PistolController(model);
        this.commandHandler = Mockito.mock(CommandHandler.class);
        this.soundManager = Mockito.mock(SoundManager.class);
    }

    @Test
    void cannotShootTest() {
        try (MockedStatic<SoundManager> managerMocked = Mockito.mockStatic(SoundManager.class)) {
            managerMocked.when(SoundManager::getInstance).thenReturn(soundManager);
            Mockito.when(model.canShoot()).thenReturn(false);
            this.controller.shoot(this.commandHandler, new Vector2D(2, 2), Vector2D.Direction.DOWN);
            Mockito.verify(model, Mockito.never()).shot();
            Mockito.verify(commandHandler, Mockito.never()).handleCommand(Mockito.any(CreateProjectile.class));
            Mockito.verify(soundManager, Mockito.never()).playSFX(SoundManager.SFX.SHOOT);
        }
    }

    @Test
    void canShootTest() {
        try (MockedStatic<SoundManager> managerMocked = Mockito.mockStatic(SoundManager.class)) {
            managerMocked.when(SoundManager::getInstance).thenReturn(soundManager);
            Mockito.when(model.canShoot()).thenReturn(true);
            this.controller.shoot(this.commandHandler, new Vector2D(2, 2), Vector2D.Direction.DOWN);
            Mockito.verify(model, Mockito.times(1)).shot();
            Mockito.verify(commandHandler, Mockito.times(1)).handleCommand(Mockito.any(CreateProjectile.class));
            Mockito.verify(soundManager, Mockito.times(1)).playSFX(SoundManager.SFX.SHOOT);
        }
    }

    @Test
    void reloadSoundTest() {
        try (MockedStatic<SoundManager> managerMocked = Mockito.mockStatic(SoundManager.class)) {
            managerMocked.when(SoundManager::getInstance).thenReturn(soundManager);
            this.controller.reload();
            Mockito.verify(soundManager, Mockito.times(1)).playSFX(SoundManager.SFX.PISTOL_RELOAD);
        }
    }
}
