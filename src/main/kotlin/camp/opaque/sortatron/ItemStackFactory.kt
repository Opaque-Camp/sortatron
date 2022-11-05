package camp.opaque.sortatron

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

/**
 * A factory for creating [ItemStack]s with specified [Material]s.
 */
interface ItemStackFactory {
    fun create(type: Material): ItemStack
}
