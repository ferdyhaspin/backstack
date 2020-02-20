package app.ferdyhaspin.backstack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_one.*

class OneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentManager = fragmentManager

        fragment_back_stack_one_button.setOnClickListener {

            var twoFragment: Fragment? =
                FragmentUtil.getFragmentByTagName(fragmentManager, FragmentUtil.FRAGMENT_TWO)

            if (twoFragment == null){
                twoFragment = TwoFragment()
            }

            fragmentManager?.beginTransaction().apply {
                if (this != null){
                    replace(R.id.fragment_back_stack_frame_layout, twoFragment, FragmentUtil.FRAGMENT_TWO)
                        .addToBackStack(null)
                        .commit()
                }
            }

            FragmentUtil.printActivityFragmentList(fragmentManager)

        }
    }
}
