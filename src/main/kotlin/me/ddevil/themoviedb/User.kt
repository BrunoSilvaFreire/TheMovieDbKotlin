package me.ddevil.themoviedb

import me.ddevil.util.getString
import java.util.*

class User {
    val apiKey: String
    val language: Locale

    @JvmOverloads
    constructor(apiKey: String, language: Locale = Locale.getDefault()) {
        this.apiKey = apiKey
        this.language = language
    }

    constructor(map: Map<String, Any>) {
        this.apiKey = map.getString(MovieDBConstants.USER_API_KEY)
        this.language = if (MovieDBConstants.USER_LOCALE_KEY in map) {
            val localeId = map.getString(MovieDBConstants.USER_LOCALE_KEY)
            Locale(localeId)
        } else {
            Locale.getDefault()
        }
    }

}