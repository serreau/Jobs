package sero.com.jobs.utils.extension

import androidx.navigation.fragment.findNavController
import sero.com.jobs.ui.fragment.home.HomeFragment
import sero.com.jobs.ui.fragment.home.HomeFragmentDirections
import sero.com.jobs.ui.fragment.research.ResearchFragment
import sero.com.jobs.ui.fragment.research.ResearchFragmentDirections
import sero.com.jobs.ui.fragment.result.ResultFragment
import sero.com.jobs.ui.fragment.result.ResultFragmentDirections

fun HomeFragment.goToResearch() {
    findNavController().navigate(HomeFragmentDirections.actionNavigationHomeToNavigationResearch())
}

fun ResearchFragment.goToResult() {
    findNavController().navigate(ResearchFragmentDirections.actionNavigationResearchToNavigationResult())
}

fun ResultFragment.goToSort() {
    findNavController().navigate(ResultFragmentDirections.actionNavigationResultToNavigationSort())
}

fun ResultFragment.goToFilter() {
    findNavController().navigate(ResultFragmentDirections.actionNavigationResultToNavigationFilter())
}