package cl.maps.google.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import cl.maps.google.R
import cl.maps.google.model.db.QuoteMini
import cl.maps.google.viewmodel.QuoteViewModel
import kotlinx.android.synthetic.main.fragment_list_quoteragment.*
import kotlinx.android.synthetic.main.fragment_quote.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListQuoteragment.newInstance] factory method to
 * create an instance of this fragment.
 */
private var quoteList = ArrayList<QuoteMini>()
internal lateinit var adapter: QuoteAdapter
private lateinit var quoteViewModel: QuoteViewModel
class ListQuoteragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_quoteragment, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListQuoteragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListQuoteragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        adapter = QuoteAdapter(quoteList)
        quoteRecycler.adapter = adapter

        val quoteViewModel: QuoteViewModel by activityViewModels()
        quoteViewModel.listQuote.observe(viewLifecycleOwner, Observer {
            adapter.updateItems(it)
        })
        adapter.quoteSelected.observe(viewLifecycleOwner, Observer { requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view_tag, QuoteFragment.newInstance(it.id.toString(), ""), "detail")
            .addToBackStack("detail").commit()
        })
    }
}