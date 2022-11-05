package camp.opaque.sortatron

import net.kyori.adventure.text.Component
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

class CustomItemStackMarkerImpl(private val customMaterial: CustomMaterial) :
    CustomItemStackMarker {
    override fun markItemStack(stack: ItemStack) {
        if (stack.type != customMaterial.material) {
            throw IllegalArgumentException("ItemStack must be of type $customMaterial")
        }
        stack.itemMeta = stack.itemMeta.apply {
            displayName(Component.text(customMaterial.humanName))
            persistentDataContainer[namespacedKey("is_${customMaterial.name.lowercase()}"), PersistentDataType.BYTE] = 1
        }
    }
}
