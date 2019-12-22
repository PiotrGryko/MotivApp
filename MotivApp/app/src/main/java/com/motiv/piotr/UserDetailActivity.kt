 
package com.motiv.piotr
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.DaoRepositoryFactory
import com.motiv.piotr.dao.LocalStorage
import com.motiv.piotr.databinding.UserdetailactivityBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.userdetailactivity.*

public class UserDetailActivity : AppCompatActivity(), UserDetailActivityContract.View {

    private lateinit var userdetailactivityBinding: UserdetailactivityBinding

    private lateinit var user: com.motiv.piotr.User

    private lateinit var presenter: UserDetailActivityContract.Presenter

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsListAdapter: PostsListAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var fragmentsPagerAdapter: FragmentsPagerAdapter

    private lateinit var goRestApi: GoRestApi

    private lateinit var daoRepository: DaoRepository

    private lateinit var localStorage: LocalStorage

    private lateinit var navigationController: NavigationController

    private lateinit var linearlayout00: LinearLayout

    private lateinit var imageview10: ImageView

    private lateinit var textview11: TextView

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        userdetailactivityBinding = DataBindingUtil.setContentView(this, R.layout.userdetailactivity)

        user = com.motiv.piotr.User.fromJson(getIntent().getStringExtra("user"))

        usersListAdapter = UsersListAdapter()
        postsListAdapter = PostsListAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        fragmentsPagerAdapter = FragmentsPagerAdapter(this@UserDetailActivity.getSupportFragmentManager())
        daoRepository = DaoRepositoryFactory.getInstance(this@UserDetailActivity)
        localStorage = LocalStorage.getInstance(this@UserDetailActivity)
        navigationController = NavigationController(this@UserDetailActivity)
        goRestApi = GoRestApiFactory.getInstance(localStorage)
        linearlayout00 = userdetailactivityBinding.linearlayout00
        imageview10 = userdetailactivityBinding.imageview10
        textview11 = userdetailactivityBinding.textview11

        presenter = UserDetailActivityPresenter(this@UserDetailActivity, goRestApi, daoRepository, localStorage)

        Picasso.with(this@UserDetailActivity).load(user.getLinks().getAvatar().getHref()).into(imageview10)
        textview11.setText(user.getFirst_name())
    }
}
