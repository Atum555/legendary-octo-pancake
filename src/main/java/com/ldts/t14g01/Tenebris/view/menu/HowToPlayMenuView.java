package com.ldts.t14g01.Tenebris.view.menu;

import com.ldts.t14g01.Tenebris.gui.GUI;
import com.ldts.t14g01.Tenebris.model.menu.HowToPlayMenu;
import com.ldts.t14g01.Tenebris.model.menu.Menu;
import com.ldts.t14g01.Tenebris.utils.Vector2D;
import com.ldts.t14g01.Tenebris.view.View;

import java.util.ArrayList;
import java.util.List;

public class HowToPlayMenuView extends View<Menu> {
    public HowToPlayMenuView(Menu model) {
        super(model);
    }

    @Override
    protected void drawElements() {
        GUI gui = GUI.getGUI();

        // Get center position
        int centerX = gui.getWindowSize().x() / 2;
        int centerY = gui.getWindowSize().y() / 2;

        // X axis Offset
        int offsetX = 4;

        // Draw Lines
        List<String> titleLines = new ArrayList<>();
        titleLines.add("How to Play");
        titleLines.add("───────────────");

        // Draw Title
        for (int i = 0; i < titleLines.size(); i++)
            gui.drawText(
                    titleLines.get(i),
                    new Vector2D(offsetX, centerY - 8 + i),
                    GUI.Colors.BRIGHT_YELLOW,
                    GUI.Colors.BLACK
            );

        // Draw Options
        for (int i = 0; i < this.getModel().getOptions().size(); i++) {
            GUI.Colors foreGroundColor;

            // Highlight selected Option
            if (i == this.getModel().getSelectedOption()) foreGroundColor = GUI.Colors.YELLOW;
            else foreGroundColor = GUI.Colors.WHITE;

            // Draw Back Button (special case)
            if (i == this.getModel().getOptions().size() - 1) {
                gui.drawText(
                        this.getModel().getOptions().get(i).replace('_', ' '),
                        new Vector2D(centerX - this.getModel().getOptions().get(i).length() / 2, gui.getWindowSize().y() - 2),
                        foreGroundColor,
                        GUI.Colors.BLACK
                );

            }

            // Draw other Option
            else
                gui.drawText(
                        this.getModel().getOptions().get(i).replace('_', ' '),
                        new Vector2D(offsetX, 6 + i),
                        foreGroundColor,
                        GUI.Colors.BLACK
                );

            // Draw Information of the selected option
            switch (HowToPlayMenu.HowToPlayMenuOptions.valueOf(this.getModel().getOptions().get(this.getModel().getSelectedOption()))) {
                case Menu_Navigation -> this.drawMenuNavigationControls();
                case Default_Controls -> this.drawDefaultControls();
                case Objective -> this.drawObjective();
                case Game_Basics -> this.drawGameBasics();
                case Weapons -> this.drawWeapons();
                case Enemies -> this.drawEnemies();
                case Bosses -> this.drawBosses();
                case Difficulty_Levels -> this.drawDifficultyLevels();
                case Map_Elements -> this.drawMapElements();
            }
        }
    }

    private void drawMenuNavigationControls() {
        GUI gui = GUI.getGUI();

        // Draw Navigation Controls Explanation
        List<String> navigationOptions = new ArrayList<>();
        navigationOptions.add(" - Move Up");
        navigationOptions.add(" - Move Down");
        navigationOptions.add(" - Select Option");
        navigationOptions.add(" - Go to Previous Menu");
        navigationOptions.add(" - Quit Game");

        List<String> navigationKeys = new ArrayList<>();
        navigationKeys.add("      ↑");
        navigationKeys.add("      ↓");
        navigationKeys.add("  Enter");
        navigationKeys.add("    ESC");
        navigationKeys.add("      Q");

        for (int i = 0; i < navigationOptions.size(); i++) {
            gui.drawText(
                    navigationKeys.get(i),
                    new Vector2D(23, 6 + i),
                    GUI.Colors.CYAN,
                    GUI.Colors.BLACK
            );
            gui.drawText(
                    navigationOptions.get(i),
                    new Vector2D(23 + navigationKeys.get(i).length(), 6 + i),
                    GUI.Colors.WHITE,
                    GUI.Colors.BLACK
            );
        }
    }

    private void drawDefaultControls() {
        GUI gui = GUI.getGUI();

        gui.drawText(
                "Move Character:",
                new Vector2D(25, 6),
                GUI.Colors.WHITE,
                GUI.Colors.BLACK
        );

        // Draw Movement Controls Explanation
        List<String> defaultMovementDescription = new ArrayList<>();
        defaultMovementDescription.add(" - Up");
        defaultMovementDescription.add(" - Left");
        defaultMovementDescription.add(" - Down");
        defaultMovementDescription.add(" - Right");

        List<String> defaultMovementKeys = new ArrayList<>();
        defaultMovementKeys.add("   W");
        defaultMovementKeys.add("   A");
        defaultMovementKeys.add("   S");
        defaultMovementKeys.add("   D");

        for (int i = 0; i < defaultMovementDescription.size(); i++) {
            gui.drawText(
                    defaultMovementDescription.get(i),
                    new Vector2D(29, 7 + i),
                    GUI.Colors.WHITE,
                    GUI.Colors.BLACK
            );
            gui.drawText(
                    defaultMovementKeys.get(i),
                    new Vector2D(25, 7 + i),
                    GUI.Colors.CYAN,
                    GUI.Colors.BLACK
            );
        }


        // Draw Aim Controls Explanation
        gui.drawText(
                "Aim Controls:",
                new Vector2D(43, 6),
                GUI.Colors.WHITE,
                GUI.Colors.BLACK
        );

        List<String> defaultAimDescription = new ArrayList<>();
        defaultAimDescription.add(" - Up");
        defaultAimDescription.add(" - Left");
        defaultAimDescription.add(" - Down");
        defaultAimDescription.add(" - Right");
        defaultAimDescription.add(" - Shoot");

        List<String> defaultAimKeys = new ArrayList<>();
        defaultAimKeys.add("    ↑");
        defaultAimKeys.add("    ←");
        defaultAimKeys.add("    ↓");
        defaultAimKeys.add("    →");
        defaultAimKeys.add("Space");

        for (int i = 0; i < defaultAimDescription.size(); i++) {
            gui.drawText(
                    defaultAimKeys.get(i),
                    new Vector2D(43, 7 + i),
                    GUI.Colors.CYAN,
                    GUI.Colors.BLACK
            );
            gui.drawText(
                    defaultAimDescription.get(i),
                    new Vector2D(48, 7 + i),
                    GUI.Colors.WHITE,
                    GUI.Colors.BLACK
            );
        }
    }

    private void drawObjective() {
        GUI gui = GUI.getGUI();

        // Draw Game Objective Explanation
        List<String> lines = new ArrayList<>();
        lines.add("Play as Dylan Macron, ");
        lines.add("a character fighting for survival,");
        lines.add("as he battles monsters ");
        lines.add("across different arenas.");
        lines.add("Collect weapons, ");
        lines.add("manage resources, ");
        lines.add("and adapt to different enemies and ");
        lines.add("bosses to progress.");

        int space = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (i == 4) space = 1;
            gui.drawText(
                    lines.get(i),
                    new Vector2D(23, 6 + i + space),
                    GUI.Colors.WHITE,
                    GUI.Colors.BLACK
            );
        }
    }

    private void drawGameBasics() {
        GUI gui = GUI.getGUI();

        // Draw Game Basics Explanation
        List<String> gameBasics = new ArrayList<>();
        gameBasics.add("Health Points (HP)");
        gameBasics.add("Represents the damage that an Entity");
        gameBasics.add("can take before dying.");
        gameBasics.add("Energy (EN)");
        gameBasics.add("Required to fire weapons.");
        gameBasics.add("Regenerates over time.");
        gameBasics.add("Damage (DMG)");
        gameBasics.add("Indicates how much HP is lost when an");
        gameBasics.add("Entity or obstacle inflicts damage.");

        int space = 0;
        for (int i = 0; i < gameBasics.size(); i++) {
            GUI.Colors color = GUI.Colors.WHITE;
            if (i == 0 || i == 3 || i == 6) {
                color = GUI.Colors.CYAN;
                if (i != 0) space++;
            }

            gui.drawText(
                    gameBasics.get(i),
                    new Vector2D(23, 5 + i + space),
                    color,
                    GUI.Colors.BLACK
            );
        }
    }

    private void drawWeapons() {
        GUI gui = GUI.getGUI();

        // Draw Weapon Stats
        // TODO Update this info
        List<String> weaponsStats = new ArrayList<>();
        weaponsStats.add("Simple Shot");
        weaponsStats.add("  • Fire Rate     : 2 bullets/s");
        weaponsStats.add("  • Energy Cost   : 10 EN/bullet");
        weaponsStats.add("  • Damage        : 5 HP");
        weaponsStats.add("Explosion Shot");
        weaponsStats.add("  • Fire Rate     : 4 shots/s");
        weaponsStats.add("  • Energy Cost   : 25 EN/bullet");
        weaponsStats.add("  • Damage        : 15 - 3,75 HP");
        weaponsStats.add("  • Max Radius    : 4 tiles");
        weaponsStats.add("Death Ray (Laser)");
        weaponsStats.add("  • Cooldown      : 1 minute");
        weaponsStats.add("  • Energy Cost   : 20 EN/s");
        weaponsStats.add("  • Damage        : 20 HP/s");
        weaponsStats.add("  • Max Duration  : 5 seconds");

        int space = 0;
        for (int i = 0; i < weaponsStats.size(); i++) {
            GUI.Colors color = GUI.Colors.WHITE;
            if (i == 0 || i == 4 || i == 9) {
                color = GUI.Colors.CYAN;
                if (i != 0) space++;
            }

            gui.drawText(
                    weaponsStats.get(i),
                    new Vector2D(23, 1 + i + space),
                    color,
                    GUI.Colors.BLACK
            );
        }
    }

    private void drawEnemies() {
        GUI gui = GUI.getGUI();

        // Draw Monster Info
        // TODO Update this info
        List<String> monsterInfo = new ArrayList<>();
        monsterInfo.add("Tenebris Peon");
        monsterInfo.add("Melee range, low HP, moderate damage");
        monsterInfo.add("Tenebris Heavy");
        monsterInfo.add("High HP, low damage, slow speed");
        monsterInfo.add("Tenebris Spiked Scout");
        monsterInfo.add("Low HP, high collision damage, fast speed");
        monsterInfo.add("Tenebris Harbinger");
        monsterInfo.add("High damage, Range attacker, low HP");
        monsterInfo.add("Tenebris Warden");
        monsterInfo.add("Mini-Boss: High HP, high fire rate");

        int space = 0;

        for (int i = 0; i < monsterInfo.size(); i++) {
            GUI.Colors color = GUI.Colors.WHITE;

            if (i % 2 == 0) {
                color = GUI.Colors.CYAN;
                if (i != 0) {
                    space++;
                }
            }

            gui.drawText(monsterInfo.get(i), new Vector2D(22, 2 + i + space), color, GUI.Colors.BLACK);
        }
    }

    private void drawBosses() {
        GUI gui = GUI.getGUI();

        // Draw Intro
        // TODO Update this info
        List<String> bossesIntro = new ArrayList<>();
        bossesIntro.add("Bosses have unique arenas & attack phases");
        bossesIntro.add("Follow attack cues and destroy their");
        bossesIntro.add("weak points to defeat them!");
        for (int i = 0; i < bossesIntro.size(); i++)
            gui.drawText(
                    bossesIntro.get(i),
                    new Vector2D(23, 1 + i),
                    GUI.Colors.BRIGHT_GREEN,
                    GUI.Colors.BLACK
            );


        // Draw Bosses Info
        List<String> bossesInfo = new ArrayList<>();
        bossesInfo.add("Black Sum Emissary");
        bossesInfo.add("Avoid marked spots to dodge attacks");
        bossesInfo.add("Shoot upwards to damage");
        bossesInfo.add("Abyssal Archon");
        bossesInfo.add("Destroy 2 Abyssal Bulbs to reach Phase 2");
        bossesInfo.add("Then attack! But maneuver carefully.");
        bossesInfo.add("Nightmare Sovereign");
        bossesInfo.add("Moves through different arenas,");
        bossesInfo.add("Each with unique challenges!");
        bossesInfo.add("Survive or defeat him. Choose wisely!");

        int space = 0;
        for (int i = 0; i < bossesInfo.size(); i++) {
            GUI.Colors color = GUI.Colors.WHITE;
            if (i % 3 == 0 && i < bossesInfo.size() - 1) {
                color = GUI.Colors.CYAN;
                if (i != 0) space++;
            }

            gui.drawText(
                    bossesInfo.get(i),
                    new Vector2D(23, 5 + i + space),
                    color,
                    GUI.Colors.BLACK
            );
        }
    }

    private void drawDifficultyLevels() {
        GUI gui = GUI.getGUI();

        // Draw Difficulty Levels Information
        List<String> difficultyLevelExplain = new ArrayList<>();
        difficultyLevelExplain.add("Easy");
        difficultyLevelExplain.add("• Higher HP that resets in each arena");
        difficultyLevelExplain.add("• Normal EN regeneration, frequent drops");
        difficultyLevelExplain.add("Normal");
        difficultyLevelExplain.add("• Standard HP that resets in each arena");
        difficultyLevelExplain.add("• Slower EN regeneration, frequent drops");
        difficultyLevelExplain.add("Champion");
        difficultyLevelExplain.add("• Standard HP that resets in each level");
        difficultyLevelExplain.add("• Only larger monsters drop EN");
        difficultyLevelExplain.add("Heartless");
        difficultyLevelExplain.add("• 'Champion' rules");
        difficultyLevelExplain.add("• No respawn!");

        int space = 0;
        for (int i = 0; i < difficultyLevelExplain.size(); i++) {
            GUI.Colors color = GUI.Colors.WHITE;
            if (i % 3 == 0) {
                color = GUI.Colors.CYAN;
                if (i != 0) space++;
            }

            gui.drawText(
                    difficultyLevelExplain.get(i),
                    new Vector2D(23, 1 + i + space),
                    color,
                    GUI.Colors.BLACK
            );
        }
    }

    private void drawMapElements() {
        GUI gui = GUI.getGUI();

        // Draw Map Elements Info
        List<String> mapElementsInfo = new ArrayList<>();
        mapElementsInfo.add("Standard Wall");
        mapElementsInfo.add("Blocks movement and bullets");
        mapElementsInfo.add("Destructible Wall/Crates");
        mapElementsInfo.add("Can be destroyed with bullets");
        mapElementsInfo.add("Spike");
        mapElementsInfo.add("Deals damage on contact");
        mapElementsInfo.add("Sand bag");
        mapElementsInfo.add("Blocks movement but not bullets");

        int space = 0;
        for (int i = 0; i < mapElementsInfo.size(); i++) {
            GUI.Colors color = GUI.Colors.WHITE;
            if (i % 2 == 0) {
                color = GUI.Colors.CYAN;
                if (i != 0) space++;
            }

            gui.drawText(
                    mapElementsInfo.get(i),
                    new Vector2D(23, 4 + i + space),
                    color,
                    GUI.Colors.BLACK
            );
        }
    }
}
