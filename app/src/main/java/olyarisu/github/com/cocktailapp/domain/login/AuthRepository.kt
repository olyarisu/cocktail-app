package olyarisu.github.com.cocktailapp.domain.login

import io.reactivex.Completable
import io.reactivex.Single

interface AuthRepository {
    fun userLoginId(): Single<String>
    fun authWithGoogle(idToken: String): Completable
}