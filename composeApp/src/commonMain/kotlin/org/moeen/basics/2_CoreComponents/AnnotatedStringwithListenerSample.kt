package org.moeen.basics.`2_CoreComponents`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.navigation.NavController

@Composable
fun AnnotatedStringwithListenerSample(navController: NavController){

    val uriHandler = LocalUriHandler.current


    Box(modifier = Modifier.fillMaxSize()
        , contentAlignment = Alignment.Center
    ){

        Text(


            buildAnnotatedString {

                append("Build better apps faster with")
                val link = LinkAnnotation.Url(

                    "https://developer.android.com/develop/ui/compose/documentation",
                    TextLinkStyles(

                        SpanStyle(
                            color = Color.Blue
                        )
                    )
                ){

                    val url = (it as LinkAnnotation.Url).url
                    uriHandler.openUri(url)

                }

                withLink(link){
                    append("JetPack Compose")
                }
            }

        )
    }
    Button(
        onClick = {navController.popBackStack()},
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "← Back to Home")
    }


}