 
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
import kotlin.collections.List
import kotlinx.android.synthetic.main.postslistfragment.*

public class PostsListFragment : Fragment(), PostsListFragmentContract.View {

    private lateinit var presenter: PostsListFragmentContract.Presenter

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsListAdapter: PostsListAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var fragmentsPagerAdapter: FragmentsPagerAdapter

    private lateinit var goRestApi: GoRestApi

    private var daoRepository: DaoRepository = DaoRepositoryFactory.getInstance(activity!!)

    private lateinit var localStorage: LocalStorage

    private lateinit var navigationController: NavigationController

    private lateinit var linearlayout00: LinearLayout

    private lateinit var recyclerview10: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View {
        val v: View = inflater.inflate(R.layout.postslistfragment, parent, false)

        usersListAdapter = UsersListAdapter()
        postsListAdapter = PostsListAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        fragmentsPagerAdapter = FragmentsPagerAdapter(activity!!.getSupportFragmentManager())
        localStorage = LocalStorage.getInstance(activity!!)
        navigationController = NavigationController(activity!!)
        goRestApi = GoRestApiFactory.getInstance(localStorage)
        linearlayout00 = v.findViewById<LinearLayout>(R.id.linearlayout00)
        recyclerview10 = v.findViewById<RecyclerView>(R.id.recyclerview10)
        presenter = PostsListFragmentPresenter(this@PostsListFragment, goRestApi, daoRepository, localStorage)

        recyclerview10?.setLayoutManager(LinearLayoutManager(activity!!))

        recyclerview10?.setAdapter(postsListAdapter)
        presenter.goRestApigetPostsList()
        postsListAdapter.setOnItemClickListener(object : com.motiv.piotr.PostsListAdapter.OnItemClickListener {
            override fun onItemClick(argument0: Int, argument1: com.motiv.piotr.Post) {
                presenter.eloonItemClick(argument0, argument1)
            } 
        })

        return v
    } override fun postsListAdaptersetData(arg0: List<com.motiv.piotr.Post>) {
        postsListAdapter.setData(arg0)
    } override fun navigationControllerstartPostDetailsActivity(arg0: com.motiv.piotr.Post) {
        navigationController.startPostDetailsActivity(arg0)
    }
}
