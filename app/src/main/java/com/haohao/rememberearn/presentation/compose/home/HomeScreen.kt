package com.haohao.rememberearn.presentation.compose.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.haohao.rememberearn.R
import com.haohao.rememberearn.presentation.ui.states.MessageType
import kotlinx.coroutines.delay

@Composable
internal fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.candleState.collectAsStateWithLifecycle()
    HomeScreen(
        uiState = uiState,
        onCalc = viewModel::calcData,
        modifier = modifier,
    )
}

@Composable
fun HomeScreen(
    uiState: HomeState,
    onCalc: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var text by remember { mutableStateOf("") }
        Text(
            modifier = Modifier.padding(top = 24.dp),
            text = "Input setting",
            color = Color.Black,
            fontSize = TextUnit(20f, TextUnitType.Sp),
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            modifier = Modifier.padding(top = 32.dp),
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter compare candle number") }
        )

        OutlinedTextField(
            modifier = Modifier.padding(top = 16.dp),
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter compare candle number") }
        )

        Button(
            modifier = Modifier
                .padding(top = 24.dp)
                .size(200.dp, 50.dp),
            onClick = { onCalc.invoke() }) {
            Text(
                text = "Get result",
                color = Color.Black,
                fontSize = TextUnit(18f, TextUnitType.Sp)
            )
        }
    }
}

@Composable
fun ShowProgressDialog() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = colorResource(id = R.color.purple_700))
    }
}


@Composable
fun CustomToast(
    message: String,
    modifier: Modifier = Modifier,
    messageType: MessageType = MessageType.ERROR,
    callBack: () -> Unit
) {
    var isVisible by remember { mutableStateOf(true) }

    LaunchedEffect(isVisible) {
        delay(500)
        isVisible = false
        callBack()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 0.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(
                    color = if (messageType == MessageType.ERROR) {
                        colorResource(id = android.R.color.holo_red_light)
                    } else {
                        colorResource(id = android.R.color.holo_green_light)
                    },
                    shape = RoundedCornerShape(4.dp)
                ),
        ) {
            Row(
                modifier = modifier.padding(horizontal = 16.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (messageType == MessageType.SUCCESS) {
                    Image(
                        painter = painterResource(id = android.R.drawable.ic_media_play),
                        contentDescription = null,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }

                Text(
                    text = message,
                    color = Color(0xFFF8FEFF),
                    fontSize = 14.sp,
                    modifier = Modifier.wrapContentWidth()
                )
            }
        }
    }
}