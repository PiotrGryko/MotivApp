 
package com.motiv.piotr
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage
import com.motiv.piotr.databinding.ViewpageractivityBinding
import kotlinx.android.synthetic.main.viewpageractivity.*

public class ViewPagerActivity : AppCompatActivity() {

    private lateinit var viewpageractivityBinding: ViewpageractivityBinding

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsListAdapter: PostsListAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var fragmentsPagerAdapter: FragmentsPagerAdapter

    private lateinit var goRestApi: GoRestApi

    private var daoRepository: DaoRepository = DaoRepositoryFactory.getInstance(this@ViewPagerActivity)

    private lateinit var localStorage: LocalStorage

    private lateinit var navigationController: NavigationController

    private lateinit var linearlayout00: LinearLayout

    private lateinit var tablayout10: TabLayout

    private lateinit var viewpager11: ViewPager

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        viewpageractivityBinding = DataBindingUtil.setContentView(this, R.layout.viewpageractivity)

        usersListAdapter = UsersListAdapter()
        postsListAdapter = PostsListAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        fragmentsPagerAdapter = FragmentsPagerAdapter(this@ViewPagerActivity.getSupportFragmentManager())
        localStorage = LocalStorage.getInstance(this@ViewPagerActivity)
        navigationController = NavigationController(this@ViewPagerActivity)
        goRestApi = GoRestApiFactory.getInstance(localStorage)
        linearlayout00 = viewpageractivityBinding.linearlayout00
        tablayout10 = viewpageractivityBinding.tablayout10
        viewpager11 = viewpageractivityBinding.viewpager11

        viewpager11.setAdapter(fragmentsPagerAdapter)
    }
}
