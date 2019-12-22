 
package com.motiv.piotr
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage
import com.motiv.piotr.databinding.ViewpageractivityBinding
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlinx.android.synthetic.main.viewpageractivity.*

public class ViewPagerActivity : AppCompatActivity(), ViewPagerActivityContract.View, HasSupportFragmentInjector {

    private lateinit var viewpageractivityBinding: ViewpageractivityBinding

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var presenter: ViewPagerActivityContract.Presenter

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

    private lateinit var tablayout10: TabLayout

    private lateinit var viewpager11: ViewPager

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    } override fun onCreate(savedInstanceState: android.os.Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewpageractivityBinding = DataBindingUtil.setContentView(this, R.layout.viewpageractivity)

        usersListAdapter = UsersListAdapter()
        postsListAdapter = PostsListAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        fragmentsPagerAdapter = FragmentsPagerAdapter(this@ViewPagerActivity.getSupportFragmentManager())
        navigationController = NavigationController(this@ViewPagerActivity)
        linearlayout00 = viewpageractivityBinding.linearlayout00
        tablayout10 = viewpageractivityBinding.tablayout10
        viewpager11 = viewpageractivityBinding.viewpager11

        presenter = ViewPagerActivityPresenter(this@ViewPagerActivity, goRestApi, daoRepository, localStorage)

        viewpager11.setAdapter(fragmentsPagerAdapter)
    }
}
