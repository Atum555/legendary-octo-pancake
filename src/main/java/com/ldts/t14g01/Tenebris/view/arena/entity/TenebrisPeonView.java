package com.ldts.t14g01.Tenebris.view.arena.entity;

import com.ldts.t14g01.Tenebris.gui.GUI;
import com.ldts.t14g01.Tenebris.model.arena.entity.monster.TenebrisPeon;

public class TenebrisPeonView extends EntityView<TenebrisPeon> {
    public TenebrisPeonView(TenebrisPeon model) {
        super(model);
    }

    @Override
    public void draw(GUI gui) {
        this.updateState();
        this.tickState();
        gui.drawMonster(this.model.getPosition(), GUI.Monster.TENEBRIS_PEON, this.state);
    }
}
