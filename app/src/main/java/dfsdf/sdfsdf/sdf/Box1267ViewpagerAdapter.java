package dfsdf.sdfsdf.sdf;

import androidx.fragment.app.*;

public class Box1267ViewpagerAdapter extends FragmentStatePagerAdapter {

    public Box1267ViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {

        return 2;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new Box1267Page0();
            case 1:
                return new Box1267Page1();
        }
        throw new RuntimeException();
    }

    @Override
    public java.lang.String getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Box1267Page0";
            case 1:
                return "Box1267Page1";
        }
        return "";
    }
}
