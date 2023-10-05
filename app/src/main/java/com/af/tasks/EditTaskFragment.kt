

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.af.tasks.EditTaskFragmentArgs
import com.af.tasks.databinding.FragmentEditTaskBinding

class EditTaskFragment :Fragment(){

    private var _binding: FragmentEditTaskBinding? = null
    private val binding get()=_binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentEditTaskBinding.inflate(inflater,container,false)
        val view=binding.root


        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView=binding.taskId
        val taskId=EditTaskFragmentArgs.fromBundle(requireArguments()).taskId
        binding.taskId.text=taskId.toString()

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}