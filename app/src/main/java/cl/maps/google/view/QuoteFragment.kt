package cl.maps.google.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.maps.google.R
import cl.maps.google.model.db.QuoteMini
import cl.maps.google.model.db.Repository
import cl.maps.google.viewmodel.QuoteViewModel
import kotlinx.android.synthetic.main.fragment_list_quoteragment.*


private var quoteList = ArrayList<QuoteMini>()
internal lateinit var adapter: QuoteAdapter
private lateinit var quoteViewModel: QuoteViewModel
class QuoteFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_quoteragment, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            QuoteFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        adapter = QuoteAdapter(quoteList)
        quoteRecycler.adapter = adapter

        val quoteViewModel: QuoteViewModel by activityViewModels()
        /*quoteViewModel.listQuote.observe(viewLifecycleOwner, Observer {
            adapter.updateItems(it)
        })*/
        var datos = Repository(view.context).loadApiData()
        /*adapter.quoteSelected.observe(viewLifecycleOwner, Observer { requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view_tag, newInstance(it.id.toString(), ""), "detail")
            .addToBackStack("detail").commit()
        })*/
    }
}