package com.aulia.idn.newsapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulia.idn.newsapp.data.model.ResponseNews
import com.aulia.idn.newsapp.data.repository.NewsRepository
import com.aulia.idn.newsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
//meng-inject repository
class MainViewModel @Inject constructor(
    private val repository: NewsRepository): ViewModel() {

    //2 variable,
    //1 transaksi di dalam view model
    //yg lainnya d dlm (activity/fragment lain)
    private val _newsData = MutableLiveData<Resource<ResponseNews>>()
    val newsData = _newsData

    init {
        fetchNewsViewModel()
    }
    //nge fetch data
    //nge jalanin coroutine flowny d dlm view model scope
    //viewModelScope = tempat dmn coroutine ini akan berjalan
    private fun fetchNewsViewModel() = viewModelScope.launch {
        _newsData.value = Resource.Loading

        repository.fetchNewsRepository().collect { news ->
            _newsData.value = news
        }
    }
}