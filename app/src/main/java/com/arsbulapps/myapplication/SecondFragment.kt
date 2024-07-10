package com.arsbulapps.myapplication

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.arsbulapps.myapplication.databinding.FragmentSecondBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)

//        binding.button.setOnClickListener {
//            Log.e("Test text", binding.editText.text.toString())
//        } // Первая версия
        binding.editText.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if (event != null && event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    binding.progressBar.visibility = View.VISIBLE
                    RetrofitHelper.catsApi.getFact(binding.editText.text.toString().toInt()) // Вызов метода отправки get-запроса на получение данных ВНЕ ОСНОВНОГО ПОТОКА
                        .enqueue(object : Callback<FactResponse> {
                            override fun onResponse(
                                call: Call<FactResponse>,
                                response: Response<FactResponse>
                            ) { // Обработака данных в случае успшного их получения
                                binding.progressBar.visibility = View.GONE
                                if (response.body() != null) {
                                    binding.factText.text = response.body()!!.fact
                                }

                            }

                            override fun onFailure(call: Call<FactResponse>, t: Throwable) { // Выполнение кода в случае ошибки
                                binding.progressBar.visibility = View.GONE
                                binding.factText.text = "Произошла ошибка: ${t.message}" // Вывод сообщения в слчае ошибки

                            }
                        })
                    binding.editText.clearFocus()
                    binding.editText.isCursorVisible = false
                    return true
                } else {
                    binding.editText.isCursorVisible = true
                    return true
                }

                return false
            }

        })
        return binding.root
    }

}