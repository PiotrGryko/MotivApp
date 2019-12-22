 
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
import com.motiv.piotr.dao.DaoRepositoryFactory
import com.motiv.piotr.dao.LocalStorage
import com.motiv.piotr.databinding.UserslistfragmentBinding
import kotlinx.android.synthetic.main.userslistfragment.*

public class UsersListFragment : Fragment() {

    private lateinit var userslistfragmentBinding: UserslistfragmentBinding

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsListAdapter: PostsListAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var fragmentsPagerAdapter: FragmentsPagerAdapter

    private lateinit var goRestApi: GoRestApi

    private lateinit var daoRepository: DaoRepository

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
        daoRepository = DaoRepositoryFactory.getInstance(activity!!)
        localStorage = LocalStorage.getInstance(activity!!)
        navigationController = NavigationController(activity!!)
        goRestApi = GoRestApiFactory.getInstance(localStorage)
        linearlayout00 = userslistfragmentBinding.linearlayout00
        recyclerview10 = userslistfragmentBinding.recyclerview10

        recyclerview10?.setLayoutManager(LinearLayoutManager(activity!!))

        recyclerview10?.setAdapter(usersListAdapter)
        goRestApi.getUsersList(object : com.motiv.piotr.OnResponseListener<com.motiv.piotr.UsersListResponse> {
            override fun onSuccess(argument0: com.motiv.piotr.UsersListResponse) {
                usersListAdapter.setData(argument0.getResult())
            } override fun onError(argument0: Exception) {
            } 
        })
        usersListAdapter.setOnItemClickListener(object : com.motiv.piotr.UsersListAdapter.OnItemClickListener {
            override fun onItemClick(argument0: Int, argument1: com.motiv.piotr.User) {
                navigationController.startUserDetailActivity(argument1)
            } 
        })

        return userslistfragmentBinding.getRoot()
    }
}
