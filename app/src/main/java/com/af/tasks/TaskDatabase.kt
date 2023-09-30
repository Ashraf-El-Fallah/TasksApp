package com.af.tasks

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class TaskDatabase :RoomDatabase(){
    //you will use data access methods in TaskDAO
    //taskDAO property
    abstract val taskDAO:TaskDAO

    companion object{
        @Volatile
        private var INSTANCE:TaskDatabase?=null  //returns an instance of data base

        fun getInstance(context: Context):TaskDatabase{
            synchronized(this){
                var instance= INSTANCE
                if(instance==null){
                    instance= Room.databaseBuilder(
                        context.applicationContext,
                        TaskDatabase::class.java,
                        "tasks_database"
                    ).build()
                    INSTANCE=instance
                }
                return instance
            }
        }
    }
}