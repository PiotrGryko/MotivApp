 
package com.motiv.piotr
import androidx.fragment.app.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*

public class FragmentsPagerAdapter(val fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int {
        return 3
    } override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return UsersListFragment()
            1 -> return PostsListFragment()
            2 -> return PhotosFragment()
        }
        throw RuntimeException()
    } override fun getPageTitle(position: Int): String {
        when (position) {
            0 -> return "UsersListFragment"
            1 -> return "PostsListFragment"
            2 -> return "PhotosFragment"
        }
        return ""
    }
}
