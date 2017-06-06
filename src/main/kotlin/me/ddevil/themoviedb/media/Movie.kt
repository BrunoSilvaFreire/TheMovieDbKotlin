package me.ddevil.themoviedb.media

import me.ddevil.themoviedb.MovieDBConstants
import me.ddevil.util.getBoolean
import me.ddevil.util.getString

class Movie(map: Map<String, Any>) : Media(map) {
    val title = map.getString(MovieDBConstants.MOVIE_TITLE_KEY)
    val originalTitle = map.getString(MovieDBConstants.MOVIE_ORIGINAL_TITLE_KEY)
    val adult = map.getBoolean(MovieDBConstants.MOVIE_ADULT_KEY)
    val releaseDate = parseDate(map.getString(MovieDBConstants.MOVIE_RELEASE_DATE_KEY))
    override fun toString(): String {
        return "Movie(id=$id, overview='$overview', voteCount=$voteCount, voteAverage=$voteAverage, popularity=$popularity, posterPath='$posterPath', backdropPath='$backdropPath', originalLanguage='$originalLanguage', genreIds=$genreIds, title='$title', originalTitle='$originalTitle', adult=$adult, releaseDate=$releaseDate)"
    }

}