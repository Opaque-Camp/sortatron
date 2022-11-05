package camp.opaque.sortatron

class SortatronLogger(private val logger: java.util.logging.Logger) : Logger {
    override fun info(msg: String) {
        logger.info(prefixedMsg(msg))
    }

    private fun prefixedMsg(msg: String) = "[Sortatron] $msg"
}
