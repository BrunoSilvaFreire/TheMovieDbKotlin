package me.ddevil.themoviedb.request

import me.ddevil.json.JsonObject
import me.ddevil.themoviedb.User
import me.ddevil.themoviedb.media.TVShow
import me.ddevil.themoviedb.util.webSafe
import me.ddevil.util.getList
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpGet

class SearchTVShowRequest(val showName: String, user: User) : AbstractSearchRequest<TVShow>(user) {
    override fun handle(response: HttpResponse, text: String): List<TVShow> {
        val json = readJson(text)
        val list = json.getList<JsonObject>("results")
        return list.map {
            TVShow(it as Map<String, Any>)
        }
    }


    override fun createRequest(user: User) = HttpGet("$baseUrl&query=${showName.webSafe}")

    override val endPoint: String = "search/tv"
}