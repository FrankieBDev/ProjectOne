package com.fbada.projectone.presentation


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
import Cougar
import Explorer
import Ford
import Maybach
import Mercedes
import Omega
import Sprinter
import Traveliner
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fbada.projectone.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cars = listOf(
            Mercedes(3, 55, 1999, AvailableColours.BLACK, AvailableFuelTypes.HYBRID, AvailableGearBoxes.MANUAL),
            Mercedes(5, 160, 2021, AvailableColours.WHITE, AvailableFuelTypes.DIESEL, AvailableGearBoxes.AUTOMATIC),
            BMW(AvailableBMWDashboards.DIGITAL, AvailableSatNavs.GOOGLE, "Sheffield", 2022, AvailableColours.BLUE, AvailableFuelTypes.PETROL, AvailableGearBoxes.AUTOMATIC),
            BMW(AvailableBMWDashboards.SPORT, AvailableSatNavs.APPLE, "Stockport", 2020, AvailableColours.RED, AvailableFuelTypes.ELECTRIC, AvailableGearBoxes.AUTOMATIC),
            Ford(5, AvailableInteriorMaterials.LEATHER, 2, 2015, AvailableColours.GREEN, AvailableFuelTypes.PETROL, AvailableGearBoxes.MANUAL),
            Ford(4, AvailableInteriorMaterials.FABRIC, 1, 2018, AvailableColours.SILVER, AvailableFuelTypes.DIESEL, AvailableGearBoxes.AUTOMATIC),
            Beta(true, AvailableInsurance.STANDARD_PROTECTION, true, AvailableBMWDashboards.HUD, AvailableSatNavs.GARMIN, "London", 2004, AvailableColours.YELLOW, AvailableFuelTypes.DIESEL, AvailableGearBoxes.MANUAL),
            Beta(true, AvailableInsurance.ROADSIDE_ASSISTANCE, true, AvailableBMWDashboards.IDRIVE, AvailableSatNavs.GARMIN, "Manchester", 2023, AvailableColours.BLUE, AvailableFuelTypes.DIESEL, AvailableGearBoxes.MANUAL),
            Beta(false, AvailableInsurance.BASIC_LIABILITY, false, AvailableBMWDashboards.DIGITAL, AvailableSatNavs.TOMTOM, "Newcastle", 2002, AvailableColours.RED, AvailableFuelTypes.PETROL, AvailableGearBoxes.AUTOMATIC),
            Omega(100, AvailableBMWDashboards.IDRIVE, AvailableSatNavs.APPLE, "Huddersfield", 2021, AvailableColours.BLUE, AvailableFuelTypes.HYBRID, AvailableGearBoxes.AUTOMATIC),
            Omega(120, AvailableBMWDashboards.IDRIVE, AvailableSatNavs.GOOGLE, "Hull", 2023, AvailableColours.WHITE, AvailableFuelTypes.DIESEL, AvailableGearBoxes.AUTOMATIC),
            Cougar(AvailableRadios.CD_PLAYER, 6, AvailableInteriorMaterials.LEATHER, 3, 2020, AvailableColours.GREEN, AvailableFuelTypes.PETROL, AvailableGearBoxes.MANUAL),
            Cougar(AvailableRadios.SMART_PHONE_CONNECT, 5, AvailableInteriorMaterials.COMBO, 2, 1999, AvailableColours.BLACK, AvailableFuelTypes.ELECTRIC, AvailableGearBoxes.AUTOMATIC),
            Cougar(AvailableRadios.CD_PLAYER, 4, AvailableInteriorMaterials.FABRIC, 3, 2016, AvailableColours.RED, AvailableFuelTypes.PETROL, AvailableGearBoxes.MANUAL),
            Explorer(true, 85.0, 7, AvailableInteriorMaterials.LEATHER, 1, 2017, AvailableColours.WHITE, AvailableFuelTypes.DIESEL, AvailableGearBoxes.AUTOMATIC),
            Explorer(false, 90.0, 5, AvailableInteriorMaterials.FABRIC, 2, 2018, AvailableColours.SILVER, AvailableFuelTypes.PETROL, AvailableGearBoxes.MANUAL),
            Explorer(true, 95.0, 6, AvailableInteriorMaterials.LEATHER, 2, 2019, AvailableColours.SILVER, AvailableFuelTypes.HYBRID, AvailableGearBoxes.AUTOMATIC),
            Capri(true, true, 5, 5, AvailableInteriorMaterials.LEATHER, 1, 2021, AvailableColours.RED, AvailableFuelTypes.ELECTRIC, AvailableGearBoxes.MANUAL),
            Capri(true, true, 6, 4, AvailableInteriorMaterials.LEATHER, 2, 2003, AvailableColours.GREEN, AvailableFuelTypes.HYBRID, AvailableGearBoxes.AUTOMATIC),
            Capri(false, false, 4, 4, AvailableInteriorMaterials.PLASTIC, 3, 2019, AvailableColours.BLUE, AvailableFuelTypes.ELECTRIC, AvailableGearBoxes.MANUAL),
            Traveliner(true, 4, 120, 2021, AvailableColours.YELLOW, AvailableFuelTypes.DIESEL, AvailableGearBoxes.AUTOMATIC),
            Traveliner(false, 5, 140, 2020, AvailableColours.BLUE, AvailableFuelTypes.PETROL, AvailableGearBoxes.MANUAL),
            Traveliner(false, 6, 150, 2018, AvailableColours.BLACK, AvailableFuelTypes.DIESEL, AvailableGearBoxes.MANUAL),
            Maybach(480.0, AvailableInteriorMaterials.SUEDE, 3, 170, 2020, AvailableColours.BLUE, AvailableFuelTypes.HYBRID, AvailableGearBoxes.AUTOMATIC),
            Maybach(500.0, AvailableInteriorMaterials.LEATHER, 4, 200, 2022, AvailableColours.BLACK, AvailableFuelTypes.ELECTRIC, AvailableGearBoxes.AUTOMATIC),
            Maybach(450.0, AvailableInteriorMaterials.SUEDE, 2, 180, 2021, AvailableColours.WHITE, AvailableFuelTypes.HYBRID, AvailableGearBoxes.AUTOMATIC),
            Sprinter(10000, AvailableInteriorMaterials.FABRIC, 4, 160, 2019, AvailableColours.RED, AvailableFuelTypes.DIESEL, AvailableGearBoxes.MANUAL),
            Sprinter(20000, AvailableInteriorMaterials.PLASTIC, 5, 140, 2020, AvailableColours.GREEN, AvailableFuelTypes.PETROL, AvailableGearBoxes.AUTOMATIC),
            Sprinter(460, AvailableInteriorMaterials.COMBO, 4, 120, 200, AvailableColours.BLUE, AvailableFuelTypes.ELECTRIC, AvailableGearBoxes.MANUAL)
        )


    }
}