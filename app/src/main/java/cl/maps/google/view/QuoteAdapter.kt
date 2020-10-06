package cl.maps.google.view
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.maps.google.R
import cl.maps.google.model.db.QuoteMini
import kotlinx.android.synthetic.main.fragment_quote.view.*

class QuoteAdapter(private var quoteDataset: MutableList<QuoteMini>) : RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_quote, parent, false)
        return QuoteViewHolder(view)
    }
    val quoteSelected = MutableLiveData<QuoteMini>()

   override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        Log.d("Adapter de los datos", "${quoteDataset.get(position)}")
        holder.textTitle.text = quoteDataset.get(position).body
        holder.textTitle2.text = quoteDataset.get(position).author
        holder.textTitle3.text = quoteDataset.get(position).id.toString()
       Log.d("ADAPTER", "${quoteDataset.get(position).favorite}")
       holder.starFav.setOnClickListener{
           if (!quoteDataset.get(position).favorite) {
               quoteDataset.get(position).favorite = true
               holder.starFav.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
           } else {
               quoteDataset.get(position).favorite = false
               holder.starFav.setBackgroundResource(R.drawable.ic_baseline_star_24)
           }
           Log.d("ADAPTER2", "${quoteDataset.get(position).favorite}")
       }

        quoteSelected.value = quoteDataset.get(position)
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
        var textTitle = itemView.authorView
        var textTitle2 = itemView.bodyView
        var textTitle3 = itemView.idView
        var starFav = itemView.imageButton
    }
}