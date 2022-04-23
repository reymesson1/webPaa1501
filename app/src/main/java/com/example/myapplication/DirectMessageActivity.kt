package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.Model.RestAPI
import kotlinx.android.synthetic.main.activity_direct_message.*
import kotlinx.android.synthetic.main.layout_item_message.view.*
import kotlinx.android.synthetic.main.layout_item_message_you.view.*

class DirectMessageActivity : AppCompatActivity() {
    var restAPI = RestAPI()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_direct_message)

        topTitle.setText(RestAPI.topTitle)//Este es el titulo de arriba del chat

        var data = arrayOf("Test", "CocaCola", "Disney", "IBM", "Microsoft", "Google", "hp", "Nescafe", "Pepsi", "Nike", "Colgate", "KFC", "3M", "VW", "Oracle", "UPS")
//        var data = arrayOf("")

        data.forEach { at ->

            var itemMessage = layoutInflater.inflate(R.layout.layout_item_message, null)
            var itemMessageYou = layoutInflater.inflate(R.layout.layout_item_message_you, null)

            if(at.length<4){
                itemMessage.me.setText(at)
                scContentMessage.addView(itemMessage)

            }else{
                itemMessageYou.you.setText(at)
                scContentMessage.addView(itemMessageYou)

            }

        }

    }
}