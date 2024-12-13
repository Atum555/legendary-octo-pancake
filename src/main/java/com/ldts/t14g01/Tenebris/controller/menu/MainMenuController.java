package com.ldts.t14g01.Tenebris.controller.menu;

import com.ldts.t14g01.Tenebris.controller.Controller;
import com.ldts.t14g01.Tenebris.gui.Action;
import com.ldts.t14g01.Tenebris.model.menu.*;
import com.ldts.t14g01.Tenebris.savedata.SaveDataProvider;
import com.ldts.t14g01.Tenebris.state.MenuState;
import com.ldts.t14g01.Tenebris.state.StateChanger;

import java.io.IOException;

public class MainMenuController extends Controller<Menu> {
    public MainMenuController(Menu model) {
        super(model);
    }

    void executeOption(StateChanger stateChanger) throws IOException {
        switch (MainMenu.MainMenuOptions.valueOf(this.getModel().getOptions().get(this.getModel().getSelectedOption()))) {
            case New_Game -> stateChanger.setState(new MenuState(new NewGameMenu()));
            case Load_Game -> stateChanger.setState(new MenuState(new LoadGameMenu()));
            case Levels -> stateChanger.setState(new MenuState(new LevelsMenu()));
            case Statistics -> stateChanger.setState(new MenuState(new StatisticsMenu()));
            case How_to_Play -> stateChanger.setState(new MenuState(new HowToPlayMenu()));
            case Credits -> stateChanger.setState(new MenuState(new CreditsMenu()));
            case Exit -> this.quit(stateChanger);
            // ToDo: Add Other Menus when they are available
            default -> {
            }
        }
    }

    void quit(StateChanger stateChanger) throws IOException {
        stateChanger.setState(null);
    }

    @Override
    public void tick(Action action, StateChanger stateChanger, SaveDataProvider saveDataProvider) throws IOException {
        switch (action) {
            case LOOK_UP -> this.getModel().moveUp();
            case LOOK_DOWN -> this.getModel().moveDown();
            case EXEC -> this.executeOption(stateChanger);
            case ESC, QUIT -> this.quit(stateChanger);
            case null, default -> {
            }
        }
    }
}
