package com.syafi.ecoquest.presentation.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.Coil
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.syafi.ecoquest.ui.theme.green
import com.syafi.ecoquest.ui.theme.grey
import com.google.accompanist.pager.PagerState
import com.syafi.ecoquest.R
import com.syafi.ecoquest.ui.theme.dark
import com.syafi.ecoquest.util.Routes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {

    val welcomePageList = listOf<WelcomePages>(
        WelcomePages.first,
        WelcomePages.second,
        WelcomePages.third,
    )
    val pagerState = rememberPagerState(pageCount = welcomePageList.size)
    val scope = rememberCoroutineScope()

    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = R.drawable.logo,
                contentDescription = "",
                modifier = Modifier.size(width = 100.dp, height = 25.dp)
            )
            AnimatedVisibility(
                visible = pagerState.currentPage != 2,
            ) {
                Row() {
                    OutlinedButton(
                        onClick = {
                            viewModel.saveOnBoardingState(true)
                            navController.popBackStack()
                            navController.navigate(Routes.HOME)
                        },
                        border = BorderStroke(1.dp, MaterialTheme.colors.dark)
                    ) {
                        Text(
                            text = "Lewati",
                            color = MaterialTheme.colors.dark,
                            style = MaterialTheme.typography.subtitle1
                        )
                    }
                }
            }
        }
        Column(
            Modifier
                .fillMaxWidth()
                .weight(10f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                state = pagerState,
                verticalAlignment = Alignment.Top,
            ) { index ->
                Screen(
                    welcomePages = welcomePageList[index],
                    pagerState = pagerState,
                )
            }
            HorizontalPagerIndicator(
                pagerState = pagerState,
                activeColor = MaterialTheme.colors.green,
                inactiveColor = MaterialTheme.colors.grey,
                indicatorWidth = 40.dp,
                indicatorHeight = 10.dp,
                spacing = 10.dp,
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = {
                if (pagerState.currentPage == 2) {
                    viewModel.saveOnBoardingState(true)
                    navController.popBackStack()
                    navController.navigate(Routes.HOME)
                } else {
                    scope.launch {
                        pagerState.animateScrollToPage(
                            pagerState.currentPage + 1
                        )
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.dark),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = welcomePageList[pagerState.currentPage].btnText,
                style = MaterialTheme.typography.subtitle1,
                color = Color.White
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Screen(
    welcomePages: WelcomePages,
    pagerState: PagerState,

    ) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(
                model = welcomePages.image,
                contentDescription = null,
                modifier = Modifier.size(240.dp)

            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = welcomePages.title,
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Center,
            )
            if (pagerState.currentPage == 0) {
                Text(
                    text = "EcoQuest",
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.green
                )
            }
        }
    }
}