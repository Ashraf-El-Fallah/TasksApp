

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.af.tasks.R
import com.af.tasks.TaskDatabase
import com.af.tasks.TaskItemAdapter
import com.af.tasks.TasksViewModel
import com.af.tasks.TasksViewModelFactory
import com.af.tasks.databinding.FragmentTasksBinding


class TasksFragment: Fragment(){

    private var _binding: FragmentTasksBinding? = null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentTasksBinding.inflate(inflater,container,false)
        val view=binding.root



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //build the data base and get reference to taskDao property
        val application= requireNotNull(this.activity).application
        val dao= TaskDatabase.getInstance(application).taskDAO

        //get the view model
        val viewModelFactory= TasksViewModelFactory(dao)
        val viewModel= ViewModelProvider(
            this,viewModelFactory).get(TasksViewModel::class.java)

        //view model
        binding.viewModel=viewModel
        //this sets the data binding so that the layout can use it to access the view model's properties and methods
        binding.lifecycleOwner = viewLifecycleOwner

        //take a task adapter object
        //passing lambda function to adapter to make the item respond to clicks and display a toast
        val adapter= TaskItemAdapter{ taskId ->
            //Toast.makeText(context,"Clicked task $taskId",Toast.LENGTH_SHORT).show()
            viewModel.onTaskClicked(taskId)
        }

        binding.tasksList.adapter=adapter

        //set the TaskItemAdapter's data property to List<Task>
        viewModel.tasks.observe(viewLifecycleOwner, Observer {
            it?.let{
//                adapter.data=it

                //…using submitList()
                //To pass a list of tasks to TaskItemAdapter’s backing list, we’ll use a method called submitList().
                // This method is used to update a ListAdapter’s backing list with a new List object, so it’s perfect for this situation.
                //Use the submitList() method to submit a new version of a list to a ListAdapter Recycler views

                adapter.submitList(it)
            }
        })

        //run this code when navigateToTask is set to a new taskId that's not null
        viewModel.navigateToTask.observe(viewLifecycleOwner, Observer {taskId->
            taskId?.let {

                val args=Bundle()
                args.putLong("taskId",taskId)
                //val action=TasksFragmentDirections.actionTasksFragmentToEditTaskFragment(taskId)

                this.findNavController().navigate(R.id.action_tasksFragment_to_editTaskFragment,args)
                viewModel.onTaskNavigated()
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}