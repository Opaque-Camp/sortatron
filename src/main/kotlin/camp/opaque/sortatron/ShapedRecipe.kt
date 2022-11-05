package camp.opaque.sortatron

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe

fun shapedRecipe(
    key: String,
    resultMaterial: Material,
    init: ShapedRecipe.() -> Unit
) = ShapedRecipe(namespacedKey(key), ItemStack(resultMaterial)).apply { init() }
