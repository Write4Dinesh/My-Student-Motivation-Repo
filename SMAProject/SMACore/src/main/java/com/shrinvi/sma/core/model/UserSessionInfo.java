package com.shrinvi.sma.core.model;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
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
            sUserName = userName;
        }
    }

    public static boolean isUserSignedIn() {
        if (getLastLoginTime() != -1 && sIsUserLoggedIn) {
            long elapsed = System.currentTimeMillis() - getLastLoginTime();
            if (elapsed >= (5 * 60 * 1000)) {//5mins
                Backendless.UserService.isValidLogin(new AsyncCallback<Boolean>() {
                    @Override
                    public void handleResponse(Boolean response) {
                        sIsUserLoggedIn = response;
                        if (!sIsUserLoggedIn) {
                            resetUserData();
                        }
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {

                    }
                });
            }
        }
        return sIsUserLoggedIn;
    }

    public static void setIsUserLoggedIn(boolean isUserLoggedIn) {
        sIsUserLoggedIn = isUserLoggedIn;
    }

    public static String getUserEmail() {
        return sUserEmail;
    }

    public static void setUserEmail(String userEmail) {
        if (!SMAUtility.isStringNullOrEmpty(userEmail) && userEmail.contains("@")) {
            sUserEmail = userEmail;
        }
    }

    public static long getLastLoginTime() {
        return sLastLoginTime;
    }

    public static void setLastLoginTime(long sLastLoginTime) {
        sLastLoginTime = sLastLoginTime;
    }

    public static void onLogout() {
        resetUserData();
    }

    private static void resetUserData() {
        sUserName = "un-known";
        sIsUserLoggedIn = false;
        sUserEmail = "un-known";
        sLastLoginTime = -1;
    }

}
