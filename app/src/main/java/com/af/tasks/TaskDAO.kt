package com.af.tasks

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TaskDAO {

    //suspend to use coroutines
    @Insert
    suspend fun insert(task:ToDoTask)

//    @Update
//    suspend fun update(task: ToDoTask)
//
//    @Delete
//    suspend fun delete(task: ToDoTask)

//    @Query("SELECT * FROM task_table WHERE taskId = :taskId")
//    fun get(taskId:Long):LiveData<Task>

//    @Query("SELECT * FROM task_table ORDER BY taskId DESC")
//    fun getAll():LiveData<List<Task>>
}