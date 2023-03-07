package co.id.zeelandia.ziapps.ui.login

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import co.id.zeelandia.ziapps.MainActivity
import co.id.zeelandia.ziapps.databinding.ActivityLoginBinding

import co.id.zeelandia.ziapps.R
import co.id.zeelandia.ziapps.adapter.NPDRequestAdapter
import co.id.zeelandia.ziapps.response.LoginResponse
import co.id.zeelandia.ziapps.response.NPDRequestResponse
import co.id.zeelandia.ziapps.services.ApiConfig
import co.id.zeelandia.ziapps.services.SharedPrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding
    companion object {
        private const val TAG = "LoginActivity"
        private const val BEARER_TOKEN = "4|Z7iWLFRvifpnkbIUVglbqReCFP0OzRsyNgncRtPJ"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val main = Intent(this, MainActivity::class.java)
//        startActivity(main)

        val username = binding.edittextUsername
        val password = binding.edittextPassword
        val login = binding.buttonLogin
        val loading = binding.loading

        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)

        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
            val loginState = it ?: return@Observer

            // disable login button unless both username / password is valid
            login!!.isEnabled = loginState.isDataValid

            if (loginState.usernameError != null) {
                username?.error = getString(loginState.usernameError)
            }
            if (loginState.passwordError != null) {
                password?.error = getString(loginState.passwordError)
            }
        })

        loginViewModel.loginResult.observe(this@LoginActivity, Observer {
            val loginResult = it ?: return@Observer

            loading.visibility = View.GONE
            if (loginResult.error != null) {
                showLoginFailed(loginResult.error)
            }
            if (loginResult.success != null) {
                updateUiWithUser(loginResult.success)
            }
            setResult(Activity.RESULT_OK)

            //Complete and destroy login activity once successful
//            val main = Intent(this, MainActivity::class.java)
//            startActivity(main)
            //finish()
        })

        username?.afterTextChanged {
            loginViewModel.loginDataChanged(
                username?.text.toString(),
                password?.text.toString()
            )
        }

        password?.apply {
            afterTextChanged {
                loginViewModel.loginDataChanged(
                    username?.text.toString(),
                    password?.text.toString()
                )
            }

            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        loginViewModel.login(
                            username?.text.toString(),
                            password?.text.toString()
                        )
                }
                false
            }

            login?.setOnClickListener {
                loading.visibility = View.VISIBLE
                val client = ApiConfig.getApiService().userLogin(username?.text.toString(),password?.text.toString())
                client.enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {

                        loading.visibility = View.INVISIBLE
                        if (response.isSuccessful) {
                            val responseBody = response.body()
                            if (responseBody != null) {
                                //sharedpreference
                                SharedPrefManager.getInstance(applicationContext).saveUser(response.body()?.user!!,response.body()?.accessToken)
//                                if(SharedPrefManager.getInstance(applicationContext).user.user_type == "user") {
//                                    startActivity(Intent(applicationContext, ContentUserActivity::class.java))
//                                }
//                                else if(SharedPrefManager.getInstance(applicationContext).user.user_type == "admin") {
//                                    startActivity(Intent(applicationContext, ContentActivity::class.java))
//                                }
                                Toast.makeText(
                                    applicationContext,
                                    "Hai "+SharedPrefManager.getInstance(applicationContext).user.name,
                                    Toast.LENGTH_LONG
                                ).show()

                                //Complete and destroy login activity once successful
                                val main = Intent(applicationContext, MainActivity::class.java)
                                startActivity(main)
                            }
                        } else {
                            Log.e(LoginActivity.TAG, "onFailure: ${response.message()}")
                        }
                    }
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

                        loading.visibility = View.INVISIBLE
                        Log.e(LoginActivity.TAG, "onFailure: ${t.message}")
                    }
                })
            }
        }
    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome)
        val displayName = model.displayName
        // TODO : initiate successful logged in experience
        Toast.makeText(
            applicationContext,
            "$welcome $displayName",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }
}

/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}