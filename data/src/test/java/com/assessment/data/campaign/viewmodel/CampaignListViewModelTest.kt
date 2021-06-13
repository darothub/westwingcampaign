package com.assessment.data.campaign.viewmodel

import android.util.Log
import com.assessment.data.campaign.model.CampaignDetails
import com.assessment.data.campaign.repository.CampaignDetailMockList
import com.assessment.data.campaign.repository.FakeCampaignRepository
import com.assessment.data.campaign.state.CampaignUiState
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verify

class CampaignListViewModelTest{
    private lateinit var viewModel: CampaignListViewModel
    @ExperimentalCoroutinesApi
    private val dispatcher = TestCoroutineDispatcher()
    private lateinit var repository: FakeCampaignRepository

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        repository = FakeCampaignRepository()
        viewModel = CampaignListViewModel(repository, null)
    }
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `fetch campaign data, return list of campaign detail `() = runBlockingTest{
        val list = viewModel.getCampaignDetailsForTest()
        assertNotNull(list)
    }
    @ExperimentalCoroutinesApi
    @Test
    fun `fetch campaign data, return list of campaign detail with name and description`() = runBlockingTest{
        val list = viewModel.getCampaignDetailsForTest()
        assertEquals(list.size, 2)
    }
    @ExperimentalCoroutinesApi
    @Test
    fun `fetch campaign data, confirm item has name and description`() = runBlockingTest{
        val list = viewModel.getCampaignDetailsForTest()
        assertEquals(list[0], CampaignDetailMockList.list()[0])
        assertEquals(list[1], CampaignDetailMockList.list()[1])
    }
}