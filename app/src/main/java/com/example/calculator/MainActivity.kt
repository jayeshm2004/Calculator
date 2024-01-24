package com.example.calculator
import android.view.View
import android.widget.Button
import com.example.calculator.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
     private var currentinput=""
    private var currentOperator=""
    private var firstoperand=0.0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.editbutton.isFocusable=false
        binding.editbutton.isClickable=false
          binding.btnequal.setOnClickListener {
            equalevent()
        }
        binding.btnac.setOnClickListener{
            clearevent()
        }
        binding.clear.setOnClickListener{
            clear()
        }

    }

    fun numberevent(view: View) {
        val digit=(view as Button).text.toString()
        currentinput+=digit
        binding.editbutton.append(digit)
    }
    
    fun operatorevent(view: View) {
        currentOperator=(view as Button).text.toString()
        firstoperand=binding.editbutton.text.toString().toDouble()
        binding.editbutton.text.clear()
    }
    fun equalevent() {
        val secondoperand=  binding.editbutton.text.toString().toDouble()
        val result=when(currentOperator){
            "+"->firstoperand+secondoperand
            "-"->firstoperand-secondoperand
            "X"->firstoperand*secondoperand
            "/"->{
                if (secondoperand!=0.0){
                    firstoperand/secondoperand
                }
                else{
                    return
                }
            }
            else->return


        }
        binding.editbutton.setText(result.toString())
        currentOperator=""
        firstoperand=0.0
    }
    fun clearevent() {
        binding.editbutton.text.clear()
        currentOperator=""
        firstoperand=0.0
    }
    fun clear() {
        val current=binding.editbutton.text.toString()
        if(current.isNotEmpty()){
            binding.editbutton.text.delete(current.length-1,current.length)
        }
    }




}



