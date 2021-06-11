package com.assessment.core.di.modules.repository

import com.assessment.data.campaign.repository.CampaignRepository
import com.assessment.data.campaign.repository.CampaignRepositoryImpl
import com.assessment.data.campaign.services.RemoteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {
    @Provides
    @ActivityRetainedScoped
    fun provideRepositoryInterface(
        remoteService: RemoteService,
    ): CampaignRepository = CampaignRepositoryImpl(remoteService)
}
