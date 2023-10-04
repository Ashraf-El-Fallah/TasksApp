
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

        val textView=binding.taskId
        val taskId=EditTaskFragmentArgs.fromBundle(requireArguments()).taskId
        textView.text=taskId.toString()

        return view

    }
}