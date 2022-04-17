object BuildConfig {

    object DEV : Field() {
        // TODO: 링크 변경
        override val HOME_DOMAIN = "\"https://docfriends.github.io/Docfriends_Android_Recruit/\""
    }

    abstract class Field {
        abstract val HOME_DOMAIN: String
    }
}
