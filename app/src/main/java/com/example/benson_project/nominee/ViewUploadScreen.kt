package com.example.benson_project.nominee


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter

import com.example.benson_project.data.NomineeViewModel
import com.example.benson_project.models.Nominee
import com.example.benson_project.models.Upload
import com.example.benson_project.navigation.ROUTE_UPDATE_NOMINEEPOTAL


@Composable
fun ViewUploadsScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var NomineeRepository = NomineeViewModel(navController, context)


        val emptyProductState = remember { mutableStateOf(Nominee("","","",)) }
        val emptyProductsListState = remember { mutableStateListOf<Nominee>() }

        val uploads = NomineeRepository.viewUploads(emptyProductState, emptyProductsListState)



        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All uploads",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(uploads){
                    UploadItem(
                        name = it.name,
                        id = it.id,
                        post = it.post,
                        imageUrl = it.imageUrl,
                        navController = navController,
                        NomineeRepository = NomineeRepository


                    )
                }
            }
        }
    }
}


@Composable
fun UploadItem(name:String, id:String, post:String, imageUrl:String,
               navController:NavHostController, NomineeRepository:NomineeViewModel) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = id)
        Text(text = post)
        Image(
            painter = rememberAsyncImagePainter (imageUrl),
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
        Button(onClick = {
            NomineeRepository.deleteNominee(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            navController.navigate(ROUTE_UPDATE_NOMINEEPOTAL+"/$id")
        }) {
            Text(text = "Update")
        }
    }
}

