package com.java.date

import java.util.*

/**
 * @author zJiaLi
 * @since 2020-03-25 10:19
 */
class GetDate {
    val startTime: Date
        get() {
            val calendar = Calendar.getInstance()
            calendar.time = Date()
            calendar[Calendar.HOUR_OF_DAY] = 23
            calendar[Calendar.MINUTE] = 59
            calendar[Calendar.SECOND] = 59
            return calendar.time
        }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val getDate = GetDate()
            val threads = arrayOfNulls<Thread>(100)
            for (i in 0..99) {
                val t1 = Thread(Runnable {
                    var startTime: Date? = null
                    for (j in 0..19) {
                        startTime = getDate.startTime
                    }
                    println(Thread.currentThread().name)
                    println(startTime)
                })
                threads[i] = t1
            }
            for (thread in threads) {
                thread!!.start()
            }
        }
    }
}