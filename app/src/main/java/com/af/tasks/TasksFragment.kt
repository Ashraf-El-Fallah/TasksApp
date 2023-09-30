
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.af.tasks.TaskDatabase
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

        //build the data base and get reference to taskDao property
        val application= requireNotNull(this.activity).application
        val dao=TaskDatabase.getInstance(application).taskDAO

        //get the view model
        val viewModelFactory=TasksViewModelFactory(dao)
        val viewModel=ViewModelProvider(
            this,viewModelFactory).get(TasksViewModel::class.java)

        //this sets the data binding so that the layout can use it to access the view model's properties and methods
        binding.viewModel=viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}