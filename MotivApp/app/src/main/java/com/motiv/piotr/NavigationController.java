package com.motiv.piotr;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

public class NavigationController {

    private Activity context;
    private View view;
    private static NavigationController instance;

    public NavigationController(Activity context) {
        this.context = context;
        this.view = context.findViewById(R.id.nav_host_fragment);
    }

    public void startUsersListFragment() {
        Navigation.findNavController(view).navigate(R.id.UsersListFragment);
    }

    public void startDashboardActivity(com.motiv.piotr.User loggedUser) {

        Intent intent = new Intent(context, DashboardActivity.class);
        intent.putExtra("loggedUser", com.motiv.piotr.User.toJson(loggedUser));

        context.startActivity(intent);
    }

    public void startUserDetailActivity(com.motiv.piotr.User user) {

        Intent intent = new Intent(context, UserDetailActivity.class);
        intent.putExtra("user", com.motiv.piotr.User.toJson(user));

        context.startActivity(intent);
    }

    public void startPostsListFragment() {
        Navigation.findNavController(view).navigate(R.id.PostsListFragment);
    }

    public void startPostDetailsActivity(com.motiv.piotr.Post post) {

        Intent intent = new Intent(context, PostDetailsActivity.class);
        intent.putExtra("post", com.motiv.piotr.Post.toJson(post));

        context.startActivity(intent);
    }

    public void startPhotosFragment() {
        Navigation.findNavController(view).navigate(R.id.PhotosFragment);
    }

    public void startBottomNavigationActivity() {

        Intent intent = new Intent(context, BottomNavigationActivity.class);

        context.startActivity(intent);
    }

    public void startViewPagerActivity() {

        Intent intent = new Intent(context, ViewPagerActivity.class);

        context.startActivity(intent);
    }

    public void startDestinationById(@Nullable int id) {

        if (id == R.id.BottomNavigationActivity) {
            Intent intent = new Intent(context, BottomNavigationActivity.class);
            context.startActivity(intent);
        }

        if (id == R.id.ViewPagerActivity) {
            Intent intent = new Intent(context, ViewPagerActivity.class);
            context.startActivity(intent);
        }

        if (id == R.id.UsersListFragment) {
            Navigation.findNavController(view).navigate(R.id.UsersListFragment);
        }

        if (id == R.id.PostsListFragment) {
            Navigation.findNavController(view).navigate(R.id.PostsListFragment);
        }

        if (id == R.id.PhotosFragment) {
            Navigation.findNavController(view).navigate(R.id.PhotosFragment);
        }
    }
}
