package dfsdf.sdfsdf.sdf;

import androidx.fragment.app.*;

public class Box1280ViewpagerAdapter extends FragmentStatePagerAdapter {

    public Box1280ViewpagerAdapter(FragmentManager fm) {
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
                return new Box1280Page0();
            case 1:
                return new Box1280Page1();
            case 2:
                return new Box1280Page2();
        }
        throw new RuntimeException();
    }

    @Override
    public java.lang.String getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Box1280Page0";
            case 1:
                return "Box1280Page1";
            case 2:
                return "Box1280Page2";
        }
        return "";
    }
}
