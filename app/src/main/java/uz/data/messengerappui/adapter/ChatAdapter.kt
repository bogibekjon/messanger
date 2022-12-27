package uz.data.messengerappui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.data.messengerappui.R
import uz.data.messengerappui.model.Chat

class ChatAdapter(var context: Context, var list: ArrayList<Chat>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ROOM = 0
    private val TYPE_MESSAGE = 1

    override fun getItemViewType(position: Int): Int {
        var chat = list[position]

        if (chat.rooms.isEmpty()) return TYPE_MESSAGE
        return TYPE_ROOM
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_MESSAGE) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
            return MessageViewHolder(view)
        } else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_chat_room, parent, false)
            return RoomViewHolder(context, view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = list[position]
        if (holder is MessageViewHolder) {
            holder.apply {
                Glide.with(ivProfile).load(chat.message?.image).into(ivProfile)
                tvMessage.text = chat.message?.message
                tvTime.text = chat.message?.time
                tvFullName.text = chat.message?.fullname
                if (chat.message?.isOnline == true) {
                    ivOnline.visibility = View.VISIBLE
                } else {
                    ivOnline.visibility = View.INVISIBLE
                }
            }
        }

        if (holder is RoomViewHolder) {
            holder.apply {
                rvRoom.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                rvRoom.adapter=RoomAdapter(chat.rooms)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivProfile = view.findViewById<ImageView>(R.id.iv_profile)
        val ivOnline = view.findViewById<ImageView>(R.id.iv_online)
        val tvFullName = view.findViewById<TextView>(R.id.tv_fullname)
        val tvMessage = view.findViewById<TextView>(R.id.tv_message)
        val tvTime = view.findViewById<TextView>(R.id.tv_time)
    }

    class RoomViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {
        val rvRoom = view.findViewById<RecyclerView>(R.id.rv_chat_room)
    }

}