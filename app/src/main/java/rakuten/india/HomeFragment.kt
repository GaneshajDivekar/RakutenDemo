package rakuten.india

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import rakuten.india.adapter.GithubRepoAdapter
import rakuten.india.databinding.FragmentHomeBinding
import rakuten.india.model.GithubRepoSearchPojo
import rakuten.india.utilis.NetworkHelper
import rakuten.india.viewmodel.MainViewModel
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val mainViewModel: MainViewModel by viewModels()
    @Inject
    lateinit var networkHelper: NetworkHelper
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        initView()
        return binding.root

    }

    private fun initView() {
        binding.btnSearch.setOnClickListener {
            if (binding.platform.text.toString().trim().equals("")) {
            Toast.makeText(activity,"Please enter Platform",Toast.LENGTH_SHORT).show()
            } else if (binding.orgnizations.text.toString().trim().equals("")) {
                Toast.makeText(activity,"Please enter org",Toast.LENGTH_SHORT).show()
            } else {
                mainViewModel.getGitHubRepo("android", "rakutentech").observe(viewLifecycleOwner, Observer {
                    if (it != null) {

                        linearLayoutManager = LinearLayoutManager(context)
                        list.layoutManager = linearLayoutManager
                        list.adapter = GithubRepoAdapter(requireContext(), it.items)
                    }
                })
            }
        }
    }

}