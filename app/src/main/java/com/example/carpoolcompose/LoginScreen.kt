package com.example.carpoolcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val (image1, image2) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.rect_dark),
            contentDescription = null,
            modifier = Modifier
                .height(131.dp)
                .width(404.dp)
                .constrainAs(image1) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.rect_light),
            contentDescription = null,
            modifier = Modifier
                .height(140.dp)
                .width(286.dp)
                .constrainAs(image2) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )

        {

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = stringResource(id = R.string.logo),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colorResource(id = R.color.abc),
                            colorResource(id = R.color.def)
                        )
                    )
                ),
                modifier = Modifier
                    .padding(top = 30.dp)
            )

            Text(
                text = stringResource(id = R.string.welcome_message),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = stringResource(id = R.string.existing_account),
            )

            Spacer(modifier = Modifier.height(20.dp))

            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            OutlinedTextField(
                value = "",
                onValueChange = {email = it},
                label = { Text(text = stringResource(id = R.string.email)) },
                placeholder = { Text(stringResource(id = R.string.enter_email)) },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_mail),
                        contentDescription = "Email Icon",
                        modifier = Modifier.size(24.dp)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(vertical = 12.dp)
            )

            OutlinedTextField(
                value = "",
                onValueChange = {password = it},
                label = { Text(text = stringResource(id = R.string.password)) },
                placeholder = { Text(stringResource(id = R.string.enter_password)) },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.group),
                        contentDescription = "Password Icon",
                        modifier = Modifier.size(18.dp)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
            Text(
                text = stringResource(id = R.string.forgot),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(horizontal = 16.dp)
                    .padding(vertical = 16.dp)
            )

            GradientButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .padding(horizontal = 104.dp),
                text = stringResource(id = R.string.log_in),
                onClick = {},
            )
            Text(
                text = stringResource(id = R.string.or_sign_up),
                modifier = Modifier
                    .padding(vertical = 16.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = null,
                modifier = Modifier.size(28.dp)
            )
            Text(
                text = buildAnnotatedString {
                    append(stringResource(id = R.string.regular_part))
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                        append(stringResource(id = R.string.bold_part))
                    }
                },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .clickable { navController.navigate("signup") }
            )
        }
    }
}

@Composable
fun GradientButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    gradient: Brush = Brush.verticalGradient(
        listOf(
            colorResource(id = R.color.abc),
            colorResource(id = R.color.def)
        )
    )
) {
    Box(
        modifier = modifier
            .background(brush = gradient, shape = RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .padding(vertical = 12.dp, horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

