 
package com.motiv.piotr
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage
import com.motiv.piotr.databinding.BottomnavigationactivityBinding
import kotlinx.android.synthetic.main.bottomnavigationactivity.*

public class BottomNavigationActivity : AppCompatActivity() {

    private lateinit var bottomnavigationactivityBinding: BottomnavigationactivityBinding

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
        bottomnavigationactivityBinding = DataBindingUtil.setContentView(this, R.layout.bottomnavigationactivity)

        usersListAdapter = UsersListAdapter()
        postsListAdapter = PostsListAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        fragmentsPagerAdapter = FragmentsPagerAdapter(this@BottomNavigationActivity.getSupportFragmentManager())
        localStorage = LocalStorage.getInstance(this@BottomNavigationActivity)
        navigationController = NavigationController(this@BottomNavigationActivity)
        goRestApi = GoRestApiFactory.getInstance(localStorage)
        relativelayout00 = bottomnavigationactivityBinding.relativelayout00
        bottomnavigationview11 = bottomnavigationactivityBinding.bottomnavigationview11

        bottomnavigationview11.setOnNavigationItemSelectedListener(object : com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(argument0: android.view.MenuItem): Boolean {
                navigationController.startDestinationById(argument0.getItemId())

                return false
            } 
        })
    }
}
