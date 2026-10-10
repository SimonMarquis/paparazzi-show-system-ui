package com.example.reproducer.ui.main

import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test

class MainScreenTest {

    @get:Rule
    val paparazzi = Paparazzi(
        showSystemUi = true,
        deviceConfig = DeviceConfig.PIXEL_9_PRO_XL,
        theme = "Theme.Reproducer",
    )

    @Test
    fun launchComposable() = paparazzi.snapshot {
        MainScreen()
    }

}