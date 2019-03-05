package main.kotlin.coffeeshop

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            
            val coffeeShop = CoffeeShop()

            coffeeShop.makeCoffee("Cappucino", "OneMilk")
            coffeeShop.makeCoffee("Espresso", "TwoMilk")
        }
    }
}