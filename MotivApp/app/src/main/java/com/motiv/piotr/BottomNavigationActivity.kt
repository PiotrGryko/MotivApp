 
package com.motiv.piotr
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage
import kotlinx.android.synthetic.main.bottomnavigationactivity.*

public class BottomNavigationActivity : AppCompatActivity(), BottomNavigationActivityContract.View {

    private lateinit var presenter: BottomNavigationActivityContract.Presenter

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsListAdapter: PostsListAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var fragmentsPagerAdapter: FragmentsPagerAdapter

    private lateinit var goRestApi: GoRestApi

    private var daoRepository: DaoRepository = DaoRepositoryFactory.getInstance(this@BottomNavigationActivity)

    private lateinit var localStorage: LocalStorage

    private lateinit var navigationController: NavigationController

    private lateinit var relativelayout00: RelativeLayout

    private lateinit var bottomnavigationview11: BottomNavigationView

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottomnavigationactivity)

        usersListAdapter = UsersListAdapter()
        postsListAdapter = PostsListAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        fragmentsPagerAdapter = FragmentsPagerAdapter(this@BottomNavigationActivity.getSupportFragmentManager())
        localStorage = LocalStorage.getInstance(this@BottomNavigationActivity)
        navigationController = NavigationController(this@BottomNavigationActivity)
        goRestApi = GoRestApiFactory.getInstance(localStorage)
        relativelayout00 = findViewById<RelativeLayout>(R.id.relativelayout00)
        bottomnavigationview11 = findViewById<BottomNavigationView>(R.id.bottomnavigationview11)

        presenter = BottomNavigationActivityPresenter(this@BottomNavigationActivity, goRestApi, daoRepository, localStorage)

        bottomnavigationview11.setOnNavigationItemSelectedListener(object : com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(argument0: android.view.MenuItem): Boolean {
                presenter.eloonNavigationItemSelected(argument0)

                return false
            } 
        })
    } override fun navigationControllerstartDestinationById(arg0: Int) {
        navigationController.startDestinationById(arg0)
    }
}
