package org.moeen.basics.Navigation

import kotlinx.serialization.Serializable


sealed class Navigation {

    @Serializable
    object Main : Navigation()
}

sealed class Routes {

    @Serializable
    object Home : Routes()

    @Serializable
    object AccessImage : Routes()

    @Serializable
    object TextAccess : Routes()

    @Serializable
    object BorderOutlined : Routes()

    @Serializable
    object SelectableTextScreen : Routes()

    @Serializable
    object PasswordViewScreen : Routes()


    @Serializable
    object SimplePassword : Routes()

    @Serializable
    object RainbowTextScreen : Routes()

    @Serializable
    object ScrollableTextScreen : Routes()

    @Serializable
    object AnnotatedStringwithListenerSample : Routes()

    @Serializable
    object ShadowText : Routes()

    @Serializable
    object Imageshow : Routes()

    @Serializable
    object Box : Routes()

    @Serializable
    object Columnexample : Routes()

    @Serializable
    object RowExample : Routes()

    @Serializable
    object LazyColumn : Routes()

    @Serializable
    object LazyRow : Routes()

    @Serializable
    object Modifier : Routes()

    @Serializable
    object BottomSheet : Routes()

    @Serializable
    object Dialog : Routes()

    @Serializable
    object AppTheme : Routes()

    @Serializable
    object Animation : Routes()

    @Serializable
    object BottomNavigation : Routes()

    @Serializable
    object Drawer : Routes()

    @Serializable
    object Badges : Routes()

    @Serializable
    object CheckBox : Routes()

    @Serializable
    object DatePicker : Routes()

    @Serializable
    object DetailedDrawer : Routes()

    @Serializable
    object DropDownMenu : Routes()

    @Serializable
    object ElevatedCard : Routes()

    @Serializable
    object FloatingActionButton : Routes()

    @Serializable
    object InputChip : Routes()

    @Serializable
    object ProgressIndicator : Routes()

    @Serializable
    object Pulltorefresh : Routes()

    @Serializable
    object Scaffold : Routes()

    @Serializable
    object SearchBar : Routes()

    @Serializable
    object SegmentedButton : Routes()

    @Serializable
    object Slider : Routes()

    @Serializable
    object SnackBar : Routes()

    @Serializable
    object Switch : Routes()

    @Serializable
    object Timepicker : Routes()

    @Serializable
    object TopAppBar : Routes()

    @Serializable
    object ToggleTheme : Routes()
    
    @Serializable
    object LoginForm : Routes()
    
    @Serializable
    object ProductList : Routes()
    
    @Serializable
    object ProfileCard : Routes()
    
    @Serializable
    object CounterApp : Routes()
    
    @Serializable
    object CustomComposables : Routes()
    
    @Serializable
    object CanvasGraphics : Routes()


    // Add more routes as needed

}