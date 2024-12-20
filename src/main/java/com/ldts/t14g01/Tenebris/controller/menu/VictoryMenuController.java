package com.ldts.t14g01.Tenebris.controller.menu;

import com.ldts.t14g01.Tenebris.controller.Controller;
import com.ldts.t14g01.Tenebris.gui.Action;
import com.ldts.t14g01.Tenebris.gui.GUI;
import com.ldts.t14g01.Tenebris.model.menu.MainMenu;
import com.ldts.t14g01.Tenebris.model.menu.Menu;
import com.ldts.t14g01.Tenebris.savedata.SaveDataProvider;
import com.ldts.t14g01.Tenebris.state.MenuState;
import com.ldts.t14g01.Tenebris.state.StateChanger;

import java.io.IOException;

public class VictoryMenuController extends Controller<Menu> {
    private static final int DELAY = 30;
    private int frameCount;

    public VictoryMenuController(Menu model) {
        super(model);
    }

    @Override
    public void tick(StateChanger stateChanger, SaveDataProvider saveDataProvider) throws IOException, InterruptedException {
        frameCount++;
        if (frameCount < DELAY) return;

        Action action = GUI.getGUI().getAction();

        switch (action) {
            case ESC, EXEC -> stateChanger.setState(new MenuState(new MainMenu(saveDataProvider)));
            case QUIT -> stateChanger.setState(null);
            case null, default -> {
            }
        }
    }
}
