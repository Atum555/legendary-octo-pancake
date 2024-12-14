package com.ldts.t14g01.Tenebris.view.arena.staticelement;

import com.ldts.t14g01.Tenebris.gui.GUI;
import com.ldts.t14g01.Tenebris.model.arena.staticelement.SandBag;
import com.ldts.t14g01.Tenebris.view.arena.ElementView;

public class SandbagView extends ElementView<SandBag> {
    public SandbagView(SandBag model) {
        super(model);
    }

    @Override
    public void draw(GUI gui) {
        gui.drawSandbag(this.model.getPosition());
    }
}