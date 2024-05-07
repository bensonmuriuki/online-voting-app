package com.example.benson_project.nominee

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.mandatorySystemGesturesPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.benson_project.R
import com.example.benson_project.data.NomineeViewModel
import com.example.benson_project.navigation.ROUTE_VIEW_NOMINEE
import com.example.benson_project.navigation.ROUTE_VIEW_UPLOAD



@Composable
fun  AddNomineeScreen(navController: NavHostController) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.halfvote),
            contentDescription = "home page",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize().mandatorySystemGesturesPadding()


        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var context = LocalContext.current
            Text(
                text = "Add Nominee",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red,
                modifier = Modifier.padding(20.dp),
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )

            var nomineeName by remember { mutableStateOf(TextFieldValue("")) }
            var nomineeId by remember { mutableStateOf(TextFieldValue("")) }
            var nomineePost by remember { mutableStateOf(TextFieldValue("")) }

            OutlinedTextField(
                value = nomineeName,
                onValueChange = { nomineeName = it },
                label = { Text(text = "Nominee name *") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = nomineeId,
                onValueChange = { nomineeId = it },
                label = { Text(text = "nominee IdentityCard *") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = nomineePost,
                onValueChange = { nomineePost = it },
                label = { Text(text = "nominee post *") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {


                val nomineeRepository = NomineeViewModel(navController, context)
                nomineeRepository.saveNominee(
                    nomineeName.text.trim(), nomineeId.text.trim(),
                    nomineePost.text
                )
                navController.navigate(ROUTE_VIEW_NOMINEE)


            }) {
                Text(text = "Save")
            }
            Spacer(modifier = Modifier.height(20.dp))


            //---------------------IMAGE PICKER START-----------------------------------//




}
    }
@Composable
fun ImagePicker(modifier: Modifier = Modifier, context: Context, navController: NavHostController, name:String, id:String, post:String){

        var hasImage by remember { mutableStateOf(false) }
        var imageUri by remember { mutableStateOf<Uri?>(null) }

        val imagePicker = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent(),
            onResult = { uri ->
                hasImage = uri != null
                imageUri = uri
            }
        )

        Column(modifier = modifier,) {
            if (hasImage && imageUri != null) {
                val bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, imageUri)
                Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Selected image")
            }
            Column(
                modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Button(
                    onClick = {
                        imagePicker.launch("image/*")
                    },
                ) {
                    Text(
                        text = "Select Image"
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = {
                    //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                    var nomineeRepository = NomineeViewModel(navController, context)
                    nomineeRepository.saveNomineeWithImage(name, id, post, imageUri!!)
                    navController.navigate(ROUTE_VIEW_UPLOAD)

                }) {
                    Text(text = "Upload")
                }
                Button(onClick = {
                    //-----------WRITE THE UPLOAD LOGIC HERE---------------//

                    navController.navigate(ROUTE_VIEW_UPLOAD)

                }) {
                    Text(text = "view uploads")
                }

            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddNomineeScreenPreview() {
    AddNomineeScreen(rememberNavController())

}
