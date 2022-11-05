package camp.opaque.sortatron

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

interface ItemStackFactory {
    fun create(type: Material): ItemStack
}
