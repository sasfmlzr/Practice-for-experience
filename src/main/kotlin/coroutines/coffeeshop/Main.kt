package coroutines.coffeeshop

import example.Logger
import example.Order
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.selects.select
import kotlin.system.measureTimeMillis

@ExperimentalCoroutinesApi
fun main(args: Array<String>) = runBlocking {

    val listMilk = listOf(
        Order("Espresso", "TwoMilk"),
        Order("Huespresso", "HueMilk"),
        Order("Cappucino", "OneMilk"),
        Order("Latte", "ThreeMilk"),
        Order("Something", "SomethingMilk"),
        Order("Anything", "AnythingMilk")
    )

    val ordersChannel = Channel<Order>()
    launch(CoroutineName("cashier")) {
        for (o in listMilk) {
            ordersChannel.send(o)
        }
        ordersChannel.close()
    }

    val time = measureTimeMillis {
        val coffeeChannelA = makeCoffee("barista-1", ordersChannel)
        val coffeeChannelB = makeCoffee("barista-2", ordersChannel)


        var isBaristaOneActive = true
        var isBaristaTwoActive = true
        while (isBaristaOneActive || isBaristaTwoActive) {
            select<Unit> {
                if (isBaristaOneActive) {
                    coffeeChannelA.onReceiveOrNull { v ->
                        if (coffeeChannelA.isClosedForReceive) isBaristaOneActive = false
                        if (v != null) Logger.d("Main", "Serve: $v")
                    }
                }
                if (isBaristaTwoActive) {
                    coffeeChannelB.onReceiveOrNull { v ->
                        if (coffeeChannelB.isClosedForReceive) isBaristaTwoActive = false
                        if (v != null) Logger.d("Main", "Serve: $v")
                    }
                }
            }
        }

    }
    Logger.d("Finish", time.toString() + "ms")
}

private suspend fun CoroutineScope.makeCoffee(tag: String, ordersChannel: ReceiveChannel<Order>) =
    produce(CoroutineName(tag)) {
        val coffeeShop = CoffeeShop()

        for (o in ordersChannel) {
            Logger.d("Make Coffee", "Processing order: $o")

            coroutineScope {
                send(coffeeShop.makeCoffee(o.coffee, o.milk))
            }
        }
    }

