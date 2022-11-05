package camp.opaque.sortatron

import org.bukkit.plugin.java.JavaPlugin

class SortatronPlugin : JavaPlugin() {
    private val logger = SortatronLogger(getLogger())
    private val customItemStackMarker = CustomItemStackMarkerImpl()

    override fun onEnable() {
        logger.info("Sortatron plugin starting up...")
        Recipes().register(server)
        server.pluginManager.registerEvents(
            PrepareCustomItemCraftEventListener(customItemStackMarker),
            this
        )
        logger.info("Sortatron plugin startup complete.")
    }

    companion object {
        const val NAMESPACE = "sortatron"
    }
}
