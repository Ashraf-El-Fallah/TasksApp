

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.af.tasks.EditTaskViewModel
import com.af.tasks.R
import com.af.tasks.TaskDatabase
import com.af.tasks.databinding.FragmentEditTaskBinding
import com.hfad.tasks.EditTaskViewModelFactory

class EditTaskFragment :Fragment(){

    private var _binding: FragmentEditTaskBinding? = null
    private val binding get()=_binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditTaskBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val taskId= arguments?.getLong("taskId")
//        binding.taskId.text=taskId.toString()

        //these lines used to create view model factory
        val application= requireNotNull(this.activity).application
        val dao=TaskDatabase.getInstance(application).taskDAO

        //get a reference to a view model
        val viewModelFactory=EditTaskViewModelFactory(taskId!!.toLong(),dao)
        val viewModel=ViewModelProvider(this,viewModelFactory)
            .get(EditTaskViewModel::class.java)

        //set the layout's data binding variable
        binding.viewModel=viewModel
        //this is used to interact with life data
        binding.lifecycleOwner=viewLifecycleOwner

        viewModel.navigateToList.observe(viewLifecycleOwner, Observer {navigate->
            if(navigate){
                view.findNavController()
                    .navigate(R.id.action_editTaskFragment_to_tasksFragment)
                viewModel.onNavigatedToList()
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}