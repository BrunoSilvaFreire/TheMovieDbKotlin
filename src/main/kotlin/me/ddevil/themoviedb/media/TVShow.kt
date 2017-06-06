package me.ddevil.themoviedb.media

import me.ddevil.themoviedb.MovieDBConstants
import me.ddevil.util.getList
import me.ddevil.util.getString

class TVShow(map: Map<String, Any>) : Media(map) {
    val name = map.getString(MovieDBConstants.TV_SHOW_NAME_KEY)
    val originalName = map.getString(MovieDBConstants.TV_SHOW_ORIGINAL_NAME_KEY)
    val originCountry = map.getList<String>(MovieDBConstants.TV_SHOW_ORIGIN_COUNTRY_KEY)
    val firstAirDate = parseDate(map.getString(MovieDBConstants.TV_SHOW_FIRST_AIR_DATE_KEY))

    override fun toString(): String {
        return "TVShow(id=$id, overview='$overview', voteCount=$voteCount, voteAverage=$voteAverage, popularity=$popularity, posterPath='$posterPath', backdropPath='$backdropPath', originalLanguage='$originalLanguage', genreIds=$genreIds, name='$name', originalName='$originalName', originCountry=$originCountry, firstAirDate=$firstAirDate)"
    }


}