 
package com.motiv.piotr
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.DaoRepositoryFactory
import com.motiv.piotr.dao.LocalStorage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.userdetailactivity.*

public class UserDetailActivity : AppCompatActivity() {

    private lateinit var user: com.motiv.piotr.User

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
        setContentView(R.layout.userdetailactivity)

        user = com.motiv.piotr.User.fromJson(getIntent().getStringExtra("user"))

        usersListAdapter = UsersListAdapter()
        postsListAdapter = PostsListAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        fragmentsPagerAdapter = FragmentsPagerAdapter(this@UserDetailActivity.getSupportFragmentManager())
        daoRepository = DaoRepositoryFactory.getInstance(this@UserDetailActivity)
        localStorage = LocalStorage.getInstance(this@UserDetailActivity)
        navigationController = NavigationController(this@UserDetailActivity)
        goRestApi = GoRestApiFactory.getInstance(localStorage)
        linearlayout00 = findViewById<LinearLayout>(R.id.linearlayout00)
        imageview10 = findViewById<ImageView>(R.id.imageview10)
        textview11 = findViewById<TextView>(R.id.textview11)

        Picasso.with(this@UserDetailActivity).load(user.getLinks().getAvatar().getHref()).into(imageview10)
        textview11.setText(user.getFirst_name())
    }
}
