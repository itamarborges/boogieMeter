package com.borbi.boogiemeter.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BoogieTimelineDao {

    @Insert
    fun insert(boogieTimeLine: BoogieTimeline)

    @Update
    fun update(boogieTimeLine: BoogieTimeline)

    @Query("SELECT * from boogie_timeline WHERE boogieTimeLineId = :key")
    fun get(key: Long): BoogieTimeline?

    @Query("SELECT * FROM boogie_timeline WHERE gig_id = :key ORDER BY boogie_time DESC")
    fun getAllBoogiesFromGig(key: Long): LiveData<List<BoogieTimeline>>
}