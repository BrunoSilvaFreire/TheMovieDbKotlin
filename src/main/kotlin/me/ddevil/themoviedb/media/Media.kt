package me.ddevil.themoviedb.media

import me.ddevil.themoviedb.MovieDBConstants
import me.ddevil.util.*
import java.time.LocalDate

abstract class Media(map: Map<String, Any>) {
    val id = map.getInt(MovieDBConstants.MEDIA_ID_KEY)
    val overview = map.getString(MovieDBConstants.MEDIA_OVERVIEW_KEY)
    val voteCount = map.getInt(MovieDBConstants.MEDIA_VOTE_COUNT_KEY)
    val voteAverage = map.getDouble(MovieDBConstants.MEDIA_VOTE_AVERAGE_KEY)
    val popularity = map.getDouble(MovieDBConstants.MEDIA_POPULARITY_KEY)
    val posterPath = map.getStringOrNull(MovieDBConstants.MEDIA_POSTER_PATH_KEY)
    val backdropPath = map.getStringOrNull(MovieDBConstants.MEDIA_BACKDROP_PATH_KEY)
    val originalLanguage = map.getString(MovieDBConstants.MEDIA_ORIGINAL_LANGUAGE_KEY)
    val genreIds = map.getList<Int>(MovieDBConstants.MEDIA_GENRE_ID_KEY)
    override fun toString(): String {
        return "Media(id=$id, overview='$overview', voteCount=$voteCount, voteAverage=$voteAverage, popularity=$popularity, posterPath='$posterPath', backdropPath='$backdropPath', originalLanguage='$originalLanguage', genreIds=$genreIds)"
    }

    protected fun parseDate(string: String) = LocalDate.parse(string)!!


}