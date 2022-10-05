package com.borbi.boogiemeter.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface GigDao {

    @Insert
    fun insert(gig: Gig)

    @Update
    fun update(gig: Gig)

    @Query("SELECT * from gig WHERE gigId = :key")
    fun get(key: Long): Gig?

    @Query("SELECT * FROM gig ORDER BY start_time DESC")
    fun getAllGigs(): LiveData<List<Gig>>


}