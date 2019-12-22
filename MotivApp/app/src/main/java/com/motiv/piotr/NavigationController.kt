 
package com.motiv.piotr
import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.navigation.Navigation

public class NavigationController {

    private var context: Activity

    private var view: View? = null

    constructor(context: Activity) {
        this.context = context
        this.view = context.findViewById(R.id.nav_host_fragment)
    }

    fun startUsersListFragment() {
        Navigation.findNavController(view!!).navigate(R.id.UsersListFragment)
    } fun startDashboardActivity(loggedUser: com.motiv.piotr.User) {
        val intent = Intent(context, DashboardActivity::class.java)
        intent.putExtra("loggedUser", com.motiv.piotr.User.toJson(loggedUser))

        context.startActivity(intent)
    } fun startUserDetailActivity(user: com.motiv.piotr.User) {
        val intent = Intent(context, UserDetailActivity::class.java)
        intent.putExtra("user", com.motiv.piotr.User.toJson(user))

        context.startActivity(intent)
    } fun startPostsListFragment() {
        Navigation.findNavController(view!!).navigate(R.id.PostsListFragment)
    } fun startPostDetailsActivity(post: com.motiv.piotr.Post) {
        val intent = Intent(context, PostDetailsActivity::class.java)
        intent.putExtra("post", com.motiv.piotr.Post.toJson(post))

        context.startActivity(intent)
    } fun startPhotosFragment() {
        Navigation.findNavController(view!!).navigate(R.id.PhotosFragment)
    } fun startBottomNavigationActivity() {
        val intent = Intent(context, BottomNavigationActivity::class.java)

        context.startActivity(intent)
    } fun startViewPagerActivity() {
        val intent = Intent(context, ViewPagerActivity::class.java)

        context.startActivity(intent)
    } fun startDestinationById(id: Int?) {
        if (id == R.id.BottomNavigationActivity) {
            val intent = Intent(context, BottomNavigationActivity::class.java)
            context.startActivity(intent)
        }

        if (id == R.id.ViewPagerActivity) {
            val intent = Intent(context, ViewPagerActivity::class.java)
            context.startActivity(intent)
        }

        if (id == R.id.UsersListFragment) {
            Navigation.findNavController(view!!).navigate(R.id.UsersListFragment)
        }

        if (id == R.id.PostsListFragment) {
            Navigation.findNavController(view!!).navigate(R.id.PostsListFragment)
        }

        if (id == R.id.PhotosFragment) {
            Navigation.findNavController(view!!).navigate(R.id.PhotosFragment)
        }
    }
}
