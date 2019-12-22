 
package com.motiv.piotr
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.*
import com.bumptech.glide.Glide
import com.google.android.material.navigation.NavigationView
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlinx.android.synthetic.main.dashboardactivity.*

public class DashboardActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var loggedUser: com.motiv.piotr.User

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

    private lateinit var drawerlayout00: DrawerLayout

    private lateinit var navigationview11: NavigationView

    private lateinit var headerlinearlayout00: LinearLayout

    private lateinit var headerimageview10: ImageView

    private lateinit var headertextview11: TextView

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    } override fun onCreate(savedInstanceState: android.os.Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboardactivity)

        loggedUser = com.motiv.piotr.User.fromJson(getIntent().getStringExtra("loggedUser"))

        usersListAdapter = UsersListAdapter()
        postsListAdapter = PostsListAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        fragmentsPagerAdapter = FragmentsPagerAdapter(this@DashboardActivity.getSupportFragmentManager())
        navigationController = NavigationController(this@DashboardActivity)
        drawerlayout00 = findViewById<DrawerLayout>(R.id.drawerlayout00)
        navigationview11 = findViewById<NavigationView>(R.id.navigationview11)
        headerlinearlayout00 = navigationview11.getHeaderView(0).findViewById<LinearLayout>(R.id.linearlayout00)
        headerimageview10 = navigationview11.getHeaderView(0).findViewById<ImageView>(R.id.imageview10)
        headertextview11 = navigationview11.getHeaderView(0).findViewById<TextView>(R.id.textview11)

        navigationview11.setNavigationItemSelectedListener(object : com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(argument0: android.view.MenuItem): Boolean {
                navigationController.startDestinationById(argument0.getItemId())

                return false
            } 
        })
        headertextview11.setText(loggedUser.getFirst_name())
        Glide.with(this@DashboardActivity)
            .load(loggedUser.getLinks().getAvatar().getHref())
            .into(headerimageview10)
        headerlinearlayout00.setOnClickListener(object : android.view.View.OnClickListener {
            override fun onClick(argument0: android.view.View) {
                navigationController.startUserDetailActivity(loggedUser)
            } 
        })
    }
}
