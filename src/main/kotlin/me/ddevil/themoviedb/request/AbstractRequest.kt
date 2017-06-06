package me.ddevil.themoviedb.request

import me.ddevil.json.parse.JsonParser
import me.ddevil.themoviedb.MovieDBConstants
import me.ddevil.themoviedb.User
import me.ddevil.util.readToString
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpUriRequest
import java.util.*

abstract class AbstractRequest<out R>(val user: User) : Request<R> {
    override fun execute(client: HttpClient): R {
        val request = createRequest(user)
        println(request)
        val response = client.execute(request)
        val text = response.entity.content.readBytes().readToString()
        return handle(response, text)
    }

    protected abstract fun handle(response: HttpResponse, text: String): R

    protected abstract fun createRequest(user: User): HttpUriRequest

    abstract val endPoint: String

    fun readJson(text: String) = JsonParser().parseObject(text)

    val baseUrl: String get() {
        var base = "${MovieDBConstants.MOVIE_DB_API_PREFIX}$endPoint/?api_key=${user.apiKey}"
        if (user.language != Locale.US) {
            base += "&language=${user.language.isO3Country}"
        }
        return base
    }
}

