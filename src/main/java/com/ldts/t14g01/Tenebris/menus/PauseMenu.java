package com.ldts.t14g01.Tenebris.menus;

import com.ldts.t14g01.Tenebris.State;
import com.ldts.t14g01.Tenebris.screen.ScreenGetter;

import java.io.IOException;

public class PauseMenu implements Menu {
    private static final String name = "Pause";

    @Override
    public void run(ScreenGetter screenGetter, State state) throws IOException, InterruptedException {
    }

    @Override
    public String getName() {
        return PauseMenu.name;
    }
}