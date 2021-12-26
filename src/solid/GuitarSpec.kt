package solid

class GuitarSpec(
    price: Double, model: String,
    val maker: String,
    val type: String,
    val backWood: String,
    val topWood: String
) : InstrumentSpec(price, model) {
    override fun toString(): String {
        return "maker : $maker\ntype : $type\nbackWood: $backWood\ntopWood : $topWood"
    }
}