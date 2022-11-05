package camp.opaque.sortatron

import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ShapedRecipe

class SortatronTerminalRecipe(sortatronTerminalItemStackGenerator: SortatronTerminalItemStackGenerator) :
    ShapedRecipe(
        NamespacedKey(SortatronPlugin.NAMESPACE, "sortatron_terminal"),
        sortatronTerminalItemStackGenerator.generate()
    ) {
    init {
        shape(
            "scs",
            "crc",
            "scs"
        )
        setIngredient('s', Material.COBBLESTONE)
        setIngredient('c', Material.ENDER_CHEST)
        setIngredient('r', Material.REDSTONE_BLOCK)
    }
}
