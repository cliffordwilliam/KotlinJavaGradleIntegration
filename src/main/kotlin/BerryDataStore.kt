// interface shape for alll berry data store methods

interface BerryDataStore {
    fun getBerries(
        pagingParam: PagingParam,
    ): Results<PaginatedList<Berry>>
}