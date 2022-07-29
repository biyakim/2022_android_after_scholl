package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast as Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_layout)

        //식별자를 이용한 뷰 접근
        var myButton : Button =findViewById(R.id.my_button)
        var myEditText=findViewById(R.id.my_edittext) as EditText
        var myTextView=findViewById<TextView>(R.id.my_textview)

//        myButton.setOnClickListener(
//          object: View.OnClickListener{
//                override fun onClick(p0: View?) {
//                   Toast.makeText(this@MainActivity,
//                    "클릭!",Toast.LENGTH_SHORT).show()
//                }
//            }
//        )

//        myButton.setOnClickListener{
//            v->
//            Toast.makeText(this@MainActivity,"클랙!",Toast.LENGTH_SHORT).show()
//        }

        myButton.setOnClickListener{
           // Toast.makeText(this@MainActivity, "클릭!",Toast.LENGTH_SHORT).show()
            Log.d("my_tag", "Hello")
            //로그캣과 로그
                //로그캣에 에러 메시지가 뜸 (앱 비정상 종료 이유 알 수 있음)
                  //로그캣 띄우면 로그 메시지 볼 수 있다
                  //Log.d("태그명","메시지")
            //액티비티 개념
                    //액티비티 => 한 화면을 정의하기 위한 단위
                    //Activity 클래스를 상속 받는 클래스를 정의하면 액티비티 클래스 만들 수 잇음
                    //액티비티 클래스는 하나의 XML 레이아웃 파일을 필요로 함
                    //(*) 마니페스트 파일에도 상용할 액티비티 태그를 정의해야 함
            //액티비티 생명주기 메소드(lifecycle method)
               //안드로이드 코딩을 어렵게 만드는 주
               //기억해야 할 두 가지 생명주기 메소드
                   //onCreate:액티비티의 초기 데이터 정리라던지 생성자 역할
                   //onDestroy:액티비티에서 생성한 리소스 정리라던지 파괴자 역할
        }
//        myTextView.setText("Hello")
//          myTextView.text="Hello"

//        Log.d("my_tag",myTextView.text.toString())
//        Log.d("my_tag",myTextView.getText().toString())

//        myEditText.text="Hello"
//        myEditText.setText("Hello")

    }
}