public class Pagination {
    // props
    private int mOffset;  // current offset (page number * limit)
    private int mLimit;   // items per page (limit)
    private int mTotal;   // total items available (count from API)
    private String mNextUrl; // URL for the next page, if available
    private String mPreviousUrl; // URL for the previous page, if available

    // constructor
    public Pagination(int offset, int limit, int total, String nextUrl, String previousUrl) {
        this.mOffset = offset;
        this.mLimit = limit;
        this.mTotal = total;
        this.mNextUrl = nextUrl;
        this.mPreviousUrl = previousUrl;
    }

    public Pagination() { // shortcut version where you pass new instances
        this(0, 0, 0, null, null);
    }

    // getters
    public int getOffset() {
        return mOffset;
    }

    public int getLimit() {
        return mLimit;
    }

    public int getTotal() {
        return mTotal;
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) mTotal / mLimit);
    }

    public String getNextUrl() {
        return mNextUrl;
    }

    public String getPreviousUrl() {
        return mPreviousUrl;
    }

    // optional convenience methods for checking the availability of next/prev pages
    public boolean hasNext() {
        return mNextUrl != null && !mNextUrl.isEmpty();
    }

    public boolean hasPrevious() {
        return mPreviousUrl != null && !mPreviousUrl.isEmpty();
    }

    // overrides
    @Override
    public String toString() {
        return "Pagination { offset=" + mOffset + ", limit=" + mLimit + ", total=" + mTotal 
                + ", nextUrl=" + mNextUrl + ", previousUrl=" + mPreviousUrl + " }";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pagination pagination = (Pagination) obj;
        return mOffset == pagination.mOffset && mLimit == pagination.mLimit && mTotal == pagination.mTotal
                && mNextUrl.equals(pagination.mNextUrl) && mPreviousUrl.equals(pagination.mPreviousUrl);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(mOffset);
        result = 31 * result + Integer.hashCode(mLimit);
        result = 31 * result + Integer.hashCode(mTotal);
        result = 31 * result + (mNextUrl != null ? mNextUrl.hashCode() : 0);
        result = 31 * result + (mPreviousUrl != null ? mPreviousUrl.hashCode() : 0);
        return result;
    }
}
