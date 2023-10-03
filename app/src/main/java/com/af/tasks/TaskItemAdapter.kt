package com.af.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.af.tasks.databinding.TaskItemBinding

class TaskItemAdapter:ListAdapter<ToDoTask,TaskItemAdapter.TaskItemViewHolder>(TaskDiffItemCallBack()){
    //RecyclerView.Adapter<TaskItemAdapter.TaskItemViewHolder>() {

    //set(value) .. This is the setter block. It gets executed when you assign a new value to the data property.
    //field: The field keyword refers to the backing field of the property.
    // The backing field is an automatically generated field that stores the actual value of the property.
    // When you write field = value, you are updating the backing field with the new value provided via the setter.


//    var data= listOf<ToDoTask>()
//        set(value) {
//            field=value
//            notifyDataSetChanged() //this method tells the r.v when the data's changed
//        }

    //we will make the view holder responsible for populating its layout instead of adapter
    //class TaskItemViewHolder(val rootView:CardView):RecyclerView.ViewHolder(rootView)
    class TaskItemViewHolder(val binding:TaskItemBinding):RecyclerView.ViewHolder(binding.root) {

//        val taskName=rootView.findViewById<TextView>(R.id.task_name)
//        val taskDone=rootView.findViewById<CheckBox>(R.id.task_done)

        companion object {
            //this inflates the layout of the items
            fun inflateFrom(parent: ViewGroup): TaskItemViewHolder {
                val layoutInflater=LayoutInflater.from(parent.context)
//              val view=layoutInflater.inflate(R.layout.task_item,parent,false) as CardView

                val binding=TaskItemBinding.inflate(layoutInflater,parent,false)
                return TaskItemViewHolder(binding)
            }
        }
        fun bind(item:ToDoTask){
            //this is used for findviewbyId
//            taskName.text=item.taskName
//            taskDone.isChecked=item.taskDone

            //this for data binding
            //binding.task=item

            //this is used with view binding
            binding.taskName.text=item.taskName
            binding.taskDone.isChecked=item.taskDone

        }
    }


    //inflate each item's layout
    //it's used for each item that needs to be displayed in the recycler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder = TaskItemViewHolder.inflateFrom(parent)

//    override fun getItemCount() = data.size

    //it's called for each TaskItemViewHolder to bind data to views in each view holder layout
    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item=getItem(position)
        holder.bind(item)
    }


}