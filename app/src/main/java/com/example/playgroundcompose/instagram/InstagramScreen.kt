package com.example.playgroundcompose.instagram

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Arrangement.SpaceAround
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.playgroundcompose.R
import com.ramcosta.composedestinations.annotation.Destination


@Destination
@Composable
fun InstagramScreen() {
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        TopBar(name = "safakc_44", Modifier.padding(top = 10.dp))
        Profile(Modifier.padding(top = 10.dp))
        ButtonSection(Modifier.padding(top = 10.dp))
        StoryHighLightSection(
            Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            highLights = listOf(
                ImageWithtext(
                    image = painterResource(id = R.drawable.example_image), text = "Stories"
                ),
                ImageWithtext(
                    image = painterResource(id = R.drawable.example_image), text = "Stories"
                ),
                ImageWithtext(
                    image = painterResource(id = R.drawable.example_image), text = "Stories"
                ),
                ImageWithtext(
                    image = painterResource(id = R.drawable.example_image), text = "Stories"
                )
            )
        )
        PostTabView(Modifier.padding(top = 10.dp),
            imageWithText = listOf(
                ImageWithtext(
                    image = painterResource(id = R.drawable.ic_grid),
                    text = "Posts"
                ),
                ImageWithtext(
                    image = painterResource(id = R.drawable.ic_reels),
                    text = "Reels"
                ),
                ImageWithtext(
                    image = painterResource(id = R.drawable.ic_igtv),
                    text = "IGTV"
                ),
                ImageWithtext(
                    image = painterResource(id = R.drawable.profile),
                    text = "Profile"
                )
            )
        ) {
            selectedTabIndex = it
        }
        when (selectedTabIndex) {
            0 -> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.example_image),
                    painterResource(id = R.drawable.example_image),
                    painterResource(id = R.drawable.example_image),
                    painterResource(id = R.drawable.example_image),
                    painterResource(id = R.drawable.example_image),
                    painterResource(id = R.drawable.example_image)
                ),
                Modifier.fillMaxWidth()
            )
        }
    }
}


@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = SpaceAround
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = Ellipsis,
            fontWeight = Bold,
            fontSize = 20.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Bell",
            tint = Black,
            modifier = Modifier.size(20.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Dot Menu",
            tint = Black,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun Profile(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = CenterVertically,
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.example_image),
                modifier = modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = modifier.width(16.dp))
            StatSection(modifier = modifier.weight(7f))
        }
        ProfileDescription(
            displayName = "Safak ",
            description = "Instagram Profile 😟",
            url = "https://www.google.de/",
            followedBy = listOf("a,b,c,d"),
            otherCount = 20
        )
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image, contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(width = 1.dp, color = LightGray, shape = CircleShape)
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = CenterVertically,
        horizontalArrangement = SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(numberText = "123", text = "Posts")
        ProfileStat(numberText = "12345", text = "Followers")
        ProfileStat(numberText = "9874", text = "Following")
    }
}

@Composable
fun ProfileStat(
    modifier: Modifier = Modifier,
    numberText: String,
    text: String
) {
    Column(
        verticalArrangement = Center,
        horizontalAlignment = CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}


@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 12.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
            color = Color.Blue
        )
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Black,
                        fontWeight = Bold
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle) // Set the Style to top of our Stack
                        append(name)
                        pop() // drop the style from our Stack
                        if (index < followedBy.size - 1) {
                            append(",")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val minWith = 95.dp
    val height = 35.dp

    Row(horizontalArrangement = SpaceAround, modifier = modifier.fillMaxWidth()) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = modifier
                .defaultMinSize(minWith)
                .height(height)
        )
        ActionButton(
            text = "Message", modifier = modifier
                .defaultMinSize(minWith)
                .height(height)
        )
        ActionButton(
            text = "Email", modifier = modifier
                .defaultMinSize(minWith)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = modifier.size(height)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Center,
        verticalAlignment = CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp),
    ) {
        if (text != null) {
            Text(text = text, fontWeight = SemiBold, fontSize = 14.sp)
        }
        if (icon != null) {
            Icon(imageVector = icon, contentDescription = null, tint = Black)
        }
    }
}

@Composable
fun StoryHighLightSection(
    modifier: Modifier = Modifier, highLights: List<ImageWithtext>
) {
    LazyRow(modifier = modifier.fillMaxWidth(), horizontalArrangement = SpaceAround) {
        items(highLights.size) {
            Column(
                modifier = modifier.padding(end = 15.dp),
                horizontalAlignment = CenterHorizontally,
                verticalArrangement = Center
            ) {
                RoundImage(
                    modifier = Modifier.size(70.dp),
                    image = highLights[it].image
                )
                Text(text = highLights[it].text, overflow = Ellipsis)
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithText: List<ImageWithtext>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val inactiveColor = Color(0xF7777777)

    TabRow(
        selectedTabIndex = selectedTabIndex,
        contentColor = Black,
        backgroundColor = Transparent,
        modifier = modifier
    ) {
        imageWithText.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp),
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Black else inactiveColor
                )
            }
        }
    }
}

/**
 * modifier.scale(1.01f) = um die Border an der rechten und linke seite aus dem Screen zu schieben
 */
@Composable
fun PostSection(posts: List<Painter>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(3), modifier = modifier.scale(1.01f)) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = White
                    )
            )
        }
    }
}
