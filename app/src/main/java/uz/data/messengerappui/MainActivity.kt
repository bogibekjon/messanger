package uz.data.messengerappui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.data.messengerappui.adapter.ChatAdapter
import uz.data.messengerappui.model.Chat
import uz.data.messengerappui.model.Message
import uz.data.messengerappui.model.Room

class MainActivity : AppCompatActivity() {
    lateinit var list: ArrayList<Chat>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()


    }

    private fun initViews() {
        val rvChat = findViewById<RecyclerView>(R.id.rv_chat)
        loadList()
        rvChat.adapter = ChatAdapter(this, list)
        rvChat.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun loadList() {
        list = ArrayList()
        list.add(
            Chat(
                arrayListOf(
                    Room(
                        "https://m.economictimes.com/thumb/msid-64491856,width-1200,height-900,resizemode-4,imgsize-208661/priyankasundar.jpg",
                        "Sundai Pichai"
                    ),
                    Room(
                        "https://m.economictimes.com/thumb/msid-64491856,width-1200,height-900,resizemode-4,imgsize-208661/priyankasundar.jpg",
                        "Sundai Pichai"
                    ),
                    Room(
                        "https://m.economictimes.com/thumb/msid-64491856,width-1200,height-900,resizemode-4,imgsize-208661/priyankasundar.jpg",
                        "Sundai Pichai"
                    )
                )
            )
        )
        list.add(
            Chat(
                Message(
                    "https://c.files.bbci.co.uk/11CB0/production/_84808827_gettyimages-464948948.jpg",
                    "Sundai Pichai",
                    "Hi Bro ",
                    "Friday"
                )
            )
        )

        list.add(
            Chat(
                Message(
                    "https://c.files.bbci.co.uk/11CB0/production/_84808827_gettyimages-464948948.jpg",
                    "Sundai Pichai",
                    "Hi Bro ",
                    "Monday",true
                )
            )
        )
    }
}