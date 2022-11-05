package camp.opaque.sortatron

import org.bukkit.plugin.java.JavaPlugin

class SortatronPlugin : JavaPlugin() {
    private val logger = SortatronLogger(getLogger())
    private val sortatronConfiguratorItemStackGenerator =
        CustomItemStackMarkerImpl(CustomMaterial.SORTATRON_CONFIGURATOR)
    private val sortatronAccessorItemStackGenerator = CustomItemStackMarkerImpl(CustomMaterial.SORTATRON_ACCESSOR)

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
