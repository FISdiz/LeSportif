package cl.maps.google.view
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.maps.google.R
import cl.maps.google.model.db.QuoteEntity
import cl.maps.google.model.db.QuoteMini
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_list_quoteragment.view.*
import kotlinx.android.synthetic.main.fragment_quote.view.*

class QuoteAdapter(private var quoteDataset: MutableList<QuoteMini>) : RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_list_quoteragment, parent, false)
        return QuoteViewHolder(view)
    }
    val quoteSelected = MutableLiveData<QuoteMini>()

   override fun onBindViewHolder(holder: QuoteAdapter.QuoteViewHolder, position: Int) {
        Log.d("Adapter", "${quoteDataset.get(position)}")
        holder.textTitle.text = quoteDataset.get(position).body
        holder.textTitle2.text = quoteDataset.get(position).author
        holder.button2.setOnClickListener{
            quoteSelected.value = quoteDataset.get(position)
       }

    }

    override fun getItemCount(): Int {
       return quoteDataset.size
    }

    fun updateItems(it: List<QuoteMini>) {
        quoteDataset.clear()
        quoteDataset.addAll(it)
        notifyDataSetChanged()
    }

    class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textTitle = itemView.body
        var textTitle2 = itemView.author
        var button1 = itemView.buttonMap
        var button2 = itemView.buttonField

    }
}