 
package com.motiv.piotr
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlinx.android.synthetic.main.bottomnavigationactivity.*

public class BottomNavigationActivity : AppCompatActivity(), BottomNavigationActivityContract.View, HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var presenter: BottomNavigationActivityContract.Presenter

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

    private lateinit var relativelayout00: RelativeLayout

    private lateinit var bottomnavigationview11: BottomNavigationView

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    } override fun onCreate(savedInstanceState: android.os.Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottomnavigationactivity)

        usersListAdapter = UsersListAdapter()
        postsListAdapter = PostsListAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        fragmentsPagerAdapter = FragmentsPagerAdapter(this@BottomNavigationActivity.getSupportFragmentManager())
        navigationController = NavigationController(this@BottomNavigationActivity)
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
