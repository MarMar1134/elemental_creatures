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
    Scorcheds are generated when a Zombie stays on lava for 10 seconds (try to don't give them Fire Resistance!)
- ### Worshipper of Illapa
    This loyal follower of the Gods inflicts lightning damage, which penetrates armor, and has double damage points than a
    regular Zombie. Is generated when a Zombie is struck by a Lightning Bolt.
---

## Skeletons
There are three new skeleton variants.
- ### Soul Reaper
  Soul Reapers spawn on Soul Sand Valleys, which are in the Nether, and shoot special arrows that inflicts soul fire to the target.
- ### Follower of Tláloc
  This loyal follower of the Gods shoots a new type of arrow, Lightning arrows, which inflict lightning damage. Followers of Tláloc can't spawn naturally, but are
  generated when a Skeleton is struck with a Lightning Bolt.
---

## Compatibility
- If you're developing a Biomes mod, and you want the Elementals to be able to spawn on certain biomes, add them under the `elemental_creatures:can_spawn_<mob_type>` biomeTag.
  - For example, if you are developing a _Volcano_ biome, and you want the _Scorched_ to spawn there, add _Volcano_ to `elemental_creatures:can_spawn_scorched` biome tag and the mod will handle the spawn replacement.
---

## Spawn configurations
- The user can configure if a given creature can spawn naturally on the world or not. For that, it needs to go to `config/elemental_creatures-common.toml` and set the mob configuration to `false`
  - For example, if you want The Lost to only appear with its spawn egg, go to the config and search for `spawnLost`, then set it to `false`.
- The user can configure the replacement probability of a given mob for the Elemental. By default, all Elementals that spawn naturally have an 80% change of replacing its vanilla variant.
  - For example, you can configure _the Lost_ to only have a 15% chance of replacing a Zombie, and a Rotten to have a 90% chance instead.
  - Replacement probabilities only applies on the biomes where the Elementals have been configured to spawn.
---

## License, permissions and credits
- This mod uses the MIT license.
- You can utilize this mod on any modpack given the corresponding credits.
- You can create forks and addons for/of this mod. Forks need credits retribution.
- Some sounds utilize alternative licenses, so here are the credits of its authors:
  - Fire Forest 2 by SoundReality -- https://freesound.org/s/819492/ -- License: Attribution NonCommercial 4.0