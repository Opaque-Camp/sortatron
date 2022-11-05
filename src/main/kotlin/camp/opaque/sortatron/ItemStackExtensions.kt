package camp.opaque.sortatron

import org.bukkit.inventory.ItemStack

fun ItemStack.isCustomItemOfType(type: CustomMaterial) = itemMeta.persistentDataContainer.has(type.identityKey)
