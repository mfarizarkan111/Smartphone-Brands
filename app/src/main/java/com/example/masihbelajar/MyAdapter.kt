import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.masihbelajar.DetailActivity
import com.example.masihbelajar.Detailbrand
import com.example.masihbelajar.R
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val brandList: ArrayList<Detailbrand>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_brand, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return brandList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = brandList[position]
        holder.brandImage.setImageResource(currentItem.brandImage)
        holder.tvHeading.text = currentItem.heading

        // Set klik listener untuk item RecyclerView
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("brandImage", currentItem.brandImage)
            intent.putExtra("brandHeading", currentItem.heading)

            // Ambil deskripsi dari strings.xml berdasarkan heading
            val descriptionResId = when (currentItem.heading) {
                "Apple" -> R.string.apple_description
                "Asus" -> R.string.asus_description
                "LG" -> R.string.lg_description
                "Nokia" -> R.string.nokia_description
                "Oneplus" -> R.string.oneplus_description
                "Poco" -> R.string.poco_description
                "Realme" -> R.string.realme_description
                "Samsung" -> R.string.samsung_description
                "Vivo" -> R.string.vivo_description
                "Xiaomi" -> R.string.xiaomi_description
                else -> R.string.default_description
            }

            // Kirim deskripsi ke DetailActivity
            intent.putExtra("brandDescription", context.getString(descriptionResId))
            context.startActivity(intent)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val brandImage: ShapeableImageView = itemView.findViewById(R.id.brand_image)
        val tvHeading: TextView = itemView.findViewById(R.id.tvHeading)
    }
}
