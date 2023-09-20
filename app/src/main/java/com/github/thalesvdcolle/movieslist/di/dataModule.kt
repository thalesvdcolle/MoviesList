package com.github.thalesvdcolle.movieslist.di

import com.github.thalesvdcolle.movieslist.data.MoviesService
import com.github.thalesvdcolle.movieslist.data.moviesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn (ViewModelComponent::class)
object dataModule {
   @Provides
   fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    fun providesMoviesService(retrofit: Retrofit): MoviesService{
        return retrofit.create(moviesService::class.java)
    }
}
