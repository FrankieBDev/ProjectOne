/**
 * Scores for use in calculations of prices
 */
const val MIN = 0
const val LOW = 2
const val MEDIUM = 4
const val HIGH = 5
const val ULTIMATE = 7

/**
 * Colours available as part of [Car] specification
 */
enum class AvailableColours { RED, BLUE, GREEN, YELLOW, SILVER, WHITE, BLACK }

/**
 * Fuel Types available as part of [Car] specification
 */
enum class AvailableFuelTypes { PETROL, DIESEL, ELECTRIC, HYBRID }

/**
 * Gear boxes available as part of [Car] specification
 */
enum class AvailableGearBoxes { MANUAL, AUTOMATIC }

/**
 * Dashboards available as part of [BMW] specification
 */
enum class AvailableBMWDashboards { ANALOGUE, DIGITAL, HUD, IDRIVE, SPORT, CONNECTEDDRIVE }

/**
 * Interior materials available as part of [Ford] specification
 */
enum class AvailableInteriorMaterials { LEATHER, FABRIC, PLASTIC, FAUX_LEATHER, SUEDE, COMBO }

/**
 * Satellite Navigation available as part of [BMW] specification
 */
enum class AvailableSatNavs { GARMIN, TOMTOM, MAGELLAN, NAVMAN, APPLE, GOOGLE, WAZE, HERE }

/**
 * Insurance available as part of Beta subclass specification
 */
enum class AvailableInsurance { BASIC_LIABILITY, STANDARD_PROTECTION, FULL_COVERAGE, PREMIUM_PROTECTION, ROADSIDE_ASSISTANCE }

/**
 * Radio available as part of Cougar subclass specification
 */
enum class AvailableRadios { FM, CASSETTE_PLAYER, CD_PLAYER, DIGITAL, INTERNET, USB, SMART_PHONE_CONNECT }

/**
 * Superclass
 * Represents a general vehicle type with the following properties:
 * @property year year of manufacture
 * @property colour exterior colour
 * @property price base price
 * @property fuelType fuel that runs the car
 * @property gearBox manual or automatic
 */
open class Car(
    private var year: Int,
    private val colour: AvailableColours,
    open var price: Double,
    val fuelType: AvailableFuelTypes,
    val gearBox: AvailableGearBoxes
) {
    /**
     *  motCheck checks for valid MOT
     */
    var motCheck: Boolean = true

    /**
     * Accelerates the vehicle
     */
    private fun accelerate() {
        println("Move forward")
    }

    /**
     * Halts the vehicle
     */
    private fun brake() {
        println("Stopped")
    }
}

/**
 * Subclass BMW Manufacturer type car.  Extends [Car] class.
 * @property dashboard interior dashboard type
 * @property satNav brand of satellite navigation available
 * @property location pick up location
 */
abstract class BMW(
    open val dashboard: AvailableBMWDashboards,
    open val satNav: AvailableSatNavs,
    var location: String,
    year: Int,
    colour: AvailableColours,
    fuelType: AvailableFuelTypes,
    gearbox: AvailableGearBoxes
) : Car(year, colour, price = 400.00, fuelType, gearbox) {
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
 * @property maxSpeed maximum speed of the car
 */
open class Mercedes(
    private var doors: Int,
    var maxSpeed: Int,
    year: Int,
    colours: AvailableColours,
    fuelType: AvailableFuelTypes,
    gearbox: AvailableGearBoxes
) : Car(year, colours, price = 500.00, fuelType, gearbox) {
    /**
     * Book a test drive based on mot validity
     */
    fun bookTestDrive() {
        if (motCheck) {
            println("Test drive booked")
        } else {
            throw IllegalStateException("MOT needed before test drive can be booked")
        }
    }
}

/**
 * Subclass Ford Manufacturer type car.  Extends [Car] class.
 * @property seats max number of people that can fit in the car
 * @property interiorMaterial interior material type
 * @property owners number of previous owners
 */
abstract class Ford(
    private var seats: Int,
    val interiorMaterial: AvailableInteriorMaterials,
    private var owners: Int,
    year: Int,
    colour: AvailableColours,
    fuelType: AvailableFuelTypes,
    gearbox: AvailableGearBoxes
) :
    Car(year, colour, price = 200.00, fuelType, gearbox) {
    /**
     * Calculate ecoRating within specific models
     */
    abstract fun ecoRating(): Int

    /**
     * Opens the boot
     */
    open fun openBoot() {
        println("boot is open")
    }
}

/**
 * Subclass Alpha Model type car.  Extends [BMW] class.
 * @property powerSteering
 */
abstract class Alpha(
    val powerSteering: Boolean,
    dashboard: AvailableBMWDashboards,
    satNav: AvailableSatNavs,
    location: String,
    year: Int,
    colour: AvailableColours,
    fuelType: AvailableFuelTypes,
    gearbox: AvailableGearBoxes
) : BMW(dashboard, satNav, location, year, colour, fuelType, gearbox) {
    /**
     * Calculates a score based on dashboard type
     */
    fun dashboardScore(): Int {
        return when (dashboard) {
            AvailableBMWDashboards.ANALOGUE -> LOW
            AvailableBMWDashboards.CONNECTEDDRIVE, AvailableBMWDashboards.IDRIVE -> MEDIUM
            AvailableBMWDashboards.DIGITAL -> HIGH
            AvailableBMWDashboards.HUD, AvailableBMWDashboards.SPORT -> ULTIMATE
        }
    }

    /**
     * Calculates a score based on sat nav type
     */
    fun satNavScore(): Int {
        return when (satNav) {
            AvailableSatNavs.GARMIN -> LOW
            AvailableSatNavs.TOMTOM, AvailableSatNavs.MAGELLAN -> MEDIUM
            AvailableSatNavs.NAVMAN, AvailableSatNavs.WAZE, AvailableSatNavs.GOOGLE -> HIGH
            AvailableSatNavs.APPLE, AvailableSatNavs.HERE -> ULTIMATE
        }
    }

    /**
     * Calculates a combined navigation score based on dashboard and sat nav types and whether power steering is available.
     */
    fun alphaNavigationRatingBonus(): Int {
        val combinedRatingScore = dashboardScore() + satNavScore()
        return if (powerSteering) {
            combinedRatingScore * 2
        } else {
            combinedRatingScore
        }
    }

    /**
     * Subclass Beta Model type car.  Extends [BMW] class.
     * @property insurance whether insurance available
     * @property insuranceType types of insurance
     * @property powerSteering whether power steering available
     */
    abstract class Beta(
        var insurance: Boolean,
        var insuranceType: AvailableInsurance?,
        private var powerSteering: Boolean,
        dashboard: AvailableBMWDashboards,
        satNav: AvailableSatNavs,
        location: String,
        year: Int,
        colour: AvailableColours,
        fuelType: AvailableFuelTypes,
        gearbox: AvailableGearBoxes
    ) : BMW(dashboard, satNav, location, year, colour, fuelType, gearbox) {
        /**
         * Calculates an insurance score based on insurance type
         */
        fun insuranceScore(): Int {
            return insuranceType?.takeIf { insurance }?.let {
                when (it) {
                    AvailableInsurance.BASIC_LIABILITY -> MIN
                    AvailableInsurance.STANDARD_PROTECTION -> LOW
                    AvailableInsurance.FULL_COVERAGE -> MEDIUM
                    AvailableInsurance.PREMIUM_PROTECTION -> HIGH
                    AvailableInsurance.ROADSIDE_ASSISTANCE -> ULTIMATE
                }
            } ?: throw IllegalStateException("Insurance Not Available")
        }


        /**
         * Calculates an insurance bonus based on whether the car has power steering
         */
        fun insuranceBonus() {
            if (powerSteering) {
                insuranceScore() + 1
            }
        }
    }

    /**
     * Subclass Omega Model type car.  Extends [BMW] class.
     * @property windowSize Size of windows
     */
    abstract class Omega(
        private var windowSize: Int,
        dashboard: AvailableBMWDashboards,
        satNav: AvailableSatNavs,
        location: String,
        year: Int,
        colour: AvailableColours,
        fuelType: AvailableFuelTypes,
        gearbox: AvailableGearBoxes
    ) : BMW(dashboard, satNav, location, year, colour, fuelType, gearbox) {
        /**
         * @property price base price of the car
         *
         */
        override var price: Double = 100.0

        /**
         * @property omegaTotalPrice Total price of the Omega model, including premiums
         */
        val omegaTotalPrice = price + automaticPetrolPremium() + windscreenPremium()

        /**
         * Calculates a premium for automatic petrol cars.
         */
        fun automaticPetrolPremium(): Double {
            return if (fuelType == AvailableFuelTypes.PETROL && gearBox == AvailableGearBoxes.AUTOMATIC) {
                price * 30
            } else {
                price + 450
            }
        }

        /**
         * Calculates a premium based on windscreen size
         */
        fun windscreenPremium(): Double {
            if (windowSize > 88.9) {
                price += 53.00
            }
            return price
        }
    }

    /**
     * Subclass Maybach Model type car.  Extends [Mercedes] class.
     * @property bootSize size of boot of car
     * @property interior interior materials available
     */
    class Maybach(
        var bootSize: Double,
        val interior: AvailableInteriorMaterials,
        doors: Int,
        maxSpeed: Int,
        year: Int,
        colour: AvailableColours,
        fuelType: AvailableFuelTypes,
        gearbox: AvailableGearBoxes
    ) :
        Mercedes(doors, maxSpeed, year, colour, fuelType, gearbox) {
        /**
         * Calculates premium price based on boot size
         */
        fun largeCarPremium(): Double {
            return price + (0.5 * bootSize)
        }
    }


    /**
     * Subclass Sprinter Model type car.  Extends [Mercedes] class.
     * @property mileage number of miles driven in the car
     * @property interior interior materials available
     */
    class Sprinter(
        var mileage: Int,
        val interior: AvailableInteriorMaterials,
        doors: Int,
        maxSpeed: Int,
        year: Int,
        colour: AvailableColours,
        fuelType: AvailableFuelTypes,
        gearbox: AvailableGearBoxes
    ) :
        Mercedes(doors, maxSpeed, year, colour, fuelType, gearbox) {
        /**
         * @property price price based on mileage and max speed scores
         */
        override var price: Double =
            super.price + sprinterPriceScoreBasedOnMileage() + sprinterPriceScoreBasedOnMaxSpeed() * 2

        /**
         * Calculates a price score based on mileage
         */
        private fun sprinterPriceScoreBasedOnMileage(): Int {
            return when (mileage) {
                in 0..100 -> MIN
                in 100..500 -> LOW
                in 500..700 -> MEDIUM
                in 700..999 -> HIGH
                else -> ULTIMATE
            }
        }

        /**
         * Calculates a price score based on vehicle max speed.
         */
        private fun sprinterPriceScoreBasedOnMaxSpeed(): Int {
            return when (maxSpeed) {
                in 0..60 -> LOW
                in 61..80 -> MEDIUM
                in 81..100 -> HIGH
                else -> ULTIMATE
            }
        }
    }

    /**
     * Subclass Traviliner Model type car.  Extends [Mercedes] class.
     *  @property powerSteering whether power steering available
     */
    class Traveliner(
        var powerSteering: Boolean,
        doors: Int,
        maxSpeed: Int,
        year: Int,
        colour: AvailableColours,
        fuelType: AvailableFuelTypes,
        gearbox: AvailableGearBoxes
    ) :
        Mercedes(doors, maxSpeed, year, colour, fuelType, gearbox) {
        /**
         * @property price price based on max speed price score.
         */
        override var price: Double = super.price + (travelingPriceBasedOnMaxSpeed() * 3)

        /**
         * Calculates a score based on max speed.
         */
        private fun travelingPriceBasedOnMaxSpeed(): Int {
            return when (maxSpeed) {
                in 0..60 -> LOW
                in 61..80 -> MEDIUM
                in 81..100 -> HIGH
                else -> ULTIMATE
            }
        }
    }

    /**
     * Subclass Cougar Model type car.  Extends [Ford] class.
     * @property radioType Type of radio inside car.
     */
    abstract class Cougar(
        private val radioType: AvailableRadios,
        seats: Int,
        interior: AvailableInteriorMaterials,
        owners: Int,
        year: Int,
        availableColours: AvailableColours,
        fuelType: AvailableFuelTypes,
        gearbox: AvailableGearBoxes
    ) : Ford(seats, interior, owners, year, availableColours, fuelType, gearbox) {
        /**
         * @property price Base price plus interior score
         */
        override var price: Double = super.price + interiorPremium() * 15

        /**
         * Calculates a price based on interior materials and radio.
         */
        private fun interiorPremium(): Double {
            val materialPrice = materialPriceScore(interiorMaterial)
            val radioPrice = radioPriceScore(radioType)
            return (materialPrice + radioPrice) * 0.75
        }

        private fun materialPriceScore(material: AvailableInteriorMaterials): Int {
            return when (material) {
                AvailableInteriorMaterials.LEATHER, AvailableInteriorMaterials.SUEDE -> HIGH
                AvailableInteriorMaterials.COMBO -> HIGH
                AvailableInteriorMaterials.FABRIC -> MEDIUM
                else -> {
                    LOW
                }
            }
        }

        private fun radioPriceScore(radio: AvailableRadios): Int {
            return when (radio) {
                AvailableRadios.SMART_PHONE_CONNECT -> ULTIMATE
                AvailableRadios.INTERNET, AvailableRadios.DIGITAL -> HIGH
                AvailableRadios.CD_PLAYER -> LOW
                else -> {
                    MIN
                }
            }
        }
    }

    /**
     * Subclass Explorer Model type car.  Extends [Ford] class.
     * @property spareTyre whether spare tyre available
     * @property spareTyreSize Size of spare tyres available.
     */
    abstract class Explorer(
        var spareTyre: Boolean,
        var spareTyreSize: Double,
        seats: Int,
        interior: AvailableInteriorMaterials,
        owners: Int,
        year: Int,
        availableColours: AvailableColours,
        fuelType: AvailableFuelTypes,
        gearbox: AvailableGearBoxes
    ) : Ford(seats, interior, owners, year, availableColours, fuelType, gearbox) {
        /**
         * @property price Explorer base price
         */
        override var price: Double = 700.00

        /**
         * Opens the boot
         */
        override fun openBoot() {
            println("Rear access enabled")
        }

        /**
         * Checks if a spare tyre is available based on its presence and size.
         * @return true if a spare tyre is available and its size is less than 89, otherwise unavailable .
         */
        fun spareTyreAvailable(): Boolean {
            return (spareTyreSize < 89).takeIf { spareTyre } ?: false
        }
    }

    /**
     * Subclass Capri Model type car.  Extends [Ford] class.
     * @property premiumInteriorAvailable whether premium interior is available
     * @property sunRoof whether the car has a sunroof
     * @property comfortRating comfort rating of the car
     */
    abstract class Capri(
        private var premiumInteriorAvailable: Boolean,
        private var sunRoof: Boolean,
        var comfortRating: Int,
        seats: Int,
        interior: AvailableInteriorMaterials,
        owners: Int,
        year: Int,
        availableColours: AvailableColours,
        fuelType: AvailableFuelTypes,
        gearbox: AvailableGearBoxes
    ) : Ford(seats, interior, owners, year, availableColours, fuelType, gearbox) {
        /**
         * @property price Base price of Capri.
         */
        override var price: Double = 52.00

        /**
         * Calculates the eco rating based on fuel type.
         */
        override fun ecoRating(): Int = when (fuelType) {
            AvailableFuelTypes.PETROL, AvailableFuelTypes.DIESEL -> LOW
            AvailableFuelTypes.HYBRID -> MEDIUM
            AvailableFuelTypes.ELECTRIC -> HIGH
        }

        /**
         * Calculates the premium for extras including premium interior, sunroof, and comfort rating.
         * @return the total premium for extras
         */
        fun extrasPremium(): Double {
            var totalPremium = price

            if (premiumInteriorAvailable) {
                totalPremium += 100.00
            }
            if (sunRoof) {
                totalPremium += 200.00
            }
            totalPremium += when (comfortRating) {
                in 0..2 -> 50.00
                in 3..4 -> 100.00
                in 5..7 -> 150.00
                else -> 200.00
            }
            totalPremium += when (ecoRating()) {
                LOW -> 50.00
                MEDIUM -> -100.00
                HIGH -> -150.00
                else -> 0.00
            }
            return totalPremium
        }
    }

    abstract class AlphaSport(
        powerSteering: Boolean,
        dashboard: AvailableBMWDashboards,
        satNav: AvailableSatNavs,
        location: String,
        year: Int,
        colour: AvailableColours,
        fuelType: AvailableFuelTypes,
        gearbox: AvailableGearBoxes
    ) : Alpha(powerSteering, dashboard, satNav, location, year, colour, fuelType, gearbox) {
        override fun navigate() {
            if (powerSteering) {
                println("Alpha Sport offers the optimum driving experience")
            } else {
                println("Standard package selected")
            }
        }
    }
}





