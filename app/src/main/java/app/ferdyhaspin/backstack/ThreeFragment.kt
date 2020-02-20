package app.ferdyhaspin.backstack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_three.*


class ThreeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_back_stack_three_button.setOnClickListener {

            val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()

            FragmentUtil.printActivityFragmentList(fragmentManager)

            fragmentTransaction
                .replace(
                    R.id.fragment_back_stack_frame_layout,
                    OneFragment(),
                    FragmentUtil.FRAGMENT_ONE
                ).addToBackStack(null)
                .commit()
        }
    }


}
