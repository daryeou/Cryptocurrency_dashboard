object BuildConfig {

    object DEV : Field() {
        override val HOME_DOMAIN = "\"https://docfriends.github.io/Docfriends_Android_Recruit/api/home.json\""
    }

    abstract class Field {
        abstract val HOME_DOMAIN: String
    }
}
