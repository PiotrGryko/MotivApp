 
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
import com.motiv.piotr.databinding.UserslistfragmentBinding
import kotlin.collections.List
import kotlinx.android.synthetic.main.userslistfragment.*

public class UsersListFragment : Fragment(), UsersListFragmentContract.View {

    private lateinit var userslistfragmentBinding: UserslistfragmentBinding

    private lateinit var presenter: UsersListFragmentContract.Presenter

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
        userslistfragmentBinding = UserslistfragmentBinding.inflate(inflater)

        usersListAdapter = UsersListAdapter()
        postsListAdapter = PostsListAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        fragmentsPagerAdapter = FragmentsPagerAdapter(activity!!.getSupportFragmentManager())
        localStorage = LocalStorage.getInstance(activity!!)
        navigationController = NavigationController(activity!!)
        goRestApi = GoRestApiFactory.getInstance(localStorage)
        linearlayout00 = userslistfragmentBinding.linearlayout00
        recyclerview10 = userslistfragmentBinding.recyclerview10
        presenter = UsersListFragmentPresenter(this@UsersListFragment, goRestApi, daoRepository, localStorage)

        recyclerview10?.setLayoutManager(LinearLayoutManager(activity!!))

        recyclerview10?.setAdapter(usersListAdapter)
        presenter.goRestApigetUsersList()
        usersListAdapter.setOnItemClickListener(object : com.motiv.piotr.UsersListAdapter.OnItemClickListener {
            override fun onItemClick(argument0: Int, argument1: com.motiv.piotr.User) {
                presenter.eloonItemClick(argument0, argument1)
            } 
        })

        return userslistfragmentBinding.getRoot()
    } override fun usersListAdaptersetData(arg0: List<com.motiv.piotr.User>) {
        usersListAdapter.setData(arg0)
    } override fun navigationControllerstartUserDetailActivity(arg0: com.motiv.piotr.User) {
        navigationController.startUserDetailActivity(arg0)
    }
}
