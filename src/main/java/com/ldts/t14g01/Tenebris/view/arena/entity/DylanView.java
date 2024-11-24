package com.ldts.t14g01.Tenebris.view.arena.entity;

import com.ldts.t14g01.Tenebris.gui.GUI;
import com.ldts.t14g01.Tenebris.model.arena.entity.Dylan;
import com.ldts.t14g01.Tenebris.utils.Vector2D;
import com.ldts.t14g01.Tenebris.view.View;

import java.io.IOException;

public class DylanView extends View<Dylan> {
    public DylanView(Dylan model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        gui.drawRectangle(
                new Vector2D(350, 100),
                new Vector2D(50, 50),
                GUI.Colors.BRIGHT_YELLOW
        );
    }
}