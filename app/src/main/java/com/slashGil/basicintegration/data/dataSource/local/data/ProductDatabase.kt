package com.slashGil.basicintegration.data.dataSource.local.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.slashGil.basicintegration.data.dataSource.local.data.models.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductDatabase: RoomDatabase() {
    abstract val productDao: ProductDao
}
