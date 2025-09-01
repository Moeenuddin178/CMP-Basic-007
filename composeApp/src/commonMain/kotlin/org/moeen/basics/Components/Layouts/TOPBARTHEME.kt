package org.moeen.basics.Components.Layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cmp_basic_007.composeapp.generated.resources.Res
import cmp_basic_007.composeapp.generated.resources.ic_dark_mode
import cmp_basic_007.composeapp.generated.resources.ic_light_mode
import cmp_basic_007.composeapp.generated.resources.theme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.moeen.basics.Navigation.Routes
import org.moeen.basics.theme.LocalThemeIsDark

import androidx.compose.material3.TopAppBarDefaults

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar() {
    val isDarkState = LocalThemeIsDark.current
    var isDark by isDarkState

    val icon = remember(isDark) {
        if (isDark) Res.drawable.ic_light_mode
        else Res.drawable.ic_dark_mode
    }

    TopAppBar(
        title = {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "CMP Codes \uD83D\uDE80",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }
        },
        navigationIcon = {

        },
        actions = {
            ElevatedButton(
                onClick = { isDark = !isDark },
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .height(40.dp)
            ) {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = "Toggle Theme"
                )
                Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
                Text(text = stringResource(Res.string.theme))
            }
        },
        //colors = TopAppBarDefaults.topAppBarColors(Color.White),
        modifier = Modifier.padding(horizontal = 4.dp)
    )
}
