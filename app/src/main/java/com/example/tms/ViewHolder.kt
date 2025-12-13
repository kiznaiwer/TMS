import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tms.Item
import com.example.tms.R

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val imageView: ImageView = itemView.findViewById(R.id.image_view)
    val titleTextView: TextView = itemView.findViewById(R.id.title_text_view)
    val descriptionTextView: TextView = itemView.findViewById(R.id.description_text_view)
    val actionButton: Button = itemView.findViewById(R.id.action_button)

    fun bind(item: Item, onActionClick: (Item) -> Unit) {
        titleTextView.text = item.title
        descriptionTextView.text = item.description

        actionButton.setOnClickListener {
            onActionClick(item)
        }
    }
}