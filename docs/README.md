# **LDTS T14G01 - TENEBRIS**

## **Game Description**

A character named Dylan Macron finds himself jumping from arena to arena, fighting for his life. Each arena is filled with monsters of various types, all determined to kill him. Starting out relatively powerless, Dylan grows stronger with each fight as he gains experience. He can find weapons scattered around the arenas, and there are three types: Simple Shot, Explosion Shot, and Death Ray. Each shot consumes energy, which regenerates slowly and can also be dropped by defeated monsters. Dylan has only one life per level. If he dies, he will respawn at the beginning of the level and can continue fighting. However, if he dies on the hardest difficulty level, it’s game over.

> This project was developed by [Cláudio Meireles](https://github.com/Atum555) (up202306618), [Dinis Silva](https://github.com/DinisBSilva) (up202306207) and [Miguel Pereira](https://github.com/migalha212) (up202304387).

## Controls
```↑```: Moves Player up.  

```↓```: Moves Player down.  

```←```: Moves Player left.  

```→```: Moves Player right.  

> Arrow Keys are also used to navigate throw the Menus.

```Space```: Shoot.

```Q```: Quits Game.

```ESC```: Return to the previous menu (or quit game if you are in Main Menu).  

```ENTER```: Select the desired options in the menu.  

## **Implemented Features**
    
### Main Menu
First menu of the game. It will show up when opening the game and from here you can select one of the following options:

- **New Game**: Allows you to create a new game and select the difficulty.
- **Load Game**: Allows you to access and continue a previously saved game session.
- **Levels**: This option just appears if you have already some saved game session. It is used to select one of the unlocked levels to play next.
- **Statistics**: Displays informations such as kills, deaths, levels completed, etc. of the current session.
- **How to Play**: Explains you how you can play the game.
- **Credits**: Shows the credits of the game.
- **Exit**: Exits the Game.

> Load Game, Levels and Statistics options only appear once the player has at least one saved game.

### New Game Menu
Allows players to select their preferred difficulty level. [Options](#difficulty-levels) include Easy, Normal, Champion and Heartless, each accompanied by a brief description to guide the player. Once a difficulty is selected, the game proceeds to start.

### How to Play Menu
Provides essential gameplay information, including navigation, controls, objective (of the game), the game basics and details about weapons, enemies, bosses, difficulty levels, and map elements. Navigation instructions are shown on the right, with options to move through the menu or go back.

### Credits Menu
A simple text-based screen that highlights the individuals who contributed to the development of the game and the purpose behind its creation. It provides a straightforward way to acknowledge the team. The menu includes a single option to return to the Main Menu, ensuring easy navigation.

### Screen Resizer
At the game's launch, the code dynamically detects the user's screen resolution to ensure that the game's proportionality remains consistent, regardless of the screen size. This approach guarantees that the full game window is always displayed without being cropped or cut off, providing an optimal experience across various screen resolutions.

### Screen Size Locker
This feature prevents the user from resizing the game window, ensuring the game’s layout and functionality remain intact. If the user attempts to adjust the window size, the code detects this action, closes the current window, and reopens a new one with the predefined dimensions. The new window restores the exact state of the previous one, preserving all content and progress seamlessly.

### Collision Detection
Although it is not yet fully apparent in gameplay due to ongoing feature development, the game already incorporates a collision detection mechanism. This system will be a crucial part of the game, determining whether entities can move to specific positions and if monsters successfully deal damage to Dylan.

## **Features In Development**
This section highlights the features that are currently being worked on but are not yet fully implemented. While these functionalities are in progress, they may not be fully functional or may be subject to changes before completion. Check back later for updates as we continue to improve and expand the game!

### Difficulty Levels
- **Easy**:
  - The player’s HP resets at the beginning of every arena; 
  - The player has a bigger starting Health Pool;
  - Every monster drops a bit of energy, energy regenerates at a normal level.	

- **Medium**:
  - The player’s HP resets at the beginning of every arena;
  - Every monster drops a bit of energy, energy regeneration slightly reduzed.

- **Champion**:
  - The player's HP resets at the beginning of every level;
  - Only bigger monsters drop energy.

- **Heartless**:
  - Champion difficulty level;
  - If you die, game over!
  
### **Game Elements**
All Game Elements (entities, projectiles and static elements, like walls) are defined by their position and size.

### Entity  

The entities in the game are Dylan (our player) and the monsters. While they share some common attributes, they also have distinct characteristics:

**Shared Attributes:**
- **Health Points** (HP) : the amount of damage an Entity can take before dying.
- **Velocity** :  the speed at which an entity can move, measured in units per second.
- **Aceleration** : rate at which an entity's velocity changes over time. It is typically measured in units of speed per unit of time and can indicate how quickly an entity speeds up or slows down.

**Distinguishing Attributes:**
- **Damage** (DMG) : the amount of HP that is taken away from an entity in the interaction (Monsters only).
- **Energy** (EN) : a resource used by the player (Dylan) to fire weapons.

### Projectiles
Projectiles represent distinct types of ammunition in the game, with Bullet being a simple, linear damage-dealing projectile, and Explosive Bullet offering more advanced mechanics (such as area-of-effect damage).

**Shared Attributes:**  
- **Velocity** : projectile moves with a constant speed in the direction defined by its velocity vector.
- **Damage** :  both projectiles inflict damage when they interact with entities that can take damage.

**Distinguish Attributes:**
- While Bullet causes straightforward damage to any entity that can take damage, the Explosive Bullet deals area-of-effect damage upon impact, affecting multiple entities within the blast radius.

### Static Elements

- **Standard Wall**:
  - Blocks Entities and Projectiles: This wall blocks both entities (players, monsters) and projectiles, acting as a complete barrier.
- **Breakable Wall**:
  - Destructible: This wall can be destroyed by taking enough damage. Once its health reaches zero, it breaks and disappears, allowing passage through the space it once occupied.
- **Sand Bag**:
  - Blocks Entities: This wall type prevents entities (like players and monsters) from passing through it but allows projectiles to pass unhindered.
- **Spike**:
  - Damages Entities: Entities that pass through this take damage.
  - No Effect on Projectiles: Projectiles can pass through without being affected, unlike entities.

### **Arena**
The Arena is the battleground where players and enemies interact, filled with obstacles and dynamic elements that affect gameplay. It is designed to challenge players, requiring strategic movement, use of the environment, and careful decision-making.

- **Layout**: The arena consists of various types of terrain, including walls, open spaces, and other obstacles, all arranged to create diverse challenges and opportunities for both the player and enemies.
- **Boundaries**: The arena has defined boundaries that limit movement, ensuring that combat stays within a controlled space. These boundaries are defined by walls that block passage.
- **Interactive Elements**: The arena features interactive elements such as breakable walls, sandbags, and spikes, each impacting gameplay differently. These elements can be used to block enemies, gain tactical advantages, or even cause harm to those who come into contact with them.
- **Progressive Arenas**: The game features multiple arenas, each with its own unique layout and challenges. As players progress through the game, they will encounter increasingly difficult arenas, with more complex layouts and stronger enemies, pushing their skills to the limit.

## Features Planned to be Implemented

### Pause Menu

This menu can be opened while in-game. It lets you pause your game and gives you some options such as:

- **Continue** : Unpauses the game.
- **Restart Level** : Reloads the current level.
- **Statistics** : Displays informations such as kills, deaths, levels completed, etc. of the current session.
- **Back to Main Menu** : Goes to Main Menu.

### Statistics Menu
This menu allows the player to view their game statistics, such as kills, deaths, levels completed, etc. of the session currently loaded. The only available option in this menu is to return to the previous menu.

### Player Movement
The player will be able to move (using the arrow keys), shoot (Space bar). Also, the player's movement animations wiil be different according to the player's current action.

### Monsters Movement
Monsters will have the ability to "see" the player within a certain range, provided there are no walls obstructing their line of sight. Once they detect the player, they will move in his direction.

### Predefine the values of Entity attributes

### Dylan
- **Starting Health Pool** :
  - 150 hp for easy difficulty;
  - 100 hp for all others.

- **Starting Energy Pool** :
  - 100 en for every difficulty.

- **Starting Energy Regen** :
  - 1 en per second for Easy;
  - 0,5 en per second for Medium;
  - 0,1 en per second for Champion. 

### Monsters
- **Tenebris Peon**:
  - Health Points : 20 hp; 
  - Speed : Normal;
  - Damage : 15 hp;
  - Range : 1 tile.

- **Tenebris Heavy**:
  - Health Points : 50 hp;
  - Speed : Slow;       
  - Damage : 10 hp;
  - Range : 1 tile.
            
- **Tenebris Spiked Scout**:
  - Health Points : 15 hp;
  - Speed : Fast;
  - Damage : 35 hp;     
  - Range : 1 tile.

- **Tenebris Harbinger** :
  - Health Points : 20 hp;
  - Speed : Normal;
  - Damage: 35hp;
  - Range : 5 tiles.

- **Tenebris Warden** :
  - Health Points : 75 hp;     
  - Speed : Normal;
  - Damage : 45 hp;
  - Range : 1 tile.
 
### Weapons Available
- **Simple Weapon** :
  - Fire Rate - 2 bullets per second;
  - Energy Cost to Shot - 10 en per bullet;
  - Damage - 5 hp.

- **Explosion Weapon** :
  - Fire Rate - 0,25 bullets per second;
  - Energy Cost to shot - 25 en per bullet;
  - Ability - when reaches a wall or a Monster it deals damage to all enemies in a radius of 4 tiles;
  - Damage - (15 - 3,75 * radius) hp.

- **Death Ray (Laser)** :
  - Energy Cost to shot - 20en per second active;
  - Ability - gives damage to all enemies in that direction;
  - Max Laser duration - 5 seconds;
  - Cooldown - 1 minute;
  - Damage - 20 hp / sec.


> All of these predefined values are provisional and subject to change as we conduct further in-game testing.

### Bosses

- **Black Sun Emissary**
  - **Description**: An ancient being empowered by the power of the Black Sun. The Archon is a master of dark energy, unleashing beams of corrupting power and summoning tentacles from below to trap players.
  - **Arena Type**: Boss sits on the top half of the screen (immobile ASCII art) with a clean walkable arena below it.
  - **Attack Patters**: In certain intervals, coordinates around the arena will light up in warning, showing the Pattern for the coming attack; 
                                After another interval if the player is standing in any of the highlighted spots, he will take heavy Damage.
  - **How to damage**: The Boss sits above the player, so simply shooting upwards will hit the Boss and reduce its HP.

- **Abyssal Archon**
  - **Description**: An ancient being empowered by the depths of the Abyss. The Archon is a master of dark energy, unleashing the power of Abyssal Bulbs and his armies of Abissal Tenebris Warriors, be careful not to destroy it’s gems or it’s full rage will be awakened and destroy the players where they stand.
  - **Arena Type**: a clean walkable arena with the boss sat in an unreachable spot in the middle, 2 other spots will be covered by an impassable yet destructible object.
  - **Attack Patterns**: Divided in 2 phases, 1 that sends out enemies to protect the 2 spots, and another where the boss itself attacks with a set of attacks predefined.
  - **How to damage**: at first the Boss is invulnerable this phase 1, only when both “Abyssal Bulbs” are destroyed will the boss become vulnerable, this also marks the beginning of the boss’ phase 2.
  - **“Abyssal Bulb”**: the mentioned impassable yet destructible object, has HP, marks phase 1 of the Abyssal Archon, deals no damage to the player upon colision

- **Nightmare Sovereign**
  - **Description**: A malevolent ruler who twists reality around itself, bringing players into a nightmare realm. The Sovereign manipulates illusions, creating clones and warping the arena to confuse players.
  - **Arena Type**: the only Boss(of the original 3) to have his battle happen through different rooms in the arena, each with an experience for the player be it a maze, a bullet hell, enemy gauntlet, or another boss’ room.
  - **Attack Patterns**: Each room will mean different attacks, only when face to face with the boss is a pattern defined, though the rooms and teleporting is also an atack from the boss.
  - **How to damage**: beat the challenge room the boss teleports you into, or when face to face with it, attacking it directly.

## General Structure
<p align="center">
<img src="/docs/resources/uml/overview.png">
</p>

## Design Patterns

### Code Structure

#### Problem in Context
When developing software that involves a user interface, it is essential to establish an appropriate structural pattern. The code must be well-organized and modular to uphold the Single Responsibility Principle.

To achieve this, we need to implement a system that separates the various components of our game, such as processing inputs, rendering images to the screen, and managing game logic. This separation ensures maintainability, scalability, and clarity in the codebase.

#### The Pattern
To address the need for a well-structured and modular design, we decided to adopt the Model/View/Controller (MVC) Pattern, a common choice for Graphical User Interfaces (GUI). This pattern divides the application into three distinct sections:

- Model: Represents the data, rules, and game logic.
- View: Displays the model and sends user actions to the controller.
- Controller: Acts as an intermediary, providing the model to the view and interpreting user actions.

With this pattern in mind, we brainstormed ideas and began implementing initial classes and methods for each section. Once these were completed, we merged the code, resolved conflicts, and established the game's main components.  

Since the initial implementation, we have made several adjustments and improvements. However, applying the MVC pattern has greatly increased the independence of components, enabling changes to one part without significantly impacting the others. This modularity has proven invaluable for maintaining and expanding the game.

#### Implementation

We decided to include direct links to our implementation of this method in the following section, using the Main Menu as a specific example:
- [Model](/src/main/java/com/ldts/t14g01/Tenebris/model/menu/MainMenu.java)
- [View](/src/main/java/com/ldts/t14g01/Tenebris/view/menu/MainMenuView.java)
- [Controller](/src/main/java/com/ldts/t14g01/Tenebris/controller/menu/MainMenuController.java)

Throughout the project, the implementation of the MVC model adheres to the following diagram:
<p align="center">
  <img src="resources/uml/mvc.png">
</p>

#### Consequences
Adopting the Model/View/Controller (MVC) pattern brings several key benefits, such as:
- **Improved Maintainability**: Clear separation between Model, View, and Controller makes it easier to maintain the code. Changes to one part of the system are less likely to impact others.
- **Easier Testing**: The modular structure allows for isolated testing of each component, making bug detection more efficient.
- **Scalability**: New features and expansions can be added without major changes to other parts of the system. The modular design makes the game easier to grow and adapt.
- **Decoupling**: The MVC pattern promotes a high level of decoupling, which simplifies development and reduces the impact of changes on other layers of the system.
- **Interface Maintenance**: UI changes can be made in the View without affecting game logic, allowing for faster updates and fewer errors.

### Managing a Single Instance of the Game Loop and GUI

#### Problem in Context

In a game, it's essential to control the execution flow, ensuring that certain components, like the game loop and the GUI, run in a controlled and consistent manner. As the game grows in complexity, there might be multiple components that need to interact with the game loop (such as updating entities, handling inputs, or rendering graphics) and with the GUI (such as changing it's type, drawing to it or even reopening). So, it's important that only one game loop and GUI exist at any given time to prevent issues like performance inconsistencies, redundant processing, or synchronization problems across different parts of the game. The challenge lies in ensuring that the management of the Game and GUI is centralized and accessed globally without being instantiated multiple times, especially as the game scales.

#### The Pattern
The Singleton Pattern is a design pattern used to ensure that a class has only one instance throughout the lifetime of the application and provides a global point of access to that instance. This pattern is particularly useful when a single, centralized object is needed to control or manage a resource, ensuring that it is not accidentally duplicated or instantiated multiple times.

Key characteristics of the Singleton pattern:
- **Single Instance**: The class can have only one instance, which is shared across the entire application.
- **Global Access**: The instance is globally accessible, usually through a static method.
- **Lazy Initialization**: The instance is created only when it is first needed, which optimizes memory usage.

#### Implementation
In the case of the Game Loop, we can apply the Singleton pattern to ensure that only one game loop exists during the entire game session. The loop would control the execution flow, managing the game’s updates, rendering, and logic processing.
The full implementation is provided on the Tenebris class [here](/src/main/java/com/ldts/t14g01/Tenebris/Tenebris.java).
About the GUI this pattern helps centralize all of it's logic, assuring that the GUI is always in a consistent state, and that no two GUIs can coexist, as that would break the game.
The Full implementation of the pattern is available in the LanternaGUI class [here](/src/main/java/com/ldts/t14g01/Tenebris/gui/LanternaGUI.java).

#### Consequences

Adopting the Singleton Pattern offers several advantages when managing critical systems like the Game Loop and GUI. It ensures centralized control by guaranteeing that only one instance of each system exists, preventing duplication and maintaining consistency throughout the application's lifecycle. This pattern provides a global access point, simplifying interactions and making it easier to manage dependencies without explicit passing of instances. Lazy initialization optimizes resource usage by creating the instance only when it is first needed, avoiding unnecessary memory consumption. Additionally, the Singleton ensures consistent state management, keeping shared systems stable and predictable, which is crucial for avoiding conflicts or synchronization issues. Debugging is also simplified, as there is only one instance to monitor, making it easier to diagnose and resolve problems. Overall, the Singleton Pattern enhances the stability, efficiency, and maintainability of complex systems.

### Managing the State of the Game

#### Problem in Context

As in any graphical application, changing contexts from one window to another or one menu to another is a big part of the whole graphical context. Specially in a game where there are multiple menus and even the game window itself, coordinating this switching can become confusing and scattered around the code base. This should be avoided, and a clear and centralized way of switching from one state to another should be implemented.

#### The Pattern

The state pattern is a behavioral design pattern used in software development to allow an object to alter its behavior when its internal state changes. This pattern is particularly useful for scenarios where an object's behavior is influenced by its state, and it helps organize code to make it more maintainable and scalable.

Key Components of the State Pattern
- **Context**: The main object that operates with different states. It maintains a reference to the current state object and delegates behavior to it.
- **State Interface**: Defines the common interface for all concrete states. This ensures the Context can interact with different states in a uniform manner.
- **Concrete States**: Implement the state interface and encapsulate specific behavior for a particular state. Each concrete state represents a unique behavior and transitions to other states as necessary.

#### Implementation

We created, as per the design, a generic `State<T>` Class and the necessary more specific implementations in junction with the MVC Design Pattern. This Classes can be found [here](/src/main/java/com/ldts/t14g01/Tenebris/state).

#### Consequences

The State Pattern improves code organization and maintainability by encapsulating each state's behavior into distinct classes, ensuring modularity and clarity. It simplifies adding or modifying states, enabling scalability without impacting existing ones. By centralizing transition logic, it eliminates redundancy and ensures consistent, predictable flows. Delegating behavior to state classes removes complex conditional structures and enhances dynamic control over application behavior. This approach reinforces the single responsibility principle, resulting in a more robust, flexible, and clean system.

## Class Hierarchies

[comment]: <> (View Tree)

<h3 align="center">
  View Tree
</h3>

<p align="center">
<img src="/docs/resources/uml/view.png">
</p>

[comment]: <> (Controller Tree)

<h3 align="center">
  Controller Tree
</h3>

<p align="center">
<img src="/docs/resources/uml/controllers.png">
</p>

[comment]: <> (Game Element Tree)

<h3 align="center">
  Game Element Tree
</h3>

<p align="center">
<img src="/docs/resources/uml/gameElements.png">
</p>