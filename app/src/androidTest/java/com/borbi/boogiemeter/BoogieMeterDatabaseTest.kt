package com.borbi.boogiemeter

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.borbi.boogiemeter.database.BoogieMeterDatabase
import com.borbi.boogiemeter.database.Gig
import com.borbi.boogiemeter.database.GigDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class BoogieMeterDatabaseTest {

    private lateinit var gigDao: GigDao
    private lateinit var db: BoogieMeterDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, BoogieMeterDatabase::class.java)
                // Allowing main thread queries, just for testing.
                .allowMainThreadQueries()
                .build()
        gigDao = db.gigDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insert() {
        val gig = Gig()
        gigDao.insert(gig)
    }
}