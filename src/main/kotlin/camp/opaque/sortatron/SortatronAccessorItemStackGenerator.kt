package camp.opaque.sortatron

import org.bukkit.inventory.ItemStack

/**
 * Modifies an ItemStack to have properties of a Sortatron Accessor - adds a custom display name and a persistent data
 * container value that indicates that the ItemStack is in fact a Sortatron Accessor and not just an Ender Chest.
 */
interface SortatronAccessorItemStackGenerator {
    fun modifyStack(stack: ItemStack)
}
