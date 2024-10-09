package com.slashGil.basicintegration.data.dataSource.local.di

import android.app.Application
import androidx.room.Room
import com.slashGil.basicintegration.data.dataSource.local.ProductLocalDataSource
import com.slashGil.basicintegration.data.dataSource.local.data.ProductDao
import com.slashGil.basicintegration.data.dataSource.local.data.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): ProductDatabase {
        return Room.databaseBuilder(
                application,
                ProductDatabase::class.java,
                "product_database").build()
    }

    @Provides
    fun provideProductDao(database: ProductDatabase) = database.productDao

    @Provides
    fun provideProductLocalDataSource(productDao: ProductDao) = ProductLocalDataSource(productDao)
}
