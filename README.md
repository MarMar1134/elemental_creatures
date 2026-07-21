# Elemental Creatures
Discover the Elementals! This new creatures generates all around of the Minecraft world, replacing vanilla creatures and adding more variety and challenge to your adventure.

---

## Zombies
There are five new zombie variants awarding for you. Most of then even spawn naturally on the Overworld.
- ### The Rotten
  The Rotten inflicts Poison when attacking the player, and can be found on Swamps and Mangrove Swamps.
- ### The Lost
    The Lost frosts the player on touch, and generates alongside Strays. They also generates when a Zombie freezes without lethal damage.
- ### The Scorched
    The Scorched ignites the player on touch, but can't spawn naturally on the Overworld.
    Scorcheds are generated when a Zombie stays on fire for 15 seconds or more.
  - ### Soul Scorched
    If a Zombie stays on soul fire for 15 seconds, it will become a Soul Scorched instead. Soul Scorcheds have less health but more damage, so be careful.
- ### Worshipper of Illapa
    This loyal follower of the Gods inflicts lightning damage, which penetrates armor, and has double damage points than a
    regular Zombie. Is generated when a Zombie is struck by a Lightning Bolt. They have a chance of dropping Lightning essence.

---

## Skeletons
There are five new skeleton variants.
- ### The Sunken
  The Sunken is an underwater mob similar to the Drowned. It shoots the new Prismarine Arrows, which travels the water like if it was air.
  Sunkens are generated when a Skeleton stays underwater for 30 or more seconds.
- ### The Putrid
  The Putrid is a backport of vanilla's Bogged. Spawns naturally on swamps, mangrove swamps and lush caves, with an 80% chance of replace a Skeleton. Shoots poisonous arrows.
- ### The Dried
  The Dried is a backport of vanilla's Parched, behaving like the vanilla one. Spawns on deserts, with an 80% chance to replace Skeletons. Shoots weakness arrows.
  Like the Husk, if a Dried stays on water 30 seconds or more, it will be converted to a Skeleton.
- ### Soul Reaper
  Soul Reapers spawn on Soul Sand Valleys, which are in the Nether, and shoot special arrows that inflicts soul fire to the target.
- ### Follower of Tláloc
  This loyal follower of the Gods shoots a new type of arrow, Lightning arrows, which inflict lightning damage. Followers of Tláloc can't spawn naturally, but are
  generated when a Skeleton is struck with a Lightning Bolt. They have a chance of dropping Lightning essence.

---

## Slimes
There are four new slime variants.
- ### Ice Cube
  Ice Cubes replaces regular Slimes on snowy biomes. In addition to slime balls, they can drop snowballs.
- ### Sand Cube
  Sand Cubes replaces regular Slimes on deserts and beaches, and deal additional damage. In addition to slime balls, they can drop sand.
  - ### Red Sand Cube
    Red Sand Cubes replaces regular Slimes on badlands biomes and its variants, and deal additional damage. In addition to slime balls, they can drop red sand.
- ### Phranque
  Phranques are a special type of Slime which generates when a Slime is struck with a lightning bolt. Phranques have 6 hearts, 2 chestplates of armor and deal 3 hearts of damage, two of them with lightning damage.
  Phranques can't spawn on regular biomes, and like other charged mobs, they have a chance to drop Lightning essence.

---

## New Items
- ### Lightning arrow
  Lightning arrows are shot by Followers of Tláloc. They inflict additional lightning damage that penetrates armor.
  The player can craft Lightning arrows combining 8 regular arrows with Lightning essence.
- ### Prismarine arrow
  Prismarine arows are shot by Sunkens. They travel the water like it was air, allowing the player to use the bow underwater.
  Prismarine arrows can't be crafted.
- ### Soul arrow
  Soul arrows are shot by Soul Reapers. They ignite the target with soul fire, which inflicts additional fire damage.
  Soul arrows can't be crafted.
- ### Lightning essence
  Lightning essence is a mythological item dropped by charged mobs. It can be used to craft Lightning arrows.

---

## Compatibility
- If you're developing a Biomes mod, and you want the Elementals to be able to spawn on certain biomes, add them under the `elemental_creatures:can_spawn_<mob_type>` biomeTag.
  - For example, if you are developing a _Volcano_ biome, and you want the _Scorched_ to spawn there, add _Volcano_ to `elemental_creatures:can_spawn_scorched` biome tag and the mod will handle the spawn replacement.

---

## Spawn configurations
- The user can configure if a given creature can spawn naturally on the world or not. For that, it needs to go to `config/elemental_creatures-common.toml` and set the mob configuration to `false`
  - For example, if you want The Lost to only appear with its spawn egg, go to the config and search for `spawnLost`, then set it to `false`.
- The user can configure the replacement probability of a given mob for the Elemental. By default, all Elementals that spawn naturally have an 80% change of replacing its vanilla variant.
  - For example, you can configure the _Lost_ to only have a 15% chance of replacing a Zombie, and a _Rotten_ to have a 90% chance instead.
  - Replacement probabilities only applies on the biomes where the Elementals have been configured to spawn.

---

## License, permissions and credits
- This mod uses the MIT license.
- You can utilize this mod on any modpack given the corresponding credits.
- You can create forks and addons for/of this mod. Forks need credits retribution.
- Some sounds utilize alternative licenses, so here are the credits of its authors:
  - Fire Forest 2 by SoundReality -- https://freesound.org/s/819492/ -- License: Attribution NonCommercial 4.0
  - Video Game SFX - Drowning sound by Breviceps -- https://freesound.org/s/445971/ -- License: Creative Commons 0
  - Drowning Girl 2 by killbaybee -- https://freesound.org/s/321461/ -- License: Attribution 3.0
  - drowning by RNAn_SoundDesign -- https://freesound.org/s/725874/ -- License: Creative Commons 0
  - Steps_Fine_Snow_Or_Sand_Strong_29 by BlondPanda -- https://freesound.org/s/778568/ -- License: Creative Commons 0