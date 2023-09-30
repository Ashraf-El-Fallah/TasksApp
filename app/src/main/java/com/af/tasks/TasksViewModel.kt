package com.af.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TasksViewModel(private val dao: TaskDAO):ViewModel() {
    var newTaskName=""

    fun addTask() {
        //launch the coroutines in the same as the view model
        //This change means that each time the addTask() method gets called,
        // it will use TaskDao’s insert() method (a coroutine) to insert records in the background.

        viewModelScope.launch(Dispatchers.IO){
            val task = ToDoTask()
            task.taskName = newTaskName
            dao.insert(task)
        }
    }
}