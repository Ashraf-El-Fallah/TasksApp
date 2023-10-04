package com.af.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TasksViewModel(private val dao: TaskDAO):ViewModel() {
    var newTaskName=""

////    private val tasks = dao.getAll()
//    val tasksString = Transformation.map(tasks) {        t
//    tasks -> formatTasks(tasks)
//    }
//}

     val tasks = dao.getAll()

    //live data
    private val _navigateToTask= MutableLiveData<Long?>()
    val navigateToTask:LiveData<Long?>
        get() = _navigateToTask

    fun onTaskClicked(taskId:Long){
        _navigateToTask.value=taskId
    }

    fun onTaskNavigated(){
        _navigateToTask.value=null
    }

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

//    fun formatTasks(tasks:List<ToDoTask>):String{
//        return tasks.fold(""){
//            str,item-> str + '\n' + formatTask(item)
//        }
//    }

//    fun formatTask(task: ToDoTask):String{
//        var str="ID : ${task.taskId}"
//        str += '\n' + "Name: ${task.taskName}"
//        str += '\n' + "Complete: ${task.taskDone}" + '\n'
//
//        return str
//    }
}