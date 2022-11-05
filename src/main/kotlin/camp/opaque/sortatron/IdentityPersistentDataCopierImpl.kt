package camp.opaque.sortatron

import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.persistence.PersistentDataType

class IdentityPersistentDataCopierImpl : IdentityPersistentDataCopier {
    override fun copyIdentityPersistentData(from: PersistentDataContainer, to: PersistentDataContainer) {
        val keysToCopy = from.keys.filter { it.isSortatronIdentityKey }
        // Custom item marker keys always have a value of 1 of type BYTE
        keysToCopy.forEach { to.set(it, PersistentDataType.BYTE, 1) }
    }
}
