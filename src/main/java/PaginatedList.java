// class to handle list of things with a pagination meta

import java.util.ArrayList;
import java.util.List;

// map {
//     PaginatedList(
//         pagination = Pagination(it.count, it.next, it.previous),
//         list = it.results
//     )
// }
public class PaginatedList<T> implements BaseList<T> {
    private Pagination mPagination; // Holds pagination information like count, next, previous, pagination class state manager
    private List<T> mList;           // Holds the list of Berry objects (or whatever the generic type is), built in list that holds item T generic
    // constructors
    public PaginatedList(Pagination pagination, List<T> list) { // classic version with all params
        mPagination = pagination;
        mList = new ArrayList<>(); // create new List class instance and populate with passed in list
        if (list != null) mList.addAll(list);
    }
    public PaginatedList() { // shortcut version where you pass new instances
        this(new Pagination(), new ArrayList<T>());
    }
    public PaginatedList(Builder builder) { // builder constructor
        mPagination = builder.mPagination;
        mList = new ArrayList<>(builder.mList.size()); // this is for optimization u can just pass it in normally np
        mList.addAll(builder.mList);
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
    public boolean isNextPageAvailable() {
        return mPagination.getNextUrl() != null && !mPagination.getNextUrl().isEmpty();
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
        // constructors
        public Builder() {
            mList = new ArrayList<>();
        }
        public Builder(PaginatedList<T> incomingPaginatedList) {
            mList = new ArrayList<>();
            mList.addAll(incomingPaginatedList.getList()); // could just pass in immediately too btw
            mPagination = incomingPaginatedList.getPagination();
        }
        // building abilities
        public Builder setList(List<T> list) {
            mList = list;
            return this;
        }
        public Builder setPagination (Pagination pagination) {
            mPagination = pagination;
            return this;
        }
        public PaginatedList build() {return new PaginatedList(this);}
    }
}