package com.borbi.boogiemeter.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gig")
data class Gig(

        @PrimaryKey(autoGenerate = true)
        var gigId: Long = 0L,

        @ColumnInfo(name = "start_time")
        val startTime: Long = System.currentTimeMillis(),

        @ColumnInfo(name = "end_time")
        var endTime: Long = System.currentTimeMillis(),

        @ColumnInfo(name = "description")
        var description: String = "sDefault",

        @ColumnInfo(name = "rating")
        var rating: Int = 0,

        @ColumnInfo(name = "score_boogies")
        var scoreBoogies: Int = 0,

        @ColumnInfo(name = "total_boogies")
        var totalBoogies: Int = 0,

        @ColumnInfo(name = "total_super_dooper_boogies")
        var superDooperBoogies: Int = 0
)