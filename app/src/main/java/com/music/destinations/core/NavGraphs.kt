package com.r.bottomnavigation.feature

import com.r.bottomnavigation.feature.destinations.*
import com.ramcosta.composedestinations.spec.*

/**
 * Class generated if any Composable is annotated with `@Destination`.
 * It aggregates all [TypedDestination]s in their [NavGraph]s.
 */
object NavGraphs {

    val root = NavGraph(
        route = "root",
        startRoute = HomeScreenDestination,
        destinations = listOf(
            FavoriteScreenDestination,
			HomeScreenDestination,
			ProfileScreenDestination,
			CartScreenDestination
        )
    )
}