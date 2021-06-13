package com.assessment.data.campaign.repository

import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test


class CampaignRepositoryImplTest {

    private lateinit var fakeCampaignRepository: CampaignRepository

    @Before
    fun setUp() {
        fakeCampaignRepository = FakeCampaignRepository()
    }

    @Test
    fun `fetch campaign data and remove campaign list without name or description`() = runBlockingTest{
        val listOfWantedCampaigns = fakeCampaignRepository.getCampaigns()
        assert(listOfWantedCampaigns.size == 2)
    }
}