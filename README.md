<h1 align="center">Tamable Foxes-Revived</h1>
<p align="center">
SpigotMC Plugin that gives you the ability to tame foxes!
</p>



### WARNING: Do not reload the plugin, you may loose foxes!!
**TamableFoxes-Revived** is a fork and continuation of the original **[TamableFoxes](https://github.com/SeanOMik/TamableFoxes)** plugin. This project was created because the original repository was archived and no longer maintained.

This project still follows the [MIT](https://github.com/bgfoxsland/TamableFoxes-Revived/blob/master/LICENSE) license of the original repository

The game versions currently supported by this plugin are as follows:

1.14、 1.14.1、 1.14.2、 1.14.3、 1.14.4、

1.15、 1.15.1、 1.15.2

1.16、 1.16.2、 1.16.3、 1.16.4、 1.16.5

1.17、 1.17.1

1.18、 1.18.1、1.18.2

1.19、 1.19.1、 1.19.2、 1.19.3、 1.19.4

1.20、 1.20.1、 1.20.3、 1.20.4

1.21、 1.21.1、 1.21.4、 1.21.5、 1.21.6、 1.21.7、 1.21.8、 1.21.9、 1.21.10、 1.21.11

### Default configuration files:
* [config.yml](https://github.com/bgfoxsland/TamableFoxes-Revived/blob/master/Plugin/src/main/resources/config.yml)
* [language.yml](https://github.com/bgfoxsland/TamableFoxes-Revived/blob/master/Plugin/src/main/resources/language.yml)
<br>

If you get any errors, <a href="https://github.com/bgfoxsland/TamableFoxes-Revived/issues/new">create an issue!</a><br><br>

Have you ever wanted to tame foxes? Well, now you can! <b>Use chicken to tame</b> and sweet berries to breed them!<br><br>

## Features:
* 33% Chance of taming
* Breeding
* Wild foxes pick berry bushes
* Leaping on targets
* Tamed foxes sleep when their owner does
* Foxes follow owner
* You can shift + right-click to let the fox hold items
* Right-click to make the fox sit
* Shift Right-click with an empty hand to make the fox sleep
* If the fox is holding a totem of undying, the fox will consume it and be reborn.
* Foxes attack the owner's target
* Foxes attack the thing that attacked the owner.
* Foxes are automatically spawned inside the world. (Same areas as vanilla foxes)
* Foxes attack chickens and rabbits.
* Snow and red foxes.
* Language.yml
* Message when a tamed fox dies
* /givefox command to give foxes to other players.
* Disabling certain gameplay messages
  * You can do this by changing certain fields in `language.yml` to "disabled". The fields that can be disabled are:
    * `taming-tamed-message`
    * `taming-asking-for-name-message`
    * `taming-chosen-name-perfect`
    * `fox-doesnt-trust`

## Commands:
* /spawntamablefox [red/snow]: Spawns a tamable fox at the players' location.
* /tamablefoxes reload: Reloads
* /givefox [player name]: Give a fox to another player.

## Permissions:
* `tamablefoxes.reload`: Reloads the plugin config. Default: `op`
* `tamablefoxes.spawn`: Gives permission to run the command /spawntamablefox. Default: `op`
* `tamablefoxes.tame`: Gives the player the ability to tame a fox. Default: `Everybody`
* `tamablefoxes.tame.unlimited`: Lets players bypass the tame limit. Default: `op`
* `tamablefoxes.tame.anywhere`: Lets players bypass the banned worlds in config.yml (so they can tame in any world). Default: `op`
* `tamablefoxes.givefox.give.others`: Allows the player to give another players fox to a player with /givefox. This will ignore if the other receiving has the `tamablefoxes.givefox.receive` permission. Default: `op`
* `tamablefoxes.givefox.give`: Gives the player the ability to give foxes to other players with /givefox. Default: `Everybody`
* `tamablefoxes.givefox.receive`: Gives the player the ability to receive foxes from other players from /givefox. Default: `Everybody`

<br>

![foxes sleeping](Screenshots/foxes-sleeping-with-player.png)
![foxes sitting player holding sword](Screenshots/foxes-sitting-sword.png)
![foxes with baby looking at player](Screenshots/foxes-baby-looking-at-player.png)
![giving fox totem](Screenshots/giving-fox-item.gif)
![fox leaping towards chicken](Screenshots/fox-pouncing.gif)

## Building
Use JDK 21 and run `mvn package` to build the project.

After building, you can find the plugin in `./run/plugins/`

*<small>Although the old information below mentions using compileSpigotVersions.sh to prepare the maven cache, I found in practice that with good network conditions, using JDK 21 and running `mvn package` is sufficient.</small>*

*<small>Old information:To build you must have every version of spigot starting from 1.14 built and inside your maven cache. To do that, look at [compileSpigotVersions.sh](compileSpigotVersions.sh) that lists all the java commands and the java versions for them.</small>*

## Metrics collection
![metrics](https://bstats.org/signatures/bukkit/TamableFoxes.svg)
Tamable Foxes collects anonymous server statistics through bStats, an open-source statistics service for Minecraft software. If you wish to opt-out, you can do so in the `bstats/config.yml` file.
