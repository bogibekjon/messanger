package uz.data.messengerappui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.data.messengerappui.R
import uz.data.messengerappui.model.Room

class RoomAdapter(val list: ArrayList<Room>) : RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {


    class RoomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivProfile = view.findViewById<ImageView>(R.id.iv_profile)
        val ivOnline = view.findViewById<ImageView>(R.id.iv_online)
        val tvFullName = view.findViewById<TextView>(R.id.tv_fullname)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_room_view, parent, false)
        return RoomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val room=list[position]
        holder.apply {
            Glide.with(ivProfile).load(room.image).into(ivProfile)
            tvFullName.text = room.fullName

        }
    }

    override fun getItemCount() = list.size


}