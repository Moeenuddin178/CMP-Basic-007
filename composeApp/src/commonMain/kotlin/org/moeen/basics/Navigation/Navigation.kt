package org.moeen.basics.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.newjetpackcomposecourse.`4_LayoutComposables`.ModifierExample
import com.kmm.kmm_course.`1_Resources`.AccessImage
import com.kmm.kmm_course.`1_Resources`.TextAccees
import com.kmm.kmm_course.`2_CoreComponents`.BorderOutlined
import com.kmm.kmm_course.`2_CoreComponents`.PartiallySelectlableText
import com.kmm.kmm_course.`2_CoreComponents`.PasswordViewButton
import com.kmm.kmm_course.`2_CoreComponents`.RainbowText
import com.kmm.kmm_course.`2_CoreComponents`.ScrollableText
import com.kmm.kmm_course.`2_CoreComponents`.ShadowText
import org.moeen.basics.`2_CoreComponents`.AnnotatedStringwithListenerSample
import org.moeen.basics.`2_CoreComponents`.Imageshow
import org.moeen.basics.`3_LayoutComposables`.BoxExample
import org.moeen.basics.`3_LayoutComposables`.ColumnExample
import org.moeen.basics.`3_LayoutComposables`.LazyColumnExample
import org.moeen.basics.`3_LayoutComposables`.LazyRowExample
import org.moeen.basics.`3_LayoutComposables`.PartialBottomSheet
import org.moeen.basics.`3_LayoutComposables`.RowExample
import org.moeen.basics.HomeScreen
import org.moeen.basics.dumy.DialogWithImage
import org.moeen.basics.dumy.FloatingActionButton


@Composable
fun AppNavigationNEW(){

    val navController = rememberNavController()
    NavHost(navController= navController, startDestination = Navigation.Main){


        navigation<Navigation.Main>(startDestination = Routes.Home){

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
                FloatingActionButton(navController= navController)
            }
            
        }


    }


}

