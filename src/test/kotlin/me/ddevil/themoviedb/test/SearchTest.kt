package me.ddevil.themoviedb.test

import me.ddevil.json.parse.JsonParser
import me.ddevil.themoviedb.User
import me.ddevil.themoviedb.request.SearchMovieRequest
import me.ddevil.themoviedb.request.SearchTVShowRequest
import org.apache.http.impl.client.HttpClients
import org.junit.Test
import java.io.File

val user = loadUser()

fun loadUser(): User {
    val file = File("./config.json")
    println(file.canonicalPath)
    val json = JsonParser().parseObject(file)
    return User(json as Map<String, Any>)
}

class SearchTest {
    @Test
    fun movies() {
        for (movie in SearchMovieRequest("Kimi no Na Wa", user).execute(HttpClients.createSystem())) {
            println(movie.toString())
        }
    }

    @Test
    fun tvShows() {
        for (tvShow in SearchTVShowRequest("The Walking Dead", user).execute(HttpClients.createSystem())) {
            println(tvShow.toString())
        }
    }
}