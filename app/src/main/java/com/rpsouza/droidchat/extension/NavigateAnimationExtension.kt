package com.rpsouza.droidchat.extension

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry

private const val DURATION_IN_MILLIS = 300

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideInToRight() = this.slideIntoContainer(
    towards = AnimatedContentTransitionScope.SlideDirection.Right,
    animationSpec = tween(DURATION_IN_MILLIS)
)

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideInToLeft() = this.slideIntoContainer(
    towards = AnimatedContentTransitionScope.SlideDirection.Left,
    animationSpec = tween(DURATION_IN_MILLIS)
)

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideOutToRight() = this.slideOutOfContainer(
    towards = AnimatedContentTransitionScope.SlideDirection.Right,
    animationSpec = tween(DURATION_IN_MILLIS)
)

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideOutToLeft() = this.slideOutOfContainer(
    towards = AnimatedContentTransitionScope.SlideDirection.Left,
    animationSpec = tween(DURATION_IN_MILLIS)
)