package org.moeen.basics.Navigation

import kotlinx.serialization.Serializable


sealed class Navigation{

    @Serializable
    object Main: Navigation()
}

sealed class Routes{

    @Serializable
    object Home: Routes()

    @Serializable
    object AccessImage: Routes()

    @Serializable
    object TextAccess: Routes()

    @Serializable
    object BorderOutlined: Routes()

    @Serializable
    object SelectableTextScreen: Routes()

    @Serializable
    object PasswordViewScreen: Routes()

    @Serializable
    object RainbowTextScreen: Routes()

    @Serializable
    object ScrollableTextScreen: Routes()

    @Serializable
    object AnnotatedStringwithListenerSample: Routes()

    @Serializable
    object ShadowText: Routes()

    @Serializable
    object Imageshow: Routes()

    @Serializable
    object Box: Routes()

    @Serializable
    object Columnexample: Routes()

    @Serializable
    object RowExample: Routes()

    @Serializable
    object LazyColumn: Routes()

    @Serializable
    object LazyRow: Routes()

    @Serializable
    object Modifier: Routes()

    @Serializable
    object BottomSheet: Routes()

    @Serializable
    object Dialog: Routes()

    // Add more routes as needed

}

