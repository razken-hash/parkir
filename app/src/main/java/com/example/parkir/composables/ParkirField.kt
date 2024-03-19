@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.parkir.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.parkir.ui.theme.black
import com.example.parkir.ui.theme.grey06
import com.example.parkir.ui.theme.grey6F
import com.example.parkir.ui.theme.primary
import com.example.parkir.ui.theme.primary1A

@Composable
fun ParkirField(
    value: String,
    placeholder: @Composable (() -> Unit)? = null,
    placeHolderText: String = "",
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    leadingIconId: Int? = null,
    leadingIconDescription: String = "",
    trailingIcon: @Composable (() -> Unit)? = null,
    trailingIconId: Int? = null,
    trailingIconDescription: String = "",
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RoundedCornerShape(size = 10.dp),
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(),
//    modifier: Modifier,
) {
    var isFocused by remember { mutableStateOf(false) }

    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeHolderText,
                style = MaterialTheme.typography.bodyMedium,
            )
        },
        textStyle = MaterialTheme.typography.labelLarge.merge(textStyle),
        leadingIcon = {
            if (leadingIconId != null)
                Image(
                    painter = painterResource(id = leadingIconId),
                    contentDescription = leadingIconDescription,
                    colorFilter = ColorFilter.tint(
                        if (isFocused)
                            black else grey6F

                    ),
                    modifier = Modifier
                        .size(20.dp),
                ) else {
            }
        },
        trailingIcon = {
            if (trailingIconId != null)
                Image(
                    painter = painterResource(id = trailingIconId),
                    contentDescription = trailingIconDescription,
                    colorFilter = ColorFilter.tint(
                        if (isFocused)
                            black else grey6F
                    ),
                    modifier = Modifier
                        .size(20.dp),
                ) else {
            }
        },
        maxLines = maxLines, enabled = enabled,
        readOnly = readOnly,
        label = label,
        supportingText = supportingText,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        interactionSource = interactionSource,
        shape = shape,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = if (isFocused) primary1A else grey06,
            placeholderColor = grey6F,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
        ).apply { colors },
        modifier = Modifier
            .border(
                color = if (isFocused) primary else grey06,
                width = if (isFocused) 2.dp else 0.dp,
                shape = RoundedCornerShape(size = 10.dp)
            )
            .clip(RoundedCornerShape(size = 10.dp))
            .fillMaxWidth()
            .onFocusChanged {
                isFocused = it.isFocused
            }
            .height(58.dp)
            .wrapContentHeight(align = Alignment.CenterVertically)
//            .then(modifier),
    )
}
