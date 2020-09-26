package cl.maps.google.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import cl.maps.google.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_register.*


class Registro : Fragment() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.fragment_register)
        auth = Firebase.auth
        //val editText = findViewById<EditText>(R.id.editText)
        val text1 = editText.text
        val text0 = editText2.text
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onStart() {
        super.onStart()
    val currentUser = auth.currentUser
    }
    fun signIn(user: String, pass: String){
        auth.signInWithEmailAndPassword(user, pass).addOnCompleteListener {
            task ->
            if(task.isSuccessful){
                val user = auth.currentUser
                Toast.makeText(context, "Authentication succes", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Authentication fail", Toast.LENGTH_SHORT).show()

            }
        }
    }
}