package dfsdf.sdfsdf.sdf;

import android.app.Activity;
import android.content.Intent;

public class NavigationController {

    private Activity context;
    private static NavigationController instance;

    public NavigationController(Activity context) {
        this.context = context;
    }

    public void startHome() {

        Intent intent = new Intent(context, Home.class);

        context.startActivity(intent);
    }

    public void startSignIn() {

        Intent intent = new Intent(context, SignIn.class);

        context.startActivity(intent);
    }

    public void startSignUp() {

        Intent intent = new Intent(context, SignUp.class);

        context.startActivity(intent);
    }

    public void startOnboarding() {

        Intent intent = new Intent(context, Onboarding.class);

        context.startActivity(intent);
    }

    public void startSmoothiesList() {

        Intent intent = new Intent(context, SmoothiesList.class);

        context.startActivity(intent);
    }

    public void startRedFruit() {

        Intent intent = new Intent(context, RedFruit.class);

        context.startActivity(intent);
    }

    public void startPlacingOrder() {

        Intent intent = new Intent(context, PlacingOrder.class);

        context.startActivity(intent);
    }

    public void startMyOrders() {

        Intent intent = new Intent(context, MyOrders.class);

        context.startActivity(intent);
    }

    public void startConfirmOrder() {

        Intent intent = new Intent(context, ConfirmOrder.class);

        context.startActivity(intent);
    }

    public void startChooseItems() {

        Intent intent = new Intent(context, ChooseItems.class);

        context.startActivity(intent);
    }
}
