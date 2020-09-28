package cl.maps.google

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_registro.*


class RegistroFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_registro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonRegister3.setOnClickListener{
            val text2 = editText3.text.toString()
            val text3 = editText4.text.toString()
            signIn(text2, text3)
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
    }

    fun signIn(user: String, pass: String){
        auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener {
           task ->
            if(task.isSuccessful){
                val user = auth.currentUser
                Toast.makeText(context, "Registro completo", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_registroFragment_to_mainFragment)
            } else {
                Toast.makeText(context, "No se pudo registrar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}




