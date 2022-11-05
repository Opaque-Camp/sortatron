package camp.opaque.sortatron

import net.kyori.adventure.text.Component
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

class SortatronTerminalItemStackGeneratorImpl : SortatronTerminalItemStackGenerator {
    override fun modifyStack(stack: ItemStack) {
        if (stack.type != MaterialAliases.SORTATRON_TERMINAL) {
            throw IllegalArgumentException("ItemStack type must be ${MaterialAliases.SORTATRON_TERMINAL}")
        }
        stack.itemMeta = stack.itemMeta.apply {
            persistentDataContainer[namespacedKey("is_sortatron_terminal"), PersistentDataType.BYTE] = 1
            displayName(Component.text("Sortatron Terminal"))
        }
    }
}
