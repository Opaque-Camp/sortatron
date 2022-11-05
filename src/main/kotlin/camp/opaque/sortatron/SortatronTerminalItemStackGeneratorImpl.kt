package camp.opaque.sortatron

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

class SortatronTerminalItemStackGeneratorImpl(private val itemStackFactory: ItemStackFactory) :
    SortatronTerminalItemStackGenerator {
    override fun generate(): ItemStack {
        val itemStack = itemStackFactory.create(Material.COMMAND_BLOCK)
        itemStack.itemMeta.apply {
            persistentDataContainer[namespacedKey("is_sortatron_terminal"), PersistentDataType.BYTE] = 1
            displayName(Component.text("Sortatron Terminal"))
        }
        return itemStack
    }
}
