package sero.com.jobs.utils.extension

import androidx.navigation.fragment.findNavController
import sero.com.jobs.view.fragment.home.HomeFragment
import sero.com.jobs.view.fragment.home.HomeFragmentDirections
import sero.com.jobs.view.fragment.research.ResearchFragment
import sero.com.jobs.view.fragment.research.ResearchFragmentDirections
import sero.com.jobs.view.fragment.result.ResultFragment
import sero.com.jobs.view.fragment.result.ResultFragmentDirections

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