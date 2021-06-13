package com.assessment.core.di.modules.repository

import android.content.Context
import com.assessment.data.campaign.repository.CampaignRepository
import com.assessment.data.campaign.repository.CampaignRepositoryImpl
import com.assessment.data.campaign.repository.NetworkRepository
import com.assessment.data.campaign.repository.NetworkRepositoryImpl
import com.assessment.data.campaign.services.RemoteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {
    @Provides
    @ActivityRetainedScoped
    fun provideCampaignRepository(
        remoteService: RemoteService,
    ): CampaignRepository = CampaignRepositoryImpl(remoteService)

    @Provides
    @ActivityRetainedScoped
    fun provideNetworkRepository(
        @ApplicationContext context: Context
    ): NetworkRepository = NetworkRepositoryImpl(context)
}
