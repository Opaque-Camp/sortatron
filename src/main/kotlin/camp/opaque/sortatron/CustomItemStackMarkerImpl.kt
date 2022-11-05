package camp.opaque.sortatron

import net.kyori.adventure.text.Component
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

class CustomItemStackMarkerImpl : CustomItemStackMarker {
    override fun markItemStack(material: CustomMaterial, stack: ItemStack) {
        if (stack.type != material.material) {
            throw IllegalArgumentException("ItemStack must be of type $material")
        }
        stack.itemMeta = stack.itemMeta.apply {
            displayName(Component.text(material.humanName))
            persistentDataContainer[namespacedKey("is_${material.name.lowercase()}"), PersistentDataType.BYTE] = 1
        }
    }
}
