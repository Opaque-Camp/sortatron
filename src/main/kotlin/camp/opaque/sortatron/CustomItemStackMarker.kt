package camp.opaque.sortatron

import org.bukkit.inventory.ItemStack

/**
 * Modifies an ItemStack to have properties of a certain custom material - adds a custom display name
 * and a persistent data container value to distinguish it from items of the original material type,
 * for example, a Sortatron Accessor from an Ender Chest.
 */
interface CustomItemStackMarker {
    fun markItemStack(item: CustomItem, stack: ItemStack)
}
