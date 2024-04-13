
"I would really appreciate if you'd come with 
pull requests instead of making hundreds of forks."
~ andrei1058

# BedWars1058
BedWars is a mini-game where you have to defend your bed and destroy the others.  
Once your bed is destroyed, you cannot respawn.

## What's new:
- Added Build Height Limit messages:
  - Credits: [BedWars1058-BuildLimit](https://github.com/Frawlah80/BedWars1058-BuildLimit)
  - You can now configure MAX BUILD HEIGHT and MIN BUILD HEIGHT in the arena's config. Messages (such as "Build height limit reached!" or "You cannot build any further down!" are configurable (in language files)!)
- Added Map Command:
  - Credits: [BedWars1058-MapCommand](https://github.com/Frawlah80/BedWars1058-MapCommand)
  - Added commands: /map & /wtfmap
  - Messages are configurable in language files (as {arenaDisplayName} to show the arena display name or {arenaName} to show the arena's original name)
- Added new placeholders:
  - %bw1058_arena_displayname%
  - %bw1058_arena_name%
  - %bw1058_player_level_no_brackets% (removes brackets in levels. Example: [1⭐] would look like 1⭐, and it will still retain the colors)
  - {levelNoBrackets} placeholder for lobby scoreboard
- Added PerGroupShop:
  - Full Credits: [BedWars2023](https://github.com/tomkeuper/BedWars2023)
- Added Invisibility Potion Effect:
  - Credits: [BedWars2023](https://github.com/tomkeuper/BedWars2023)
  - Added footstep particles (configurable in config).
- Added Anti-Drop:
  - Credit: [BedWars1058-AntiDrop](https://polymart.org/resource/bedwars1058-antidrop-addon.1661?__cf_chl_tk=54SoQcQ1KkWUBrb6kAO301OFl5.q3rosFaEUJz.nHkk-1712989639-0.0.1.1-1578)
  - Configurable in config (You can disable this feature).

## Main features

###### Flexible | Ways you can run the plugin:
- **SHARED**: Can run among other mini-games on the same spigot instance. Games will only be accessible via commands.
- **MULTIARENA**: Will require an entire server instance for hosting the mini-game. It will protect the lobby world and games can be joined via commands, NPCs, signs and GUIs.
- **BUNGEE-LEGACY**: The old classic bungee mode where a game means an entire server instance. You'll be added to the game when joining the server. Arena status will be displayed as MOTD.
- **BUNGEE**: A brand new scalable bungee mode. It can host multiple arenas on the same server instance, clone and start new arenas when needed so other players can join. The server can be automatically restarted after a certain amount of games played. This will require installing [BedWarsProxy](https://www.spigotmc.org/resources/bedwarsproxy.66642/) on your lobby servers so players can join. And of course, you can run as many servers as you want in bungee mode.

###### Language | Per player language system:
- Each player can receive messages, holograms, GUIs etc. in their desired language. /bw lang.
- You can either remove or add new languages.
- Team names, group names, shop contents and a lot more can be translated in your languages.
- Custom titles and subtitles for [starting countdown](https://gitlab.com/andrei1058/BedWars1058/-/wikis/language-configuration#custom-title-sub-title-for-arena-countdown).

###### Lobby removal | Optional:
The waiting-lobby inside the map can be removed once the game starts.

###### Arena Groups | Customization:
- You can group arenas by type (4v4, 50v50). You can name them however you want.
- Groups can have custom scoreboard layouts, team upgrades, start items and custom generator settings.
- You can join maps by group: /bw join <group>

###### Shop | Customization:
- You may configure quick-buy default items.
- You may add or remove categories.
- You may add new shop items or execute commands when bought.
- Permanent items are given after you re-spawn.
- Permanent items can be downgradable which will make you lose one tier per death.
- Items can have weight so you can't buy a weaker item than your current one etc.
- Special items available: BedBug, Dream Defender, Egg Bridge, TNT Jump and Straight Fireball.
- Quick buy feature is available and is synced between nodes as well in bungee mode.

###### Team Upgrades | Customization:
- You may have different team upgrades per arena group.
- You may either add and remove categories and contents.
- You may make upgrade elements that: enchant items, give potion effects (to team-mates/ base/ enemies when they enter the island), you can edit generator settings and change the dragons amount for the Sudden Death phase.
- You may add new traps that: disenchant-items (sword, armor, bow), give potion effects (team/ base/ enemies), remove potion effect when an enemy enters your island range and trigger commands.

###### Ways to join an arena:
- Arena selector, which can be configured. /bw gui will display all arena groups while /bw gui Solo will show games from Solo groups and /bw gui Solo+4v4 will show games from Solo and 4v4.
- You can also join games via NPCs by installing Citizens.
- Join-signs are also available with status block.
- Commands can be used as well. /bw join random will bring you the most filled arena, while /bw join <arena> will send you to the given arena and /bw join groupName+groupName2 will bring you on a map from the given groups.

###### Arena Settings | Customization:
- You can set a custom display name used on signs, GUIs etc.
- Option to set the amount of min/max players and team size.
- Toggle options for: allowing spectators, disabling generators for empty teams, disabling NPCs for empty teams, disabling internal drops management, bed holograms usage.
- Protection range for team-spawn and team NPCs.
- Island radius (for features like triggering traps and map) border radius.
- Instant kill on void based on Y coordinate.
- You can create as many teams as you want.
- You can allow map breaking like on a SkyWars game.
- You can toggle generator split.
- Custom game rules per map.
- Unlimited iron/gold/emerald generators per team.

###### VIP Kick | Privilege:
Players with bw.vip permission are able to join full arenas in starting phase. This will kick a player without bw.vip permission from that game.

###### Player Statistics:
- We do not provide leaderboard holograms but you can use [ajLeaderboards](https://www.spigotmc.org/resources/ajleaderboards.85548/) with [DecentHolograms](https://www.spigotmc.org/resources/decentholograms-1-8-1-20-4-papi-support-no-dependencies.96927/) for that using the placeholders we provide or provided by [BedWars1058-GroupStats Addon](https://polymart.org/resource/bedwars1058-groupstats.3184)
- Players can see their stats using the internal stats GUI, which can be customized and accessed by /bw stats.

###### Party System:
- We provide a basic and functional internal party system to play with your friends on the same team or arena.
- We also support [Parties by AlessioDP](https://www.spigotmc.org/resources/parties-an-advanced-parties-manager.3709/) and Party and Friends by Simonsator which could be a better solution if you are a large network.

###### Anti AFK System:
Inactive players for more than 45 seconds can't pick-up items from generators.

###### Custom Join Items:
- You can add and remove items that you receive when you join the server (only on multi-arena) and the items you receive when you join a game in starting/waiting phase or when you join as a spectator.
- Join items can execute commands.

###### Map Restore System:
- The default restore adapter from BedWars1058 is based on un-loading the map, un-zipping a backup and loading it again. This may be heavy for servers with cheap hardware. We recommend using gaming processors and a SSD.
- To improve performance we added support for SlimeWorldManager, which loads maps way faster with less performance impact thanks to its slime format. We really encourage you installing this plugin. No manual conversion is required. BedWars1058 will handle everything. Read how to install it here.
- You can also implement your own map adapter through the API.
- It may seem heavy than other plugins because we don't simply keep track of modified blocks. We need to restore the entire map because server owners can allow players to destroy the maps like on a SkyWars game. Regions like generators, NPCs and team spawns will be protected.

###### Re-Join | Feature:
If you get disconnected, or if you leave a game (configurable) you can re-join it via command or by joining the server again. This is also available in bungee scalable mode.

###### TNT Jump | Feature:
- Players are able to do TNT jump with configurable values.
- Players with TNT in their inventory have a red particle on their head (configurable).

## 3rd party libraries
- [bStats](https://bstats.org/getting-started/include-metrics)
- [SidebarLib](https://github.com/andrei1058/SiderbarLib)
- [Commons IO](https://mvnrepository.com/artifact/commons-io/commons-io)
- [HikariCP](https://mvnrepository.com/artifact/com.zaxxer/HikariCP)
- [SLF4J](http://www.slf4j.org/)
