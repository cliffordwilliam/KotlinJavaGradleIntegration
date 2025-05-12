// Pagination state manager class with useful methods

public class Pagination {
    // props
    private long mTotal; // total items in db
    private int mCurrentPage; // current offset
    private int mTotalPage; // total pages depending on my limit
    private int mPerPage; // the limit
    private int mTotalCurrent; // not sure maybe the total items in current page?
    // constructors
    public Pagination(long total, int currentPage, int totalPage, int perPage, int totalCurrent) {  // classic all props
        this.mTotal = total;
        this.mCurrentPage = currentPage;
        this.mTotalPage = totalPage;
        this.mPerPage = perPage;
        this.mTotalCurrent = totalCurrent;
    };
    public Pagination() {  // optional shortcut all 0 props, calling the above all classic version
        this(0, 0, 0, 0, 0);
    }
    public Pagination(long total, int currentPage, int perPage) {  // what is this?
        this.mTotal = total;
        this.mCurrentPage = currentPage;
        // this.mTotalPage = totalPage;
        this.mPerPage = perPage;
        // this.mTotalCurrent = totalCurrent;
        if (total == 0) {
            mTotalPage = 1;
        } else {
            mTotalPage = (int) Math.ceil((double) total / perPage);
        }
    };
    // getters
    public long getTotal() {
        return mTotal;
    }
    public int getCurrentPage() {
        return mCurrentPage;
    }
    public int getTotalPage() {
        return mTotalPage;
    }
    public int getPerPage() {
        return mPerPage;
    }
    public int getTotalCurrent() {
        return mTotalCurrent;
    }
    // overrides
    // my str representation for log or testing
    @Override
    public String toString() {
        return "Total: " + mTotal;
    }
    // use this when using this class as key, this is for quick lookups
    @Override
    public boolean equals(Object givenObject) {
        if (this == givenObject) { // point to same mem?
            return true;
        }
        if (givenObject == null || getClass() != givenObject.getClass()) { // made from same class? from adsdsa = new Pagination();
            return false; // not like its a kid of it so its ok, that is not the case here, must be exact same
        }
        Pagination pagination = (Pagination) givenObject; // cast Object type to Pagination type like TS to new variable pagination
        if (mTotal != pagination.mTotal) {
            return false;
        }
        if (mCurrentPage != pagination.mCurrentPage) {
            return false;
        }
        if (mTotalPage != pagination.mTotalPage) {
            return false;
        }
        if (mPerPage != pagination.mPerPage) {
            return false;
        }
        return mTotalCurrent == pagination.mTotalCurrent;
        // if (mTotalCurrent != pagination.mTotalCurrent) {
        //     return false;
        // }
        // return true;
    }
    @Override
    public int hashCode() {
        int result = (int) (mTotal ^ (mTotal >>> 32)); // we need all props in int, convert long to int
        result = 31 * result + mCurrentPage; // not collision free perfect but to combine props into hash gotta accumulate and multiply by 31
        result = 31 * result + mTotalPage; // so turn all to int, then combine all prop with 31 multiplier to make unique class hash msg dig
        result = 31 * result + mPerPage;
        result = 31 * result + mTotalCurrent;
        return result;
    }
}
