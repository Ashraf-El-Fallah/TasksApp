package com.af.tasks

import androidx.recyclerview.widget.DiffUtil


//The recycler view behaves in this way because we’re using DiffUtil to submit changes to it, instead of replacing the entire list.
class TaskDiffItemCallBack:DiffUtil.ItemCallback<ToDoTask>() {

    override fun areContentsTheSame(oldItem: ToDoTask, newItem: ToDoTask): Boolean = (oldItem == newItem)

    override fun areItemsTheSame(oldItem: ToDoTask, newItem: ToDoTask): Boolean = (oldItem.taskId == newItem.taskId)

}