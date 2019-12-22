 
package com.motiv.piotr
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlinx.android.synthetic.main.mainactivity.*

public class MainActivity : AppCompatActivity(), MainActivityContract.View, HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var presenter: MainActivityContract.Presenter

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsListAdapter: PostsListAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var fragmentsPagerAdapter: FragmentsPagerAdapter

    @Inject
    lateinit var goRestApi: GoRestApi

    @Inject
    lateinit var daoRepository: DaoRepository

    @Inject
    lateinit var localStorage: LocalStorage

    private lateinit var navigationController: NavigationController

    private lateinit var linearlayout00: LinearLayout

    private lateinit var edittext10: EditText

    private lateinit var button11: Button

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    } override fun onCreate(savedInstanceState: android.os.Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity)

        usersListAdapter = UsersListAdapter()
        postsListAdapter = PostsListAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        fragmentsPagerAdapter = FragmentsPagerAdapter(this@MainActivity.getSupportFragmentManager())
        navigationController = NavigationController(this@MainActivity)
        linearlayout00 = findViewById<LinearLayout>(R.id.linearlayout00)
        edittext10 = findViewById<EditText>(R.id.edittext10)
        button11 = findViewById<Button>(R.id.button11)

        presenter = MainActivityPresenter(this@MainActivity, goRestApi, daoRepository, localStorage)

        button11.setOnClickListener(object : android.view.View.OnClickListener {
            override fun onClick(argument0: android.view.View) {
                presenter.eloonClick(argument0)
            } 
        })
    } override fun edittext10getText(): CharSequence {
        return edittext10.getText().toString()
    } override fun showToast(arg0: String) {
        Toast.makeText(this@MainActivity, arg0, Toast.LENGTH_LONG).show()
    } override fun navigationControllerstartDashboardActivity(arg0: com.motiv.piotr.User) {
        navigationController.startDashboardActivity(arg0)
    }
}
