package com.example.benson_project.data


import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.benson_project.models.Nominee
import com.example.benson_project.navigation.ROUTE_LOGIN
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class NomineeViewModel(var navController: NavHostController, var context: Context) {
    var authRepository: AuthViewModel
    var progress: ProgressDialog

    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }


    fun saveNominee(nomineeName: String, nomineeId: String, nomineePost: String) {
        var id = System.currentTimeMillis().toString()
        var nomineeData = Nominee(nomineeName, nomineeId, nomineePost)
        var nomineeRef = FirebaseDatabase.getInstance().getReference()
            .child("Nominee/$id")
        progress.show()
        nomineeRef.setValue(nomineeData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    fun saveNomineeWithImage(
        nomineeName: String,
        nomineeId: String,
        nomineePost: String,
        imageUri: Uri
    ) {
        var id = System.currentTimeMillis().toString()
        var nomineeData = Nominee(nomineeName,  nomineeId,nomineePost)
        var nomineeRef = FirebaseDatabase.getInstance().getReference()
            .child("Nominees/$id")
        progress.show()
        nomineeRef.setValue(nomineeData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    fun viewUploads(
        nominee: MutableState<Nominee>,
        nominees: SnapshotStateList<Nominee>
    ): SnapshotStateList<Nominee> {
        val ref = FirebaseDatabase.getInstance().getReference().child("Products")

        //progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                //progress.dismiss()
                nominees.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(Nominee::class.java)
                    nominee.value = value!!
                    nominees.add(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return nominees
    }



    fun deleteNominee(id: String) {
        var delRef = FirebaseDatabase.getInstance().getReference()
            .child("Nominee/$id")
        progress.show()
        delRef.removeValue().addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Nominee deleted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun updateNominee(name: String, id: String, post: String) {
        var updateRef = FirebaseDatabase.getInstance().getReference()
            .child("Nominee/$id")
        progress.show()
        var updateData = Nominee(name, id, post, )
        updateRef.setValue(updateData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
