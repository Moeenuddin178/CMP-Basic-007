package org.moeen.basics.Components.Forms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.moeen.basics.Components.BackButton

@Composable
fun Switch(navController: NavController) {
    // Add BackButton at the top
    BackButton(navController)
    
    //CodeViewerExample()
    var checked by remember { mutableStateOf(true) }
    Box(
        modifier = Modifier.fillMaxSize(), // outer full box
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(200.dp) // 👈 Set fixed size
                .background(if (checked) Color.Green else Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Switch(
                checked = checked,
                onCheckedChange = {
                    checked = it
                },
                thumbContent = if (checked) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = null,
                            modifier = Modifier.size(SwitchDefaults.IconSize)
                        )
                    }
                } else {
                    null
                }
            )
        }
    }

}

@Composable
fun CodeViewer(
    code: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFF2D2D2D),
    showWindowControls: Boolean = true
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
    ) {
        // Window controls (macOS style)
        if (showWindowControls) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Red, Yellow, Green circles
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFFF5F57))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFFFBD2E))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF28CA42))
                )
            }
        }

        // Code content
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp)
        ) {
            Text(
                text = highlightKotlinCode(code),
                fontFamily = FontFamily.Monospace,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                color = Color.White
            )
        }
    }
}

@Composable
private fun highlightKotlinCode(code: String): androidx.compose.ui.text.AnnotatedString {
    return buildAnnotatedString {
        val keywords = setOf(
            "class", "fun", "val", "var", "if", "else", "when", "for", "while",
            "return", "import", "package", "data", "object", "interface", "enum",
            "private", "public", "internal", "protected", "override", "open",
            "abstract", "final", "companion", "init", "constructor", "this",
            "super", "null", "true", "false", "is", "as", "in", "out"
        )

        val functions = setOf(
            "painterResource", "size", "align", "dp", "Image", "Modifier"
        )

        val types = setOf(
            "String", "Int", "Boolean", "Float", "Double", "Long", "Short",
            "Byte", "Char", "Any", "Unit", "Nothing", "List", "Map", "Set",
            "Array", "Alignment", "Res"
        )

        val lines = code.split("\n")
        lines.forEachIndexed { lineIndex, line ->
            var currentIndex = 0

            // Handle indentation
            val leadingSpaces = line.takeWhile { it == ' ' || it == '\t' }
            append(leadingSpaces)
            currentIndex = leadingSpaces.length

            val restOfLine = line.drop(leadingSpaces.length)
            var i = 0

            while (i < restOfLine.length) {
                val remaining = restOfLine.drop(i)

                when {
                    // String literals
                    remaining.startsWith('"') -> {
                        val endQuote = remaining.indexOf('"', 1)
                        if (endQuote != -1) {
                            withStyle(SpanStyle(color = Color(0xFFCE9178))) {
                                append(remaining.substring(0, endQuote + 1))
                            }
                            i += endQuote + 1
                        } else {
                            append(remaining[0])
                            i++
                        }
                    }

                    // Comments
                    remaining.startsWith("//") -> {
                        withStyle(SpanStyle(color = Color(0xFF6A9955))) {
                            append(remaining)
                        }
                        break
                    }

                    // Numbers
                    remaining[0].isDigit() -> {
                        val number = remaining.takeWhile { it.isDigit() || it == '.' }
                        withStyle(SpanStyle(color = Color(0xFFB5CEA8))) {
                            append(number)
                        }
                        i += number.length
                    }

                    // Identifiers (keywords, functions, types)
                    remaining[0].isLetter() || remaining[0] == '_' -> {
                        val word = remaining.takeWhile { it.isLetterOrDigit() || it == '_' }
                        when {
                            keywords.contains(word) -> {
                                withStyle(SpanStyle(color = Color(0xFF569CD6))) {
                                    append(word)
                                }
                            }
                            functions.contains(word) -> {
                                withStyle(SpanStyle(color = Color(0xFF4EC9B0))) {
                                    append(word)
                                }
                            }
                            types.contains(word) -> {
                                withStyle(SpanStyle(color = Color(0xFF4EC9B0))) {
                                    append(word)
                                }
                            }
                            else -> {
                                withStyle(SpanStyle(color = Color.White)) {
                                    append(word)
                                }
                            }
                        }
                        i += word.length
                    }

                    // Special characters
                    remaining[0] in "(){}[],.;=+-*/<>!&|" -> {
                        withStyle(SpanStyle(color = Color(0xFFD4D4D4))) {
                            append(remaining[0])
                        }
                        i++
                    }

                    else -> {
                        append(remaining[0])
                        i++
                    }
                }
            }

            if (lineIndex < lines.size - 1) {
                append("\n")
            }
        }
    }
}

// Example usage
@Composable
fun CodeViewerExample() {
    val sampleCode =
        """Image(
            painter = painterResource(Res.drawable.news),
            contentDescription = "News Image",
            modifier = Modifier
            .size(150.dp).align(Alignment.Center)
)"""

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        CodeViewer(
            code = sampleCode,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

// Alternative with custom colors
@Composable
fun CustomCodeViewer(
    code: String,
    modifier: Modifier = Modifier
) {
    CodeViewer(
        code = code,
        modifier = modifier,
        backgroundColor = Color(0xFF1E1E1E), // VS Code dark theme
        showWindowControls = true
    )
}