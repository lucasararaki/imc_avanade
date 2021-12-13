package br.com.fiap.imc20.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.imc20.R
import br.com.fiap.imc20.databinding.ActivityLoginBinding
import br.com.fiap.imc20.databinding.ActivityNovoUsuarioBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setListeners()
    }

    private fun setListeners() {
        binding.loginTextViewCriarConta.setOnClickListener {
            val intent = Intent(this, NovoUsuarioActivity::class.java)
            startActivity(intent)
        }

        binding.loginButtonEntrar.setOnClickListener {
            autenticar()
        }
    }

    private fun autenticar() {
        val dados = getSharedPreferences("usuario", MODE_PRIVATE)

        val email = dados.getString("email", "")
        val password = dados.getString("password", "")


        val etEmail = binding.loginEditTextEmail.text.toString()
        val etPassword = binding.loginEditTextPassword.text.toString()

        if (email == etEmail && password == etPassword) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            finish()
        }
    }

}