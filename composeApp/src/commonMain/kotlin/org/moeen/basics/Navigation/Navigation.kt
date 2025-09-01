package org.moeen.basics.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.newjetpackcomposecourse.`4_LayoutComposables`.ModifierExample
import org.moeen.basics.Components.Cards.ElevatedCard
import com.kmm.kmm_course.`1_Resources`.AccessImage
import com.kmm.kmm_course.`1_Resources`.TextAccees
import com.kmm.kmm_course.`2_CoreComponents`.BorderOutlined
import com.kmm.kmm_course.`2_CoreComponents`.PartiallySelectlableText
import com.kmm.kmm_course.`2_CoreComponents`.PasswordViewButton
import com.kmm.kmm_course.`2_CoreComponents`.RainbowText
import com.kmm.kmm_course.`2_CoreComponents`.ScrollableText
import com.kmm.kmm_course.`2_CoreComponents`.ShadowText
import com.kmm.kmm_course.`2_CoreComponents`.SimplePassword
import org.moeen.basics.`2_CoreComponents`.AnnotatedStringwithListenerSample
import org.moeen.basics.`2_CoreComponents`.Imageshow
import org.moeen.basics.`3_LayoutComposables`.BoxExample
import org.moeen.basics.`3_LayoutComposables`.ColumnExample
import org.moeen.basics.`3_LayoutComposables`.LazyColumnExample
import org.moeen.basics.`3_LayoutComposables`.LazyRowExample
import org.moeen.basics.`3_LayoutComposables`.PartialBottomSheet
import org.moeen.basics.`3_LayoutComposables`.RowExample
import org.moeen.basics.HomeScreen
import org.moeen.basics.Components.AnimatedBox
import org.moeen.basics.Components.Indicators.Badge
import org.moeen.basics.Components.Forms.CheckBoxExample
import org.moeen.basics.Components.Pickers.DatePickerEx
import org.moeen.basics.Components.Layouts.DetailedDrawerExample
import org.moeen.basics.Components.Dialogs.DialogWithImage
import org.moeen.basics.Components.DropDownmenu
import org.moeen.basics.Components.Layouts.BottomNavigationBar
import org.moeen.basics.Components.Buttons.FloatingActionButton
import org.moeen.basics.Components.Forms.InputChipExample
import org.moeen.basics.Components.PulltoRefreshScreen
import org.moeen.basics.Components.Indicators.ProgresIndicator
import org.moeen.basics.Components.Layouts.ScaffoldExample
import org.moeen.basics.Components.SearchScreen
import org.moeen.basics.Components.Segmentedbutton
import org.moeen.basics.Components.Slider
import org.moeen.basics.Components.SnackBAr
import org.moeen.basics.Components.Forms.Switch
import org.moeen.basics.Components.Pickers.TimePickerEx
import org.moeen.basics.Components.Layouts.TopAppBar
import org.moeen.basics.theme.themeHandler
import org.moeen.basics.Examples.LoginFormScreen
import org.moeen.basics.Examples.ProductListScreen
import org.moeen.basics.Examples.ProfileCardScreen
import org.moeen.basics.Examples.CounterAppScreen
import org.moeen.basics.Examples.CustomComposablesScreen
import org.moeen.basics.Examples.CanvasGraphicsScreen


@Composable
fun AppNavigationNEW() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Navigation.Main) {


        navigation<Navigation.Main>(startDestination = Routes.Home) {

            composable<Routes.Home> {
                HomeScreen(navController = navController)
            }

            composable<Routes.AccessImage> {
                AccessImage(navController = navController)
            }
            composable<Routes.TextAccess> {
                TextAccees(navController = navController)
            }
            composable<Routes.BorderOutlined> {
                BorderOutlined(navController = navController)
            }
            composable<Routes.SelectableTextScreen> {
                PartiallySelectlableText(navController = navController)
            }
            composable<Routes.PasswordViewScreen> {
                PasswordViewButton(navController = navController)
            }
            composable<Routes.SimplePassword> {
                SimplePassword(navController = navController)
            }
            composable<Routes.RainbowTextScreen> {
                RainbowText(navController = navController)
            }
            composable<Routes.ScrollableTextScreen> {
                ScrollableText(navController = navController)
            }

            composable<Routes.AnnotatedStringwithListenerSample> {
                AnnotatedStringwithListenerSample(navController = navController)
            }
            composable<Routes.ShadowText> {
                ShadowText(navController = navController)
            }

            composable<Routes.Imageshow> {
                Imageshow(navController = navController)
            }
            composable<Routes.Box> {
                BoxExample(navController = navController)
            }

            composable<Routes.Columnexample> {
                ColumnExample(navController = navController)
            }
            composable<Routes.RowExample> {
                RowExample(navController = navController)
            }

            composable<Routes.LazyColumn> {
                LazyColumnExample(navController = navController)
            }
            composable<Routes.LazyRow> {
                LazyRowExample(navController = navController)
            }

            composable<Routes.Modifier> {
                ModifierExample(navController = navController)
            }
            composable<Routes.BottomSheet> {
                PartialBottomSheet(navController = navController)
            }

            composable<Routes.Dialog> {
                DialogWithImage(navController = navController)
            }
            composable<Routes.AppTheme> {
                themeHandler(navController = navController)
            }
            composable<Routes.Animation> {
                AnimatedBox(navController = navController)
            }
            composable<Routes.BottomNavigation> {
                BottomNavigationBar(navController = navController)
            }
            composable<Routes.DetailedDrawer> {
                DetailedDrawerExample(navController = navController)
            }
            composable<Routes.Badges> {
                Badge(navController = navController)
            }
            composable<Routes.CheckBox> {
                CheckBoxExample(navController = navController)
            }
            composable<Routes.DatePicker> {
                DatePickerEx(navController = navController)
            }
            composable<Routes.Timepicker> {
                TimePickerEx(navController = navController)
            }
            composable<Routes.FloatingActionButton> {
                FloatingActionButton(navController = navController)
            }
            composable<Routes.ProgressIndicator> {
                ProgresIndicator(navController = navController)
            }
            composable<Routes.Pulltorefresh> {
                PulltoRefreshScreen(navController = navController)
            }
            composable<Routes.Scaffold> {
                ScaffoldExample(navController = navController)
            }
            composable<Routes.SearchBar> {
                SearchScreen(navController = navController)
            }
            composable<Routes.SegmentedButton> {
                Segmentedbutton(navController = navController)
            }
            composable<Routes.Slider> {
                Slider(navController = navController)
            }
            composable<Routes.SnackBar> {
                SnackBAr(navController = navController)
            }
            composable<Routes.Switch> {
                Switch(navController = navController)
            }
            composable<Routes.TopAppBar> {
                TopAppBar(navController = navController)
            }
            composable<Routes.DropDownMenu> {
                DropDownmenu(navController = navController)
            }
            composable<Routes.ElevatedCard> {
                ElevatedCard(navController = navController)
            }
            composable<Routes.InputChip> {
                InputChipExample(navController = navController)
            }
            composable<Routes.LoginForm> {
                LoginFormScreen(navController = navController)
            }
            composable<Routes.ProductList> {
                ProductListScreen(navController = navController)
            }
            composable<Routes.ProfileCard> {
                ProfileCardScreen(navController = navController)
            }
            composable<Routes.CounterApp> {
                CounterAppScreen(navController = navController)
            }
            composable<Routes.CustomComposables> {
                CustomComposablesScreen(navController = navController)
            }
            
            composable<Routes.CanvasGraphics> {
                CanvasGraphicsScreen(navController = navController)
            }






        }


    }


}