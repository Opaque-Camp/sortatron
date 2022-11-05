package camp.opaque.sortatron

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe

fun shapedRecipe(
    key: String,
    result: ItemStack,
    init: ShapedRecipe.() -> Unit
) = ShapedRecipe(namespacedKey(key), result).apply { init() }
