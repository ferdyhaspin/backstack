package app.ferdyhaspin.backstack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Fragment BackStack"

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val oneFragment = OneFragment()

        fragmentTransaction
            .add(R.id.fragment_back_stack_frame_layout, oneFragment, FragmentUtil.FRAGMENT_ONE)
            .commit()

        FragmentUtil.printActivityFragmentList(fragmentManager)
    }
}
