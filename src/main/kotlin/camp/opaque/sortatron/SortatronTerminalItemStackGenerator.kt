package camp.opaque.sortatron

import org.bukkit.inventory.ItemStack

/**
 * Modifies an ItemStack to have properties of a Sortatron Terminal - adds a custom display name and a persistent data
 * container value that indicates that the ItemStack is in fact a Sortatron Terminal and not just a Command Block.
 */
interface SortatronTerminalItemStackGenerator {
    fun modifyStack(stack: ItemStack)
}
