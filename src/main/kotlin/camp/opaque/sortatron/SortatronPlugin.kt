package camp.opaque.sortatron

import org.bukkit.plugin.java.JavaPlugin

class SortatronPlugin : JavaPlugin() {
    private val logger = SortatronLogger(getLogger())
    private val sortatronConfiguratorItemStackGenerator = SortatronConfiguratorItemStackGeneratorImpl()
    private val sortatronAccessorItemStackGenerator = SortatronAccessorItemStackGeneratorImpl()

    override fun onEnable() {
        logger.info("Sortatron plugin starting up...")
        Recipes().register(server)
        server.pluginManager.registerEvents(
            SortatronConfiguratorPrepareItemCraftEventListener(sortatronConfiguratorItemStackGenerator),
            this
        )
        server.pluginManager.registerEvents(
            SortatronAccessorPrepareItemCraftEventListener(sortatronAccessorItemStackGenerator),
            this
        )
        logger.info("Sortatron plugin startup complete.")
    }

    companion object {
        const val NAMESPACE = "sortatron"
    }
}
