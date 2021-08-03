package com.picpay.desafio.android.home.data.repositories.user

import com.picpay.desafio.android.database.daos.UserDao
import com.picpay.desafio.android.home.data.datasets.user.UserDataSet
import com.picpay.desafio.android.home.domain.entities.User
import com.picpay.desafio.android.home.domain.toDomain
import com.picpay.desafio.android.home.domain.toEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UserRepositoryImpl
@Inject constructor(
    private val userDataSet: UserDataSet,
    private val userDao: UserDao
) : UserRepository {

    override fun requestUsers(): Single<List<User>> =
        userDataSet.getUsers()
            .doAfterSuccess { usersDto -> userDao.save(usersDto.toEntity()) }
            .map { usersDto -> usersDto.toDomain() }

    override fun getLocalUsers(): Single<List<User>> =
        userDao.selectAll()
            .map { users -> users?.toDomain() }
}