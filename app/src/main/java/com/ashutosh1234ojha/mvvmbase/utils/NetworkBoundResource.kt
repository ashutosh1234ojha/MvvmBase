package com.ashutosh1234ojha.mvvmbase.utils

import kotlinx.coroutines.flow.*

/**
 * Created by Ashutosh Ojha on 09,March,2022
 */

fun <ResultType, RequestType> networkBoundResource(
    query: () -> Flow<ResultType>,
    fetch: suspend () -> RequestType,
    saveFetchResult: suspend (RequestType) -> Unit,
    shouldFetch: (ResultType) -> Boolean = { true }
) = flow<Resource<ResultType>> {
    val data = query().first()

    val flow = if (shouldFetch(data)) {
        emit(Resource.Loading(data))

        try {
            saveFetchResult(fetch())
            query().map { Resource.Success(it) }

        } catch (throwable: Throwable) {
            query().map { Resource.Error(it, throwable) }

        }

    } else {
        query().map { Resource.Success(it) }

    }

    emitAll(flow)
}