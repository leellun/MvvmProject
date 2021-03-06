package com.newland.mvvmproject.di

import com.newland.mvvmproject.db.HistoryDatabase
import com.newland.mvvmproject.db.dao.HistoryDao
import com.newland.mvvmproject.module.register.RegisterRepository
import com.newland.mvvmproject.module.register.RegisterViewModel
import com.newland.mvvmproject.network.RetrofitService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { RegisterViewModel(get()) }
}
val repositoryModule = module {
    single { RegisterRepository(get()) }
}
val apiModule = module {
    single { RetrofitService.apiService }
}
val databaseModule = module {
    single { HistoryDatabase.getInstance(get()) }
    single { createHistoryDao(get()) }
}

internal fun createHistoryDao(database: HistoryDatabase): HistoryDao {
    return database.historyDao()
}