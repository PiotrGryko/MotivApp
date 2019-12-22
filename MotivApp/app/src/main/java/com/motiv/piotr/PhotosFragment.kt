 
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
import com.motiv.piotr.dao.DaoRepositoryFactory
import com.motiv.piotr.dao.LocalStorage
import com.motiv.piotr.databinding.PhotosfragmentBinding
import kotlin.collections.List
import kotlinx.android.synthetic.main.photosfragment.*

public class PhotosFragment : Fragment(), PhotosFragmentContract.View {

    private lateinit var photosfragmentBinding: PhotosfragmentBinding

    private lateinit var presenter: PhotosFragmentContract.Presenter

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsListAdapter: PostsListAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var fragmentsPagerAdapter: FragmentsPagerAdapter

    private lateinit var goRestApi: GoRestApi

    private lateinit var daoRepository: DaoRepository

    private lateinit var localStorage: LocalStorage

    private lateinit var navigationController: NavigationController

    private lateinit var linearlayout00: LinearLayout

    private lateinit var tablayout10: TabLayout

    private lateinit var viewpager11: ViewPager

    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View {
        photosfragmentBinding = PhotosfragmentBinding.inflate(inflater)

        usersListAdapter = UsersListAdapter()
        postsListAdapter = PostsListAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        fragmentsPagerAdapter = FragmentsPagerAdapter(activity!!.getSupportFragmentManager())
        daoRepository = DaoRepositoryFactory.getInstance(activity!!)
        localStorage = LocalStorage.getInstance(activity!!)
        navigationController = NavigationController(activity!!)
        goRestApi = GoRestApiFactory.getInstance(localStorage)
        linearlayout00 = photosfragmentBinding.linearlayout00
        tablayout10 = photosfragmentBinding.tablayout10
        viewpager11 = photosfragmentBinding.viewpager11
        presenter = PhotosFragmentPresenter(this@PhotosFragment, goRestApi, daoRepository, localStorage)

        viewpager11.setAdapter(photosPagerAdapter)
        presenter.goRestApigetPhotosList()

        return photosfragmentBinding.getRoot()
    } override fun photosPagerAdaptersetData(arg0: List<com.motiv.piotr.Photo>) {
        photosPagerAdapter.setData(arg0)
    }
}
