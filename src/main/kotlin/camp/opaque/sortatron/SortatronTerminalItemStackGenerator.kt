package camp.opaque.sortatron

import org.bukkit.inventory.ItemStack

interface SortatronTerminalItemStackGenerator {
    fun modifyStack(stack: ItemStack)
}
