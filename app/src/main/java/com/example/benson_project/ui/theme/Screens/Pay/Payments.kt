package com.example.benson_project.ui.theme.Screens.Pay


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.res.painterResource


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.benson_project.R
import com.example.benson_project.navigation.ROUTE_ADD_NOMINEE
import com.example.benson_project.navigation.ROUTE_VIEW_NOMINEE


@Composable
fun HomeScreen(navController: NavController) {


    Box {
        Image(
            painter = painterResource(id = R.drawable.download),
            contentDescription = "v6",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize())



        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var context = LocalContext.current
            //var productdata=productviewmodel(navController,context)


//            Text(
//                text = "Welcome to Home page",
//                color = Color.Black,
//                fontFamily = FontFamily.Default,
//
//                fontSize = 30.sp,
//                fontWeight = FontWeight.SemiBold
//            )

            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .height(100.dp)
                    .fillMaxWidth()
                    .aspectRatio(6f), colors = CardDefaults.cardColors(
                    containerColor = Color.Black
                ),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Icon 1",
                            tint = Color.Yellow,
                            modifier = Modifier.size(48.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = "my profile",
                            tint = Color.Yellow, modifier = Modifier.size(48.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Build,
                            contentDescription = "my profile",
                            tint = Color.Yellow, modifier = Modifier.size(48.dp)
                        )
                    }



                }
            }



            Spacer(modifier = Modifier.height(350.dp))

            Button(
                onClick = {
                    navController.navigate(ROUTE_ADD_NOMINEE)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.Black),
            ) {
                Text(text = "Add Product",
                    color = Color.Yellow)
            }


            Button(
                onClick = {
                    navController.navigate(ROUTE_VIEW_NOMINEE)
                }, modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(text = "View Product",
                    color = Color.Yellow )
            }
            Button(
                onClick = {
                    navController.navigate(ROUTE_ADD_NOMINEE)
                }, modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(text = "Sell your spares",
                    color = Color.Yellow)
            }
            Spacer(modifier = Modifier.height(80.dp))



        }
    }
}



@Preview (showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}









//Card(
//modifier = Modifier
////.fillMaxWidth()
//.padding(10.dp)
//.height(50.dp)
//.aspectRatio(1f), colors = CardDefaults.cardColors(
//containerColor = Color.Yellow
//
//)
//) {
//    IconButton(onClick = { /*TODO*/ }) {
//        Icon(
//            imageVector = Icons.Filled.Build,
//            contentDescription = "my profile",
//            tint = Color.Black
//        )
//
//    }
//
//}
