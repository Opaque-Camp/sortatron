package camp.opaque.sortatron

import org.bukkit.plugin.java.JavaPlugin

class SortatronPlugin : JavaPlugin() {
    private val logger = SortatronLogger(getLogger())
    private val itemStackFactory = ItemStackFactoryImpl()
    private val sortatronTerminalItemStackGenerator = SortatronTerminalItemStackGeneratorImpl(itemStackFactory)

    override fun onEnable() {
        logger.info("Sortatron plugin starting up...")
        registerRecipes()
        logger.info("Sortatron plugin startup complete.")
    }

    private fun registerRecipes() {
        server.addRecipe(SortatronTerminalRecipe(sortatronTerminalItemStackGenerator))
    }

    companion object {
        const val NAMESPACE = "sortatron"
    }
}
