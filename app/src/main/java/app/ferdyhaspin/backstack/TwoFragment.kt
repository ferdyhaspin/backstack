package app.ferdyhaspin.backstack


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_two.*

/**
 * A simple [Fragment] subclass.
 */
class TwoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_back_stack_two_button.setOnClickListener {

            val fragmentTransaction = fragmentManager?.beginTransaction()

            FragmentUtil.printActivityFragmentList(fragmentManager)

            val twoFragment: Fragment? =
                FragmentUtil.getFragmentByTagName(fragmentManager, FragmentUtil.FRAGMENT_TWO)
            if (twoFragment != null) {
                Log.d(
                    FragmentUtil.TAG_NAME_FRAGMENT,
                    "Fragment Two exist in back stack, will hide it now."
                );
                fragmentTransaction?.hide(twoFragment)
            }

            fragmentTransaction.apply {
                if (this != null) {
                    replace(
                        R.id.fragment_back_stack_frame_layout,
                        ThreeFragment(),
                        FragmentUtil.FRAGMENT_THREE
                    )
                    addToBackStack(null)
                    commit()
                }
            }
        }

    }


}
