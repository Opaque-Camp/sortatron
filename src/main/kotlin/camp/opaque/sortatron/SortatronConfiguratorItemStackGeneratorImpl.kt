package camp.opaque.sortatron

import net.kyori.adventure.text.Component
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

class SortatronConfiguratorItemStackGeneratorImpl : SortatronConfiguratorItemStackGenerator {
    override fun modifyStack(stack: ItemStack) {
        if (stack.type != MaterialAliases.SORTATRON_CONFIGURATOR) {
            throw IllegalArgumentException("ItemStack type must be ${MaterialAliases.SORTATRON_CONFIGURATOR}")
        }
        stack.itemMeta = stack.itemMeta.apply {
            persistentDataContainer[namespacedKey("is_sortatron_configurator"), PersistentDataType.BYTE] = 1
            displayName(Component.text("Sortatron Configurator"))
        }
    }
}
