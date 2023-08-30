package com.curso.android.app.practica.integrador.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.assertion.ViewAssertions

import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import  com.curso.android.app.practica.integrador.R
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    
    @get:Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)
    @org.junit.jupiter.api.BeforeEach
    fun setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    fun tearDown() {
    }

    @Test
    fun mainActivity_Compara(){
        onView(ViewMatchers.withId(R.id.data1))
            .perform(ViewActions.typeText("Hola")
            )

        onView(ViewMatchers.withId(R.id.data2))
            .perform(ViewActions.typeText("Hola")
            )

        onView(ViewMatchers.withId(R.id.btn_Comp))
            .perform(ViewActions.click()
            )
        Espresso.onView(
            ViewMatchers.withId(R.id.view_Resulta
            )).check(
                ViewAssertions.matches(
                    ViewMatchers.withText("Son iguales")
                )
            )
    }
}