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

public class CreditsMenuController extends Controller<Menu> {
    public CreditsMenuController(Menu model) {
        super(model);
    }

    void executeOption(StateChanger stateChanger, SaveDataProvider saveDataProvider) throws IOException {
        stateChanger.setState(new MenuState(new MainMenu(saveDataProvider)));
    }

    void quit(StateChanger stateChanger) throws IOException {
        stateChanger.setState(null);
    }

    @Override
    public void tick(StateChanger stateChanger, SaveDataProvider saveDataProvider) throws IOException, InterruptedException {
        Action action = GUI.getGUI().getAction();

        switch (action) {
            case ESC, EXEC -> this.executeOption(stateChanger, saveDataProvider);
            case QUIT -> this.quit(stateChanger);
            case null, default -> {

            }
        }
    }
}
