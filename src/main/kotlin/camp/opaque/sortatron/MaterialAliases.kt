package camp.opaque.sortatron

import org.bukkit.Material

/**
 * Aliases for [Material] values that our special blocks and items use.
 * Since there is no way to register custom materials, we have to use existing ones and add persistent data values to
 * them in order to distinguish them from other items, for example, a Sortatron Configurator from a Command Block.
 */
object MaterialAliases {
    val SORTATRON_CONFIGURATOR = Material.COMMAND_BLOCK
    val SORTATRON_ACCESSOR = Material.ENDER_CHEST
}
