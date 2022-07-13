package br.com.dio.app.repositories.data.repositories

import br.com.dio.app.repositories.core.RemoteException
import br.com.dio.app.repositories.data.services.GithubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepoRepositoryImplementation(private val service: GithubService) : RepoRepository {

    override suspend fun listRepositories(user: String) = flow {
        try {
            val repoList = service.listRepositories(user)
            emit(repoList)
        } catch (exception: HttpException) {
            throw RemoteException(exception.message ?: "Não foi possível fazer a busca no momento!")
        }

    }
}