package com.fbada.projectone.presentation


import Alpha
import AlphaSport
import AvailableBMWDashboards
import AvailableColours
import AvailableFuelTypes
import AvailableGearBoxes
import AvailableInsurance
import AvailableInteriorMaterials
import AvailableRadios
import AvailableSatNavs
import BMW
import Beta
import Capri
import Car
import Cougar
import Explorer
import Ford
import Maybach
import Mercedes
import Omega
import Sprinter
import Traveliner
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fbada.projectone.R


class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cars = listOf(
            Beta(
                true,
                AvailableInsurance.STANDARD_PROTECTION,
                true,
                AvailableBMWDashboards.HUD,
                AvailableSatNavs.GARMIN,
                "London",
                2004,
                AvailableColours.YELLOW,
                AvailableFuelTypes.DIESEL,
                AvailableGearBoxes.MANUAL
            ),
            Beta(
                true,
                AvailableInsurance.ROADSIDE_ASSISTANCE,
                true,
                AvailableBMWDashboards.IDRIVE,
                AvailableSatNavs.GARMIN,
                "Manchester",
                2023,
                AvailableColours.BLUE,
                AvailableFuelTypes.DIESEL,
                AvailableGearBoxes.MANUAL
            ),
            Beta(
                true,
                AvailableInsurance.BASIC_LIABILITY,
                false,
                AvailableBMWDashboards.DIGITAL,
                AvailableSatNavs.TOMTOM,
                "Newcastle",
                2002,
                AvailableColours.RED,
                AvailableFuelTypes.PETROL,
                AvailableGearBoxes.AUTOMATIC
            ),
            Omega(
                100,
                AvailableBMWDashboards.IDRIVE,
                AvailableSatNavs.APPLE,
                "Huddersfield",
                2021,
                AvailableColours.BLUE,
                AvailableFuelTypes.HYBRID,
                AvailableGearBoxes.AUTOMATIC
            ),
            Omega(
                120,
                AvailableBMWDashboards.IDRIVE,
                AvailableSatNavs.GOOGLE,
                "Hull",
                2023,
                AvailableColours.WHITE,
                AvailableFuelTypes.DIESEL,
                AvailableGearBoxes.AUTOMATIC
            ),
            Cougar(
                AvailableRadios.CD_PLAYER,
                6,
                AvailableInteriorMaterials.LEATHER,
                3,
                2020,
                AvailableColours.GREEN,
                AvailableFuelTypes.PETROL,
                AvailableGearBoxes.MANUAL
            ),
            Cougar(
                AvailableRadios.SMART_PHONE_CONNECT,
                5,
                AvailableInteriorMaterials.COMBO,
                2,
                1999,
                AvailableColours.BLACK,
                AvailableFuelTypes.ELECTRIC,
                AvailableGearBoxes.AUTOMATIC
            ),
            Cougar(
                AvailableRadios.CD_PLAYER,
                4,
                AvailableInteriorMaterials.FABRIC,
                3,
                2016,
                AvailableColours.RED,
                AvailableFuelTypes.PETROL,
                AvailableGearBoxes.MANUAL
            ),
            Explorer(
                true,
                85.0,
                7,
                AvailableInteriorMaterials.LEATHER,
                1,
                2017,
                AvailableColours.WHITE,
                AvailableFuelTypes.DIESEL,
                AvailableGearBoxes.AUTOMATIC
            ),
            Explorer(
                false,
                90.0,
                5,
                AvailableInteriorMaterials.FABRIC,
                2,
                2018,
                AvailableColours.SILVER,
                AvailableFuelTypes.PETROL,
                AvailableGearBoxes.MANUAL
            ),
            Explorer(
                true,
                95.0,
                6,
                AvailableInteriorMaterials.LEATHER,
                2,
                2019,
                AvailableColours.SILVER,
                AvailableFuelTypes.HYBRID,
                AvailableGearBoxes.AUTOMATIC
            ),
            Capri(
                true,
                true,
                5,
                5,
                AvailableInteriorMaterials.LEATHER,
                1,
                2021,
                AvailableColours.RED,
                AvailableFuelTypes.ELECTRIC,
                AvailableGearBoxes.MANUAL
            ),
            Capri(
                true,
                true,
                6,
                4,
                AvailableInteriorMaterials.LEATHER,
                2,
                2003,
                AvailableColours.GREEN,
                AvailableFuelTypes.HYBRID,
                AvailableGearBoxes.AUTOMATIC
            ),
            Capri(
                false,
                false,
                4,
                4,
                AvailableInteriorMaterials.PLASTIC,
                3,
                2019,
                AvailableColours.BLUE,
                AvailableFuelTypes.ELECTRIC,
                AvailableGearBoxes.MANUAL
            ),
            Traveliner(
                true,
                4,
                120,
                2021,
                AvailableColours.YELLOW,
                AvailableFuelTypes.DIESEL,
                AvailableGearBoxes.AUTOMATIC
            ),
            Traveliner(
                false,
                5,
                140,
                2020,
                AvailableColours.BLUE,
                AvailableFuelTypes.PETROL,
                AvailableGearBoxes.MANUAL
            ),
            Traveliner(
                false,
                6,
                150,
                2018,
                AvailableColours.BLACK,
                AvailableFuelTypes.DIESEL,
                AvailableGearBoxes.MANUAL
            ),
            Maybach(
                480.0,
                AvailableInteriorMaterials.SUEDE,
                3,
                170,
                2020,
                AvailableColours.BLUE,
                AvailableFuelTypes.HYBRID,
                AvailableGearBoxes.AUTOMATIC
            ),
            Maybach(
                500.0,
                AvailableInteriorMaterials.LEATHER,
                4,
                200,
                2022,
                AvailableColours.BLACK,
                AvailableFuelTypes.ELECTRIC,
                AvailableGearBoxes.AUTOMATIC
            ),
            Maybach(
                450.0,
                AvailableInteriorMaterials.SUEDE,
                2,
                180,
                2021,
                AvailableColours.WHITE,
                AvailableFuelTypes.HYBRID,
                AvailableGearBoxes.AUTOMATIC
            ),
            Sprinter(
                10000,
                AvailableInteriorMaterials.FABRIC,
                4,
                160,
                2019,
                AvailableColours.RED,
                AvailableFuelTypes.DIESEL,
                AvailableGearBoxes.MANUAL
            ),
            Sprinter(
                20000,
                AvailableInteriorMaterials.PLASTIC,
                5,
                140,
                2020,
                AvailableColours.GREEN,
                AvailableFuelTypes.PETROL,
                AvailableGearBoxes.AUTOMATIC
            ),
            Sprinter(
                460,
                AvailableInteriorMaterials.COMBO,
                4,
                120,
                200,
                AvailableColours.BLUE,
                AvailableFuelTypes.ELECTRIC,
                AvailableGearBoxes.MANUAL
            ),
            Mercedes(
                3,
                55,
                1999,
                AvailableColours.BLACK,
                AvailableFuelTypes.HYBRID,
                AvailableGearBoxes.MANUAL
            ),
            Mercedes(
                5,
                160,
                2021,
                AvailableColours.WHITE,
                AvailableFuelTypes.DIESEL,
                AvailableGearBoxes.AUTOMATIC
            ),
            BMW(
                AvailableBMWDashboards.DIGITAL,
                AvailableSatNavs.GOOGLE,
                "Sheffield",
                2022,
                AvailableColours.BLUE,
                AvailableFuelTypes.PETROL,
                AvailableGearBoxes.AUTOMATIC
            ),
            BMW(
                AvailableBMWDashboards.SPORT,
                AvailableSatNavs.APPLE,
                "Stockport",
                2020,
                AvailableColours.RED,
                AvailableFuelTypes.ELECTRIC,
                AvailableGearBoxes.AUTOMATIC
            ),
            Ford(
                5,
                AvailableInteriorMaterials.LEATHER,
                2,
                2015,
                AvailableColours.GREEN,
                AvailableFuelTypes.PETROL,
                AvailableGearBoxes.MANUAL
            ),
            Ford(
                4,
                AvailableInteriorMaterials.FABRIC,
                1,
                2018,
                AvailableColours.SILVER,
                AvailableFuelTypes.DIESEL,
                AvailableGearBoxes.AUTOMATIC
            )
        )

        val numberOfCarsTextView = findViewById<TextView>(R.id.number_of_cars)
        val numberOfCars = cars.size
        numberOfCarsTextView.text = getString(R.string.car_count, numberOfCars)

        val cheapestCarTextView = findViewById<TextView>(R.id.cheapest_car)
        val cheapestCar = cars.minByOrNull { it.price }
        val cheapestCarPrice = cheapestCar?.price?.toInt() ?: 0
        cheapestCarTextView.text = getString(R.string.cheapest_car, cheapestCarPrice)

        val expensiveCarTextView = findViewById<TextView>(R.id.expensive_car)
        val expensiveCar = cars.maxByOrNull { it.price }
        val expensiveCarPrice = expensiveCar?.price?.toInt() ?: 0
        expensiveCarTextView.text = getString(R.string.expensive_car, expensiveCarPrice)

        val averageCarTextView = findViewById<TextView>(R.id.average_car)
        val sumOfCarPrices = cars.sumOf { it.price }
        val averageCar = sumOfCarPrices / numberOfCars
        val averageCarPrice = averageCar.toInt()
        averageCarTextView.text = getString(R.string.average_car, averageCarPrice)

        val numberOfBMWCarsTextView = findViewById<TextView>(R.id.number_of_bmw_cars)
        val numberOfBMWCars = cars.count { it is BMW }
        numberOfBMWCarsTextView.text = getString(R.string.bmw_count, numberOfBMWCars)

        val numberOfMercedesCarsTextView = findViewById<TextView>(R.id.number_of_mercedes_cars)
        val numberOfMercedesCars = cars.count { it is Mercedes }
        numberOfMercedesCarsTextView.text = getString(R.string.mercedes_count, numberOfMercedesCars)

        val numberOfFordCarsTextView = findViewById<TextView>(R.id.number_of_ford_cars)
        val numberOfFordCars = cars.count { it is Ford }
        numberOfFordCarsTextView.text = getString(R.string.ford_count, numberOfFordCars)

        val numberOfAutomaticCarsTextView = findViewById<TextView>(R.id.number_of_automatic_cars)
        val numberOfAutomaticCars = cars.count { it.gearBox == AvailableGearBoxes.AUTOMATIC }
        numberOfAutomaticCarsTextView.text =
            getString(R.string.automatic_count, numberOfAutomaticCars)

        val numberOfManualCarsTextView = findViewById<TextView>(R.id.number_of_manual_cars)
        val numberOfManualCars = cars.count { it.gearBox == AvailableGearBoxes.AUTOMATIC }
        numberOfManualCarsTextView.text = getString(R.string.manual_count, numberOfManualCars)

        val carCard = findViewById<LinearLayout>(R.id.car_card)

        for (car in cars) {
            val carCardView = layoutInflater.inflate(R.layout.car_card, carCard, false)
            val carImage = carCardView.findViewById<ImageView>(R.id.car_image1)
            val carDescription = carCardView.findViewById<TextView>(R.id.car_description1_1)
            carImage.setImageResource(R.drawable.car_placeholder)
            carDescription.text = generateCarDescription(car)
            carCard.addView(carCardView)
        }
    }



    private fun generateCarDescription(car: Car): String {
        return buildString {
            append("Car Details\n")
            append("Year: ${car.year}\n")
            append("Colour: ${car.colour}\n")
            append("Basic Price: £${car.price}\n")
            append("Fuel Type: ${car.fuelType}\n")
            append("Gearbox: ${car.gearBox}\n")

            when (car) {
                is AlphaSport -> {
                    append("${car.navigate()}")
                }
                is Alpha -> {
                    append("Model: Alpha\n")
                    append("Power Steering Available: ${if (car.powerSteering) "Yes" else "No"}\n")
                    append("Navigation Bonus Score: ${car.alphaNavigationRatingBonus()}\n")
                }
                is Beta -> {
                    append("Model: Beta\n")
                    append("Insurance Type: ${car.insuranceType}\n")
                    append("Power Steering Available: ${if (car.powerSteering) "Yes" else "No"}\n")
                    append("Insurance Score: ${car.insuranceScore()}\n")
                }
                is Omega -> {
                    append("Model: Omega\n")
                    append("Window Size: ${car.windowSize}ins\n")
                    append("Price with extras: ${car.omegaTotalPrice}")
                }
                is Maybach -> {
                    append("Boot Size: ${car.bootSize}ins \n")
                    append("Interior: ${car.interior}\n")
                    append("Price with extras: ${car.largeCarPremium()} \n")
                }
                is Sprinter -> {
                    append("Mileage: ${car.mileage} km \n")
                    append("Interior: ${car.interior}\n")
                }
                is Traveliner -> {
                    append("Power Steering Available: ${if (car.powerSteering) "Yes" else "No"}\n")
                }
                is Cougar -> {
                    append("Radio Type: ${car.radioType}\n")
                }
                is Explorer -> {
                    append("Spare Tyre Available: ${if (car.spareTyreAvailable()) "Yes" else "No"}\n")
                }
                is Capri -> {
                    append("Sun Roof: ${if (car.sunRoof) "Yes" else "No"}\n")
                    append("Price with extras: ${car.extrasPremium()}")
                }
                is BMW -> {
                    append("Manufacturer: BMW\n")
                    append("Dashboard: ${car.dashboard}\n")
                    append("SatNav: ${car.satNav}\n")
                    append("Location: ${car.location}")
                }
                is Mercedes -> {
                    append("Manufacturer: Mercedes\n")
                    append("Number of Doors: ${car.doors}\n")
                }
                is Ford -> {
                    append("Manufacturer: Ford\n")
                    append("Seats: ${car.seats}\n")
                    append("Interior Material: ${car.interiorMaterial}\n")
                    append("Owners: ${car.owners}\n")
                }
                else -> {
                    append(getString(R.string.car_description_placeholder))
                }
            }
        }

    }
}



