package main.kotlin.synchronized

import main.kotlin.example.Logger
import java.util.concurrent.Executors.newFixedThreadPool

class QueueTasks {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            queueTask()
        }


        private fun queueTask(){
            val logger = Logger

            val longTask = Thread {
                logger.d("longTask", "Start")
                Thread.sleep(5000)
                logger.d("longTask", "End")
            }
            val shortTask = Thread {
                logger.d("shortTask", "Start")
                Thread.sleep(1000)
                logger.d("shortTask", "End")
            }
            val summTask = Thread {
                logger.d("summTask", "Start")
                Thread.sleep(1000)
                logger.d("summTask", "End")
            }
            val fixedPool = newFixedThreadPool(2)

            val resultLongTask = fixedPool.submit(longTask)
            val resultShortTask = fixedPool.submit(shortTask)

            logger.d("longTask", "results done? " + (resultLongTask.isDone && resultShortTask.isDone))

            resultLongTask.get()
            resultShortTask.get()

            logger.d("longTask", "results done? " + (resultLongTask.isDone && resultShortTask.isDone))
            summTask.run()

            logger.d("MAIN", "task completed")
            fixedPool.shutdown()
        }
        /**
         * longTask: results done? false
         * shortTask: Start
         * longTask: Start
         * shortTask: End
         * longTask: End
         * longTask: results done? true
         * summTask: Start
         * summTask: End
         * MAIN: task completed
         */
    }
}