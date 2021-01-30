package rakuten.india.network

import io.reactivex.Observable
import rakuten.india.model.GithubRepoSearchPojo
import retrofit2.http.GET
import retrofit2.http.Query


interface APIService {

    /*@GET("/search/repositories")
    fun getPostsCommentss(
        @Query("q") String query):Observable<GithubRepoSearchPojo>*/

    @GET("/search/repositories")
    fun getPostsComments(
        @Query("q") platform: String): Observable<GithubRepoSearchPojo>

    companion object {
        const val Base_Url = "https://api.github.com/"
    }
}
