package cl.maps.google.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cl.maps.google.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_register.*


class Registro : Fragment() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonRegister2.setOnClickListener{
            val text1 = editText2.text.toString()
            val text0 = editText.text.toString()
            logIn(text1, text0)
        }
        buttonLog.setOnClickListener{
            findNavController().navigate(R.id.action_registro_to_registroFragment)
        }
    }

    override fun onStart() {
        super.onStart()
    val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser!= null){
            findNavController().navigate(R.id.action_registro_to_mainFragment)
        }
    }

    fun logIn(user: String, pass: String){
        auth.signInWithEmailAndPassword(user, pass).addOnCompleteListener {
            task ->
            if(task.isSuccessful){
                val user = auth.currentUser
                Toast.makeText(context, "Authentication succes", Toast.LENGTH_SHORT).show()
                  findNavController().navigate(R.id.action_registro_to_mainFragment)


            } else {
                Toast.makeText(context, "Authentication fail", Toast.LENGTH_SHORT).show()

            }
        }
    }
}