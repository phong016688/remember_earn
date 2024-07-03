package com.haohao.rememberearn.presentation.compose.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

private const val HOME_GRAPH_ROUTE_PATTERN = "home_graph"
const val HOME_ROUTE = "home_route"

fun NavController.navigateToHomeGraph(navOptions: NavOptions) = navigate(
    HOME_GRAPH_ROUTE_PATTERN, navOptions
)

fun NavGraphBuilder.homeScreen() {
    composable(route = HOME_ROUTE) { HomeRoute() }
}
