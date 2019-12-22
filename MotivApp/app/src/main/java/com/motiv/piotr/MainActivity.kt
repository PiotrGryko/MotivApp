 
package com.motiv.piotr
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.DaoRepositoryFactory
import com.motiv.piotr.dao.LocalStorage
import kotlinx.android.synthetic.main.mainactivity.*

public class MainActivity : AppCompatActivity() {

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsListAdapter: PostsListAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var fragmentsPagerAdapter: FragmentsPagerAdapter

    private lateinit var goRestApi: GoRestApi

    private lateinit var daoRepository: DaoRepository

    private lateinit var localStorage: LocalStorage

    private lateinit var navigationController: NavigationController

    private lateinit var linearlayout00: LinearLayout

    private lateinit var edittext10: EditText

    private lateinit var button11: Button

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity)

        usersListAdapter = UsersListAdapter()
        postsListAdapter = PostsListAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        fragmentsPagerAdapter = FragmentsPagerAdapter(this@MainActivity.getSupportFragmentManager())
        daoRepository = DaoRepositoryFactory.getInstance(this@MainActivity)
        localStorage = LocalStorage.getInstance(this@MainActivity)
        navigationController = NavigationController(this@MainActivity)
        goRestApi = GoRestApiFactory.getInstance(localStorage)
        linearlayout00 = findViewById<LinearLayout>(R.id.linearlayout00)
        edittext10 = findViewById<EditText>(R.id.edittext10)
        button11 = findViewById<Button>(R.id.button11)

        button11.setOnClickListener(object : android.view.View.OnClickListener {
            override fun onClick(argument0: android.view.View) {
                goRestApi.getUser(
                    edittext10.getText().toString(),
                    object : com.motiv.piotr.OnResponseListener<com.motiv.piotr.UserResponse> {
                        override fun onSuccess(argument0: com.motiv.piotr.UserResponse) {
                            Toast.makeText(this@MainActivity, "success", Toast.LENGTH_LONG).show()
                            navigationController.startDashboardActivity(argument0.getResult())
                        } override fun onError(argument0: Exception) {
                            Toast.makeText(this@MainActivity, "error", Toast.LENGTH_LONG).show()
                        } 
                    }
                )
            } 
        })
    }
}
