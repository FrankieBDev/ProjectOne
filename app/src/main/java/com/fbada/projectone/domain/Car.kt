/**
 * Colours available as part of [Car] specification
 */
enum class AvailableColours { Red, Blue, Green, Yellow, Silver, White, Black }

const val petrol = "Petrol"
const val auto = "Automatic"
const val manual = "Manual"
const val big = "Big"
const val leather = "Leather"
const val lux = "luxury"
/**
 * Superclass: [Car]
 * Represents a general vehicle type with the following properties:
 * @property year year of manufacture
 * @property colour exterior colour
 * @property price base price
 */
open class Car(private val year: Int, private val colour: AvailableColours, open var price: Double) {
    /**
     * Accelerates the vehicle
     */
    fun accelerate() {
        println("Move forward")
    }
    /**
     * Halts the vehicle
     */
    fun brake() {
        println("Stopped")
    }
}

/**
 * Subclass BMW Manufacturer type car.  Extends Car class.
 * @property fuelType type of fuel the car runs on
 * @property gearBox type of gearbox
 */
abstract class BMW(private val fuelType: String, private val gearBox: String) : Car(1999, AvailableColours.Blue, 400.00) {
    /**
     * @property price price of the car based on fuel type and gearbox properties.
     *  If car runs on petrol AND is automatic base price is multiplied by 30.
     *  If car has alternative properties price is base price plus 450.
     *
     */
    override var price: Double = 0.0
        get() = if (fuelType == petrol && gearBox == auto) {
            super.price * 30
        } else {
            super.price + 450
        }
    /**
     * Reverses the vehicle
     */
    fun reverse() {
        println("Move backwards")
    }
    /**
     * Starts the windscreen wipers
     */
    fun windscreenWipers() {
        println("Turn on windscreen wipers")
    }
    /**
     * Abstract function to navigate the vehicle.
     */
    abstract fun navigate()
}
/**
 * Subclass Mercedes Manufacturer type car.  Extends Car class.
 * @property doors number of doors
 * @property owners number of previous owners
 */
open class Mercedes(val doors: Int, val owners: Int) : Car(2010, AvailableColours.Green, 500.00) {

    /**
     * @property doorPremium multiplies number of doors by 1.5
     */
    val doorPremium: Double
        get() = doors * 1.5  // Getter
    /**
     * @property price price of the car based on doors property.
     *  If a car has less than 5 doors 10 is added to base price.
     *  If car has 5 to 8 doors 20 is added to base price, if there are more than 8 doors 33 is added.
     */
    override var price: Double = 0.00 + if (doors >= 5) {
            if (doors > 8) {
                super.price + 33.00
            } else super.price + 20.00
        } else {
            super.price + 10.00
        }
}

/**
 * Subclass Ford Manufacturer type car.  Extends Car class.
 */
open class Ford : Car(2020, AvailableColours.Red, 300.00) {
    /**
     * @property seats number of seats
     * @property location pickup location
     */
    var seats: Int = 8
    private val location: String = "Manchester"
    /**
     * @property price base price becomes 100.00
     */
    override var price: Double = 100.00

    /**
     * Start test drive
     */
    fun testDrive() {
        println("Lets take this for a spin!")
    }

    /**
     * Opens the boot
     */
    open fun openBoot() {
        println("boot is open")
    }
}

/**
 * Subclass Alpha Model type car.  Extends BMW class.
 * @property dashboard Big or small dashboard type
 * @property satNav Sat Nav available
 * @property ecoRating Eco Rating Score
 */
class Alpha(private val dashboard: String, val satNav: Boolean, val ecoRating: Int) : BMW("Diesel", "Manual") {
    /**
     * @property price Base price plus eco rating multiplied by 2.
     */
    override var price: Double = super.price + (ecoRating * 2)
    /**
     * Navigation function which prints a message dependent on whether the dashboard is big or small.
     */
    override fun navigate() {
        if (dashboard == big) {
            println("Alpha is so easy to navigate")
        } else {
            println("Alpha map is too small")
        }
    }
}

/**
 * Subclass Beta Model type car.  Extends BMW class.
 * @property insurance Insurance available
 * @property dashboard Big or small dashboard type
 * @property powerSteering Power steering available
 */
class Beta(private val insurance: Boolean, private val dashboard: String, private val powerSteering: Boolean) :
    BMW(petrol, manual) {
    /**
     * Navigation function which prints a message dependent on whether the dashboard is big or small.
     */
    override fun navigate() {
        if (insurance) {
            if (dashboard == big) {
                price * 40
                println("Beta is so easy to navigate")
            } else {
                price / 3
                println("Beta map is too small")
            }
        } else {
            println("This car needs insurance!")
        }
    }
}
/**
 * Subclass Omega Model type car.  Extends BMW class.
 * @property windowSize Size of windows
 * @property dashboard Big or small dashboard type
 * @property ecoRating Eco Rating Score
 */
class Omega(private val windowSize: Int, private val dashboard: String, val ecoRating: Int) : BMW("Petrol", "Manual") {
    /**
     * Navigation function which prints a message dependent on whether the dashboard is big or small.
     */
    override fun navigate() {
        if (dashboard == "big") {
            price * 20
            println("Omega is so easy to navigate")
        } else {
            price / 13
            println("Omega map is too small")
        }
    }
}

/**
 * Subclass Mayback Model type car.  Extends Mercedes class.
 */
class Mayback : Mercedes(4, 3) {
    /**
     * @property bootSize Size of boot
     * @property price Base price plus boot size
     */
    private val bootSize: Double = 4.4
    override var price: Double = super.price + bootSize
}
/**
 * Subclass Sprinter Model type car.  Extends Mercedes class.
 * @property rating Customer rating score.
 * @property maxSpeed Maximum speed of vehicle.
 * @constructor Creates a Sprinter with rating, max speed and gearbox and returns specific specifications
 */
open class Sprinter(private val rating: Int, private val maxSpeed: Int) : Mercedes(2, 2) {
    constructor(rating: Int, maxSpeed: Int, gearbox: String) : this(rating, maxSpeed) {
        val specs =
            "This Sprinter car has the following specs:\n Customer Rating:$rating\n Gearbox: $gearbox\n Max Speed:$maxSpeed"
        println(specs)
    }
    /**
     * @property price Base price plus Sprinter Rating Price and Sprinter Max Speed Price
     */
    override var price: Double = super.price + sprinterRatingPrice() + sprinterMaxSpeedPrice()
    /**
     * Calculates a price based on customer rating
     */
    private fun sprinterRatingPrice(): Double {
        val extras: Double = when (rating) {
            in 0..10 -> 2.00 + rating
            in 11..30 -> 6.00 + rating
            in 31..55 -> 10.00 + rating
            in 56..77 -> 15.00 + rating
            else -> 22.00 + rating
        }
        return extras
    }
    /**
     * Calculates a price based on vehicle max speed.
     */
    private fun sprinterMaxSpeedPrice(): Double {
        val extras: Double = when (maxSpeed) {
            in 0..60 -> 10.00
            in 61..80 -> 20.00
            in 81..100 -> 30.00
            else -> 50.00
        }
        return extras
    }
}
/**
 * Subclass Traviliner Model type car.  Extends Mercedes class.
 *  @property rating Customer rating score.
 *  @property maxSpeed Maximum speed of vehicle.
 */
class Traveliner(private val rating: Int, private val maxSpeed: Int) : Mercedes(6, 1) {
    /**
     * @param rating Customer rating score.
     * @param maxSpeed Maximum speed of vehicle.
     * @param gearBox Gearbox type.
     */
    constructor(rating: Int, maxSpeed: Int, gearBox: String) : this(rating, maxSpeed) {
        val specs =
            "This Traveliner car has the following specs:\n Customer Rating:$rating\n Max Speed:$maxSpeed \n Number of Doors:$doors \n Previous Owners $owners"
        println(specs)
    }
    /**
     * @property price Base price plus max speed price calculation.
     */
    override var price: Double = super.price + travelinerMaxSpeedPrice()
    /**
     * Calculates a price based on max speed.
     */
    private fun travelinerMaxSpeedPrice(): Double {
        val extras: Double = when (maxSpeed) {
            in 0..60 -> 10.00
            in 61..80 -> 20.00
            in 81..100 -> 30.00
            else -> 50.00
        }
        return extras
    }

}
/**
 * Subclass Cougar Model type car.  Extends Ford class.
 * @property interior Interior material type.
 * @property materialPrice Price of interior material.
 * @property spareTyre Spare Tyre available.
 * @property radioType Type of radio inside car.
 */
class Cougar(private val interior: String, private var materialPrice: Double, private val spareTyre: Boolean, private val radioType: String) :
    Ford() {
    /**
     * @property price Base price plus interior calculation
     */
    override var price: Double = super.price + interiorPremium()
    /**
     * Calculates a price based on interior.  If the interior is Leather or Luxuary the price is multiplied by 2.5.
     */
    private fun interiorPremium(): Double {
        if (interior == leather || interior == lux) {
            materialPrice * 2.5
        } else {
            materialPrice
        }
        return materialPrice
    }
}
/**
 * Subclass Explorer Model type car.  Extends Ford class.
 * @property interior Interior material type.
 * @property maxSpeed Maximum speed of vehicle.
 * @property tyreSize Size of tyres.
 */
class Explorer(private val interior: String, private val maxSpeed: Double, private val tyreSize: Double) : Ford() {
    /**
     * @property price Base price multiplied by max speed.
     */
    override var price: Double = super.price * maxSpeed
    /**
     * Opens the boot
     */
    override fun openBoot() {
        println("Rear access enabled")
    }

}
/**
 * Subclass Capri Model type car.  Extends Ford class.
 * @property interiorPrice Cost of interior features.
 * @property sunRoof Sunroof available
 * @property rating Customer rating score.
 */
class Capri(private val interiorPrice: Int, private val sunRoof: Boolean, private val rating: Int) : Ford() {
    /**
     * @property price Base price plus interior price including VAT.
     */
    override var price: Double = super.price + interiorPriceAddVAT()
    /**
     * Calculates added VAT into interior price.
     */
    private fun interiorPriceAddVAT(): Int {
        val vat = interiorPrice / 100 * 20
        val priceWVAT = interiorPrice + vat
        return priceWVAT
    }

}





