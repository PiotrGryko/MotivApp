 
package com.motiv.piotr
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlinx.android.synthetic.main.postdetailsactivity.*

public class PostDetailsActivity : AppCompatActivity(), PostDetailsActivityContract.View, HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var post: com.motiv.piotr.Post

    private lateinit var presenter: PostDetailsActivityContract.Presenter

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

    private lateinit var textview10: TextView

    private lateinit var textview11: TextView

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    } override fun onCreate(savedInstanceState: android.os.Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.postdetailsactivity)

        post = com.motiv.piotr.Post.fromJson(getIntent().getStringExtra("post"))

        usersListAdapter = UsersListAdapter()
        postsListAdapter = PostsListAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        fragmentsPagerAdapter = FragmentsPagerAdapter(this@PostDetailsActivity.getSupportFragmentManager())
        navigationController = NavigationController(this@PostDetailsActivity)
        linearlayout00 = findViewById<LinearLayout>(R.id.linearlayout00)
        textview10 = findViewById<TextView>(R.id.textview10)
        textview11 = findViewById<TextView>(R.id.textview11)

        presenter = PostDetailsActivityPresenter(this@PostDetailsActivity, goRestApi, daoRepository, localStorage)

        textview10.setText(post.getTitle())
        textview11.setText(post.getBody())
    }
}
