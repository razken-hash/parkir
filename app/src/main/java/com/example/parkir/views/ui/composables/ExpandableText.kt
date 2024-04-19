package com.example.parkir.views.ui.composables

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle


@Composable
fun ExpandableText(
    shrinkedText: String,
    expandedText: String,
    textStyle: TextStyle = LocalTextStyle.current,
) {

    var isExpanded by remember { mutableStateOf(false) }

    val shrinkerText = "Read Less"

    val expanderText = "Read More"

    val textHandler =
        "${if (isExpanded) expandedText else shrinkedText} ${if (isExpanded) shrinkerText else expanderText}"

    val annotatedString = buildAnnotatedString {
        withStyle(
            textStyle.toSpanStyle()
        ) {
            append(if (isExpanded) expandedText else shrinkedText)
        }

        append(if (isExpanded) ". " else "... ")

        withStyle(
            MaterialTheme
                .typography.titleMedium.toSpanStyle()
        ) {
            append(if (isExpanded) shrinkerText else expanderText)
        }

        addStringAnnotation(
            tag = "expandable",
            annotation = if (isExpanded) shrinkerText else expanderText,
            start = textHandler.indexOf(if (isExpanded) shrinkerText else expanderText),
            end = textHandler.indexOf(if (isExpanded) shrinkerText else expanderText) + if (isExpanded) expanderText.length else shrinkerText.length
        )
    }

    ClickableText(
        text = annotatedString,
        softWrap = true,
        onClick = {
            annotatedString
                .getStringAnnotations(
                    "expandable",
                    it,
                    it
                )
                .firstOrNull()?.let { stringAnnotation ->
                    isExpanded = stringAnnotation.item == expanderText
                }
        }
    )
}