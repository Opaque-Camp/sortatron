package camp.opaque.sortatron

import org.bukkit.Material

class Recipes(private val sortatronTerminalItemStackGenerator: SortatronTerminalItemStackGenerator) {
    fun register() {
        shapedRecipe("sortatron_terminal", sortatronTerminalItemStackGenerator.generate()) {
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
}
