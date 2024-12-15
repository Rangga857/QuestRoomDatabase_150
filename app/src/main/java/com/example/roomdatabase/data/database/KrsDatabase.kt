package com.example.roomdatabase.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.data.dao.MahasiswaDao
import com.example.roomdatabase.data.entity.Mahasiswa


@Database(entities = [Mahasiswa::class], version = 1, exportSchema =  false)
abstract class KrsDatabase : RoomDatabase() {

    abstract fun mahasiswaDao(): MahasiswaDao

    companion object{
        @Volatile
        private var Instace: KrsDatabase?=null

        fun getDatabase(context: Context): KrsDatabase{
            return (Instace ?: synchronized(this){
                Room.databaseBuilder(
                    context,
                    KrsDatabase::class.java, //Class Database
                    "KrsDatabase" //nama database
                )
                    .build().also { Instace= it }
            })
        }
    }
}