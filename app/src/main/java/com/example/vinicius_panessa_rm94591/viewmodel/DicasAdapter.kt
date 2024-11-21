import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.vinicius_panessa_rm94591.R

data class Dica(
    val title: String,
    val description: String
)


class DicasAdapter(
    private val dicas: List<Dica>,
    private val context: Context
) : RecyclerView.Adapter<DicasAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_dica, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dica = dicas[position]
        holder.tvTitle.text = dica.title
        holder.tvDescription.text = dica.description

        holder.itemView.setOnClickListener {
            Toast.makeText(context, dica.description, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = dicas.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
    }
}