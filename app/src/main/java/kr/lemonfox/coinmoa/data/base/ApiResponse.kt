package kr.lemonfox.coinmoa.data.base

data class ApiResponse<out T> (val status: Status, val responseData: T?, val errorCode: Int?){  // TODO: ApiError class 추가
    enum class Status {
        SUCCESS, ERROR
    }
    companion object {
        fun <T> success(responseData: T?): ApiResponse<T> {
            return ApiResponse(Status.SUCCESS, responseData,null)
        }
        fun <T> error(errorCode: Int?): ApiResponse<T> {
            return ApiResponse(Status.ERROR, null, errorCode)
        }
    }
}