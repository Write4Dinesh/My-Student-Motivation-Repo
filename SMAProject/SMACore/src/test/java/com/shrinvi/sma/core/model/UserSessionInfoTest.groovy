package com.shrinvi.sma.core.model

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mock

import static org.junit.Assert.assertEquals

@RunWith(MockitoJunitRunner.class)
class UserSessionInfoTest {
    @Mock
    UserSessionInfo mUserInfo;

    void setUp() {
        super.setUp()
    }

    void tearDown() {
    }

    @Test
   public void getUserName() {
        when(UserSessionInfo.getUseName()).thenReturn("Dinesh");
        assertEquals(4,4);
    }

    @Test
    void testSetUserName() {
    }

    @Test
    void isUserSignedIn() {
    }

    @Test
    void setIsUserLoggedIn() {
    }

    @Test
    void getUserEmail() {
    }

    @Test
    void setUserEmail() {
    }

    @Test
    void getLastLoginTime() {
    }

    @Test
    void setLastLoginTime() {
    }

    void testOnLogout() {
    }
}
