package camp.opaque.sortatron

import org.bukkit.persistence.PersistentDataContainer

interface IdentityPersistentDataCopier {
    fun copyIdentityPersistentData(from: PersistentDataContainer, to: PersistentDataContainer)
}
