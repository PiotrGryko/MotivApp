 
package com.motiv.piotr
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage
import com.motiv.piotr.databinding.PostdetailsactivityBinding
import kotlinx.android.synthetic.main.postdetailsactivity.*

public class PostDetailsActivity : AppCompatActivity() {

    private lateinit var postdetailsactivityBinding: PostdetailsactivityBinding

    private lateinit var post: com.motiv.piotr.Post

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsListAdapter: PostsListAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var fragmentsPagerAdapter: FragmentsPagerAdapter

    private lateinit var goRestApi: GoRestApi

    private var daoRepository: DaoRepository = DaoRepositoryFactory.getInstance(this@PostDetailsActivity)

    private lateinit var localStorage: LocalStorage

    private lateinit var navigationController: NavigationController

    private lateinit var linearlayout00: LinearLayout

    private lateinit var textview10: TextView

    private lateinit var textview11: TextView

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        postdetailsactivityBinding = DataBindingUtil.setContentView(this, R.layout.postdetailsactivity)

        post = com.motiv.piotr.Post.fromJson(getIntent().getStringExtra("post"))

        usersListAdapter = UsersListAdapter()
        postsListAdapter = PostsListAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        fragmentsPagerAdapter = FragmentsPagerAdapter(this@PostDetailsActivity.getSupportFragmentManager())
        localStorage = LocalStorage.getInstance(this@PostDetailsActivity)
        navigationController = NavigationController(this@PostDetailsActivity)
        goRestApi = GoRestApiFactory.getInstance(localStorage)
        linearlayout00 = postdetailsactivityBinding.linearlayout00
        textview10 = postdetailsactivityBinding.textview10
        textview11 = postdetailsactivityBinding.textview11

        textview10.setText(post.getTitle())
        textview11.setText(post.getBody())
    }
}
