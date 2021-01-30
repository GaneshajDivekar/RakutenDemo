package rakuten.india

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped

import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import rakuten.india.base.BaseActivity
import rakuten.india.databinding.ActivityMainBinding
import rakuten.india.utilis.NetworkHelper
import rakuten.india.viewmodel.MainViewModel
import javax.inject.Inject

@AndroidEntryPoint
@ActivityScoped
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    private val homeFragment = HomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mViewBinding.root)
        initializeFragments()
    }

    fun initializeFragments() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, homeFragment)
        fragmentTransaction.commit()
    }


    override val mViewModel: MainViewModel by viewModels()
    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
}