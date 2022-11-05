package camp.opaque.sortatron

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ItemStackFactoryImpl : ItemStackFactory {
    override fun create(type: Material) = ItemStack(type)
}
