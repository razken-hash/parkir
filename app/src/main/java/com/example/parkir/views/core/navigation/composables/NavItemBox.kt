package com.example.parkir.views.core.navigation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.example.parkir.views.core.navigation.model.NavItem
import com.example.parkir.views.ui.theme.grey
import com.example.parkir.views.ui.theme.primary


@Composable
fun RowScope.NavItemBox(
    item: NavItem,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    NavigationBarItem(
        label = {
            Text(text = item.title)
        },
        icon = {
            Image(
                painter = painterResource(id = if (isSelected) item.selectedIcon else item.unselectedIcon),
                contentDescription = item.title,
                colorFilter = ColorFilter.tint(
                    if (isSelected) primary else grey
                )
            )
        },
        selected = isSelected,
        alwaysShowLabel = true,
        onClick = onClick,
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = Color.Transparent,
        ),
        modifier = Modifier.background(Color.Transparent),
    )
}