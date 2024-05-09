package com.example.benson_project.ui.theme.Screens.homeScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.mandatorySystemGesturesPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.benson_project.R
import com.example.benson_project.navigation.ROUTE_ABOUT
import com.example.benson_project.navigation.ROUTE_ADD_NOMINEE
import com.example.benson_project.navigation.ROUTE_HOME
import com.example.benson_project.navigation.ROUTE_REGISTER
import com.example.benson_project.navigation.ROUTE_VIEW_NOMINEE


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    Box {
        Image(
            painter = painterResource(id = R.drawable.register),
            contentDescription = "home page",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize().mandatorySystemGesturesPadding()


        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
//        .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            val context = LocalContext.current.applicationContext
            androidx.compose.material3.TopAppBar(title = { Text(text = "E-VoteHub") },
                navigationIcon = {


                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "/E-VoteHub/"
                        )
//        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu", tint = Color.White)

                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                ), actions = {

                    IconButton(onClick = {navController.navigate(ROUTE_HOME)
                        Toast.makeText(
                            context,
                            "You have clicked  add button",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Hadd nominee",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = {navController.navigate(ROUTE_HOME)
                        Toast.makeText(
                            context,
                            "You have clicked  Home button",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Home",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = { navController.navigate(ROUTE_ABOUT)
                        Toast.makeText(
                            context,
                            "You have clicked  about",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = {navController.navigate(ROUTE_REGISTER)
                        Toast.makeText(
                            context,
                            "You have clicked a profile",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "My profile",
                            tint = Color.White
                        )
                    }
                }
            )

            Text(
                text = "Welcome to Easy-VoteHub",
                color = Color.Blue,
                fontFamily = FontFamily.Cursive,
                fontSize = 30.sp,

            )

            Spacer(modifier = Modifier.height(100.dp))

//            Button(
//                onClick = {
//                    navController.navigate(ROUTE_ADD_NOMINEE)
//                }, modifier = Modifier
//            ) {
//                Text(text = "Add New Nominee")
//
//            }
            Text(
                text = "Click the button bellow to view the nomineted people ",
                color = Color.Blue,
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(100.dp))

            Button(onClick = {
                navController.navigate(ROUTE_VIEW_NOMINEE)
            }, modifier = Modifier ) {
                Text(text = "View Nominee List")
            }

            Spacer(modifier = Modifier.height(100.dp))
            Spacer(modifier = Modifier.height(100.dp))
            Spacer(modifier = Modifier.height(100.dp))



        }


    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}