package com.example.abakarmagomedov.shabimchat.di.module

import android.support.annotation.NonNull
import com.smedialink.beenderapp.di.qualifier.ComputationScheduler
import com.smedialink.beenderapp.di.qualifier.IoScheduler
import com.smedialink.beenderapp.di.qualifier.MainScheduler
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by abakarmagomedov on 06/03/2018 at project ShabimChat.
 */

@Module
class RxModule {

    @Provides
    @NonNull
    fun provideCompositeDisposable() = CompositeDisposable()

    @Provides
    @NonNull
    @IoScheduler
    fun provideSchedulerIO(): Scheduler = Schedulers.io()

    @Provides
    @NonNull
    @ComputationScheduler
    fun provideSchedulerComputation(): Scheduler = Schedulers.computation()

    //@Provides
    //@NonNull
    //@MainScheduler
    //fun provideSchedulerMainThread(): Scheduler = AndroidSchedulers.mainThread()
}