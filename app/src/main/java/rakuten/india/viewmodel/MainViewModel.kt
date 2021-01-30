package rakuten.india.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rakuten.india.model.GithubRepoSearchPojo
import rakuten.india.repository.MainRepository

class MainViewModel @ViewModelInject constructor(private val mainRepository: MainRepository) : ViewModel() {
    fun getGitHubRepo(platform: String, organisation: String): MutableLiveData<GithubRepoSearchPojo> {
        return mainRepository.getGitHubRepo(platform,organisation)
    }

}