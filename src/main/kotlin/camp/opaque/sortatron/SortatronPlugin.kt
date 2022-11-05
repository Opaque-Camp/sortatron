package camp.opaque.sortatron

import org.bukkit.plugin.java.JavaPlugin

@Suppress("unused")
class SortatronPlugin : JavaPlugin() {
    private val logger = SortatronLogger(getLogger())
    private val customItemStackMarker = CustomItemStackMarkerImpl()

    override fun onEnable() {
        logger.info("Sortatron plugin starting up...")
        Recipes().register(server)
        registerListeners()
        logger.info("Sortatron plugin startup complete.")
    }

    private fun registerListeners() {
        server.pluginManager.registerEvents(PrepareCustomItemCraftEventListener(customItemStackMarker), this)
        server.pluginManager.registerEvents(ConfiguratorInventoryOpenEventListener(), this)
    }
}
