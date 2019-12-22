 
package com.motiv.piotr
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import com.bumptech.glide.Glide
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage
import com.motiv.piotr.databinding.UserdetailactivityBinding
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlinx.android.synthetic.main.userdetailactivity.*

public class UserDetailActivity : AppCompatActivity(), UserDetailActivityContract.View, HasSupportFragmentInjector {

    private lateinit var userdetailactivityBinding: UserdetailactivityBinding

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var user: com.motiv.piotr.User

    private lateinit var presenter: UserDetailActivityContract.Presenter

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

    private lateinit var imageview10: ImageView

    private lateinit var textview11: TextView

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    } override fun onCreate(savedInstanceState: android.os.Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        userdetailactivityBinding = DataBindingUtil.setContentView(this, R.layout.userdetailactivity)

        user = com.motiv.piotr.User.fromJson(getIntent().getStringExtra("user"))

        usersListAdapter = UsersListAdapter()
        postsListAdapter = PostsListAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        fragmentsPagerAdapter = FragmentsPagerAdapter(this@UserDetailActivity.getSupportFragmentManager())
        navigationController = NavigationController(this@UserDetailActivity)
        linearlayout00 = userdetailactivityBinding.linearlayout00
        imageview10 = userdetailactivityBinding.imageview10
        textview11 = userdetailactivityBinding.textview11

        presenter = UserDetailActivityPresenter(this@UserDetailActivity, goRestApi, daoRepository, localStorage)

        Glide.with(this@UserDetailActivity)
            .load(user.getLinks().getAvatar().getHref())
            .into(imageview10)
        textview11.setText(user.getFirst_name())
    }
}
