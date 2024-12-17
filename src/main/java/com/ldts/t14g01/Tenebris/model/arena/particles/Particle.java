package com.ldts.t14g01.Tenebris.model.arena.particles;

import com.ldts.t14g01.Tenebris.controller.arena.ParticleController;
import com.ldts.t14g01.Tenebris.model.arena.GameElement;
import com.ldts.t14g01.Tenebris.model.arena.Commands.Command;
import com.ldts.t14g01.Tenebris.utils.HitBoX;
import com.ldts.t14g01.Tenebris.utils.Vector2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Particle extends GameElement {
    protected ParticleController controller;
    private int currentFrame = 1;

    public Particle(Vector2D position) {
        super(position, new HitBoX(new Vector2D(0, 0), new Vector2D(0, 0)));
        this.controller = new ParticleController(this);
    }

    public int getCurrentFrame() {
        return this.currentFrame;
    }

    public abstract boolean isOver();

    public void update() {
        this.currentFrame++;
    }

    public ParticleController getController() {
        return this.controller;
    }

    // This elements don't interact
    @Override
    public List<Command> interact(GameElement other) {
        return new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Particle particle = (Particle) o;
        return currentFrame == particle.currentFrame && Objects.equals(controller, particle.controller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(controller, currentFrame);
    }
}
