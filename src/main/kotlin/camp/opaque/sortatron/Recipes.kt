package camp.opaque.sortatron

import org.bukkit.Material
import org.bukkit.Server

class Recipes {
    fun register(server: Server) {
        server.addRecipe(
            shapedRecipe("sortatron_terminal", Material.ENDER_CHEST) {
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
