package co.id.zeelandia.ziapps.adapter

import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.id.zeelandia.ziapps.R
import co.id.zeelandia.ziapps.response.NPDRequestResponse
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class NPDRequestAdapter(private val listNPD: List<NPDRequestResponse>) : RecyclerView.Adapter<NPDRequestAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_npd_request, viewGroup, false))
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        var formatter = DateTimeFormatter.ofPattern("dd MMM yyyy")
        viewHolder.tvDate.text = LocalDate.parse(listNPD[position].reqDate.take(10)).format(formatter)
        var status = listNPD[position].reqAppStats
        viewHolder.tvStatus.text = status?.trim()
        viewHolder.tvCustName.text = listNPD[position].reqCustName?.trim()
    }
    override fun getItemCount() = listNPD.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDate: TextView = view.findViewById(R.id.textViewReqDate)
        val tvStatus: TextView = view.findViewById(R.id.textViewStatus)
        val tvCustName: TextView = view.findViewById(R.id.textViewCustName)
    }
}