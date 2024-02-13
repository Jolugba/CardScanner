package com.example.cardscanner.util

object Constants {
    object PermissionCodes {
        const val LOCATION = 1020
        const val GALLERY_REQUEST_CODE: Int = 31
        const val CAMERA_REQUEST_CODE: Int = 32
        const val PERMISSION_REQUEST_CAMERA: Int = 12
        const val MAXIMUM_IMAGES_UPLOAD = 5
        const val RC_SIGN_IN = 9001
        const val IMAGE_QUALITY: Int = 100
        const val RC_SELECT_LOCATION = 1000
    }
    object AppConstants {
        const val DIALOG_LOCATION = "com.lawpavilion.kmr.utils.location"
        const val RIGHTS = "rights"
        const val DUTIES = "duties"
        const val USERTYPE = "com.lawpavilion.kmr.utils.user.type"
        const val GENERAL_PROVISIONS = "provisions"
        const val CONSTITUTIONS = "constitutions"
        const val DUMMY_PICTURES = "https://i.pinimg.com/originals/63/e6/c2/63e6c2c1c9af8b54c916bd76c1843772.jpg"
    }

    object Preferences {
        const val ONBOARDING_SEEN = "onboarding_seen"
        const val HAS_SKIPPED_LOGIN = "has_skipped_login"
        const val HAS_USER_LOGGED_IN = "has_user_logged_in"
        const val HAS_SETUP_BEEN_DONE = "has_setup_been_done"
        const val CLIENT_TOKEN = "client_token"
        const val FIRST_NAME = "first_name"
        const val LAST_NAME = "last_name"
        const val EMAIL = "email"
    }

    object ErrorResponses {
        const val GENERIC_ERROR = "Something strange happened. Please try again.'"
    }

    object Content {
        const val FULL_CONSTITUTION = "Full Constitution"
        const val OFFSET_WIDTH_VALUE: Float = 0.93F
        val agencies = arrayOf(
            "BUREAU OF PUBLIC PROCUREMENT",
            "CORPORATE AFFAIRS COMMISSION OF NIGERIA",
            "CENTRAL BANK OF NIGERIA",
            "CONSUMER PROTECTION COUNCIL",
            "COMPUTER PROFESSIONALS OF NIGERIA",
            "DEPARTMENT OF PETROLEUM RESOURCES",
            "ENERGY COMMISSION OF NIGERIA",
            "FEDERAL AIRPORTS AUTHORITY OF NIGERIA",
            "FEDERAL HOUSING AUTHORITY",
            "FEDERAL INLAND REVENUE SERVICE",
            "FEDERAL MORTGAGE BANK OF NIGERIA",
            "FINANCIAL REPORTING COUNCIL OF NIGERIA",
            "INFRASTRUCTURE CONCESSION REGULATORY COMMISSION",
            "INDEPENDENT NATIONAL ELECTORAL COMMISSION",
            "INDUSTRIAL TRAINING FUND",
            "LEGAL AID COUNCIL",
            "NATIONAL AUTOMOTIVE DESIGN AND DEVELOPMENT COUNCIL",
            "NATIONAL AGENCY FOR FOOD AND DRUG ADMINISTRATION AND CONTROL",
            "NATIONAL INSURANCE COMMISSION",
            "NATIONAL AGENCY FOR THE PROHIBITION OF TRAFFIC IN PERSONS AND OTHER RELATED MATTERS",
            "NATIONAL BROADCASTING COMMISSION",
            "NIGERIAN BULK ELECTRICITY  TRADING PLC",
            "NIGERIAN CIVIL AVIATION AUTHORITY",
            "NIGERIAN COMMUNICATIONS COMMISSION",
            "NIGERIAN CHRISTIAN PILGRIM COMMISSION",
            "NIGER DELTA DEVELOPMENT COMMISSION",
            "NIGERIA DEPOSIT INSURANCE CORPORATION SERVICE",
            "NIGERIAN EXTRACTIVE INDUSTRIES TRANSPARENCY INITIATIVE",
            "NATIONAL EMERGENCY MANAGEMENT AGENCY",
            "NIGERIAN EXPORT PROMOTION COUNCIL",
            "NIGERIA EXPORT PROCESSING ZONES AUTHORITY",
            "NIGERIAN ELECTRICITY REGULATORY COMMISSION",
            "NATIONAL ENVIRONMENTAL STANDARDS AND REGULATIONS ENFORCEMENT AGENCY",
            "NIGERIAN EXPORT-IMPORT BANK",
            "NATIONAL INSURANCE COMMISSION",
            "NIGERIAN COMMUNICATION SATELLITE LIMITED ",
            "NIGERIAN COPYRIGHT COMMISSION",
            "NIGERIAN MARITIME ADMINISTRATION AND SAFETY AGENCY",
            "NATIONAL IDENTITY MANAGEMENT COMMISSION",
            "NIGERIAN INVESTMENT PROMOTION COMMISSION",
            "NATIONAL INFORMATION AND TECHNOLOGY DEVELOPMENT AGENCY",
            "NATIONAL LOTTERY REGULATORY COMMISSION",
            "NIGERIAN NATIONAL PETROLEUM CORPORATION",
            "NATIONAL OIL SPILL DETECTION AND RESPONSE AGENCY",
            "NATIONAL OFFICE FOR TECHNOLOGY ACQUISITION AND PROMOTION",
            "NIGERIAN PORTS AUTHORITY",
            "NATIONAL POPULATION COMMISSION",
            "NIGERIAN SHIPPERS' COUNCIL",
            "NATIONAL SUGAR DEVELOPMENT COUNCIL",
            "NATIONAL TEACHERS' INSTITUTE",
            "NATIONAL WATER RESOURCES INSTITUTE",
            "NATIONAL PENSION COMMISION",
            "MINISTRY OF POWER AND STEEL",
            "PETROLEUM PRODUCTS PRICING AND REGULATORY AGENCY",
            "SECURITIES AND EXCHANGE COMMISSION",
            "SMALL & MEDIUM ENTERPRISES DEVELOPMENT AGENCY OF NIGERIA",
            "STANDARDS ORGANISATION OF NIGERIA",
            "TEACHERS REGISTRATION COUNCIL OF NIGERIA"
        )
    }

    object URLs {
        /*const val PRIVACY_POLICY = "http://kmr-staging.lawpavilion.com/privacy-policy"
        const val ABOUT_US = "http://kmr-staging.lawpavilion.com/about-us"
        const val TERMS_AND_CONDITIONS = "http://kmr-staging.lawpavilion.com/terms-and-conditions"*/
        const val PRIVACY_POLICY = "https://lawrights.lawpavilion.com/privacy-policy"
        const val ABOUT_US = "https://lawrights.lawpavilion.com/about-us"
        const val TERMS_AND_CONDITIONS = "https://lawrights.lawpavilion.com/terms-and-conditions"
    }
}
