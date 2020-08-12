package id.co.Aldiles.BandungBaratKuy;

public enum ModelObject {


    WISATA(R.string.wisata, R.layout.slider_wisata),
            ;

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}