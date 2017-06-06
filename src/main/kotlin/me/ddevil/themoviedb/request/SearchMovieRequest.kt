package me.ddevil.themoviedb.request

import me.ddevil.json.JsonObject
import me.ddevil.themoviedb.User
import me.ddevil.themoviedb.media.Movie
import me.ddevil.themoviedb.util.webSafe
import me.ddevil.util.getList
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpGet

class SearchMovieRequest(val movieName: String, user: User) : AbstractSearchRequest<Movie>(user) {
    override fun handle(response: HttpResponse, text: String): List<Movie> {
        val json = readJson(text)
        val list = json.getList<JsonObject>("results")
        return list.map {
            Movie(it as Map<String, Any>)
        }
    }

    override fun createRequest(user: User) = HttpGet("$baseUrl&query=${movieName.webSafe}")

    override val endPoint get() = "search/movie"
}