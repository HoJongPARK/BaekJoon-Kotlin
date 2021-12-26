package solid


fun main() {
    val guitar = Guitar("123456", GuitarSpec(5000.0, "EK-120", "YAMAHA", "ELEC", "WOOD", "WOOD"))

    print(guitar.toString())
}