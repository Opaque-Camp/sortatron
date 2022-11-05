package camp.opaque.sortatron

import org.bukkit.Material
import org.bukkit.Material.COMMAND_BLOCK
import org.bukkit.Material.ENDER_CHEST

/**
 * Aliases for [Material] values that our special blocks and items use.
 * Since there is no way to register custom materials, we have to use existing ones and add persistent data values to
 * them in order to distinguish them from other items, for example, a Sortatron Configurator from a Command Block.
 */
enum class CustomMaterial(val humanName: String, val material: Material) {
    SORTATRON_CONFIGURATOR("Sortatron Configurator", COMMAND_BLOCK),
    SORTATRON_ACCESSOR("Sortatron Accessor", ENDER_CHEST);

    val recipeKey get() = namespacedKey(name.lowercase())
}
