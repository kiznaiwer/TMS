package com.example.tms.Data

import kotlinx.coroutines.delay
import kotlin.random.Random

class Repository {
    suspend fun loadData(): String {
        delay(2000)
        if (Random.nextBoolean()){
            throw Exception("Ошибка загрузки")
        }
        return "Получены данные"
    }
}