 
package com.motiv.piotr
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.*
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage
import kotlinx.android.synthetic.main.photosfragment.*

public class PhotosFragment : Fragment() {

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsListAdapter: PostsListAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var fragmentsPagerAdapter: FragmentsPagerAdapter

    private lateinit var goRestApi: GoRestApi

    private var daoRepository: DaoRepository = DaoRepositoryFactory.getInstance(activity!!)

    private lateinit var localStorage: LocalStorage

    private lateinit var navigationController: NavigationController

    private lateinit var linearlayout00: LinearLayout

    private lateinit var tablayout10: TabLayout

    private lateinit var viewpager11: ViewPager

    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View {
        val v: View = inflater.inflate(R.layout.photosfragment, parent, false)

        usersListAdapter = UsersListAdapter()
        postsListAdapter = PostsListAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        fragmentsPagerAdapter = FragmentsPagerAdapter(activity!!.getSupportFragmentManager())
        localStorage = LocalStorage.getInstance(activity!!)
        navigationController = NavigationController(activity!!)
        goRestApi = GoRestApiFactory.getInstance(localStorage)
        linearlayout00 = v.findViewById<LinearLayout>(R.id.linearlayout00)
        tablayout10 = v.findViewById<TabLayout>(R.id.tablayout10)
        viewpager11 = v.findViewById<ViewPager>(R.id.viewpager11)

        viewpager11.setAdapter(photosPagerAdapter)
        goRestApi.getPhotosList(object : com.motiv.piotr.OnResponseListener<com.motiv.piotr.PhotosListResponse> {
            override fun onSuccess(argument0: com.motiv.piotr.PhotosListResponse) {
                photosPagerAdapter.setData(argument0.getResult())
            } override fun onError(argument0: Exception) {
            } 
        })

        return v
    }
}
