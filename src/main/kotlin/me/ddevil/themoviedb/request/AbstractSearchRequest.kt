package me.ddevil.themoviedb.request

import me.ddevil.themoviedb.User

abstract class AbstractSearchRequest<out R>(user: User) : AbstractRequest<List<R>>(user)