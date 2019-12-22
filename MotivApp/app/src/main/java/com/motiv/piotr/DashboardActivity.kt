 
package com.motiv.piotr
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage
import com.motiv.piotr.databinding.DashboardactivityBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.dashboardactivity.*

public class DashboardActivity : AppCompatActivity(), DashboardActivityContract.View {

    private lateinit var dashboardactivityBinding: DashboardactivityBinding

    private lateinit var loggedUser: com.motiv.piotr.User

    private lateinit var presenter: DashboardActivityContract.Presenter

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsListAdapter: PostsListAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var fragmentsPagerAdapter: FragmentsPagerAdapter

    private lateinit var goRestApi: GoRestApi

    private var daoRepository: DaoRepository = DaoRepositoryFactory.getInstance(this@DashboardActivity)

    private lateinit var localStorage: LocalStorage

    private lateinit var navigationController: NavigationController

    private lateinit var drawerlayout00: DrawerLayout

    private lateinit var navigationview11: NavigationView

    private lateinit var headerlinearlayout00: LinearLayout

    private lateinit var headerimageview10: ImageView

    private lateinit var headertextview11: TextView

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        dashboardactivityBinding = DataBindingUtil.setContentView(this, R.layout.dashboardactivity)

        loggedUser = com.motiv.piotr.User.fromJson(getIntent().getStringExtra("loggedUser"))

        usersListAdapter = UsersListAdapter()
        postsListAdapter = PostsListAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        fragmentsPagerAdapter = FragmentsPagerAdapter(this@DashboardActivity.getSupportFragmentManager())
        localStorage = LocalStorage.getInstance(this@DashboardActivity)
        navigationController = NavigationController(this@DashboardActivity)
        goRestApi = GoRestApiFactory.getInstance(localStorage)
        drawerlayout00 = dashboardactivityBinding.drawerlayout00
        navigationview11 = dashboardactivityBinding.navigationview11
        headerlinearlayout00 = navigationview11.getHeaderView(0).findViewById<LinearLayout>(R.id.linearlayout00)
        headerimageview10 = navigationview11.getHeaderView(0).findViewById<ImageView>(R.id.imageview10)
        headertextview11 = navigationview11.getHeaderView(0).findViewById<TextView>(R.id.textview11)

        presenter = DashboardActivityPresenter(this@DashboardActivity, goRestApi, daoRepository, localStorage)

        navigationview11.setNavigationItemSelectedListener(object : com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(argument0: android.view.MenuItem): Boolean {
                presenter.eloonNavigationItemSelected(argument0)

                return false
            } 
        })
        headertextview11.setText(loggedUser.getFirst_name())

        Picasso.with(this@DashboardActivity).load(loggedUser.getLinks().getAvatar().getHref()).into(headerimageview10)
        headerlinearlayout00.setOnClickListener(object : android.view.View.OnClickListener {
            override fun onClick(argument0: android.view.View) {
                presenter.eloonClick(argument0)
            } 
        })
    } override fun navigationControllerstartDestinationById(arg0: Int) {
        navigationController.startDestinationById(arg0)
    } override fun navigationControllerstartUserDetailActivity(arg0: com.motiv.piotr.User) {
        navigationController.startUserDetailActivity(arg0)
    } override fun getloggedUser(): com.motiv.piotr.User {
        return loggedUser
    }
}
