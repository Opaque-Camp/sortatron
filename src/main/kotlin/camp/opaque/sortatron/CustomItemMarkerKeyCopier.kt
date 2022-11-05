package camp.opaque.sortatron

import org.bukkit.persistence.PersistentDataContainer

interface CustomItemMarkerKeyCopier {
    fun copyIdentityPersistentData(from: PersistentDataContainer, to: PersistentDataContainer)
}
