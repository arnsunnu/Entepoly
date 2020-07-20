package com.exflater.entepoly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_reg.*
import java.lang.StringBuilder

class Reg : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        var db=FirebaseDatabase.getInstance().reference
        reg_btn.setOnClickListener {
            var name =name_edt.text.toString() // val inputValue: String = editText.text.toString()
            var rgno= rgno_edt.text.toString().toInt();
            var emid=eml_edt.text.toString();
            var phno=phno_edt.text.toString();
            db.child(rgno.toString()).setValue(details(name,phno,emid))

        }
        //GetData

        var getdata= object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                TODO("Not yet implemented")
                var sb=StringBuilder()
                /*for (i in snapshot.children){
                    var ename1=i.child("ename").getValue()
                    var emid1=i.child("emid").getValue()
                    var phno1=i.child("phno").getValue()
                    sb.append("$(i.key)$ename1 $emid1 $phno1\n" )
                }*/
                textView2.setText(sb)
            }

        }
        db.addValueEventListener(getdata)
        db.addListenerForSingleValueEvent(getdata)

    }

}