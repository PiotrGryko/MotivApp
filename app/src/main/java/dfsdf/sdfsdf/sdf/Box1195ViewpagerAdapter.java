package dfsdf.sdfsdf.sdf;

import androidx.fragment.app.*;

public class Box1195ViewpagerAdapter extends FragmentStatePagerAdapter {

    public Box1195ViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {

        return 3;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new Box1195Page0();
            case 1:
                return new Box1195Page1();
            case 2:
                return new Box1195Page2();
        }
        throw new RuntimeException();
    }

    @Override
    public java.lang.String getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Box1195Page0";
            case 1:
                return "Box1195Page1";
            case 2:
                return "Box1195Page2";
        }
        return "";
    }
}
