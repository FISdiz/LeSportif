package cl.maps.google.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cl.maps.google.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonField.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_quoteFragment)
        }
        buttonMap.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_mapsFragment)
        }
        buttonRegister.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_registro)
        }
    }
}