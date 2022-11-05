package camp.opaque.sortatron

import org.bukkit.Material
import org.bukkit.Server
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe

/** Stores all custom Sortatron recipes. */
class Recipes {
    fun register(server: Server) {
        server.addRecipe(
            shapedRecipe("sortatron_configurator", MaterialAliases.SORTATRON_CONFIGURATOR) {
                shape(
                    "scs",
                    "crc",
                    "scs"
                )
                setIngredient('s', Material.COBBLESTONE)
                setIngredient('c', Material.ENDER_CHEST)
                setIngredient('r', Material.REDSTONE_BLOCK)
            }
        )
    }
}

private fun shapedRecipe(
    key: String,
    resultMaterial: Material,
    init: ShapedRecipe.() -> Unit
) = ShapedRecipe(namespacedKey(key), ItemStack(resultMaterial)).apply { init() }
