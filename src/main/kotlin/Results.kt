// class that represent retrofit responses

// sealed = my kids are the ones defined in me only!
// out = T is for init only, methods in me cannot use T as its param
sealed class Results<out T : Any> {
    // success kid
    class Success<out T : Any>(val data: T) : Results<T>()
    // empty kid stateless singleton, Nothing class is kid of all
    object Empty : Results<Nothing>()
    // error kid
    class Error(val exception: Throwable) : Results<Nothing>()
    // success? call map method, else return as is
    fun <R: Any> map(map: T.() -> R): Results<R> {
        return when(this) {
            is Success -> Success(data.map())
            is Empty -> Empty
            is Error -> Error(exception)
        }
    }
}

// Note
// remember that this means class parameter, we say param is T, like func param, sealed class Results<out T : Any>
// know that when you see ": Results<T>()" it means Pass T from kid Success to parent Results generic param class
// so when u see this "Results<Nothing>()" it just means we pass Nothing class (which is kid of all) to parent Result param T generic
// this is lambda "map: T.() -> R is a lambda"
// where you delegate the logic outside, you can define it immediately after calling the map method, or have the class itself have a method to transform itself
// fun <R: Any> map(map: T.() -> R): Results<R> {
// this function is called map
// Func takes param R generic class
// it takes a func, T.() -> R
// said func is applied on T class to turn it into R class
// Results<R> means this func returns Result class and pass the R into its param generic
// "when" is switch statement
// "this" is self in python, like self is of type Success? Empty?