// class to represent be endpoint url pagination params (page and limit)

import java.util.HashMap;
import java.util.Map;

public class PagingParam {
    // Properties (page and limit values)
    private int mPage = 0;
    private int mLimit = 0;

    // Constructors
    public PagingParam(int page) {
        this(page, 0);  // Only page, default limit to 0
    }
    public PagingParam(int page, int limit) {
        mPage = page;
        mLimit = limit;  // Both page and limit set explicitly
    }

    // Getters
    public int getLimit() {
        return mLimit;
    }
    public int getPage() {
        return mPage;
    }

    // Abilities (Methods)
    public Map<String, String> toMap() {
        // Converts page and limit to query parameters (page and limit as string key-value pairs)
        Map<String, String> map = new HashMap<>();
        if (mPage > 0) {
            map.put("page", String.valueOf(mPage));
        }
        if (mLimit > 0) {
            map.put("limit", String.valueOf(mLimit));
        }
        return map;
    }

    public static boolean isFirstPage(PagingParam pagingParam) {
        // Checks if it's the first page (page 1)
        return (pagingParam == null || pagingParam.getPage() == 1);
    }

    @Override
    public boolean equals(Object givenObj) {
        // Defines equality based on page and limit values (important for map key comparison)
        if (this == givenObj) {
            return true;
        }
        if (givenObj == null || getClass() != givenObj.getClass()) {
            return false;
        }
        PagingParam that = (PagingParam) givenObj;
        return mPage == that.mPage && mLimit == that.mLimit;
    }

    @Override
    public int hashCode() {
        // Defines the hash code based on page and limit (important for map key storage)
        int result = mPage;
        result = 31 * result + mLimit;
        return result;
    }

    @Override
    public String toString() {
        // Provides a string representation of the object for debugging or logging
        return "PagingParam{" + "mPage=" + mPage + ", mLimit=" + mLimit + "}";
    }
}
