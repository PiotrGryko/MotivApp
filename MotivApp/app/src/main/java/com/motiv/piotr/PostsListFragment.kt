 
package com.motiv.piotr
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.*
import androidx.recyclerview.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage
import com.motiv.piotr.databinding.PostslistfragmentBinding
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlinx.android.synthetic.main.postslistfragment.*

public class PostsListFragment : Fragment() {

    private lateinit var postslistfragmentBinding: PostslistfragmentBinding

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

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

    private lateinit var recyclerview10: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    } override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View {
        postslistfragmentBinding = PostslistfragmentBinding.inflate(inflater)

        usersListAdapter = UsersListAdapter()
        postsListAdapter = PostsListAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        fragmentsPagerAdapter = FragmentsPagerAdapter(activity!!.getSupportFragmentManager())
        navigationController = NavigationController(activity!!)
        linearlayout00 = postslistfragmentBinding.linearlayout00
        recyclerview10 = postslistfragmentBinding.recyclerview10

        recyclerview10?.setLayoutManager(LinearLayoutManager(activity!!))

        recyclerview10?.setAdapter(postsListAdapter)
        goRestApi.getPostsList(object : com.motiv.piotr.OnResponseListener<com.motiv.piotr.PostsListResponse> {
            override fun onSuccess(argument0: com.motiv.piotr.PostsListResponse) {
                postsListAdapter.setData(argument0.getResult())
            } override fun onError(argument0: Exception) {
            } 
        })
        postsListAdapter.setOnItemClickListener(object : com.motiv.piotr.PostsListAdapter.OnItemClickListener {
            override fun onItemClick(argument0: Int, argument1: com.motiv.piotr.Post) {
                navigationController.startPostDetailsActivity(argument1)
            } 
        })

        return postslistfragmentBinding.getRoot()
    }
}
