package main.kotlin.coffeeshop

import main.kotlin.example.Logger

class CoffeeShop {

    private val logger = Logger
    private val TAG = "CoffeeShop"

    fun takeOrder() {
        logger.d(TAG, "takeOrder")
    }

    fun grindCoffeeBeans() {
        logger.d(TAG, "grindCoffeeBeans")
    }

    fun pullEspressoShot() {
        logger.d(TAG, "pullEspressoShot")
    }

    fun steamMilk() {
        logger.d(TAG, "steamMilk")
    }

    fun combibeForEspresso() {
        logger.d(TAG, "combibeForEspresso")
    }

    fun serveCappucino() {
        logger.d(TAG, "serveCappucino")
    }
}