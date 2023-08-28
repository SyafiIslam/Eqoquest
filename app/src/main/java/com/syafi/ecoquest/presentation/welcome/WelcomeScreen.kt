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
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.syafi.ecoquest.ui.theme.green
import com.syafi.ecoquest.ui.theme.grey
import com.google.accompanist.pager.PagerState
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
        Row(Modifier.fillMaxWidth()) {
            AnimatedVisibility(
                modifier = Modifier.fillMaxWidth(),
                visible = pagerState.currentPage != 2,
            ) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
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
        HorizontalPager(
            state = pagerState,
            verticalAlignment = Alignment.Top,
            modifier = Modifier.weight(10f)
        ) { index ->
            Screen(
                welcomePages = welcomePageList[index],
                pagerState = pagerState,
                scope = scope,
                navController = navController,
                viewModel
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
                .weight(1f)
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
    scope: CoroutineScope,
    navController: NavController,
    viewModel: HomeScreenViewModel

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
//                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = welcomePages.image),
                contentDescription = null,
                modifier = Modifier.size(240.dp)

            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = buildAnnotatedString {
                    append(welcomePages.title)
                    if (pagerState.currentPage == 0) {
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colors.green,
                                fontWeight = FontWeight.Medium
                            ),
                        ) {
                            append("EcoQuest")
                        }
                    }
                },
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Center,
            )
        }
    }
}