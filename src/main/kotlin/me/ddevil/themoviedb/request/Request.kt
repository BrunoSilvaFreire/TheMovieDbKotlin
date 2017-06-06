package me.ddevil.themoviedb.request

import org.apache.http.client.HttpClient

interface Request<out R> {
    fun execute(client: HttpClient): R
}