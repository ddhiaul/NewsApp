package com.aulia.idn.newsapp.data.repository

import com.aulia.idn.newsapp.data.model.ResponseNews
import com.aulia.idn.newsapp.data.source.APIService
import com.aulia.idn.newsapp.utils.Constant
import com.aulia.idn.newsapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

//menggunakan di untuk menginject api kedalam news repository
class NewsRepository @Inject constructor(private val apiService: APIService) {

    suspend fun fetchNewsRepository(): Flow<Resource<ResponseNews>> {
        //flow = asyncronous programming exclusif buat kotlin (flow termasuk coroutine)
        return flow {
            val response = apiService.fetchNews(
                Constant.COUNTRY,
                Constant.CATEGORY,
                Constant.API_KEY
            )

            //bisnis logic
            try {
                //jika sukses kirim state sukses
                if(response.articles.isNotEmpty()){
                    emit(Resource.Success(response))
                }else {
                    //klo empty kirim state empty
                    emit(Resource.Empty)
                }
            }catch (e: HttpException){
                //klo gagal kirim state error
                emit(Resource.Error(e.toString(), response))
        }
        }
    }
}