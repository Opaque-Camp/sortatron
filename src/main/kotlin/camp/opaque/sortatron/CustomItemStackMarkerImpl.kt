package camp.opaque.sortatron

import net.kyori.adventure.text.Component
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

class CustomItemStackMarkerImpl : CustomItemStackMarker {
    override fun markItemStack(item: CustomItem, stack: ItemStack) {
        if (stack.type != item.originalMaterial) {
            throw IllegalArgumentException("ItemStack must be of type $item")
        }
        stack.itemMeta = stack.itemMeta.apply {
            displayName(Component.text(item.humanName))
            persistentDataContainer[namespacedKey("is_${item.name.lowercase()}"), PersistentDataType.BYTE] = 1
        }
    }
}
