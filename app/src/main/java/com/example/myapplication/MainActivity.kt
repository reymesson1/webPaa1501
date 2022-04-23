package com.example.myapplication

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.Model.RestAPI
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_add.view.*
import kotlinx.android.synthetic.main.layout_item.view.*

class MainActivity : AppCompatActivity() {

    var restAPI = RestAPI()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var data = arrayOf("McDonalds", "Disney", "Oracle", "Honda")

//        restAPI.getMaster().forEach { at->
        restAPI.getMaster().forEach { at->

            var item = layoutInflater.inflate(R.layout.layout_item,null)

            /*********ADD**********/
            item.nameTXT.setText(at.name)

            item.nameTXT.setOnClickListener {

                RestAPI.topTitle = at.name
                var intent = Intent(this, DirectMessageActivity::class.java)
                startActivity(intent)
            }

            /*********EDIT**********/
            item.btn_edit.setOnClickListener {

                var modal = layoutInflater.inflate(R.layout.layout_add,null)

                var alertDialog = AlertDialog.Builder(this)

                alertDialog.setTitle("Edit Value")

                modal.editTXT.setText(at.name)

                alertDialog.setPositiveButton("Update", DialogInterface.OnClickListener { dialogInterface, i ->

                    restAPI.editMaster(at._id, modal.editTXT.text.toString())
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                })

                alertDialog.setView(modal)

                alertDialog.show()

            }

            /*********DELETE**********/
            item.btn_delete.setOnClickListener {

                restAPI.deleteMaster(at._id)

                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }

            scContent.addView(item)
        }

        btn_add.setOnClickListener {

            var modal = layoutInflater.inflate(R.layout.layout_add, null)

            var alertDialog = AlertDialog.Builder(this)

            alertDialog.setTitle("Add Value ")

            alertDialog.setView(modal)

            alertDialog.setPositiveButton("Save", DialogInterface.OnClickListener { dialogInterface, i ->

                restAPI.setMaster(modal.editTXT.text.toString())
//                syncViewModel.setMaster(modal.editTXT.text.toString())

                var intent = Intent(this,MainActivity::class.java)
                startActivity(intent)

            })

            alertDialog.show()

        }
    }
}