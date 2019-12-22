 
package com.motiv.piotr.di
import androidx.fragment.app.*
import com.motiv.piotr.BottomNavigationActivity
import com.motiv.piotr.DashboardActivity
import com.motiv.piotr.MainActivity
import com.motiv.piotr.PhotosFragment
import com.motiv.piotr.PostDetailsActivity
import com.motiv.piotr.PostsListFragment
import com.motiv.piotr.UserDetailActivity
import com.motiv.piotr.UsersListFragment
import com.motiv.piotr.ViewPagerActivity
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
@Module
public abstract class AppContributions {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity@ContributesAndroidInjector
    abstract fun contributeDashboardActivity(): DashboardActivity@ContributesAndroidInjector
    abstract fun contributeUserDetailActivity(): UserDetailActivity@ContributesAndroidInjector
    abstract fun contributePostDetailsActivity(): PostDetailsActivity@ContributesAndroidInjector
    abstract fun contributeBottomNavigationActivity(): BottomNavigationActivity@ContributesAndroidInjector
    abstract fun contributeViewPagerActivity(): ViewPagerActivity@ContributesAndroidInjector
    abstract fun contributeUsersListFragment(): UsersListFragment@ContributesAndroidInjector
    abstract fun contributePostsListFragment(): PostsListFragment@ContributesAndroidInjector
    abstract fun contributePhotosFragment(): PhotosFragment
}
