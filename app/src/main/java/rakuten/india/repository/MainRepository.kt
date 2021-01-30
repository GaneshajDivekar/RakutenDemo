package rakuten.india.repository

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rakuten.india.model.GithubRepoSearchPojo
import rakuten.india.network.APIService
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: APIService
) {
    var gitHubLiveData = MutableLiveData<GithubRepoSearchPojo>()

    fun getGitHubRepo(platform: String, organisation: String): MutableLiveData<GithubRepoSearchPojo> {
        val query = platform+"+org:"+organisation
        apiHelper.getPostsComments(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(
                { gitRepo ->

                    gitHubLiveData.postValue(gitRepo)
                },
                { error ->
                    gitHubLiveData.postValue(null)
                    handledError(error)
                }

            )

        return gitHubLiveData
    }
    private fun handledError(error: Throwable?) {
        Log.e(TAG, "Weather" + error.toString())
    }
}