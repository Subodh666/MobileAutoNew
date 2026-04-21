package com.example.mobileautomation.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.mobileautomation.R

class LoginPage {

    // Actions
    fun enterUsername(username: String): LoginPage {
        onView(withId(R.id.etUsername))
            .perform(typeText(username), closeSoftKeyboard())
        return this
    }

    fun enterPassword(password: String): LoginPage {
        onView(withId(R.id.etPassword))
            .perform(typeText(password), closeSoftKeyboard())
        return this
    }

    fun clickLogin(): LoginPage {
        onView(withId(R.id.btnLogin))
            .perform(click())
        return this
    }

    // Verifications
    fun verifyLoginSuccess(): LoginPage {
        onView(withId(R.id.tvResult))
            .check(matches(withText("Login Successful!")))
        return this
    }

    fun verifyLoginFailed(): LoginPage {
        onView(withId(R.id.tvResult))
            .check(matches(withText("Invalid Credentials!")))
        return this
    }
}