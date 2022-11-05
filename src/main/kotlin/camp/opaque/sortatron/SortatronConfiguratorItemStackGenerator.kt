package camp.opaque.sortatron

import org.bukkit.inventory.ItemStack

/**
 * Modifies an ItemStack to have properties of a Sortatron Configurator - adds a custom display name and a persistent data
 * container value that indicates that the ItemStack is in fact a Sortatron Configurator and not just a Command Block.
 */
interface SortatronConfiguratorItemStackGenerator {
    fun modifyStack(stack: ItemStack)
}
