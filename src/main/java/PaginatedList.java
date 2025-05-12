// class to handle list of things with a pagination meta

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;


public class PaginatedList<T> implements BaseList<T> {
    // props (grab from raw json by key like "a")
    @SerializedName("a")
    private Pagination mPagination; // pagination class state manager
    @SerializedName("b")
    private List<T> mList; // built in list that holds item T generic
    // constructors
    public PaginatedList(Pagination pagination, List<T> list) { // classic version with all params
        mPagination = pagination;
        mList = new ArrayList<>(); // create new List class instance and populate with passed in list
        if (list != null) mList.addAll(list);
    }
    public PaginatedList() { // shortcut version where you pass new instances
        this(new Pagination(), new ArrayList<T>());
    }
    // getter
    public Pagination getPagination() {
        return mPagination;
    }
    // abilities
    public void add(PaginatedList<T> newPaginatedList) { // dump incoming instance to update my props
        mPagination = newPaginatedList.getPagination(); // dump incoming pagination state manager props to mine
        mList.addAll(newPaginatedList.getList()); // dump incoming items to my collection
    }
    public void set(PaginatedList<T> newPaginatedList) { // pass me a new instance of me
        clearList(); // reset my props
        add(newPaginatedList); // dump incoming instance to update my props
    }
    // overrides
    @Override
    public String toString() {
        return "PaginatedList{" + "mPagination=" + mPagination + ", mList" + mList + "}"; // my str representation for test or debug
    }
    @Override
    public int size() {
        return mList.size(); // list is a built in class, use its built in method
    }
    @Override
    public boolean isEmpty() {
        return mList.isEmpty(); // list is a built in class, use its built in method
    }
    @Override
    public T get(int position) {
        return mList.get(position); // list is a built in class, use its built in method
    }
    @Override
    public T remove(int position) {
        return mList.remove(position); // list is a built in class, use its built in method
    }
    @Override
    public void insert(int position, T item) { // push or append
        if (position >= mList.size()) {
            mList.add(item);
        } else {
            mList.add(position, item);
        }
    }
    @Override
    public List<T> getList() {
        return new ArrayList<>(mList); // return a new built-in list instance
    }
    @Override
    public void clearList() { // reset my props
        mList.clear();
        mPagination = new Pagination();
    }
    @Override
    public boolean isNextPageAvailable() { // we still have more pages in front?
        return mPagination.getCurrentPage() < mPagination.getTotalPage();
    }
    @Override
    public boolean equals(Object incomObject) {
        if (this == incomObject) { // same hash?
            return true;
        }
        if (incomObject == null || getClass() != incomObject.getClass()) { // made by same class blueprint?
            return false;
        }
        PaginatedList<?> that = (PaginatedList<?>) incomObject;
        if (!ObjectUtils.equals(mPagination, that.mPagination)) { // same pagination state manager class?
            return false;
        }
        return ObjectUtils.equals(mList, that.mList); // same built in list with same items class?
    }
    // builder
    public static final class Builder<T> {
        // props
        private Pagination mPagination;
        private List<T> mList;
        public Builder() {
            mList = new ArrayList<>();
        }
        
    }
}