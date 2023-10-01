package com.af.tasks

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDAO {

    //interface for data access
    //suspend to use coroutines
    @Insert
    suspend fun insert(task:ToDoTask)

    @Update
    suspend fun update(task: ToDoTask)

    @Delete
    suspend fun delete(task: ToDoTask)

//    @Query("SELECT * FROM task_table WHERE taskId = :taskId")
//    fun get(taskId:Long):LiveData<Task>

    @Query("SELECT * FROM task_table ORDER BY taskId DESC")
    fun getAll(): LiveData<List<ToDoTask>>
}