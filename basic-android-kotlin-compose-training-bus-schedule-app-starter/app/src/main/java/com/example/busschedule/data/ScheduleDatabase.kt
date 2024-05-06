package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(
    entities = [BusSchedule::class],
    version = 1
)
public abstract class ScheduleDatabase : RoomDatabase() {
    abstract fun busScheduleDao(): BusScheduleDao

    companion object {
        @Volatile
        private var Instance: ScheduleDatabase? = null

        fun getDatabase(context: Context): ScheduleDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, ScheduleDatabase::class.java, "app_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}