package com.example.quizquiz.database

import android.content.Context
import androidx.room.*

@Dao
interface QuizDAO {
    @Insert
    fun insert(quiz: Quiz): Long
    @Update
    fun update(quiz: Quiz)
    @Delete
    fun delete(quiz: Quiz)
    @Query("SELECT * FROM quiz")
    fun getAll(): List<Quiz>
}

@Database(entities = [Quiz::class], version=1)
@TypeConverters(StringListTypeConverter::class)
abstract class QuizDatabase : RoomDatabase(){
    abstract fun quizDAC(): QuizDAO

    companion object {
        private var INSTANCE: QuizDatabase? = null

        fun getInstance(context: Context): QuizDatabase {
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    QuizDatabase::class.java,"database.db").build()
            }
            return INSTANCE!!
        }
    }
}