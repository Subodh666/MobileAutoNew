package com.example.mobileautomation.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mobileautomation.MainActivity
import com.example.mobileautomation.pages.LoginPage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private val loginPage = LoginPage()

    @Test
    fun testValidLogin() {
        loginPage
            .enterUsername("admin")
            .enterPassword("password123")
            .clickLogin()
            .verifyLoginSuccess()
    }

    @Test
    fun testInvalidLogin() {
        loginPage
            .enterUsername("wronguser")
            .enterPassword("wrongpass")
            .clickLogin()
            .verifyLoginFailed()
    }

    @Test
    fun testEmptyFields() {
        loginPage
            .clickLogin()
            .verifyLoginFailed()
    }
}