package rakuten.india.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import rakuten.india.R
import rakuten.india.databinding.ItemLayoutBinding
import rakuten.india.model.GitJsonModel
import rakuten.india.model.Item

class GithubRepoAdapter(
    private val context: Context,
    private val githubRepoSearchPojo: List<Item>
) :
    RecyclerView.Adapter<GithubRepoAdapter.FilterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterHolder {
        val binding = DataBindingUtil.inflate<ItemLayoutBinding>(
            LayoutInflater.from(context),
            R.layout.item_layout,
            parent,
            false
        )
        return FilterHolder(binding)
    }

    override fun onBindViewHolder(holder: FilterHolder, position: Int) {
        val dashboardUIModel = gitJsonModel(position)
        holder.binding.jsondata = dashboardUIModel
    }

    private fun gitJsonModel(position: Int): GitJsonModel {
        val gitJsonModel = GitJsonModel()
        gitJsonModel.name = githubRepoSearchPojo[position].name
        gitJsonModel.desc = githubRepoSearchPojo[position].description
        gitJsonModel.lang = githubRepoSearchPojo[position].language
        gitJsonModel.privacy_status = githubRepoSearchPojo[position].svnUrl
        return gitJsonModel
    }


    override fun getItemCount(): Int {
        return githubRepoSearchPojo.size
    }

    class FilterHolder constructor(
        var binding: ItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
    }
}