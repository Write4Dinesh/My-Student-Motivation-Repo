package com.shrinvi.sma.core.model;

import com.shrinvi.sma.core.SMAUtility;

public class UserSessionInfo {
    private static String sUserName = "un-known";
    private static boolean sIsUserLoggedIn = false;
    private static String sUserEmail = "un-known";
    private static long sLastLoginTime = -1;

    public static String getUserName() {
        return sUserName;
    }

    public static void setUserName(String userName) {
        if (!SMAUtility.isStringNullOrEmpty(userName)) {
            UserSessionInfo.sUserName = userName;
        }
    }

    public static boolean isUserSignedIn() {
        return sIsUserLoggedIn;
    }

    public static void setIsUserLoggedIn(boolean isUserLoggedIn) {
        UserSessionInfo.sIsUserLoggedIn = isUserLoggedIn;
    }

    public static String getUserEmail() {
        return sUserEmail;
    }

    public static void setUserEmail(String userEmail) {
        if (!SMAUtility.isStringNullOrEmpty(userEmail) && userEmail.contains("@")) {
            UserSessionInfo.sUserEmail = userEmail;
        }
    }

    public static long getLastLoginTime() {
        return sLastLoginTime;
    }

    public static void setLastLoginTime(long sLastLoginTime) {
        UserSessionInfo.sLastLoginTime = sLastLoginTime;
    }
}
