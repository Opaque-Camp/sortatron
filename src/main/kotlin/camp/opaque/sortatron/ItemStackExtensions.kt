package camp.opaque.sortatron

import org.bukkit.inventory.ItemStack

fun ItemStack.isCustomItemOfType(type: CustomItem) = itemMeta.persistentDataContainer.has(type.identityKey)
