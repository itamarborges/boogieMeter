package com.borbi.boogiemeter.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "boogie_timeline")
data class BoogieTimeline(

        @PrimaryKey(autoGenerate = true)
        var boogieTimeLineId: Long = 0L,

        @ColumnInfo(name = "gig_id")
        val gigId: Long = 0,

        @ColumnInfo(name = "boogie_time")
        val boogieTime: Long = System.currentTimeMillis(),

        @ColumnInfo(name = "boogies")
        var boogies: Int = 0,

        @ColumnInfo(name = "super_dooper_boogies")
        var superDooperBoogies: Int = 0

)