package com.borbi.boogiemeter.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
        entities = [
    Gig::class,
    BoogieTimeline::class],
        version = 1,
        exportSchema = false)

abstract class BoogieMeterDatabase : RoomDatabase() {

    abstract val gigDao: GigDao
    abstract val boogieTimelineDao: BoogieTimelineDao

    companion object {

        @Volatile
        private var INSTANCE: BoogieMeterDatabase? = null

        fun getInstance(context: Context): BoogieMeterDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            BoogieMeterDatabase::class.java,
                            "boogiemeter_database")
                            .fallbackToDestructiveMigration()
                            .build()

                    INSTANCE = instance

                } else {}

                return instance
            }
        }

    }
}
