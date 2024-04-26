package rules



data class HandlingResult(val status : Boolean = false,val message: String? = null){

}

object ErrorHandling
{
    fun checkUserName(userName:String):HandlingResult{
        return HandlingResult(
            (userName.isNotEmpty() && userName.length>=4),
            if (userName.isNotEmpty() && userName.length < 4) "Username must be at least 4 characters long." else null
            )

    }

    fun checkEmail(email:String): HandlingResult{
        return HandlingResult(
            (email.isNotEmpty() && email.length>=4),
            if (email.isNotEmpty() && email.length < 4) "Email must be at least 4 characters long." else null
        )
    }

    fun checkPassword(password:String) : HandlingResult{
        return HandlingResult(
            (password.isNotEmpty() && password.length>=6),
            if (password.isNotEmpty() && password.length < 6) "Password must be at least 6 characters long." else null
        )

    }



}

