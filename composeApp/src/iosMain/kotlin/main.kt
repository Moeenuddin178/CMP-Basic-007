import androidx.compose.ui.window.ComposeUIViewController
import org.moeen.basics.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
