package camp.opaque.sortatron

import net.kyori.adventure.text.Component
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

class SortatronAccessorItemStackGeneratorImpl : SortatronAccessorItemStackGenerator {
    override fun modifyStack(stack: ItemStack) {
        if (stack.type != MaterialAliases.SORTATRON_ACCESSOR) {
            throw IllegalArgumentException("ItemStack must be of type ${MaterialAliases.SORTATRON_ACCESSOR}")
        }
        stack.itemMeta = stack.itemMeta.apply {
            displayName(Component.text("Sortatron Accessor"))
            persistentDataContainer[namespacedKey("is_sortatron_accessor"), PersistentDataType.BYTE] = 1
        }
    }
}
